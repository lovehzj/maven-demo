package com.github.shoothzj.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author hezhangjian
 */
@Slf4j
public class EnumCompareTest {

    @Test
    public void compare() {
        System.out.println(null == Comics.NARUTO);
    }

}
