/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nuranaibrahimova.spring.springboot.spring_course_springboot.service;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dao.EmployeeRepository;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author user
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {

        List<EmployeeDTO> employeelistDTO = new ArrayList<>();
        List<Employee> allEmps = employeeRepository.findAll();

        for (Employee employee : allEmps) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(employee.getId());
            dto.setName(employee.getName());
            dto.setSurname(employee.getSurname());
            dto.setDepartment(employee.getDepartment());
            dto.setAge(employee.getAge());
            employeelistDTO.add(dto);
        }
        return employeelistDTO;
    }

    @Override
    public EmployeeDTO getEmployee(int id) {
        Employee employee = null;
        EmployeeDTO employeeDTO = new EmployeeDTO();
        Optional<Employee> emp = employeeRepository.findById(id);
        if (emp.isPresent()) {
            employee = emp.get();

          employeeDTO.setId(employee.getId());
            employeeDTO.setName(employee.getName());
            employeeDTO.setSurname(employee.getSurname());
            employeeDTO.setDepartment(employee.getDepartment());
            employeeDTO.setAge(employee.getAge());
        }
        return employeeDTO;
    }

    @Override
    public void saveEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);

    }

}
