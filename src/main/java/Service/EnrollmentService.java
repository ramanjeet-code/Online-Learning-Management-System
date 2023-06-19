package Service;

import java.util.List;

import Entity.Enrollment;
import Exception.SomeThingWentWrongException;

public interface EnrollmentService {
	 void enrollStudent(Long courseId, Long studentId) throws SomeThingWentWrongException;
	    void dropStudent(Long courseId, Long studentId) throws SomeThingWentWrongException;
	    List<Enrollment> getEnrollmentsByCourse(Long courseId) throws SomeThingWentWrongException;
	    List<Enrollment> getEnrollmentsByStudent(Long studentId) throws SomeThingWentWrongException;
	    boolean isEnrolled(Long courseId, Long studentId) throws SomeThingWentWrongException;
	    int getTotalEnrolledStudents(Long courseId)throws SomeThingWentWrongException;
	    Enrollment getEnrollmentById(Long enrollmentId) throws SomeThingWentWrongException;
}
