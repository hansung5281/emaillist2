package com.sds.icto.emaillist.test;

import java.sql.SQLException;
import java.util.List;

import com.sds.icto.emaillist.dao.EmailListDao;
import com.sds.icto.emaillist.vo.EmailListVo;

public class TestEmailListDao {
	public static void main(String[] args) {
		try {
			testInsert();
			testFetch();
			//testDelete();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void testInsert() throws ClassNotFoundException, SQLException{
		EmailListVo vo = new EmailListVo();
		vo.setFirstName("성현");
		vo.setLastName("한");
		vo.setEmail("aaa@naver.com");
		
		EmailListDao  dao = new EmailListDao(); 
		dao.insert(vo);
	}
	
	public static void testFetch() throws ClassNotFoundException, SQLException{
		EmailListDao dao = new EmailListDao();
		List<EmailListVo> list = dao.fetchList();
		
		for (EmailListVo vo : list) {
			
			System.out.print(vo.getNo() + ":");
			System.out.print(vo.getFirstName()+":");
			System.out.print(vo.getLastName()+":");
			System.out.print(vo.getEmail());
		}
	}
	
	public static void testDelete() throws ClassNotFoundException, SQLException{
		EmailListDao dao = new EmailListDao();
		dao.delete();
	}
}
