package pers.yzcam.aggregateclass.dao;

import pers.yzcam.aggregateclass.entity.Department;

import java.util.Vector;

/**
 * 数据访问接口
 *
 * @author cat
 */
public interface DepartmentDao {

    /**
     * 添加部门
     *
     * @param department 添加的部门
     */
    void insertDepartment(Department department);

    /**
     * 获取所有的部门
     *
     * @return Vector
     */
    Vector<Object> listDepartments();

    /**
     * 通过名称查找部门
     *
     * @param name 部门名称
     * @return Department
     */
    Department getDepartmentByName(String name);

    /**
     * 通过 ID 修改部门时间
     *
     * @param id    部门id
     * @param year  年
     * @param month 月
     * @param day   日
     */
    void updateDepartmentCreateDateById(String id, Integer year, Integer month, Integer day);

    /**
     * 通过名称删除部门
     *
     * @param name 部门名称
     */
    void removeDepartmentByName(String name);
}
