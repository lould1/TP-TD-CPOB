package edu.iut.app;

import java.util.ArrayList;
import java.util.List;

public class Classr2 implements SalleCretere{
	
	public List< ExamEvent> meetCriteria(List< ExamEvent> salle) {
			List< ExamEvent> pd = new ArrayList< ExamEvent>(); 
			for ( ExamEvent s : salle) {
		         if(( s.getClassroom().getClassRoomNumber()).equals("2")){
		             pd.add(s);
		          }
		       }
			
		return pd;
	}
}
