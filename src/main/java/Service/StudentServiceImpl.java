package Service;

import java.util.List;

import Dao.StudentDao;
import Entity.Student;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public class StudentServiceImpl implements StudentService{
	private StudentDao studentDao;
	public StudentServiceImpl(StudentDao studentDao) {
		// TODO Auto-generated constructor stub
		 this.studentDao = studentDao;
	}

	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addStudent(Student student) throws SomeThingWentWrongException {
		// TODO Auto-generated method stub
		studentDao.addStudent(student);
	}

	@Override
	public void updateStudent(Student student) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		  studentDao.updateStudent(student);
	}

	@Override
	public void deleteStudent(Long studentId) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		   studentDao.deleteStudent(studentId);
	}

	@Override
	public Student getStudentById(Long studentId) throws NoRecordFoundException {
		 return studentDao.getStudentById(studentId);
	}

	@Override
	public List<Student> getAllStudents() throws SomeThingWentWrongException, NoRecordFoundException {
		return studentDao.getAllStudents();
	}

	@Override
	public void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException {
		// TODO Auto-generated method stub
		
	}

}
