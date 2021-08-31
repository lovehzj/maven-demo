package com.github.shoothzj.demo.aliyun;

import com.aliyuncs.ecs.model.v20140526.DescribeInstancesResponse;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.List;

/**
 * @author hezhangjian
 */
@Slf4j
public class EcsTest {

    @Test
    public void createEcsInstance() throws Exception {
        EcsService.createEcsList();
    }

    @Test
    public void runKubernetesCluster() throws Exception {
        for (int i = 0; i < 3; i++) {
            EcsService.runEcs("kubernetesmaster" + i);
        }
    }

    @Test
    public void createLowEcs() throws Exception {
        EcsService.createLowEcs();
    }

    @Test
    public void describeInstance() throws Exception {
        final List<DescribeInstancesResponse.Instance> ecsList = EcsService.getEcsList();
        for (DescribeInstancesResponse.Instance instance : ecsList) {
            log.info("==========");
            log.info("instance is [{}]", instance);
            log.info("instance id is [{}]", instance.getInstanceId());
            log.info("instance id is [{}]", instance.getLocalStorageAmount());
        }
    }

    @Test
    public void deleteInstances() throws Exception {
        EcsService.deleteAll();
    }

}
