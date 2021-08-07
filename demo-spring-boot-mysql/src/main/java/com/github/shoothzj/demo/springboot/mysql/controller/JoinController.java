package com.github.shoothzj.demo.springboot.mysql.controller;

import com.github.shoothzj.demo.springboot.mysql.module.JoinView;
import com.github.shoothzj.demo.springboot.mysql.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hezhangjian
 */
@Slf4j
@RestController
public class JoinController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(path = "/join")
    public ResponseEntity<List<JoinView>> get() {
        final List<JoinView> joinViews = userRepository.joinView("general_pwd", 10);
        return new ResponseEntity<>(joinViews, HttpStatus.OK);
    }

}
