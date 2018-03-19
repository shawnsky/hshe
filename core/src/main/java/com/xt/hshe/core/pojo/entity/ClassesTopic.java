package com.xt.hshe.core.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "classes_topic")
@Getter
@Setter
@ToString
public class ClassesTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "classes_id")
    private Long classId;
    @Column(name = "topic_id")
    private Long topicId;
}
