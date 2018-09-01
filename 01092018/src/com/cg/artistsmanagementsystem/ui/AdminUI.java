package com.cg.artistsmanagementsystem.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.sound.midi.SysexMessage;

import com.cg.artistsmanagementsystem.bean.ArtistBean;
import com.cg.artistsmanagementsystem.bean.ComposerBean;
import com.cg.artistsmanagementsystem.bean.UserBean;
import com.cg.artistsmanagementsystem.exception.AdminException;
import com.cg.artistsmanagementsystem.service.AdminServiceImpl;
import com.cg.artistsmanagementsystem.service.IAdminService;

public class AdminUI {
	IAdminService adminService=null;
    Scanner scanner=null;
    ComposerBean composer=null;
    ArtistBean artist=null;
    UserBean admin=null;
    AdminUI(UserBean admin)
    {	
    	this.admin=admin;
    	System.out.println("------------------------------ADMIN MENU------------------------------");
    	System.out.println("1.Search Composer");
		System.out.println("2.Add Composer");
		System.out.println("3.Edit Composer");
		System.out.println("4.Search Artist");
		System.out.println("5.Add Artist");
		System.out.println("6.Edit Artist");
		System.out.println("7.Assosciate Songs");
		System.out.println("8.Return to the Main Menu");
		System.out.println("9.Exit");
		System.out.println("-----------------------------------------------------------------------");
		System.out.print("Enter choice:");
    }
	public void adminMenu() throws IOException 
	{	int option;
		scanner=new Scanner(System.in);
		
		option=scanner.nextInt();
		switch(option)
		{
		case 1:	adminService=new AdminServiceImpl();
				scanner=new Scanner(System.in);
				try 
				{
				System.out.print("Enter Composer Id to be Searched:");
				int composerId=scanner.nextInt();
					composer=new ComposerBean();
					composer=adminService.searchComposer(composerId);
					if(composer!=null)
						System.out.println(composer);
					else
						System.out.println("No Composer Found!!!");
				} 
				catch (AdminException e)
				{
					System.out.print(e);
				}
				catch(InputMismatchException e)
				{
					System.err.println("Composer Id should be Numeric!");
				}
				System.err.flush();
				new AdminUI(admin).adminMenu();
				break;
		
		case 2: adminService=new AdminServiceImpl();
				scanner=new Scanner(System.in);
				composer=new ComposerBean();
				System.out.println("Enter the details of new composer:");
				System.out.print("Enter Composer Name(Max 50 Characters): ");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String name = br.readLine();
		        if(adminService.validateName(name))
				{	
					composer.setComposerName(name);
					System.out.print("Enter Composer Born Date(dd/mm/yyyy): ");
					String bornDate=scanner.next();
					if(adminService.validateDate(bornDate))
					{	
						composer.setComposerBornDate(bornDate);
						System.out.print("Enter Died Date(dd/mm/yyyy)(NA if not Applicable): ");
						String diedDate=scanner.next();
						if(adminService.validateDate(diedDate))
						{		if(diedDate.equals("NA"))
									diedDate=null;
							composer.setComposerDiedDate(diedDate);
							System.out.print("Enter Composer Caeipi Number(Max 10 Digits):");
							String number=scanner.next();
							if(adminService.validateCaeipiNumber(number))
							{	
								composer.setComposerCaeipiNumber(number);
								System.out.print("Enter Music Society ID(100/101/000): ");
								String societyId=scanner.next();
								if("100".equals(societyId)||"101".equals(societyId))
									composer.setComposerMusicSocietyID(societyId);
								else
									composer.setComposerMusicSocietyID("000");
								try 
						        {
						        		boolean status=adminService.addComposer(composer,admin);
						        		if(status)
						        			System.out.println("Composer Sucessfully Added!");
						        		else
						        			System.out.println("Composer Not Added!");
						        } 
						        catch (AdminException e) 
						        {
										System.err.println(e);
						        }
							}
							else
								System.err.println("Enter a Valid CaeipiNumber!");
						}else	
							System.err.println("Enter the Date in Correct Format!");
					}else
						System.err.println("Enter the Date in Correct Format!");
				}else
					System.err.println("Enter a Valid Name!");
			    
		        System.err.flush();
		        new AdminUI(admin).adminMenu();
			break;
		case 3: adminService=new AdminServiceImpl();
				scanner=new Scanner(System.in);
				
				try 
				{	
					System.out.print("Enter the Id of Composer:");
					int id=scanner.nextInt();
					composer=new ComposerBean();
					composer=adminService.searchComposer(id);
					if(composer!=null)
					{	
						System.out.println("What do you want to update?");
						System.out.println("1.Composer Name\n2.Composer Born Date\n3.Composer Died Date");
						System.out.println("4.Composer Caeipi Number\n5.Composer Music Society");
						System.out.print("Enter Choice: ");
						try
						{
							int choice=scanner.nextInt();
							switch(choice)
							{
							case 1: System.out.print("Enter new Composer name: ");
									BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
									String composerName = buffer.readLine();
							        if(adminService.validateName(composerName))
							        {	
							        	composer.setComposerName(composerName);
							        	if(adminService.updateComposerName(composer,admin))
							        		System.out.println("Composer Name Updated Successfully!");
							        	else
							        		System.out.println("Composer Name Not Updated!");
							        }
							        else
							        	System.err.println("Enter a Valid Name!");
							        break;
							case 2: System.out.print("Enter New Composer Born Date(dd/mm/yyyy): ");
									String bornDate=scanner.next();
									if(adminService.validateDate(bornDate))
									{
										composer.setComposerBornDate(bornDate);
										if(adminService.updateComposerBornDate(composer,admin))
											System.out.println("Composer Born Date Updated Successfully!");
										else
											System.out.println("Composer Born Date Not Updated!");
									}
									else
										System.err.println("Enter the Date in Correct Format!");
									break;
							case 3:	System.out.print("Enter New Composer Died Date(dd/mm/yyyy)(NA if not applicable): ");
									String diedDate=scanner.next();
									if(adminService.validateDate(diedDate))
									{		if(diedDate.equals("NA"))
												diedDate=null;
										composer.setComposerDiedDate(diedDate);
										if(adminService.updateComposerDiedDate(composer,admin))
											System.out.println("Composer Died Date Updated Successfully!");
										else
											System.out.println("Composer Died Date Not Updated!");
									}
									else
										System.err.println("Enter the Date in Correct Format!");
									break;
							case 4:	System.out.print("Enter New Composer Caepei Number: ");
									String number=scanner.next();
									if(adminService.validateCaeipiNumber(number))
									{
										composer.setComposerCaeipiNumber(number);
										if(adminService.updateComposerCaeipiNumber(composer,admin))
											System.out.println("Composer Caeipi Number Updated Successfully!");
										else
											System.out.println("Composer Caeipi Number Not Updated!");
									}
									else
										System.err.println("Enter a Valid CaeipiNumber!");
								break;
							case 5:System.out.print("Enter New Music Society Id(100/101/000):");
									String societyId=scanner.next();
									if("100".equals(societyId)||"101".equals(societyId))
										composer.setComposerMusicSocietyID(societyId);
									else
										composer.setComposerMusicSocietyID("000");
									if(adminService.updateComposerMusicSocietyId(composer,admin))
										System.out.println("Composer Music Society Id Updated Successfully!");
									else
										System.out.println("Composer Music Society Not Updated!");
								break;
							
							default:System.out.println("Invalid Option!");
							}
						}catch(InputMismatchException e)
						{
							System.err.println("Enter Correct Option!");
						}
					}	
					else
						System.out.println("No Composer Found!!!");
				} 
				catch (AdminException e)
				{
					System.out.print(e);
				}
				catch(InputMismatchException e)
				{
					System.err.println("Composer Id should be Numeric!");
				}
				new AdminUI(admin).adminMenu();
				System.err.flush();				
			break;
		case 4:	adminService=new AdminServiceImpl();
				scanner=new Scanner(System.in);
				try {
					System.out.print("Enter the Artist Id to be Searched: ");
					int artistId=scanner.nextInt();
					artist=adminService.searchArtist(artistId);
					if(artist!=null)
						System.out.println(artist);
					else
						System.out.println("No Artist Found!!!");
				} 
				catch (AdminException e)
				{
					System.err.println(e);
				}
				System.err.flush();
				new AdminUI(admin).adminMenu();
			break;
		case 5:	adminService=new AdminServiceImpl();
				scanner=new Scanner(System.in);
				artist=new ArtistBean();
				System.out.println("Enter the Details of New Artist:");
				System.out.print("Enter Artist Name(Max 50 Characters): ");
				
				BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
				String artistName = buffer.readLine();
		        if(adminService.validateName(artistName))
				{	
		        	artist.setArtistName(artistName);
		        	System.out.print("Enter Artist Type(1 Character): ");
		        	String type=scanner.next();
		        	if(adminService.validateType(type))
		        	{	
			        	artist.setArtistType(type);
						System.out.print("Enter Artist Born Date(dd/mm/yyyy): ");
						String bornDate=scanner.next();
						if(adminService.validateDate(bornDate))
						{	
							artist.setArtistBornDate(bornDate);
							System.out.print("Enter Died Date(dd/mm/yyyy)(NA if not Applicable): ");
							String diedDate=scanner.next();
							if(adminService.validateDate(diedDate))
							{		if(diedDate.equals("NA"))
										diedDate=null;
								artist.setArtistDiedDate(diedDate);
									try 
							        {
							        		boolean status=adminService.addArtist(artist,admin);
							        		if(status)
							        			System.out.println("Artist Sucessfully Added!");
							        		else
							        			System.out.println("Artist Not Added!");
							        } 
							        catch (AdminException e) 
							        {
											System.out.println(e);
							        }
							}else	
								System.err.println("Enter the Date in Correct Format!");
						}else
							System.err.println("Enter the Date in Correct Format!");
		        	}else
		        		System.err.println("Enter Only 1 Character!");
				}else
					System.err.println("Enter a Valid Name!");
			    System.err.flush();
		        new AdminUI(admin).adminMenu();
					break;
		case 6: 
			break;
		case 7:
			break;
		case 8:	ClientUI.main(null);
				break;
		case 9:	System.out.print("Application Terminated!");
				System.exit(0);
				break;
		default: System.out.println("Enter a valid option!");
					
		}
		
		
		
	}
}
