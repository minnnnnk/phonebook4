package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhoneService;
import com.javaex.vo.PersonVo;

@Controller
public class PhoneController {

	// 필드
	@Autowired
	private PhoneService PhoneService;  // = new PhoneDao(); 
	// 생성자

	// 메소드 gs

	// 메소드 일반

	@RequestMapping(value="list", method = {RequestMethod.GET,RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list");
		
		//PhoneDao phoneDao = new PhoneDao();
		//service를 통해서 주소를 가져옴
		List<PersonVo> pList = PhoneService.getPersonList();
		
		System.out.println(pList);
		model.addAttribute("pList", pList);
		
		return "list";
	}
	
	// 등록 (@ModelAttribute 사용)
	@RequestMapping(value = "write", method = { RequestMethod.GET, RequestMethod.POST })
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write");
		
		//파라미터 꺼내기
		
		
		// vo로 묶기 -> modelAttrubute가 다해줌
		//PersonVo personVo = new PersonVo(name, hp, company);
		System.out.println(personVo);
		// 다오로 저장 -> service가 다해줌
		//PhoneDao phoneDao = new PhoneDao();
		PhoneService.personInsert(personVo);
		
		return "redirect:/list";
	}

	// 등록메소드 폼
	@RequestMapping(value = "writeForm", method = { RequestMethod.GET, RequestMethod.POST })
	public String writeForm() {
		System.out.println("PhoneController>writeForm");
		return "writeForm";
	}
	// 수정폼메소드
	@RequestMapping(value="updateForm",method = {RequestMethod.GET,RequestMethod.POST})
	public String modifyForm(Model model,@RequestParam("personId") int personId) {
		System.out.println("PhoneController>updateForm");
		
		//PhoneDao pDao = new PhoneDao();
		
		PersonVo pVo = PhoneService.getPerson(personId);
		
		System.out.println(pVo);
		
		model.addAttribute("pVo",pVo);
		
		return "updateForm";
	}
	// 수정 메소드
	@RequestMapping(value="update",method= {RequestMethod.GET,RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>update");

		
		// pDao = new PhoneDao();
		System.out.println(personVo);
		
		PhoneService.personUpdate(personVo);
		
		return "redirect:/list";
	}
	// 삭제메소드
	@RequestMapping(value="delete",method= {RequestMethod.GET,RequestMethod.POST})
	public String delete(@RequestParam("personId") int personId) {
		System.out.println("PhoneController>delete");
		//PhoneDao pDao = new PhoneDao();
		
		System.out.println(personId);
		PhoneService.personDelete(personId);
		
		
		return "redirect:/list";
	}
	// 리스트메소드

}
