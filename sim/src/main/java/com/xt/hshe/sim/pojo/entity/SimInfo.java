package com.xt.hshe.sim.pojo.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "siminfo")
@Getter
@Setter
@ToString
public class SimInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "source_sid")
    private long sourceSid;
    @Column(name = "target_sid")
    private long targetSid;
    @Column(name = "similarity")
    private int similarity;
}
