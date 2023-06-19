package Dao;

import java.util.List;

import Entity.Grade;
import Exception.SomeThingWentWrongException;

public interface GradeDao {
	void addGrade(Grade grade) throws SomeThingWentWrongException;
    void updateGrade(Grade grade)throws SomeThingWentWrongException;
    void deleteGrade(Long gradeId)throws SomeThingWentWrongException;
    Grade getGradeById(Long gradeId)throws SomeThingWentWrongException;
    List<Grade> getGradesByStudent(Long studentId)throws SomeThingWentWrongException;
    List<Grade> getGradesByCourse(Long courseId)throws SomeThingWentWrongException;
    double getAverageGradeForCourse(Long courseId)throws SomeThingWentWrongException;
}