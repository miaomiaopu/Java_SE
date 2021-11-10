package pers.yzcam.dateclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.dateclass.entity.Employee;
import pers.yzcam.dateclass.utils.DateSupport;

import java.util.Date;

/**
 * @author cat
 */
public class DateTest {

    DateSupport dateSupport = new DateSupport();

    @Test
    void createEmployeeTest() {
        String name = "yzcam";
        Date birth = new Date();
        Employee employee = dateSupport.createEmployee(name, birth);
        System.out.println("Name: " + employee.getName() + " Birth: " + employee.getBirth());
    }

    @Test
    void compareEmployeeBirthTest() {
        Employee employee1 = new Employee("小红", new Date(System.currentTimeMillis() - 100));
        Employee employee2 = new Employee("小刚", new Date(System.currentTimeMillis() - 101));
        System.out.println(dateSupport.compareEmployeeBirth(employee1, employee2));
    }

    @Test
    void changeDateStatusTest() {
        Date date = new Date(123456789);
        int tag = 1;
        long num = 10000;
        dateSupport.changeDateStatus(date, num, tag);
        System.out.println(date.getTime());
    }

    @Test
    void toStringForDateTest() {
        Date date = new Date();

        System.out.println(date);
    }
}
