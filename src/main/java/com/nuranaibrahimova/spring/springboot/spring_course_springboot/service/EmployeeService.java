/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nuranaibrahimova.spring.springboot.spring_course_springboot.service;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.List;

/**
 * @author user
 */
public interface EmployeeService {
    List<EmployeeDTO> getAllEmployees();

    void saveEmployee(Employee emp);

    public EmployeeDTO getEmployee(int id);

    public void deleteEmployee(int id);
}
