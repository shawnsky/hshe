package com.xt.hshe.core.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * Created by shawn on 2018/1/22.
 */
@Getter
@Setter
@ToString
public class TopicVo {
    private long id;
    private String title;
    private List<ProblemListItemVo> problemListItemVos;
}
