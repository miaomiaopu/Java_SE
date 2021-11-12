package pers.yzcam.arrayclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.arrayclass.dao.DepartmentDao;
import pers.yzcam.arrayclass.dao.impl.DepartmentDaoImpl;
import pers.yzcam.arrayclass.entity.Department;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

/**
 * @author cat
 */
public class CaseTest {

    DepartmentDao dao = new DepartmentDaoImpl();

    @Test
    void departmentTableTest() {
        printDepartmentList();
        System.out.println();

        Department target = dao.getDepartmentByName("市场部");
        if (target != null) {
            System.out.println("部门ID: " + target.getId() +
                    " 部门名称: " + target.getName() +
                    " 部门成立时间: " + new SimpleDateFormat("yyyy-MM-dd").format(target.getCreateDate()));
        }
    }

    @Test
    void updateDepartmentCreateDateByIdTest() {
        String id = "DEP NO1003";
        dao.updateDepartmentCreateDateById(id, 2021, 11, 12);
        printDepartmentList();
    }

    private void printDepartmentList() {
        Vector<Object> departmentList = dao.listDepartments();
        System.out.println("部门ID\t\t部门名称\t\t成立日期");
        for (Object o : departmentList) {
            Department department = (Department) o;
            System.out.println(department.getId() + "\t\t" +
                    department.getName() + "\t\t" +
                    new SimpleDateFormat("yyyy-MM-dd").format(department.getCreateDate()));
        }
    }
}
