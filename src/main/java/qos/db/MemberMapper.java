package qos.db;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {

	MemberDTO login(MemberDTO dto); 
	
}
