package com.xt.hshe.core.pojo.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by shawn on 2018/1/22.
 */
@Getter
@Setter
@ToString
public class ProblemVo {
    private long id;
    private String title;
    private String description;
    private String memoryLimit;
    private String timeLimit;
    private String creator;
    private String createTime;
    private String acceptNum;
    private String submitNum;
    private String viewerNum;
}
