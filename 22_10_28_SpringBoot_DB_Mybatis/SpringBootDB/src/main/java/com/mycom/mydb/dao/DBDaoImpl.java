package com.mycom.mydb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.mydb.dto.EmpDto;

@Repository
public class DBDaoImpl implements DBDao{
	
	@Autowired
	DataSource dataSource;

	@Override
	public EmpDto empDetail(int employeeId) {
		EmpDto dto = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select employeeId, first_name, last_name, email, hiredate ")
			.append(" from emp where employeeId = ? ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, employeeId);
			
			rs= pstmt.executeQuery();
			if(rs.next()) {
				dto= new EmpDto();
				dto.setEmployeeId(rs.getInt("employeeId"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hiredate"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close();}
				if(con != null) { con.close();}
				if(pstmt != null) { pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}

	@Override
	public List<EmpDto> empList() {
		List<EmpDto> dtoList = new ArrayList();
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append("select employeeId, first_name, last_name, email, hiredate ")
			.append(" from emp ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			rs= pstmt.executeQuery();
			while(rs.next()) {
				EmpDto dto= new EmpDto();
				dto.setEmployeeId(rs.getInt("employeeId"));
				dto.setFirstName(rs.getString("first_name"));
				dto.setLastName(rs.getString("last_name"));
				dto.setEmail(rs.getString("email"));
				dto.setHireDate(rs.getString("hiredate"));
				dtoList.add(dto);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close();}
				if(con != null) { con.close();}
				if(pstmt != null) { pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dtoList;
	}

	@Override
	public int empInsert(EmpDto dto) {
	
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" insert into emp (employeeId, first_name, last_name, email, hiredate) ")
			.append(" values ( ?, ?, ?, ?, ?) ");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, dto.getEmployeeId());
			pstmt.setString(2, dto.getFirstName());
			pstmt.setString(3, dto.getLastName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getHireDate());
			
			
			ret= pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close();}
				if(con != null) { con.close();}
				if(pstmt != null) { pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

	@Override
	public int empDelete(int employeeId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(" delete from emp ")
			.append(" where employeeId = ?");
			
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1,employeeId);
			
			ret= pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close();}
				if(con != null) { con.close();}
				if(pstmt != null) { pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}

	@Override
	public int empChange(EmpDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;
		try {
			con = dataSource.getConnection();
			StringBuilder sb = new StringBuilder();
			int employeeId=dto.getEmployeeId();
			
			sb.append(" update emp set first_name= ?, last_name= ?, email= ?, hiredate= ? ")
			.append(" where employeeId = ?  ");
			
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, dto.getFirstName());
			pstmt.setString(2, dto.getLastName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getHireDate());
			pstmt.setInt(5,employeeId);
			
			ret= pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) { rs.close();}
				if(con != null) { con.close();}
				if(pstmt != null) { pstmt.close();}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return ret;
	}
	
}
