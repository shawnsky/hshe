package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Student;
import com.xt.hshe.core.pojo.entity.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("classService")
public class ClassServiceImpl extends BaseService implements ClassService {
    @Override
    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    @Override
    public Classes findClass(Long id) {
        return classesRepository.findOne(id);
    }

    @Override
    public long addClass(String name) {
        Classes classes = new Classes();
        classes.setCreateTime(String.valueOf(System.currentTimeMillis()));
        classes.setName(name);
        classesRepository.save(classes);
        return classes.getId();
    }

    @Override
    public List<Student> findStudents(Long id) {
        return studentRepository.findAllByClasses(id);
    }

    @Override
    public List<Map<String, String>> findAllDetails() {
        List<Classes> list = findAll();
        List<Map<String, String>> details = new ArrayList<>();
        for (Classes c: list) {
            Map<String, String> map = new HashMap<>();
            List<Topic> ownTopics = topicRepository.findTopicByClassId(c.getId());
            map.put("class_id", String.valueOf(c.getId()));
            map.put("class_name", c.getName());
            map.put("tot_topic", String.valueOf(ownTopics.size()));
            //a new class and have no topics
            if (ownTopics==null || ownTopics.size()==0){
                map.put("lastest_topic_title", null);
                map.put("lastest_topic_id", null);
            } else {
                Topic lastest = ownTopics.get(0);
                map.put("lastest_topic_title", lastest.getTitle());
                map.put("lastest_topic_id", String.valueOf(lastest.getId()));
            }
            details.add(map);
        }
        return details;
    }
}
