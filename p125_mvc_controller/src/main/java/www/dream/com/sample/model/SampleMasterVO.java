package www.dream.com.sample.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class SampleMasterVO {
	private int id;

	// 관계 속성, Master-Detail 관계. 1:N 관계
	private List<SampleVO> listSampleVO = new ArrayList<>();


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("SampleMasterVO [id=").append(id).append(", listSampleVO=");
		for (SampleVO obj : listSampleVO) {
			if (obj != null) {
				sb.append(obj.toString());
			}
		}
		sb.append("]");
		return sb.toString();
	}

}
