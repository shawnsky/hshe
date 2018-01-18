package com.xt.hshe.core.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "testpoint")
@Getter
@Setter
@ToString
public class TestPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String index;
    private String input;
    private String output;
}
