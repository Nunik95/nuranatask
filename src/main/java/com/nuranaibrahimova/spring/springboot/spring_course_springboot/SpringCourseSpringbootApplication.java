package com.nuranaibrahimova.spring.springboot.spring_course_springboot;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller.MyRESTController;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.ExportEmployeesTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.SessionScope;

import java.time.*;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class SpringCourseSpringbootApplication {
    @Autowired
    private ExportEmployeesTask task;
    private static final ScheduledExecutorService executorService
            = Executors.newSingleThreadScheduledExecutor();

  private static   LocalDateTime now = LocalDateTime.now();


  private static  LocalDateTime whenToStart = LocalDate.now().atTime(now.getHour(), 33); // hour, minute

  public static   Duration duration = Duration.between(now, whenToStart);


    public static void main(String[] args) {
        System.out.println("duration "+ duration);

        SpringApplication.run(SpringCourseSpringbootApplication.class, args);}

            @Bean

    public ScheduledExecutorService scheduledExecutorService() {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();


                duration = Duration.between(now, whenToStart);
                if (duration.isNegative()) duration=Duration.between(now, whenToStart.plusHours(1));
        scheduler.scheduleWithFixedDelay(task, SpringCourseSpringbootApplication.duration.getSeconds(), 1, TimeUnit.HOURS);
                task.start();
        return scheduler;
    }
    }


