package pers.yzcam.calendarclass.entity;

import java.util.Date;

/**
 * @author cat
 */
public class Employee {

    private String name;
    private Date birth;

    public Employee() {
    }

    public Employee(String name, Date birth) {
        this.name = name;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
