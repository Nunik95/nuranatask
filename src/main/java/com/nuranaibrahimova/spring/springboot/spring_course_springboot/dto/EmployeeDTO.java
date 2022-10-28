package com.nuranaibrahimova.spring.springboot.spring_course_springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class EmployeeDTO {

    private int id;

    private String name;
    private String surname;
    private String department;

    private int age;

    public EmployeeDTO() {
    }

    public EmployeeDTO(int id, String name, String surname, String department, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.age = age;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }
}
