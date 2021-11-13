package pers.yzcam.aggregateclass.dao;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author cat
 */
public interface EmployeeDao {
    /**
     * 获取 Employee
     *
     * @return (Set)员工集合
     */
    Set<Object> listEmployeeSet();

    /**
     * 获取按照入职时间排序的 Employee
     *
     * @return (Set)员工集合
     */
    TreeSet<Object> listEmployeeSetSortByEntryDate();
}
