package qos.db;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface MemberMapper {

	MemberDTO login(MemberDTO dto); 
	
	boolean idChk(MemberDTO dto);
	
	int join(MemberDTO dto);
	
}
