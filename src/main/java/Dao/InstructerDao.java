package Dao;

import Entity.Instructor;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public interface InstructerDao {
	 void  addInstructer(Instructor inst) throws SomeThingWentWrongException;
	 void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException;
}
