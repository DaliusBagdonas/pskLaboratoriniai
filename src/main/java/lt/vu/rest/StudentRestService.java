package lt.vu.rest;

import lt.vu.entities.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentRestService {

    @Inject private EntityManager em;

    @GET
    @Path("/{studentId}")
    public Student find(@PathParam("studentId") Integer studentId) {
        return em.find(Student.class, studentId);
    }

    @PUT
    @Path("/create")
    @Transactional
    public Student create(@QueryParam("first_name") String firstName,
                          @QueryParam("last_name") String lastName,
                          @QueryParam("REGISTRATION_NO") String regNo) {
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setRegistrationNo(regNo);
        em.persist(student);
        return student;
    }

    @POST
    @Path("/update/{studentId}")
    @Transactional
    public Student update(@PathParam("studentId") Integer studentID,
                          @QueryParam("first_name") String firstName,
                          @QueryParam("last_name") String lastName,
                          @QueryParam("REGISTRATION_NO") String regNo) {
        Student student = em.find(Student.class, studentID);
        if (student == null) {
            throw new IllegalArgumentException("Student with id \'"+ studentID + "\' was not found");
        }
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setRegistrationNo(regNo);
        em.merge(student);
        return student;
    }


}
