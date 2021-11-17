package pers.yzcam.generic.student.dao;

import pers.yzcam.generic.entity.Student;
import pers.yzcam.generic.interface_.BaseDao;

import java.util.List;

/**
 * @author cat
 */
public class StudentDaoImp implements BaseDao<Student> {
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public Student findById(String id) {
        return null;
    }

    @Override
    public void removeById(String id) {

    }

    @Override
    public void updateById(String id, Student student) {

    }
}
