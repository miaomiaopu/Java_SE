package pers.yzcam.arrayclass.dao.impl;

import pers.yzcam.arrayclass.dao.DepartmentDao;
import pers.yzcam.arrayclass.db.DataBase;
import pers.yzcam.arrayclass.entity.Department;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

/**
 * 部门数据访问接口的实现类
 *
 * @author cat
 */
public class DepartmentDaoImpl implements DepartmentDao {

    @Override
    public void insertDepartment(Department department) {
        // 使用 List 的 add 方法实现添加部门到数据库中
        DataBase.getDepartmentTable().add(department);
    }

    @Override
    public Vector<Object> listDepartments() {
        Vector<Object> departments = new Vector<>();
        List<Object> list = DataBase.getDepartmentTable();

        // 对 List 进行遍历获取每条记录，并且封装 Department 对象
        for (int i = 0; i < list.size(); i++) {
            departments.add(list.get(i));
        }
        return departments;
    }

    @Override
    public Department getDepartmentByName(String name) {
        List<Object> departmentList = DataBase.getDepartmentTable();
        for (int i = 0; i < departmentList.size(); i++) {
            Department tempDepartment = (Department) departmentList.get(i);
            if (tempDepartment.getName().equals(name)) {
                return tempDepartment;
            }
        }
        return null;
    }

    @Override
    public void updateDepartmentCreateDateById(String id, Integer year, Integer month, Integer day) {
        List<Object> departmentList = DataBase.getDepartmentTable();
        for (int i = 0; i < departmentList.size(); i++) {
            Department tempDepartment = (Department) departmentList.get(i);
            if (tempDepartment.getId().equals(id)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(tempDepartment.getCreateDate().getTime());
                if (year != null) {
                    calendar.set(Calendar.YEAR, year);
                }
                if (month != null) {
                    calendar.set(Calendar.MONTH, month - 1);
                }
                if (day != null) {
                    calendar.set(Calendar.DATE, day);
                }
                tempDepartment.setCreateDate(calendar.getTime());
            }
        }
    }
}
