package qos.instance;

import java.util.Calendar;

import org.springframework.web.bind.annotation.PathVariable;

import lombok.Data;

@Data
public class ReserCalendar {
	
	public String title;
	public String [] week = {"일","월","화","수","목","금","토"};
	public int month ,start ,firstSun , last , now , Dmonth , Rmonth , year;
	
	public ReserCalendar(int Pmonth) {
		Rmonth = Pmonth;
		
		Calendar today = Calendar.getInstance();
		
		month = today.get(Calendar.MONTH)+1;
		
		today.set(Calendar.MONTH,(month+Rmonth)-1);
		
		Calendar startDay = (Calendar) today.clone();
		startDay.set(Calendar.DAY_OF_MONTH, 1);
		
		start = startDay.get(Calendar.DAY_OF_WEEK);
		
		while (startDay.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			startDay.add(Calendar.DAY_OF_MONTH, 1);
        }
		
		firstSun = startDay.get(Calendar.DAY_OF_MONTH);
		
		last = today.getActualMaximum(Calendar.DATE);
		
		now = today.get(Calendar.DATE);
		
		if((today.get(Calendar.MONTH)+1)%12==0) {
			Dmonth = 12;
		}
		else {
			Dmonth =(today.get(Calendar.MONTH)+1)%12;
		}
		
		title = today.get(Calendar.YEAR)+"년 "+Dmonth+"월";
		
		year = today.get(Calendar.YEAR);
	}
	
	
	
	
	
}
