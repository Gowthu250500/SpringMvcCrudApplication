package com.techpalle.dao;

import java.sql.*;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;

import com.techpalle.model.Admin;
import com.techpalle.model.Student;

public class StudentDao 
{
	private static final String dbUrl = "jdbc:mysql://localhost:3306/spring";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	
	private static Connection con = null;
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	
	private static final String insertQry = "insert into student (name, email, pw, mobile) values(?, ?, ?, ?)";
	private static final String displayAllStudentsQry = "select * from student";
	private static final String studentEditQry = "select * from student where sno=?";
	private static final String updateQry = "update student set name=?, email=?, pw=?, mobile=? where sno=?";
	private static final String deleteQry = "delete from student where sno=?";
	
	private static final String validateAdmin = "select * from admin where username=? and password=?";
	
	public static ArrayList<Student> getAllStudents()
	{
		ArrayList<Student> al = new ArrayList<Student>();
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			s = con.createStatement();
			
			rs = s.executeQuery(displayAllStudentsQry);
			
			while(rs.next())
			{
				int i = rs.getInt("sno");
				String n = rs.getString("name");
				String e = rs.getString("email");
				String p = rs.getString("pw");
				long m = rs.getLong("mobile");
				
				Student s = new Student(i, n, e, p, m);
				
				al.add(s);
			}

		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs != null)
				{
					rs.close();
				}
				if(s != null)
				{
					s.close();
				}
				if(con != null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return al;
	}
	
	public static void insertStudent(Student s)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(insertQry);
			ps.setString(1, s.getSname());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(ps != null)
				{
					ps.close();
				}

				if(con != null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Student getOneStudent(int sno)
	{
		Student s = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(studentEditQry);
			ps.setInt(1, sno);
			
			rs = ps.executeQuery();
			
			rs.next();
			
			int i = rs.getInt("sno");
			String n = rs.getString("name");
			String e = rs.getString("email");
			String p = rs.getString("pw");
			long m = rs.getLong("mobile");
			
			s = new Student(i, n, e, p, m);
			
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs != null)
				{
					rs.close();
				}
				if(ps != null)
				{
					ps.close();
				}
				if(con != null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public static void updateStudent(Student s)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(updateQry);
			ps.setString(1, s.getSname());
			ps.setString(2, s.getEmail());
			ps.setString(3, s.getPassword());
			ps.setLong(4, s.getMobile());
			ps.setInt(5, s.getSno());
			
			ps.executeUpdate();
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(ps != null)
				{
					ps.close();
				}

				if(con != null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void deleteStudent(int sno)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(deleteQry);
			ps.setInt(1, sno);
			
			ps.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(ps != null)
				{
					ps.close();
				}

				if(con != null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	public static boolean validateAdmin(Admin a)
	{
		boolean b = false;
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
			
			ps = con.prepareStatement(validateAdmin);
			
			ps.setString(1, a.getUsername());
			ps.setString(2, a.getPassword());
			
			rs = ps.executeQuery();
			
			b = rs.next();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				if(rs != null)
				{
					rs.close();
				}
				if(ps != null)
				{
					ps.close();
				}

				if(con != null)
				{
					con.close();
				}
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		return b;
	}
}
