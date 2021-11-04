package pers.yzcam.packingclass.integer.test;

import pers.yzcam.packingclass.integer.entity.Employee;
import pers.yzcam.packingclass.integer.tool.IntegerManagement;

public class EmployeeTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        Employee employee1 = new Employee();

        Integer integer = 23;
        employee.setId(integer);
        System.out.println(employee.getId());

        integer = Integer.valueOf("45");
        employee1.setId(integer);
        System.out.println(employee1.getId());

        // 常量属性
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.BYTES);
        System.out.println(Integer.SIZE);

        // compareTo
        System.out.println(employee.getId().compareTo(employee1.getId()));

        // intValue
        int empId = employee.getId().intValue();

        // parseInt
        String pwd = "457820";
        int pwdInt = Integer.parseInt(pwd);
        System.out.println(pwdInt + 9);

        System.out.println(Integer.parseInt("10111", 10));
        System.out.println(Integer.parseInt("10111", 2));

        // toBinaryString、toOctalString、toHexString
        int num = 2390;
        System.out.println(IntegerManagement.fromIntegerToStringByArg(2390, 2));
        System.out.println(IntegerManagement.fromIntegerToStringByArg(2390, 8));
        System.out.println(IntegerManagement.fromIntegerToStringByArg(2390, 16));
        System.out.println(IntegerManagement.fromIntegerToStringByArg(2390, 12));

        // valueOf
        employee.setId(Integer.valueOf(23));
        System.out.println(employee.getId());
        employee.setId(Integer.valueOf("24"));
        System.out.println(employee.getId());
        employee.setId(Integer.valueOf("25", 10));
        System.out.println(employee.getId());

        // toString
        integer = 156;
        System.out.println(integer.toString() + "**");
        // 静态toString
        System.out.println(Integer.toString(165));
        System.out.println(Integer.toString(165, 2));
    }
}
