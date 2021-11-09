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
}
