package lt.vu.usecases.cdi.dao;



import lt.vu.entities.Student;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * Created by Viktoras.Navidauskas on 2017-05-21.
 */
@Decorator
public abstract class AnonymusStudentDAO implements IStudentDAO{
    @Inject
    @Delegate
    @Any
    StudentDAO studentDAO;

    public Student findById(Integer id){
        Student student = studentDAO.findById(id);
        student.setLastName("-------");
        return student;
    }
}
