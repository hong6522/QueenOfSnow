package qos.db;


import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("mDTO")
@Data
public class MemberDTO {
	String id , pw , name ,tel , address1 ,address2;
	boolean privacy_chk , terms_chk;
}
