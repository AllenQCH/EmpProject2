package com.qf.service.impl;

import com.qf.dao.EmpDao;
import com.qf.dao.impl.EmpDaoImpl;
import com.qf.entity.Emp;
import com.qf.entity.EmpManager;
import com.qf.service.EmpManagerService;
import com.qf.service.EmpService;
import com.qf.utils.DbUtils;

import java.util.ArrayList;
import java.util.List;

public class EmpServiceImpl implements EmpService {
    private EmpDao empDao = new EmpDaoImpl();

    @Override
    public List<Emp> showAllEmp() {
        List<Emp> emps = new ArrayList<>();
        try {
            DbUtils.begin();
            List<Emp> temps = empDao.selectAll();
            if (temps != null) {
                emps = temps;
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return emps;
    }

    @Override
    public int removeEmp(int id) {
        int result = 0;
        try {
            DbUtils.begin();
            result = empDao.delete(id);
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return result;
    }
}
