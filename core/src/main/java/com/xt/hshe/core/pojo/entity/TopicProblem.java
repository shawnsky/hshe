package com.xt.hshe.core.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "topic_problem")
@Getter
@Setter
@ToString
public class TopicProblem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "topic_id")
    private Long topicId;
    @Column(name = "problem_id")
    private Long problemId;
}
