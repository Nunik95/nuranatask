package com.nuranaibrahimova.spring.springboot.spring_course_springboot.dao;

import com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto.EmployeeDTO;
import com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
