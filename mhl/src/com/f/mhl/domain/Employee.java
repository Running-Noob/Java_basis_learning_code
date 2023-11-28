package com.f.mhl.domain;

/**
 * @author fzy
 * @date 2023/8/14 14:10
 * 对应于employee表的Employee类, 该Employee是一个JavaBean
 */
public class Employee {
    private String empId;
    private String empPwd;
    private String name;
    private String job;

    public Employee() { //无参构造器, 一定要提供, 底层 Apache-DBUtils 需要使用
    }

    public Employee(String empId, String empPwd, String name, String job) {
        this.empId = empId;
        this.empPwd = empPwd;
        this.name = name;
        this.job = job;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpPwd() {
        return empPwd;
    }

    public void setEmpPwd(String empPwd) {
        this.empPwd = empPwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
