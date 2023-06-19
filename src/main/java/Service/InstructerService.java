package Service;

import Entity.Instructor;
import Exception.NoRecordFoundException;
import Exception.SomeThingWentWrongException;

public interface InstructerService {
  void  addInstructer(Instructor inst) throws SomeThingWentWrongException;
  void login(String email, String password) throws SomeThingWentWrongException, NoRecordFoundException;
}
