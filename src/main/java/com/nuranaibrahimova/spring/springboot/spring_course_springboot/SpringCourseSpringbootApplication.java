package com.nuranaibrahimova.spring.springboot.spring_course_springboot;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller.MyRESTController;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.ExportEmployeesTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringCourseSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCourseSpringbootApplication.class, args);

        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService executorService;
        executorService = Executors.newSingleThreadScheduledExecutor();
        ExportEmployeesTask task=new ExportEmployeesTask();
        task.start();
        scheduler.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
    }
}
