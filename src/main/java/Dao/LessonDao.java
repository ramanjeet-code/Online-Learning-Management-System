package Dao;

import java.util.List;

import Entity.Lesson;
import Exception.SomeThingWentWrongException;

public interface LessonDao {
	void createLesson(Lesson lesson) throws SomeThingWentWrongException;

    void updateLesson(Lesson lesson) throws SomeThingWentWrongException;

    void deleteLesson(int lessonId) throws SomeThingWentWrongException;
    Lesson getLessonById(int lessonId) throws SomeThingWentWrongException;

    List<Lesson> getAllLessons() throws SomeThingWentWrongException;

    List<Lesson> getLessonsByCourse(Long courseId) throws SomeThingWentWrongException;

    int getLessonCount() throws SomeThingWentWrongException;
}
