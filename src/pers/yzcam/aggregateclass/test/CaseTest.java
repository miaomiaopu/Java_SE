package pers.yzcam.aggregateclass.test;

import org.junit.jupiter.api.Test;
import pers.yzcam.aggregateclass.dao.DepartmentDao;
import pers.yzcam.aggregateclass.dao.EmployeeDao;
import pers.yzcam.aggregateclass.dao.RoleDao;
import pers.yzcam.aggregateclass.dao.impl.DepartmentDaoImpl;
import pers.yzcam.aggregateclass.dao.impl.EmployeeDaoImpl;
import pers.yzcam.aggregateclass.dao.impl.RoleDaoImpl;
import pers.yzcam.aggregateclass.entity.Department;
import pers.yzcam.aggregateclass.entity.Employee;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author cat
 */
public class CaseTest {

    DepartmentDao dao = new DepartmentDaoImpl();
    EmployeeDao employeeDao = new EmployeeDaoImpl();
    RoleDao roleDao = new RoleDaoImpl();

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
        class ComparatorImpl implements Comparator<Object> {

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

    @Test
    void listEmployeeSetTest() {
        Set<Object> employeeSet = employeeDao.listEmployeeSet();

        Iterator<Object> iterator = employeeSet.iterator();
        System.out.println("Id\t\tName\t\tMobilePhone\t\tBirth\t\tEntryDate\t\tDepartmentId");
        while (iterator.hasNext()) {
            Employee employee = (Employee) iterator.next();
            System.out.println(employee.getId() + "\t\t" +
                    employee.getName() + "\t\t" +
                    employee.getMobilePhone() + "\t\t" +
                    new SimpleDateFormat("yyyy-MM-dd").format(employee.getBirth()) + "\t\t" +
                    new SimpleDateFormat("yyyy-MM-dd").format(employee.getEntryDate()) + "\t\t" +
                    employee.getDepartmentId());
        }
    }

    @Test
    void createSetTest() {
        int capacity = 4;
        Set<Object> set = new HashSet<>(capacity, 16);
        set.add("King");
        set.add(null);
        System.out.println(set.size());
    }

    @Test
    void treeSetSortTest() {
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(34);
        treeSet.add(35);
        treeSet.add(37);
        treeSet.add(5);
        treeSet.add(134);
        for (Object o : treeSet) {
            System.out.println(o);
        }
        Iterator<Object> iterator = treeSet.descendingIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Test
    void listEmployeeSetSortByEntryDateTest() {
        TreeSet<Object> treeSet = employeeDao.listEmployeeSetSortByEntryDate();
        for (Object o : treeSet) {
            Employee employee = (Employee) o;
            System.out.println(employee.getId() + "\t\t" + employee.getName() + "\t\t" +
                    new SimpleDateFormat("yyyy-MM-dd").format(employee.getEntryDate()));
        }
    }

    @Test
    void linkedHashSetTest() {
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(111);
        linkedHashSet.add(121);
        linkedHashSet.add(161);
        linkedHashSet.add(311);
        linkedHashSet.add(11);
        for (Object o : linkedHashSet) {
            System.out.println(o);
        }

    }

    @Test
    void listRoleListTest() {
        List<Object> roles = roleDao.listRoleList();
        System.out.println("Id\t\tName\t\tStatus\t\tDescribe");
        for (int i = 0; i < roles.size(); i++) {
            Map<Object, Object> roleMap = (Map<Object, Object>) roles.get(i);
            System.out.println(roleMap.get("id") + "\t" +
                    roleMap.get("roleName") + "\t\t\t" +
                    ((Integer) roleMap.get("status") == 0 ? "启用" : "废弃") + "\t\t\t" +
                    roleMap.get("describe"));
        }
    }

    @Test
    void addElementToMapAndUpdateMap() {
        Integer id = Integer.valueOf("10050");
        String name = "可爱";
        String describe = "超级猫猫";

        Map<Object, Object> newRole = new HashMap<>(16, 0.75F);
        newRole.put("id", id);
        newRole.put("roleName", name);
        newRole.put("status", 0);
        newRole.put("describe", describe);

        roleDao.addRole(newRole);
        listRoleListTest();
    }

    @Test
    void updateStatusToDisableTest() {
        listRoleListTest();
        Integer id = 10040;
        roleDao.updateStatusToDisable(id);
        listRoleListTest();
    }
}
