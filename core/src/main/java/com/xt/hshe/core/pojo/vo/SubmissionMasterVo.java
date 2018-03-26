package com.xt.hshe.core.pojo.vo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by shawn on 2018/1/22.
 */

@Getter
@Setter
public class SubmissionMasterVo {
    private long id;
    private long problemId;
    private String userId;
    private String lang;
    private String src;
    private String createTime;
    private int judged;
    private int memoryUsed;
    private int timeUsed;
    private int length;
    private int sim;
}
