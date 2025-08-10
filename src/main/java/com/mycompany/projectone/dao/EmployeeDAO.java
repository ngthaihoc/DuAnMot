/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.projectone.dao;

import com.mycompany.projectone.entity.Employee;
import java.util.List;

/**
 *
 * @author WellyOwO
 */
public interface EmployeeDAO extends CurdDAO<Employee, Integer> {
    Employee create(Employee entity);
    void update(Employee entity);
    void deletebyID(Integer entity);
    List<Employee> findALl();
    Employee FindByID(Integer id);
}
