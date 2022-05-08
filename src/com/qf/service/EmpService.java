package com.qf.service;

import com.qf.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> showAllEmp();
    public int removeEmp(int id);
}
