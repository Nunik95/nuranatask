package com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.SpringCourseSpringbootApplication;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller.MyRESTController;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dao.EmployeeRepository;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.service.EmployeeService;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


@Component

public class ExportEmployeesTask extends Thread {

    @Autowired
    private  EmployeeService employeeService;

    public void run() {
        try {
            this.sleep(SpringCourseSpringbootApplication.duration.getSeconds()*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try (FileOutputStream fos = new FileOutputStream("employees.txt", false)) {

                    LocalTime now = LocalTime.now();
                    fos.write(now.toString().getBytes());

                    List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
                    byte[] mybytes = allEmployees.toString().getBytes();
                    fos.write(mybytes);

            } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            };




    }



