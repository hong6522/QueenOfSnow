package qos.db;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
	List<ReservationDTO> reserChk(ReservationDTO dto);
}
