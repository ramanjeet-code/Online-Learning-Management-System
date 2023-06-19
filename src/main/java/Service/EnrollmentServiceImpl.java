package Service;

import java.util.List;

import Dao.EnrollmentDao;
import Dao.EnrollmentDaoImpl;
import Entity.Enrollment;
import Exception.SomeThingWentWrongException;

public class EnrollmentServiceImpl implements EnrollmentService{

	public EnrollmentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void enrollStudent(Long courseId, Long studentId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EnrollmentDao edo=new EnrollmentDaoImpl();
		edo.enrollStudent(courseId, studentId);
	}

	@Override
	public void dropStudent(Long courseId, Long studentId) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		EnrollmentDao edo=new EnrollmentDaoImpl();
		edo.dropStudent(courseId, studentId);
	}

	@Override
	public List<Enrollment> getEnrollmentsByCourse(Long courseId) throws SomeThingWentWrongException {
		EnrollmentDao edo=new EnrollmentDaoImpl();
		return edo.getEnrollmentsByCourse(courseId);
	}

	@Override
	public List<Enrollment> getEnrollmentsByStudent(Long studentId) throws SomeThingWentWrongException {
		EnrollmentDao edo=new EnrollmentDaoImpl();
		return edo.getEnrollmentsByStudent(studentId);
	}

	@Override
	public boolean isEnrolled(Long courseId, Long studentId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTotalEnrolledStudents(Long courseId) throws SomeThingWentWrongException {
		EnrollmentDao edo=new EnrollmentDaoImpl();
		
		return edo.getTotalEnrolledStudents(courseId);
	}

	@Override
	public Enrollment getEnrollmentById(Long enrollmentId) throws SomeThingWentWrongException {
		EnrollmentDao edo=new EnrollmentDaoImpl();
		try {
		        Enrollment enrollment = edo.getEnrollmentById(enrollmentId);
		        if (enrollment == null) {
		            throw new SomeThingWentWrongException("Enrollment not found");
		        }
		        return enrollment;
		    } catch (Exception e) {
		        throw new SomeThingWentWrongException("Failed to retrieve enrollment"+ e);
		    }
	}

	





}
