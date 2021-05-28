package www.dream.com.party.model;

public enum ContactPointType {

	addr("fdghj"), phoneNum("fghjk"), mobileNum("dfghj");
	
	private String validatingRegEx; 		// 정규식
	
	private ContactPointType(String validatingRegEx) {
		this.validatingRegEx = validatingRegEx;
	}
}
