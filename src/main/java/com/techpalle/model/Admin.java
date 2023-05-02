package com.techpalle.model;

public class Admin 
{
	private int ano;
	private String username;
	private String password;
	
	public Admin()
	{
		super();
	}
	
	public Admin(String username, String password) 
	{
		super();
		this.username = username;
		this.password = password;
	}

	public Admin(int ano, String username, String password) 
	{
		super();
		this.ano = ano;
		this.username = username;
		this.password = password;
	}
	
	public int getAno() 
	{
		return ano;
	}
	public void setAno(int ano)
	{
		this.ano = ano;
	}
	public String getUsername() 
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	
}
