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

    /**
     * 判断两个职员的出生日期先后
     *
     * @param employee1 职员1
     * @param employee2 职员2
     * @return 判断的字符串
     */
    public String compareEmployeeBirth(Employee employee1, Employee employee2) {
        return employee1.getBirth().after(employee2.getBirth()) ?
                employee1.getName() + " 比 " + employee2.getName() + " 出生更晚" :
                "两人出生日期相同 或者 " + employee2.getName() + " 比 " + employee1.getName() + " 出生更晚";
    }

    /**
     * 增加减少当前对象时间
     *
     * @param date 源时间对象
     * @param num  增加减少的幅度
     * @param tag  增加减少标志
     * @return 修改完成的字符串
     */
    public Date changeDateStatus(Date date, long num, int tag) {
        if (tag > 0) {
            date.setTime(date.getTime() + num);
        } else {
            date.setTime(date.getTime() - num);
        }
        return date;
    }
}
