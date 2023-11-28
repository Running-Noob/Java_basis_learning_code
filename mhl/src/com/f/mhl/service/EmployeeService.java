package com.f.mhl.service;

import com.f.mhl.dao.EmployeeDAO;
import com.f.mhl.domain.Employee;

/**
 * @author fzy
 * @date 2023/8/14 14:09
 * 处理Employee相关业务逻辑的类
 */
public class EmployeeService {

    private EmployeeDAO employeeDAO = new EmployeeDAO();

    //判断员工号和密码是否合法
    public Employee verification(String empId, String empPwd) {
        return employeeDAO.querySingle("SELECT employee_id AS empId, employee_pwd AS empPwd, name, job FROM employee " +
                "WHERE employee_id = ? AND MD5(?) = employee_pwd", Employee.class, empId, empPwd);
    }
}
