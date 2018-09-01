package com.cg.artistsmanagementsystem.ui;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;
import com.cg.artistsmanagementsystem.service.AdminServiceImpl;
import com.cg.artistsmanagementsystem.service.IAdminService;
import com.cg.artistsmanagementsystem.service.IUserService;
import com.cg.artistsmanagementsystem.service.UserServiceImpl;

public class ClientUI {

	public static void main(String[] args) {
		
		int option;
		char choice='y';
		Scanner scanner=new Scanner(System.in);
		
		System.out.println("*******************************************************************");
		System.out.println("           MEDIA COMPOSER AND ARTISTS MANAGEMENT SYSTEM");
		System.out.println("******************************************************************");
		System.out.println("Menu:");
		System.out.println("1.Login as Admin");
		System.out.println("1.Login as User");
		System.out.println("3.Exit");
		do
		{
			try
			{
			System.out.print("Enter Your Choice:");
			option=(int)scanner.nextInt();
			
			switch(option)
			{
				case 1:	IAdminService adminService=new AdminServiceImpl();
						try{
							System.out.print("Enter Admin Id: ");
							int adminId=scanner.nextInt();
							System.out.print("Enter Password: ");
							String adminPwd=scanner.next();
							UserBean admin=new UserBean();
						
							admin.setUserId(adminId);
							admin.setUserPwd(adminPwd);
							if(adminService.login(admin))
								{
									System.out.println("Login Successfull");
									new AdminUI(admin).adminMenu();
								}
							else
								System.err.println("Invalid Username/Password!");
						}
						catch(InputMismatchException e)
						{
							System.err.println("Enter Digits Only!\n");
						} catch (Exception e) {
							e.printStackTrace();
							System.err.println(e);;
						}
						
						break;
				case 2:	IUserService userService=new UserServiceImpl();
						try{
							System.out.println("Enter User Id:");
							int userId=scanner.nextInt();
							System.out.println("Enter Password");
							String userPwd=scanner.next();
							UserBean user=new UserBean();
							
							user.setUserId(userId);
							user.setUserPwd(userPwd);
							
							if(userService.login(user))
							{
								System.out.println("LOGIN SUCCESSFULL!");
								
							}
							else
								System.out.println("Invalid Username/Password!");
						}
						catch(InputMismatchException e)
						{
							System.err.println("Enter Digits Only!");
						}
						
						break;
				case 3: System.out.println("Application Terminated!");
						System.exit(0);
						break;
				default:System.out.print("Please Enter a Valid Option!\n");		
			}
			scanner.nextLine();
			}
			catch(InputMismatchException e)
			{
				System.err.println("Please Enter a Valid Option!");
				scanner.nextLine();
			}
			
			System.out.print("Do you want to continue?(y/n) ");
			choice=scanner.next().charAt(0);
			
		}while(choice=='y'||choice=='y');
}
	


}
