package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Classr1 implements SalleCretere{
	
	public List< ExamEvent> meetCriteria(List< ExamEvent> salle) {
			List< ExamEvent> pd = new ArrayList< ExamEvent>(); 
			for ( ExamEvent s : salle) {
		         if(( s.getClassroom().getClassRoomNumber()).equals("1")){
		             pd.add(s);
		          }
		       }
			
		return pd;
	}
}