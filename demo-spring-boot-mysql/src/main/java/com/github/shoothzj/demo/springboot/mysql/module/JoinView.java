package com.github.shoothzj.demo.springboot.mysql.module;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author hezhangjian
 */
@Data
@AllArgsConstructor
public class JoinView {

    private String username;

    private String password;

    private long salary;

    private long overtime;

    public JoinView() {
    }
}
