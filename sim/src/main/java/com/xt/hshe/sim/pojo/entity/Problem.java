package com.xt.hshe.sim.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "problem")
@Getter
@Setter
@ToString
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @Column(name = "memory_limit")
    private String memoryLimit;
    @Column(name = "time_limit")
    private String timeLimit;
    private String creator;
    @Column(name = "create_time")
    private String createTime;
}
