package www.dream.com.party.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import www.dream.com.party.model.ContactPoint;
import www.dream.com.party.model.ContactPointType;
import www.dream.com.party.model.Party;

@Controller // Q:Servlet Component로 Container에 담기기 위해서는 우리가 어디를 더 보고 확인해야하나요?
// A:servlet-context.xml
@RequestMapping("/party/*")
public class PartyController {
	
	/**
	 * party/registerParty를 호출하면 회원가입화면 열기
	 */
	
	@GetMapping(value = "registerParty1234")
	public void openRegisterPartyView1234() {
		System.out.println("openRegisterPartyView1234");
	}
	

	@GetMapping(value = "registerParty")
	public void openRegisterPartyView() {
		System.out.println("openRegisterPartyView");
	}
	
	
	/**
	 * Master-Detail 관계 -> 1:N관계
	 * party/creatParty 를 Post 방식으로 부를 때 작동하면서 인자와 객체 속성 이름을 짝지어주고
	 * 또한 객체 내부의 객체까지 만들어서 준다.
	 */
	
	@PostMapping(value = "createParty")
	public String createParty(Party obj, Model model) {
		System.out.println(obj);
		obj.setId(55);
		model.addAttribute("newbie", obj);
		
		/**
		 * 자바로 따지면
		 * Party newbie = obj;
		 * return newbie;
		 */
		
		
		return "party/confirmParty";
	}
	
	/**
	 * modelAndView 언제 사용한다고 ?
	 * AJax 에서 주로 사용합니다.
	 * @param obj
	 * @return
	 */
	@PostMapping(value = "createPartyAjax")
	public ModelAndView createPartyAjax(Party obj) {
		ModelAndView ret = new ModelAndView("party/confirmParty");
		System.out.println(obj);
		obj.setId(55);
		ret.addObject("newbie", obj);
		return ret;
	}
	
	@PostMapping(value = "createPartyByDefault")
	public String createParty(Party obj, @ModelAttribute("ageOfMine") int ageOfMine) {
		System.out.println(obj);
		System.out.println("내 ㅁㄴㅇㅁㄴ 나이 : " + ageOfMine);
		obj.setId(56);
		return "party/confirmParty";
	}
	
	
	// =====================================================================================================
	
	@PostMapping(value = "createPartyByRedirect")
	public String createPartyByRedirect(Party obj, RedirectAttributes rttr) {
		System.out.println(obj);
		obj.setId(56);
		rttr.addAttribute("newbie", 456);
		
		
		return "redirect:/party/redirectedParty";
	}
	
			
	//redirect Get방식으로 재요청한다.
	@GetMapping(value = "redirectedParty")
	public String confirmPartyRedirect (@RequestParam("newbie") int newbie, Model model) {
		System.out.println(newbie);
		Party obj = new Party();
		obj.setId(57);
		model.addAttribute("newbie", obj);
		
		return "/party/confirmParty";
	}
	
	// =====================================================================================================
	
	/** AJax RestAPI */
	@GetMapping("getJson")  // @GetMapping(value="getJson")<=이거랑 똑같음 
	public @ResponseBody Party getJSonOfParty() {
		Party obj = new Party();
		obj.setName("홍길동");
		obj.setId(57);
		
		
		ContactPoint cp = new ContactPoint();
		cp.setContactPointType(ContactPointType.mobileNum);
		cp.setValue("010-6232-4348");
		obj.addCP(cp);

		cp = new ContactPoint();
		cp.setContactPointType(ContactPointType.addr);
		cp.setValue("한양");
		obj.addCP(cp);

		return obj;
		
	}
	
	
	/**
	 * party/md 를 GET 방식으로 부를 때 작동하면서 인자와 객체 속성 이름을 짝지어서 객체까지 만들어줌
	 */
	@GetMapping(value = "md")
	public void creatParty(Party obj) {
		System.out.println(obj);
	}
	
	
}
