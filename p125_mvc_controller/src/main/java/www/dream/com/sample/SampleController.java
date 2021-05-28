package www.dream.com.sample;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import www.dream.com.sample.model.SampleMasterVO;
import www.dream.com.sample.model.SampleVO;

@Controller // Q:Servlet Component로 Container에 담기기 위해서는 우리가 어디를 더 보고 확인해야하나요?
// A:servlet-context.xml
@RequestMapping("/sample/*")
public class SampleController {

	/**
	 * sample/ 부르면 작동
	 * 오류를 생길 수 있음 ! 
	 */

	@RequestMapping("")
	public void basic() {
		System.out.println("basic()을 실행한다.");
	}

	/**
	 * sample/gp를 'GET' 또는 'POST' 방식으로 부르면 작동
	 */

	@RequestMapping(value = "gp", method = { RequestMethod.GET, RequestMethod.POST })
	public void basic4getAndPost() {
		System.out.println("basic4getAndPost()을 실행한다.");
	}

	/**
	 * sample/get을 'GET'방식으로 부르면 작동
	 */

	@GetMapping(value = "get")
	public void basic4getOnly() {
		System.out.println("basic4getOnly()을 실행한다.");
	}

	/**
	 * sample/post를 'POST'방식으로 부르면 작동
	 */

	@PostMapping(value = "post")
	public void basic4postOnly() {
		System.out.println("basic4postOnly()을 실행한다.");
	}

	/**
	 * sample/param 을 'GET'방식으로 부를때 작동하며 인자 (name과 ag)까지 변수로 자동형변환해준다. ex)
	 * sample/param?name=홍길동&ag=65465 부르면 작동
	 * 
	 */

	@GetMapping(value = "param")
	public void basic4ReqParam(@RequestParam("name") String name, @RequestParam("ag") int age) {
		System.out.println("name = " + name);
		System.out.println("age = " + age);
	}

	/**
	 * sample/param 을 'GET'방식으로 부를때 작동하며 인자와 객체 속성 이름을 짝지어서 객체까지 만들어준다.(String name과 int age)까지 변수로 자동형변환해준다. 
	 * ex) sample/param?name=홍길동&age=65465 부르면 작동
	 */

	@GetMapping(value = "vo")
	public void basic4SampleVO(SampleVO obj) {
		System.out.println(obj);
	}

	@GetMapping(value = "vo4d")
	public void basic4SampleVO(SVO4Debugging obj) {
		System.out.println(obj);
	}
	
	
	
	/**
	 * List<String> interface로는 객체 생성 못해서 오류난다. @RequestParam("ids")로 지정해 주지 않았더니
	 * List 객체로 매핑이 안됨
	 * @param ids
	 */
	@GetMapping(value = "list")
	public void basic4List(@RequestParam("ids") ArrayList<String> ids) {
		for (String str : ids) {
			System.out.println(str);
		}
	}
	
	
	/**
	 * 배열의 경우 동일 이름이 @RequestParam이 없어도 구동된다.    
	 * 	- ArrayList보다 편리함
	 * @param ids
	 * 
	 *  @RequestParam으로 이름을 지정할시에는   예를들면 @RequestParam("id")
	 *  
	 * http://localhost:8080/com/sample/arr?id=홍길동
	 * 이런식으로 맞춰줘야한다.
	 * 
	 */
	@GetMapping(value = "arr")
	public void basic4Array(@RequestParam("ida") String[] ids) {
		for (String str : ids) {
			System.out.println(str);
		}
	}
	

	/**
	 * sample/vo 를 GET 방식으로 부를 때 작동하면서 인자와 객체 속성 이름을 짝지어서 객체까지 만들어줌
	 * ~/sample/masterDetail?id=0001&listSampleVO%5B0%5D.name=홍길동&listSampleVO%5B1%5D.name=이순신&listSampleVO%5B0%5D.age=555&listSampleVO%5B1%5D.age=1000
	 * @param obj
	 */
	
	@GetMapping(value = "masterDetail")
	public void basic4MasterDetail(SampleMasterVO obj) {
		System.out.println(obj);
	}
	
	
}
