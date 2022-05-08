package com.qf.dao.impl;

import com.qf.dao.EmpDao;
import com.qf.entity.Emp;
import com.qf.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    private QueryRunner queryRunner = new QueryRunner();

    @Override
    public List<Emp> selectAll() {
        try {
            List<Emp> emps = queryRunner.query(DbUtils.getConnection(), "select * from emp;", new BeanListHandler<Emp>(Emp.class));
            return emps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delete(int id) {
        try {
            int result = queryRunner.update(DbUtils.getConnection(), "delete from emp where id =?", id);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
