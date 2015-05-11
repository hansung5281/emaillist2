package com.sds.icto.emaillist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.emaillist.vo.EmailListVo;
import com.sun.corba.se.spi.orbutil.fsm.State;

public class EmailListDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {

		Connection con = null;

		Class.forName("oracle.jdbc.driver.OracleDriver");
		String dburl = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(dburl, "webdb", "webdb");

		return con;
	}

	public void insert(EmailListVo vo) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		String sql = 
		"insert into email_list values(email_list_no_seq.nextval,?,?,?)";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, vo.getFirstName());
		st.setString(2, vo.getLastName());
		st.setString(3, vo.getEmail());
		st.executeUpdate();
		
		if (st != null) {st.close();}
		if (conn != null) {conn.close();}
	}

	public void delete() throws ClassNotFoundException, SQLException{
		Connection con = getConnection();
		Statement st = null;
		
		String sql = "delete from email_list";
		
		st = con.createStatement();
		st.executeUpdate(sql);
	}
	
	public List<EmailListVo> fetchList() 
			throws ClassNotFoundException, SQLException {
	
		List<EmailListVo> list = new ArrayList<EmailListVo>();
		Connection con = getConnection();
		Statement st = null;
		ResultSet rs = null;

		String sql = "select * from email_list";

		st = con.createStatement();
		rs = st.executeQuery(sql);

		while (rs.next()) {
			Long num = rs.getLong(1);
			String firstName = rs.getString(2);
			String lastName = rs.getString(3);
			String email = rs.getString(4);

			EmailListVo vo = new EmailListVo();
			vo.setNo(num);
			vo.setFirstName(firstName);
			vo.setLastName(lastName);
			vo.setEmail(email);

			list.add(vo);
		}

		if (rs != null) {rs.close();}
		if (st != null) {st.close();}
		if (con != null) {con.close();}
		return list;
	}
	
	public void delete(Long id){
		
	}
	
}
