package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Course;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;
import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 * Created by Viktoras.Navidauskas on 2017-05-21.
 */
@Specializes
public class CourseSpecializesDAO extends CourseDAO {
    String data = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    @Inject
    private EntityManager em;
    public List<Course> getAllCourses() {
        List<Course> courses = em.createNamedQuery("Course.findAll", Course.class).getResultList();
        for (Course course : courses) {
            course.setName(course.getName() + " " + data );
        }
        return courses;
    }
}
