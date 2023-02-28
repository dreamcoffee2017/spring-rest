package com.example.springrest.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * ScheduledTasks
 *
 * @author Administrator
 * @since 2019/5/27
 */
@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 5000)
    public void demoTask() {
        LOGGER.info("Scheduling Tasks");
    }
}
