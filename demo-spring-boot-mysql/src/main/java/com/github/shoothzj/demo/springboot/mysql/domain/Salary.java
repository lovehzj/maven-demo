package com.github.shoothzj.demo.springboot.mysql.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author hezhangjian
 */
@Entity
@Table(name = "T_Salary")
public class Salary {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_REG_ID_SEQ")
    @SequenceGenerator(name = "T_REG_ID_SEQ", sequenceName = "T_REG_ID_SEQ", allocationSize = 1)
    private Long id;

    @Column(length = 256)
    private String username;

    @Column
    private long salary;

    @Column(name = "overtime")
    private long overtime;

    public Salary() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getOvertime() {
        return overtime;
    }

    public void setOvertime(long overtime) {
        this.overtime = overtime;
    }
}
