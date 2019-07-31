package com.dreamcoffee.spring.boot.demo.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        try {
            result = point.proceed(point.getArgs());
        } catch (Throwable e) {
            result = new ResultDTO(ResultEnum.FAIL.getCode());
            LOGGER.error("", e);
        }
        long endTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(requestAttributes, "request must not be null");
        HttpServletRequest request = requestAttributes.getRequest();
        List<Object> args = new ArrayList<>(Arrays.asList(point.getArgs()));
        args.removeIf(o -> o instanceof ServletRequest || o instanceof ServletResponse);
        String logStr = "\n请求IP: {} \n请求路径: {} \n请求方式: {} \n执行时间: {} ms";
        List<Object> logArgList = new ArrayList<>(Arrays.asList(request.getRemoteAddr(), request.getRequestURL(), request.getMethod(), endTime - startTime));
        if (!CollectionUtils.isEmpty(args)) {
            logStr += " \n方法描述: \n{}";
            logArgList.add(jsonFormat(args));
        }
        if (!CollectionUtils.isEmpty(request.getParameterMap())) {
            logStr += " \n请求参数: \n{}";
            logArgList.add(jsonFormat(request.getParameterMap()));
        }
        logStr += " \n返回值: \n{}";
        logArgList.add(jsonFormat(result));
        LOGGER.info(logStr, logArgList.toArray());
        return result;
    }

    /**
     * json格式化
     *
     * @param object
     * @return
     */
    private String jsonFormat(Object object) {
        return JSON.toJSONString(object, SerializerFeature.PrettyFormat);
    }
}
