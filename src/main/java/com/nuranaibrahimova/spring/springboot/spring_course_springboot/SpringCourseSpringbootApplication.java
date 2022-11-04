package com.nuranaibrahimova.spring.springboot.spring_course_springboot;


import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.ExportEmployeesTask;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.Mutex;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@SpringBootApplication

public class SpringCourseSpringbootApplication {
    @Autowired
    private  ExportEmployeesTask task;
    private static final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();
    public static void main(String[] args) {

        SpringApplication.run(SpringCourseSpringbootApplication.class, args);
    }


    @Bean


    public ScheduledExecutorService scheduledExecutorService() {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        scheduler.scheduleWithFixedDelay(task, 0, 1, TimeUnit.NANOSECONDS);

     task.start();

        return scheduler;
    }
}