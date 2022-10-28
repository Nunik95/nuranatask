/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.nuranaibrahimova.spring.springboot.spring_course_springboot.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotEmpty(message = "The full name is required.")
    @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
    private String name;

    @Column(name = "surname")
    @NotEmpty(message = "The full surname is required.")
    private String surname;
    @Column(name = "department")
    @NotEmpty(message = "The department is required.")
    private String department;
    @Column(name = "age")
    @Min(value = 0, message = "age must be positive")
    private int age;

    public Employee() {
    }

    public Employee(int id, String name, String surname, String department, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", age=" + age +
                '}';
    }
}
