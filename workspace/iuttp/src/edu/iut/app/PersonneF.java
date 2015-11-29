package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PersonneF implements PersonneCretere{
	String s="Student";
	public List< ExamEvent> meetCriteria(List< ExamEvent> persons) {
		// TODO Auto-generated method stub
			List< ExamEvent> pd = new ArrayList< ExamEvent>(); 
			for ( ExamEvent person : persons) {
		         if((person.getStudent().getFunction().STUDENT).equals(s)){
		             pd.add(person);
		          }
		       }
			
		return pd;
	}

}
