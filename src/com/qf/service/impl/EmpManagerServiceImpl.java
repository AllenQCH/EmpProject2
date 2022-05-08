package com.qf.service.impl;

import com.qf.dao.EmpManagerDao;
import com.qf.dao.impl.EmpManagerDaoImpl;
import com.qf.entity.EmpManager;
import com.qf.service.EmpManagerService;
import com.qf.utils.DbUtils;

public class EmpManagerServiceImpl  implements EmpManagerService {
    private EmpManagerDao empManagerDao = new EmpManagerDaoImpl();
    @Override
    public EmpManager login(String username, String password) {
        EmpManager empManager =null;
        try {
            DbUtils.begin();
            EmpManager  temp = empManagerDao.select(username);
            if(temp!=null){
                if (temp.getPassword().equals(password)){
                    empManager = temp;
                }
            }
            DbUtils.commit();
        } catch (Exception e) {
            DbUtils.rollback();
            e.printStackTrace();
        }
        return empManager;
    }
}
