package com.github.shoothzj.demo.aliyun;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.github.shoothzj.javatool.util.EnvUtil;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;

/**
 * @author hezhangjian
 */
@Slf4j
public class AliConfigReader {

    @SneakyThrows
    public static Ali getAli() {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(new File(EnvUtil.getUserHome() + "/.sh/ali.yaml"), Ali.class);
    }

}
