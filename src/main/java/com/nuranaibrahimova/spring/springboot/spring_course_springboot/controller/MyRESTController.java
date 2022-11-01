/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity.Employee;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.service.EmployeeService;

import java.io.*;
import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
@EnableAsync
public class MyRESTController {
    private final EmployeeService employeeService;
    public static String textForCopy = "";

    public MyRESTController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> showAllEmployees() throws IOException {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        ResponseEntity response = ResponseEntity.status(HttpStatus.CREATED).body(allEmployees);

        textForCopy = response.getBody().toString();

        return response;
    }

    @SneakyThrows
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {

        EmployeeDTO employeeDTO = employeeService.getEmployee(id);
        textForCopy = showAllEmployees().getBody().toString();
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }

    @SneakyThrows
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addNewEmployee(@Valid @RequestBody Employee employee) {
        EmployeeDTO employeeDTO = employeeService.saveEmployee(employee);
        textForCopy = showAllEmployees().getBody().toString();
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);

    }

    @SneakyThrows
    @PutMapping("/employees")
    public ResponseEntity<EmployeeDTO> updateEmployee(@Valid @RequestBody Employee employee) {
        EmployeeDTO employeeDTO = employeeService.saveEmployee(employee);
        textForCopy = showAllEmployees().getBody().toString();
        return ResponseEntity.ok(employeeDTO);

    }

    @SneakyThrows
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        //EmployeeDTO employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        textForCopy = showAllEmployees().getBody().toString();

        return ResponseEntity.ok(HttpStatus.OK);

    }
}
