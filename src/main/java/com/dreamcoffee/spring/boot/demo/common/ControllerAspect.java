package com.dreamcoffee.spring.boot.demo.common;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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

    @Pointcut("execution(* com.dreamcoffee.spring.boot.demo.*.controller..*(..))")
    private void controllerAspect() {
    }

    @Around("controllerAspect()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        List<Object> args = new ArrayList<>(Arrays.asList(point.getArgs()));
        args.removeIf(o -> o instanceof ServletRequest || o instanceof ServletResponse);
        LOGGER.info("\n\t请求标识: {} \n\t请求IP: {} \n\t请求路径: {} \n\t请求方式: {} \n\t方法描述: {} \n\t请求参数: {}",
                uuid, request.getRemoteAddr(), request.getRequestURL(), request.getMethod(),
                StringUtils.join(args), JSON.toJSONString(request.getParameterMap()));
        long startTime = System.currentTimeMillis();
        Object result;
        try {
            result = point.proceed(point.getArgs());
        } catch (Exception e) {
            result = new ResultDTO(ResultEnum.FAIL.getCode());
            LOGGER.error("", e);
        }
        long endTime = System.currentTimeMillis();
        LOGGER.info("\n\t请求标识: {} \n\t执行时间: {} ms \n\t返回值: {}", uuid, endTime - startTime, result.toString());
        return result;
    }
}
