package pers.yzcam.aggregateclass.dao.impl;

import pers.yzcam.aggregateclass.dao.EmployeeDao;
import pers.yzcam.aggregateclass.db.DataBase;
import pers.yzcam.aggregateclass.entity.Employee;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author cat
 */
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public Set<Object> listEmployeeSet() {
        return DataBase.getEmployeeTable();
    }

    @Override
    public TreeSet<Object> listEmployeeSetSortByEntryDate() {
        TreeSet<Object> treeSet = new TreeSet<>(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                Employee employee1 = (Employee) o1;
                Employee employee2 = (Employee) o2;
                if (employee1.getEntryDate().getTime() > employee2.getEntryDate().getTime()) {
                    return -1;
                } else if (employee1.getEntryDate().getTime() < employee2.getEntryDate().getTime()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        Set<Object> tempSet = DataBase.getEmployeeTable();
        treeSet.addAll(tempSet);
        return treeSet;
    }
}
