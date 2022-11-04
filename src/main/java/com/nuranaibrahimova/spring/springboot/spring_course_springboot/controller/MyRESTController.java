/*
 * Clnullnbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity.Employee;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.service.EmployeeService;

import java.io.*;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.ExportEmployeesTask;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.threads.Mutex;
import lombok.NoArgsConstructor;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@EnableAsync
@NoArgsConstructor
public class MyRESTController {
@Autowired
private Mutex mutex;

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/employees")
    public ResponseEntity showAllEmployees() throws IOException, InterruptedException {

        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        ResponseEntity response = ResponseEntity.status(HttpStatus.CREATED).body(allEmployees);
        System.out.println("before " + Mutex.isGetRequestSent);
        if (response.getStatusCode() == HttpStatus.valueOf(201)) {
            mutex.changeStatusToTrue();
            System.out.println("after " + Mutex.isGetRequestSent);
        }
        return response;
    }

    @SneakyThrows
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {

        EmployeeDTO employeeDTO = employeeService.getEmployee(id);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }

    @SneakyThrows
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addNewEmployee(@Valid @RequestBody Employee employee) {
        EmployeeDTO employeeDTO = employeeService.saveEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);

    }

    @SneakyThrows
    @PutMapping("/employees")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody Employee employee) {
        EmployeeDTO employeeDTO = employeeService.saveEmployee(employee);

        return ResponseEntity.ok(employeeDTO);

    }

    @SneakyThrows
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        //EmployeeDTO employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(HttpStatus.OK);

    }
}
