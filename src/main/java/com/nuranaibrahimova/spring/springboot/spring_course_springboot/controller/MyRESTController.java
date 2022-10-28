/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nuranaibrahimova.spring.springboot.spring_course_springboot.controller;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity.Employee;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.service.EmployeeService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class MyRESTController {
    private final EmployeeService employeeService;
    public MyRESTController(@Autowired EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> showAllEmployees() {
        List<EmployeeDTO> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.CREATED).body(allEmployees);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int id) {
        EmployeeDTO employeeDTO = null;
        employeeDTO = employeeService.getEmployee(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);
    }
    @PostMapping("/employees")
    public ResponseEntity<EmployeeDTO> addNewEmployee( @RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(),
                employee.getName(), employee.getSurname(),
                employee.getDepartment(), employee.getAge());
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);

    }
    @PutMapping("/employees")
    public ResponseEntity<EmployeeDTO> updateEmployee(  @RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getName(), employee.getSurname(), employee.getDepartment(), employee.getAge());
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeDTO);

    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {
        EmployeeDTO employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok(HttpStatus.OK);

    }
}
