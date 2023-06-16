package Dao;

import java.util.List;

import Entity.Student;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public interface StudentDao {
	 void addStudent(Student student) throws SomeThingWentWrongException;
	    void updateStudent(Student student) throws SomeThingWentWrongException, NoRecordFoundException;
	    void deleteStudent(Long studentId) throws SomeThingWentWrongException, NoRecordFoundException;
	    Student getStudentById(Long studentId)throws NoRecordFoundException;
	    List<Student> getAllStudents() throws SomeThingWentWrongException, NoRecordFoundException;
	    void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException;
}
