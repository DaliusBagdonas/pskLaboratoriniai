package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Student;

import java.util.List;

/**
 * Created by Viktoras.Navidauskas on 2017-05-21.
 */
public interface IStudentDAO {
    void create(Student student);
    Student findById(Integer id);
}
