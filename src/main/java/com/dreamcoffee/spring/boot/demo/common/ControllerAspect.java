package com.dreamcoffee.spring.boot.demo.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * ControllerAspect
 *
 * @author Administrator
 * @date 2019/6/27
 */
@Component
@Aspect
public class ControllerAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    private void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint point) {
        Object result;
        long startTime = System.currentTimeMillis();
        Object[] args = point.getArgs();
        try {
            result = point.proceed(args);
        } catch (Throwable e) {
            result = new ResultDTO<>(ResultEnum.FAIL.getCode());
            LOGGER.error(Arrays.toString(args), e);
        }
        long endTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(requestAttributes, "request must not be null");
        HttpServletRequest request = requestAttributes.getRequest();
        String logStr = "\n\turl = {}, ip = {}, time = {}ms\n\tparams = {}\n\tresult = {}";
        LOGGER.info(logStr, request.getRequestURL(), request.getRemoteAddr(), endTime - startTime, args, result);
        return result;
    }
}
