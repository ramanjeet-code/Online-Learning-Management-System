package Service;

import java.util.List;

import Dao.GradeDao;
import Dao.GradeDaoImpl;
import Entity.Grade;
import Exception.SomeThingWentWrongException;

public class GradeServiceImpl implements GradeService {
   
 static   GradeDao gradeDao= new GradeDaoImpl();
	public GradeServiceImpl() {
		// TODO Auto-generated constructor stub

	}

	public void addGrade(Grade grade) {
       
		try {
            gradeDao.addGrade(grade);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
    }

    @Override
    public void updateGrade(Grade grade) {
        try {
            gradeDao.updateGrade(grade);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
    }

    @Override
    public void deleteGrade(Long gradeId) {
        try {
            gradeDao.deleteGrade(gradeId);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
    }

    @Override
    public Grade getGradeById(Long gradeId) {
        try {
            return gradeDao.getGradeById(gradeId);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
        return null;
    }

    @Override
    public List<Grade> getGradesByStudent(Long studentId) {
        try {
            return gradeDao.getGradesByStudent(studentId);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
        return null;
    }

    @Override
    public List<Grade> getGradesByCourse(Long courseId) {
        try {
            return gradeDao.getGradesByCourse(courseId);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
        return null;
    }

    @Override
    public double getAverageGradeForCourse(Long courseId) {
        try {
            return gradeDao.getAverageGradeForCourse(courseId);
        } catch (SomeThingWentWrongException e) {
            // Handle exception or throw custom exception
        }
        return 0;
    }

}
