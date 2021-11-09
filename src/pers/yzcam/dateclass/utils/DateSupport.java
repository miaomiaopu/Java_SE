package pers.yzcam.dateclass.utils;

import pers.yzcam.dateclass.entity.Employee;

import java.util.Date;

/**
 * @author cat
 */
public class DateSupport {
    /**
     * 创建一个员工实例
     *
     * @param name  姓名
     * @param birth 出生日期
     * @return 员工实例
     */
    public Employee createEmployee(String name, Date birth) {
        return new Employee(name, birth);
    }
}
