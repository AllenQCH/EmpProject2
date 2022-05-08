package com.qf.dao;

import com.qf.entity.Emp;

import java.util.List;

public interface EmpDao {
    public List<Emp> selectAll();

    public int delete(int id);
}
