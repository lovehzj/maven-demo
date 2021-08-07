package com.github.shoothzj.demo.basic;

import com.github.shoothzj.javatool.util.LogUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author hezhangjian
 */
@Slf4j
public class LogTest {

    @Test
    public void printException() {
        LogUtil.configureLog();
        log.info("print ex {}", "xxx", new Exception("ex"));
    }

}
