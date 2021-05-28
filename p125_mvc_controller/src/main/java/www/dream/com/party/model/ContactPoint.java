package www.dream.com.party.model;

import lombok.Data;

//가지
@Data
public class ContactPoint {
	// private long id; 정보가  있어야함
	private ContactPointType ContactPointType;
	private String value;
	
}
