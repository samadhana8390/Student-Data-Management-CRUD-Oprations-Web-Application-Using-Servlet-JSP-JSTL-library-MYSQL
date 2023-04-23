package Do;
import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modal.Student;
import util.DButillity;

public class StudentDAo 
{
		DButillity utilty;
		public StudentDAo()
		{
			utilty = new DButillity();
		}
		
		
		
		public int insertStudent(Student student,String url, String username, String password)
		{
			
			Connection con = utilty.getDBConnection(url,username,password);
			String sql = "insert into student1 values(?,?,?)";
			int i=0;
			List<Student> list = new ArrayList<Student>();
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1, student.getId());
				ps.setString(2, student.getName());
				ps.setDouble(3, student.getMarks());
					i=ps.executeUpdate();
					} 
			catch (SQLException e1)
			{
		
				e1.printStackTrace();
			}
			if(i>0)
			{
				return 1;
			}
			else {
				return 0;
			}
		}
		
	
		
	public List<Student> getAllStudent(String url, String username, String password)
	{
		Connection con = utilty.getDBConnection(url,username,password);
			String sql = "select * from student1 ";
		List<Student> list=new ArrayList<Student>();
		
		try
		{
				PreparedStatement ps = con.prepareStatement(sql);
				ResultSet rs= ps.executeQuery();
				
				
				while(rs.next())
				{
					Student s1=new Student();
					s1.setId(rs.getInt(1));
					s1.setName(rs.getString(2));
					s1.setMarks(rs.getDouble(3));
					
					list.add(s1);
							
				}
			
		}
		catch (Exception e) 
		{
				System.out.println(e);
		}
		return list;
		
	}
	
	
	
	


	public int Delete(int id, String url, String username, String password) 
	{
		int res = 0;
		try
		{
			Connection con = utilty.getDBConnection(url,username,password);
			
			String sql = " delete from student1  where id=? ";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(1,id);
				res = ps.executeUpdate();
				
		}
		catch (Exception e) 
		{
				System.out.println(e);
		}
		return res;
	
	}


	
	
	
	public int updateStudentData(Student student, String url, String username, String password) 
	{

		
		Connection con = utilty.getDBConnection(url,username,password);
		String sql = "update student1 set  name=? , marks=?  where id=?";
		int res = 0;
		try
		{
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setInt(3, student.getId());
				ps.setString(1, student.getName());
				ps.setDouble(2, student.getMarks());

				res = ps.executeUpdate();
		}
		catch (Exception e) 
		{
				System.out.println(e);
		}
		if (res > 0) 
		{
				return 1;
		} 
		else 
		{
				return 0;
		}

	}

	
	
	
	

	public Student updateServalet1(int id, String url, String username, String password) 
	{
		Connection con = utilty.getDBConnection(url,username,password);
		String sql = "select * from student1 where id=? ";
		Student s1=new Student();
	try
	{
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			ResultSet rs= ps.executeQuery();
			
			
			while(rs.next())
			{
				
				s1.setId(rs.getInt(1));
				s1.setName(rs.getString(2));
				s1.setMarks(rs.getDouble(3));
				
				
						
			}
		
	}
	catch (Exception e) 
	{
			System.out.println(e);
	}
	
	return s1;
	}
		
}
