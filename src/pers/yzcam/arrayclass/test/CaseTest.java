package pers.yzcam.arrayclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.arrayclass.dao.DepartmentDao;
import pers.yzcam.arrayclass.dao.impl.DepartmentDaoImpl;
import pers.yzcam.arrayclass.entity.Department;

import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Vector;

/**
 * @author cat
 */
public class CaseTest {

    DepartmentDao dao = new DepartmentDaoImpl();

    @Test
    void departmentTableTest() {
        printDepartmentList();
        System.out.println();

        Department target = dao.getDepartmentByName("市场部");
        if (target != null) {
            System.out.println("部门ID: " + target.getId() +
                    " 部门名称: " + target.getName() +
                    " 部门成立时间: " + new SimpleDateFormat("yyyy-MM-dd").format(target.getCreateDate()));
        }
    }

    @Test
    void updateDepartmentCreateDateByIdTest() {
        String id = "DEP NO1003";
        dao.updateDepartmentCreateDateById(id, 2021, 11, 12);
        printDepartmentList();
    }

    @Test
    void testRemoveDepartmentByName() {
        printDepartmentList();
        System.out.println("-------------------");
        dao.removeDepartmentByName("研发部");
        printDepartmentList();
    }

    @Test
    void listIterator() {
        Vector<Object> departmentVector = dao.listDepartments();
        if (departmentVector != null && departmentVector.size() != 0) {
            Iterator<Object> iterator = departmentVector.iterator();
            while (iterator.hasNext()) {
                Department department = (Department) iterator.next();
                System.out.println(department.getId() + "\t" + department.getName());
            }
        }
    }

    @Test
    void listSortTest() {
        Vector<Object> departmentVector = dao.listDepartments();
        class ComparatorImpl implements Comparator {

            @Override
            public int compare(Object o1, Object o2) {
                Department department1 = (Department) o1;
                Department department2 = (Department) o2;
                if (department1.getCreateDate().getTime() > department2.getCreateDate().getTime()) {
                    return 1;
                } else if (department1.getCreateDate().getTime() < department2.getCreateDate().getTime()) {
                    return -1;
                }
                return 0;
            }
        }
        departmentVector.sort(new ComparatorImpl());
        System.out.println("部门ID\t\t部门名称\t\t成立日期");
        for (Object o : departmentVector) {
            Department department = (Department) o;
            System.out.println(department.getId() + "\t\t" +
                    department.getName() + "\t\t" +
                    new SimpleDateFormat("yyyy-MM-dd").format(department.getCreateDate()));
        }
    }

    private void printDepartmentList() {
        Vector<Object> departmentList = dao.listDepartments();
        System.out.println("部门ID\t\t部门名称\t\t成立日期");
        for (Object o : departmentList) {
            Department department = (Department) o;
            System.out.println(department.getId() + "\t\t" +
                    department.getName() + "\t\t" +
                    new SimpleDateFormat("yyyy-MM-dd").format(department.getCreateDate()));
        }
    }
}
