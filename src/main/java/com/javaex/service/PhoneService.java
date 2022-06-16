package com.javaex.service;

import java.util.List;

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
	
	public PersonVo getPerson(int personId) {
		System.out.println("getPerson");
		PersonVo pVo = phoneDao.getPerson(personId);
		
		return pVo;
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
