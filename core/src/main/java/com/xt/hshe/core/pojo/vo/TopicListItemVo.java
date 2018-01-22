package com.xt.hshe.core.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;

/**
 * Created by shawn on 2018/1/22.
 */
@Getter
@Setter
@ToString
public class TopicListItemVo {
    private long id;
    private String title;
    private String creator;
    private int topicStatus;
}
