package qos.db;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("rDTO")
@Data
public class ReservationDTO {

	int Rmonth;
	
}
