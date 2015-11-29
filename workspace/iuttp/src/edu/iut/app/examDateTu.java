package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class examDateTu implements DateCretere{

	@Override
	public List< ExamEvent> meetCriteria(List< ExamEvent> persons) {
		// TODO Auto-generated method stub
			List< ExamEvent> pd = new ArrayList< ExamEvent>(); 
			for ( ExamEvent person : persons) {
		         if((( Date) person.getExamDate()).equals("TUESDAY")){
		             pd.add(person);
		          }
		       }
			
		return pd;
	}

}
