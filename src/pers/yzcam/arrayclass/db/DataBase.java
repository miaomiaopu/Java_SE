package pers.yzcam.arrayclass.db;

import pers.yzcam.arrayclass.entity.Department;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * 模仿数据库表
 *
 * @author cat
 */
public final class DataBase {

    /**
     * 部门信息表
     */
    private static List<Object> departmentTable = new ArrayList<>();

    static {
        Department department0 = new Department();
        department0.setId("DEP NO1001");
        department0.setName("市场部");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 10 - 1);
        calendar.set(Calendar.DATE, 10);
        department0.setCreateDate(calendar.getTime());
        departmentTable.add(department0);

        Department department1 = new Department();
        department1.setId("DEP NO1002");
        department1.setName("研发部");
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 9 - 1);
        calendar.set(Calendar.DATE, 10);
        department1.setCreateDate(calendar.getTime());
        departmentTable.add(department1);

        Department department2 = new Department();
        department2.setId("DEP NO1003");
        department2.setName("技术部");
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 11 - 1);
        calendar.set(Calendar.DATE, 10);
        department2.setCreateDate(calendar.getTime());
        departmentTable.add(department2);

        Department department3 = new Department();
        department3.setId("DEP NO1004");
        department3.setName("人事部");
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, 10 - 1);
        calendar.set(Calendar.DATE, 10);
        department3.setCreateDate(calendar.getTime());
        departmentTable.add(department3);

        Department department4 = new Department();
        department4.setId("DEP NO1005");
        department4.setName("销售部");
        calendar.set(Calendar.YEAR, 2016);
        calendar.set(Calendar.MONTH, 11 - 1);
        calendar.set(Calendar.DATE, 11);
        department4.setCreateDate(calendar.getTime());
        departmentTable.add(department4);
    }

    public static List<Object> getDepartmentTable() {
        return departmentTable;
    }

    public static void setDepartmentTable(List<Object> departmentTable) {
        DataBase.departmentTable = departmentTable;
    }
}
