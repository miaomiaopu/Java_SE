package pers.yzcam.aggregateclass.db;

import pers.yzcam.aggregateclass.entity.Department;
import pers.yzcam.aggregateclass.entity.Employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
    /**
     * 职员信息类
     */
    private static Set<Object> employeeTable = new HashSet<>();
    /**
     * 系统角色表，使用 Map 封装属性信息
     */
    private static List<Object> roleMaps = new ArrayList<>();

    public static List<Object> getRoleMaps() {
        return roleMaps;
    }

    public static void setRoleMaps(List<Object> roleMaps) {
        DataBase.roleMaps = roleMaps;
    }

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

        Employee employee1 = new Employee();
        employee1.setId("EMP 100");
        employee1.setName("王军");
        employee1.setMobilePhone(13333335567L);
        try {
            employee1.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-10-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee1.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-10-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee1.setDepartmentId("DEP NO1001");
        employeeTable.add(employee1);

        Employee employee2 = new Employee();
        employee2.setId("EMP 110");
        employee2.setName("李四");
        employee2.setMobilePhone(13433335567L);
        try {
            employee2.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-11-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee2.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-11-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee2.setDepartmentId("DEP NO1002");
        employeeTable.add(employee2);

        Employee employee3 = new Employee();
        employee3.setId("EMP 120");
        employee3.setName("闻一多");
        employee3.setMobilePhone(13533335567L);
        try {
            employee3.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-12-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee3.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2015-10-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee3.setDepartmentId("DEP NO1003");
        employeeTable.add(employee3);

        Employee employee4 = new Employee();
        employee4.setId("EMP 130");
        employee4.setName("花苑");
        employee4.setMobilePhone(13633335567L);
        try {
            employee4.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1988-12-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee4.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-10-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee4.setDepartmentId("DEP NO1002");
        employeeTable.add(employee4);

        Employee employee5 = new Employee();
        employee5.setId("EMP 140");
        employee5.setName("隆基");
        employee5.setMobilePhone(13733335567L);
        try {
            employee5.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1986-10-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee5.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2013-10-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee5.setDepartmentId("DEP NO1003");
        employeeTable.add(employee5);

        Employee employee6 = new Employee();
        employee6.setId("EMP 150");
        employee6.setName("田八");
        employee6.setMobilePhone(13833335567L);
        try {
            employee6.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1986-12-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee6.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2014-07-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee6.setDepartmentId("DEP NO1004");
        employeeTable.add(employee6);

        Employee employee7 = new Employee();
        employee7.setId("EMP 160");
        employee7.setName("任盈盈");
        employee7.setMobilePhone(13933335567L);
        try {
            employee7.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1986-11-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            employee7.setEntryDate(new SimpleDateFormat("yyyy-MM-dd").parse("2017-06-10"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        employee7.setDepartmentId("DEP NO1004");
        employeeTable.add(employee7);

        Map<String, Object> roleMap0 = new HashMap<>();
        roleMap0.put("id", 10010);
        roleMap0.put("roleName","普通");
        roleMap0.put("status",0);
        roleMap0.put("describe","普通系统用户");

        Map<String, Object> roleMap1 = new HashMap<>();
        roleMap1.put("id", 10020);
        roleMap1.put("roleName","普管");
        roleMap1.put("status",0);
        roleMap1.put("describe","普通系统管理员");

        Map<String, Object> roleMap2 = new HashMap<>();
        roleMap2.put("id", 10030);
        roleMap2.put("roleName","高管");
        roleMap2.put("status",0);
        roleMap2.put("describe","高级系统管理员");

        Map<String, Object> roleMap3 = new HashMap<>();
        roleMap3.put("id", 10040);
        roleMap3.put("roleName","超管");
        roleMap3.put("status",0);
        roleMap3.put("describe","超级系统管理员");

        roleMaps.add(roleMap0);
        roleMaps.add(roleMap1);
        roleMaps.add(roleMap2);
        roleMaps.add(roleMap3);
    }

    public static List<Object> getDepartmentTable() {
        return departmentTable;
    }

    public static void setDepartmentTable(List<Object> departmentTable) {
        DataBase.departmentTable = departmentTable;
    }

    public static Set<Object> getEmployeeTable() {
        return employeeTable;
    }

    public static void setEmployeeTable(Set<Object> employeeTable) {
        DataBase.employeeTable = employeeTable;
    }
}
