package com.javaex.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PersonVo;

@Repository
public class PhoneDao {
	
	@Autowired
	private SqlSession sqlsession;
	
	
	//리스트
	public List<PersonVo> getPersonList() {	
		System.out.println("phoenDao>getPersonList");
		List<PersonVo> personList = sqlsession.selectList("phonebook.selectList");
		
		return personList;
	}
	

	// 사람 추가
	public int personInsert(PersonVo personVo) {
		System.out.println("phoneDao>personInsert");
		
		int count = sqlsession.insert("phonebook.personInsert",personVo);
		
		System.out.println(count+"건 등록되었습니다");
		
		return count;
	}
	
	//사람추가2 (map을 사용하는 가상의 상황)
	public int personInsert2(Map<String, String> pMap) {
		System.out.println("phoneDao> personInsert2");
		
		
		int count = sqlsession.insert("phonebook.personInsert2",pMap);
		
		System.out.println(count+"건 등록되었습니다 2");
		
		return count;
	}
	

	// 사람 수정
	public int personUpdate(PersonVo personVo) {
		System.out.println("phoneDao>personUpdate");
		int count = sqlsession.update("phonebook.personUpdate",personVo);
		
		System.out.println(count+"건 변경되었습니다");
		return count;
	}
	
	// 사람 삭제
	public int personDelete(int personId) {
		System.out.println("phoneDao>personDelete");
		int count = sqlsession.delete("phonebook.personDelete", personId);
		System.out.println(count+"건 삭제되었습니다");
		return count;
	}
	
	// 1명 정보 가져오기
	public PersonVo getPerson(int personId) {
		
		PersonVo personVo = sqlsession.selectOne("phonebook.getPerson", personId);	
		
		return personVo;
	}
	
	
	public Map<String, Object> getPerson2(int no) {
		System.out.println("PhoneDao>getPerson2");
		System.out.println(no);
		
		Map<String, Object> pMap = sqlsession.selectOne("phonebook.getPerson2",no);
		
		
		return pMap;
	}

}