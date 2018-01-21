package com.xt.hshe.core.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@ToString
public class Teacher {
    @Id
    private String id;
    private String nickname;
    private String password;
    private String email;
    private String phone;
}
