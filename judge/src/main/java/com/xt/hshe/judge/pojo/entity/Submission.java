package com.xt.hshe.judge.pojo.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by shawn on 2018/1/22.
 */
@Entity
@Table(name = "submission")
@Getter
@Setter
public class Submission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "problem_id")
    private long problemId;
    @Column(name = "user_id")
    private String userId;
    private String lang;
    private String src;
    @Column(name = "create_time")
    private String createTime;
    private int judged;
    @Column(name = "mem_used")
    private int memoryUsed;
    @Column(name = "time_used")
    private int timeUsed;
    private int length;
}
