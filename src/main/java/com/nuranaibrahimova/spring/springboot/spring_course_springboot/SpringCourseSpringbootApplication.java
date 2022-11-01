package com.nuranaibrahimova.spring.springboot.spring_course_springboot;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller.MyRESTController;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.ExportEmployeesTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringCourseSpringbootApplication {
    @Autowired
    private ExportEmployeesTask task;

    public static void main(String[] args) {

        SpringApplication.run(SpringCourseSpringbootApplication.class, args);


    }

    @Bean
    public ScheduledExecutorService scheduledExecutorService(){
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService executorService;
        Executors.newSingleThreadScheduledExecutor();
        task.start();

        scheduler.scheduleWithFixedDelay(task, 0, 1, TimeUnit.MINUTES);
        return scheduler;
    }
}
