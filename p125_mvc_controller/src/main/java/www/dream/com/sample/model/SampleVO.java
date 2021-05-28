package www.dream.com.sample.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * VO : Value Object. 값을 담고 있는 객체.
 * 	- 화면에서부터 table까지 활용되는 것
 * 	- 인체구조를 비유로 들자면 '피'에 해당한다고 볼 수 있다 ^^;
 * 
 * DTO : Data(값) Transfer(전송) Object
 * 
 *
 * @Data //getter setter hashCode toString canEqual기능 활성화
 * */


@NoArgsConstructor

public class SampleVO {
	@Setter
	private String name;
	@Setter
	private int age;

	@Override //상위클래스에 있는 함수를 재정의 
	public String toString() {
		return "SampleVO [name=" + name + ", age=" + age + "]";
		//toString은 가능하면 Lombok 기능 쓰지말것 !
	}
	 
	
}
