package com.github.shoothzj.trace.pulsar.client;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author hezhangjian
 */
@Aspect
public class ProducerAspect {

    private static Logger log = LoggerFactory.getLogger(ProducerAspect.class);

    @Before("execution(* org.apache.pulsar.client.impl.ProducerImpl.sendAsync(..))")
    public void pointCut(JoinPoint joinPoint) {
      log.info("jointPoint is {} {}", joinPoint.getTarget(), joinPoint.getKind());
    }

}
