package www.dream.com.party.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


//본체
@Data
public class Party {
	private long id;
	private String name;
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date birthDate;
	private boolean sex;
	// private String address;
	
	List<ContactPoint> listContactPoint = new ArrayList<>();
	//starUML상에서  연관관계 
	
	
	public void addCP(ContactPoint cp) {
		listContactPoint.add(cp);
		
	}
	
}
