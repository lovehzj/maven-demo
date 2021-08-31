package com.github.shoothzj.demo.qpid;

import com.google.common.io.Resources;
import lombok.extern.slf4j.Slf4j;
import org.apache.qpid.server.SystemLauncher;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hezhangjian
 */
@Slf4j
public class QpidAdapt {

    private static final String INIT_CONF = "qpid-config.json";

    public static void main(String[] args) throws Exception {
        SystemLauncher systemLauncher = new SystemLauncher();
        systemLauncher.startup(createSystemConfig());
    }

    private static Map<String, Object> createSystemConfig() {
        URL resource = Resources.getResource(INIT_CONF);
        Map<String, Object> attributes = new HashMap<>();
        attributes.put("type", "Memory");
        attributes.put("initialConfigurationLocation", resource.toExternalForm());
        attributes.put("startupLoggedToSystemOut", true);
        return attributes;
    }

}
