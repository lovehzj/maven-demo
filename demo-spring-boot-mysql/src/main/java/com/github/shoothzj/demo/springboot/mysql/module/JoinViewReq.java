package com.github.shoothzj.demo.springboot.mysql.module;

import lombok.Data;

/**
 * @author shoothzj
 */
@Data
public class JoinViewReq {

    private String password;

    private long overtime;

    public JoinViewReq() {
    }
}
