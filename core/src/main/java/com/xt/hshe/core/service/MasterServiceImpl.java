package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Problem;
import com.xt.hshe.core.pojo.entity.SimInfo;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.util.SimComparator;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("masterService")
public class MasterServiceImpl extends BaseService implements MasterService {


    @Override
    public int findSim(Long submissionId) {
        SimInfo simInfo = simInfoRepository.findBySourceSid(submissionId);
        if (simInfo==null) {
            return -1;
        } else {
            return simInfo.getSimilarity();
        }

    }

    @Override
    public double findAVG(List<Problem> problems, String userId) {
        int sum = 0;
        int tot = 0;
        for (Problem p: problems) {
            List<Submission> submissions = submissionRepository.findByUserIdAndProblemId(userId, p.getId());
            //用户可能同一道题提交多次
            for (Submission s: submissions) {
                int record = findSim(s.getId());
                if (record==-1) {
                    continue;
                }
                sum += record;
                tot++;
            }
        }
        return sum*1.0/tot;
    }


    @Override
    public Map<String, List<Student>> achievement(List<Problem> problems, List<Student> studentList) {
        Map<String, List<Student>> data = new HashMap<>();
        //全部做对多少人，未完成多少人
        List<Student> allAC = new ArrayList<>();
        List<Student> notComplete = new ArrayList<>();
        Set<String> resultSet = new HashSet<>();
        resultSet.clear();
        boolean first = true;
        //作业里每道题通过同学数据, 同时取交集
        for (Problem p: problems) {
            Set<String> set = redisTemplate.opsForSet().members("acceptuser:"+p.getId());
            if (first) {
                resultSet.addAll(set==null?new HashSet<>():set);
                first = false;
            } else {
                resultSet.retainAll(set==null?new HashSet<>():set);
            }
        }

        for (String userId: resultSet){
            allAC.add(authService.findStudent(userId));
        }
        notComplete.clear();
        notComplete.addAll(studentList);
        notComplete.removeAll(allAC);
        data.put("allAC", allAC);
        data.put("notComplete", notComplete);
        return data;
    }

    @Override
    public List<List<Submission>> group(Problem problem) {
        List<List<Submission>> subGroups = new ArrayList<>();
        List<List<Integer>> idGroups = new ArrayList<>();
        boolean[] visited = new boolean[666];
        int[][] map = new int[666][666];
        Set<Integer> subIdPool = new HashSet<>();
        //查询某一题目相似度超过80%的Siminfo
        List<SimInfo> infos = simInfoRepository.findAbsoluteByProblemId(problem.getId());
        for (SimInfo info: infos) {
            int source = Long.valueOf(info.getSourceSid()).intValue();
            int target = Long.valueOf(info.getTargetSid()).intValue();
            int wight = info.getSimilarity();
            map[source][target] = 1;
            map[target][source] = 1;
        }

        for (SimInfo info: infos) {
            subIdPool.add(Long.valueOf(info.getTargetSid()).intValue());
            subIdPool.add(Long.valueOf(info.getSourceSid()).intValue());
        }

        for (int i: subIdPool) {
            //if not visited, a new group
            if (!visited[i]) {
                List<Integer> group = new ArrayList<>();
                group.add(i);
                dfs(i, group, visited, subIdPool, map);
                idGroups.add(group);
            }
        }
        //sub id group TO stu group
        for (List<Integer> list: idGroups) {
            List<Submission> subList = new ArrayList<>();
            for (Integer i: list) {
                Submission submission = submissionRepository.findOne(Long.valueOf(i));
                subList.add(submission);
            }
            //直接按照提交时间排序，使第一个为原创者
            subList.sort(new SimComparator());
            subGroups.add(subList);
        }
        return subGroups;
    }

    @Override
    public Map<String, String> getStatistics() {
        Map<String, String> map = new HashMap<>();
        map.put("submissions", String.valueOf(submissionRepository.count()));
        map.put("students", String.valueOf(studentRepository.count()));
        map.put("topics", String.valueOf(topicRepository.count()));
        map.put("classes", String.valueOf(classesRepository.count()));
        map.put("problems", String.valueOf(problemRepository.count()));
        return map;
    }


    private void dfs(int id, List<Integer> group, boolean[] visited, Set<Integer> subIdPool, int[][] map) {
        visited[id] = true;
        for (int i: subIdPool) {
            if (!visited[i] && map[id][i]==1) {
                group.add(i);
                dfs(i, group, visited, subIdPool, map);
            }
        }
    }
}
