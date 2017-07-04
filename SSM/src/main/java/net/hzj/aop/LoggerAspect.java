package net.hzj.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Class:        LoggerAspect
 * Description:  日志切面组件
 * Copyright:    Copyright (c)2017
 * Company:      CSII
 *
 * @author: huangzhengjun
 * @verion: 1.0
 * Create at:    2017/6/28
 * Modification History:
 * Date          Author               Version            Description
 * ----------------------------------------------------------------------------------------
 */
@Aspect
@Component
public class LoggerAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggerAspect.class);

    //Controller层切点
    @Pointcut("execution (* net.hzj.controller..*.*(..))")
    public  void controllerAspect() {}


    @Before("controllerAspect()")
    public void log(JoinPoint joinPoint){
        log.info("参数为:"+Arrays.toString(joinPoint.getArgs()));
    }

}
