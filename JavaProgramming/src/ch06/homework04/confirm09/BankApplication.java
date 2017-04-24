package ch06.homework04.confirm09;

import java.util.Scanner;

public class BankApplication {
	private static Account[] accountArray=new Account[100];
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		boolean run=true;
		while(run){
			System.out.println("-----------------------------------------");
			System.out.println("1.���»��� | 2.���¸�� | 3.���� | 4.��� | 5.����");
			System.out.println("-----------------------------------------");
			System.out.print("����>");
		
		
			int selectNo=scanner.nextInt();
		
			if(selectNo==1){
				createAccount();	
			}else if(selectNo==2){
				accountList();
			}else if(selectNo==3){
				deposit();
			}else if(selectNo==4){
				withdraw();
			}else if(selectNo==5){
				run=false;
				
			}
			
		}
		System.out.println("���α׷� ����");
		
	}
	
	private static void createAccount(){
		scanner.nextLine();
		System.out.println("--------");
		System.out.println(" ���»���");
		System.out.println("--------");
		
		System.out.print("���¹�ȣ:");
		String ano=scanner.nextLine();
		
		System.out.print("������:");
		String owner=scanner.nextLine();
		
		System.out.print("�ʱ��Աݱݾ�:");
		int balance=Integer.parseInt(scanner.nextLine());
		for(int i=0; i<accountArray.length;i++){
			if(accountArray[i]==null){
				accountArray[i]=new Account(ano, owner, balance);
				System.out.println("���: ���°� �����Ǿ����ϴ�.");
				break;
			}
		}

	}
	
	private static void accountList(){
		System.out.println("--------");
		System.out.println(" ���¸��");
		System.out.println("--------");
		
		for(int i=0; i<accountArray.length;i++){
			if(accountArray[i]!=null){
				System.out.println(accountArray[i].getAno()+"   "+accountArray[i].getOwner()+"   "+accountArray[i].getBalance());		
			}
		}
	}
	
	private static void deposit(){
		scanner.nextLine();
		System.out.println("--------");
		System.out.println(" ����");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String ano=scanner.nextLine();
		System.out.print("�ݾ�:");
		int money=Integer.parseInt(scanner.nextLine());
		Account target=findAccount(ano);
		if(target!=null){
			money=target.getBalance()+money;
			target.setBalance(money);
			System.out.println("���:������ �����Ǿ����ϴ�.");
		}else{
			System.out.println("���:���� �����Դϴ�.");
		}
	}
	
	private static void withdraw(){
		scanner.nextLine();
		System.out.println("--------");
		System.out.println(" ���");
		System.out.println("--------");
		System.out.print("���¹�ȣ:");
		String ano=scanner.nextLine();
		System.out.print("�ݾ�:");
		int money=Integer.parseInt(scanner.nextLine());
		Account target=findAccount(ano);
		if(target!=null){
			money=target.getBalance()-money;
			target.setBalance(money);
			System.out.println("���:����� �����Ǿ����ϴ�.");
		}else{
			System.out.println("���:���� �����Դϴ�.");
		}
	}
	
	private static Account findAccount(String ano){
		for(int i=0; i<accountArray.length;i++){
			if(accountArray[i]!=null&&accountArray[i].getAno().equals(ano)){
				return accountArray[i];	
				
			}
		}
		return null;
		
	}

}
