package com.xt.hshe.core.service;

import com.xt.hshe.core.pojo.entity.Classes;
import com.xt.hshe.core.pojo.entity.Topic;
import com.xt.hshe.core.pojo.vo.TopicListItemVo;
import com.xt.hshe.core.pojo.vo.TopicVo;

import java.util.List;

public interface TopicService {
    /**
     * 查询所有作业(表格显示对象)
     * @return list-vo
     */
    List<TopicListItemVo> findAllTopicsVo();

    /**
     * 查询作业(表格记录对象)
     * @param topicId 作业ID
     * @return vo
     */
    TopicVo findVo(Long topicId);

    /**
     * 查询作业标题
     * @param topicId 作业ID
     * @return 作业标题
     */
    String findTopicTitle(Long topicId);

    /**
     * 新增作业
     * @param classId 班级ID
     * @param title 作业标题
     * @param desc 作业描述
     * @param beginTime 开始时间unix
     * @param endTime 结束时间
     * @param creator 创建者
     * @return 作业ID
     */
    long add(Long classId,String title, String desc, String beginTime, String endTime, String creator);

    /**
     * 根据作业查询所属班级
     * @param topicId 作业ID
     * @return 班级对象
     */
    Classes findClasses(Long topicId);

}
