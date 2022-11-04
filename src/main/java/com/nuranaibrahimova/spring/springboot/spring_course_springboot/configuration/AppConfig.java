//package com.nuranaibrahimova.spring.springboot.spring_course_springboot.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.annotation.EnableAsync;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//
//@Configuration
//@EnableAsync
//public class AppConfig {
//
//    @Bean
//    public TaskExecutor threadPoolTaskExecutor() {
//        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
//        executor.setCorePoolSize(4);
//        executor.setMaxPoolSize(4);
//        executor.setThreadNamePrefix("exporting_files_Thread");
//        executor.initialize();
//        executor.setAwaitTerminationSeconds(Integer.MAX_VALUE);
//        executor.setWaitForTasksToCompleteOnShutdown(true);
//        return executor;
//    }
//}
//
//
//
