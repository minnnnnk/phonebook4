package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Service
public class PhoneService {
		
	//필드
	@Autowired
	private PhoneDao phoneDao;
	//생성자
	
	//메소드gs
	
	//메소드일반
	
	//전화번호 리스트
	public List<PersonVo> getPersonList(){
		System.out.println("getPersonList");
		
		List<PersonVo> personList = phoneDao.getPersonList();
		
		return personList;
	}
	
	//전화번호 등록
	public int personInsert(PersonVo personVo) {
		System.out.println("getPersonInsert");
		int count = phoneDao.personInsert(personVo);
		
		return count;
	}
	
	//전화번호 등록(map을 사용하는 가상의 상황:문법설명)
	public int personInsert2() {
		
		//map을 만들어 사용
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", "황일영");
		pMap.put("hp", "010-3333-3333");
		pMap.put("company", "02-3333-3333");
		
		int count = phoneDao.personInsert2(pMap);
		
		return count;
	
	}
	
	public PersonVo getPerson(int personId) {
		System.out.println("getPerson");
		PersonVo pVo = phoneDao.getPerson(personId);
		
		return pVo;
	}
	
	public Map<String, Object> getPerson2(int no) {
		System.out.println("PhoneService>getPerson2");
		
		Map<String, Object> pMap = phoneDao.getPerson2(no);
		
		return pMap;
	}
	
	public int personUpdate(PersonVo personVo) {
		System.out.println("personUpdate");
		int count = phoneDao.personUpdate(personVo);
		
		return count;
	}
	public int personDelete(int personId) {
		System.out.println("personDelete");
		int count = phoneDao.personDelete(personId);
		
		return count;
	}
}
