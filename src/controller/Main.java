package controller;

import java.io.IOException;
import java.util.Scanner;

import model.Admin;
import model.Customer;
import services.Stocks;

public class Main {
	public static void main(String args[]) throws IOException {
		boolean success=false;
		String success_Username="";
		String success_Password="";
		int n_U=0;
		Scanner s=new Scanner(System.in);
		while(success==false) {
		System.out.println("Hi ! Welcome to the Stock Manager & Portfolio Manager");
		System.out.println("You Wish to Sign In as Customer or Admin");
		System.out.println("Enter 1 or 2 for Customer or Admin");
		int n=s.nextInt();
		if(n==1) {
			n_U=n;
			System.out.println("PLease Enter the Username");
			String username=s.next();
			System.out.println("Enter your Password");
			String password=s.next();
			Customer c=new Customer(username,password);
			success=c.checkDetails();
			success_Username=username;
		}else {
			n_U=n;
			System.out.println("PLease Enter the Username");
			String username=s.next();
			System.out.println("Enter your Password");
			String password=s.next();
			System.out.println("The username entered is "+username+"\nThe password entered is "+password);
			Admin a=new Admin(username,password);
			success=a.checkDetails();
			success_Username=username;
		}
		//Sign In code
			if(success==false) {
				System.out.println("Sorry please repeat the process");
			}
		}		
		
		if(success==true) {
			System.out.println("\tHi you have succesfully signed as "+success_Username);
				if(n_U==1) {
					System.out.println("\tPlease give an input selection\n\t1.View Stocks\n\t2.Transactions\n\t3.Interaday");
					int choice =s.nextInt();
					switch(choice) {
						case 1:{
							Stocks stock=new Stocks();
							System.out.println("Hi "+success_Username+" you have want to open the entire file or want a specfic portion of the file");
							System.out.println("For entire file enter 1 or specific part enter 2");
							int choiceSpecific=s.nextInt();
							if(choiceSpecific==1) {
								System.out.println("Your Stocks are loading ..... PLease Wait ......");
								stock.display();
							}else {
//								 	.out.println("Your");
								System.out.println("1. Display Stocks by specific character\n2. Display stocks by highest Previous Close\n3. Display stocks by highest Total Value");
								choiceSpecific=s.nextInt();
								boolean test=false;
								while(test==false) {
									switch(choiceSpecific) {
									case 1:
										System.out.println("Enter the character for fetching records");
										char abc=s.next().charAt(0);
										Stocks stock1=new Stocks();
										//code for specific character
										stock1.displayCharacterWise(abc);
										test=true;break;
									case 2:
										Stocks stock2=new Stocks();
										//code for highest prev close
										stock2.displayHighestPrevValue();
										test=true;break;
									case 3:
										Stocks stock3=new Stocks();
										//code for Highest total qty
										stock3.displayHighestQtyValue();
										test=true;break;
									case 4:
										System.out.println("Enter ISIN Number to fetch from the database");
										String ISIN=s.next();
										Stocks stock4=new Stocks();
										//code for ISIN Number
										test=true;break;
									case 5:
										System.out.println("Enter the Stock name");
										String stockName=s.next();
										Stocks stock5=new Stocks();
										//code for exact stock name
										
										test=true;break;
									default:System.out.println("Please Re Enter the value to start over again");
									}
								}
							}
						}
						case 2:{
							System.out.println("The values according to transaction are as follows .");
							System.out.println("Your Stocks are loading ..... PLease Wait ......");
							Stocks stock=new Stocks();
							stock.display();
						}
						case 3:{
							System.out.println("The values according to transaction are as follows .");
							System.out.println("Your Stocks are loading ..... PLease Wait ......");
							Stocks stock=new Stocks();
							stock.display();
						}
					}
				}else {
					//yet to write the funcitonality
					
				}
			}
		}
}
