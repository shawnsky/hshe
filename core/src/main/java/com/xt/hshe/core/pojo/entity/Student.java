package com.xt.hshe.core.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
public class Student {
    @Id
    private String id;
    private String nickname;
    private String password;
    private String email;
}
