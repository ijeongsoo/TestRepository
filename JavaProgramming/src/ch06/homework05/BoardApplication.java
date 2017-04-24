package ch06.homework05;

import java.util.Scanner;

import ch06.homework04.confirm09.Account;


public class BoardApplication {
	private static Member[] memberArray=new Member[100];
	private static Board[] boardArray=new Board[100];
	private static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) {
		Session sessionInfo=Session.getInstance();
		int selectNo;
		while(sessionInfo.getSessionID()==null){
			System.out.println("---------------------------");
			System.out.println("1.ȸ������ | 2.�α��� | 3.����");
			System.out.println("---------------------------");
			System.out.print("����>");
			
			selectNo=Integer.parseInt(scanner.nextLine());
			
			if(selectNo==1){
				createMember();	
			}else if(selectNo==2){
				login();
			}else if(selectNo==3){
				System.exit(0);
			}
			
			while(sessionInfo.getSessionID()!=null){
				System.out.println("-------------------------------------------------------------");
				System.out.println("1.�۸�Ϻ��� | 2.�۾��� | 3.�ۺ��� | 4.�ۻ��� | 5.ȸ����Ϻ��� | 6.�α׾ƿ�");
				System.out.println("-------------------------------------------------------------");
				System.out.print("����>");
			
				selectNo=Integer.parseInt(scanner.nextLine());
			
				if(selectNo==1){
					boardList();	
				}else if(selectNo==2){
					createBoard();
				}else if(selectNo==3){
					boardRead();
				}else if(selectNo==4){
					boardDelete();
				}else if(selectNo==5){
					memberList();
				}else if(selectNo==6){
					System.out.println(sessionInfo.getSessionID()+"�� �ȳ��� ������");
					sessionInfo.setSessionID(null);
				}
			
			}
		}
		
	}
	
	private static void memberList(){
		System.out.println("------------------------");
		System.out.println("        ȸ�� ��� ");
		System.out.println("-------------------------");
		
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]!=null){
				System.out.println(memberArray[i].getId());		
			}
		}
	}
	
	private static void boardDelete(){
		
		System.out.print("�۹�ȣ:");
		int boardNum=Integer.parseInt(scanner.nextLine());
		Board target=findBoard(boardNum);
		int target2=findBoard2(boardNum);
		Session session=Session.getInstance();
		if(target!=null&&target.getWriter()==session.getSessionID()){
			boardArray[target2]=null;
			System.out.println("���̻����Ǿ����ϴ�.");
		}else{
			System.out.println("�ش��ȣ�� ���� ���ų� �ۼ��ڰ� �ƴϾ ����� �����ϴ�.");
		}
		
	}
	
	private static void boardRead(){
		
		System.out.print("�۹�ȣ:");
		int boardNum=Integer.parseInt(scanner.nextLine());
		Board target=findBoard(boardNum);
		if(target!=null){
			System.out.println("�۹�ȣ :"+target.getBoardNum());
			System.out.println("������ :"+target.getTitle());
			System.out.println("�۳��� :"+target.getContent());
			System.out.println("�۾��� :"+target.getWriter());
		}else{
			System.out.println("�ش��ȣ�� ���� �����ϴ�.");
		}
		
	}
	
	private static void boardList(){
		System.out.println("---------------------------");
		System.out.println("   �Խù� ��� ");
		System.out.println("-------------------------");
		System.out.println("��ȣ     ����     �۾���");
		System.out.println("--------------------------");
		
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]!=null){
				System.out.println(boardArray[i].getBoardNum()+"   "+boardArray[i].getTitle()+"   "+boardArray[i].getWriter());		
			}
		}
	}
	
	private static void createBoard(){
		System.out.println("--------");
		System.out.println(" �۾���");
		System.out.println("--------");
		
		System.out.print("����:");
		String title=scanner.nextLine();
		
		System.out.print("����:");
		String content=scanner.nextLine();
		
		Session session=Session.getInstance();
		String writer=session.getSessionID();
		
		int boardnum=Board.getNextboardNum()+1;
		
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]==null){
				boardArray[i]=new Board(boardnum, title, content, writer);
				System.out.println(writer+"���� ���� ��� �Ǿ����ϴ�.");
				break;
			}
		}

	}
	
	private static void createMember(){
		System.out.println("--------");
		System.out.println(" ȸ������");
		System.out.println("--------");
		String id;
		while(true){
			System.out.print("ID:");
			id=scanner.nextLine();
			if(findID(id)){
				break;
			}
			System.out.println("���̵� �ߺ��Դϴ�.");
		}
		System.out.print("��й�ȣ:");
		String pw=scanner.nextLine();
		
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]==null){
				memberArray[i]=new Member(id, pw);
				System.out.println(id+"��ȸ������ �Ǿ����ϴ�.");
				break;
			}
		}

	}
	
	
	private static void login(){
		System.out.print("ID:");
		String id=scanner.nextLine();
		System.out.print("PW:");
		String pw=scanner.nextLine();
		Member target=findMember(id);
		if(target!=null&&target.getPw().equals(pw)){
			String sessionID=target.getId();
			Session session=Session.getInstance();
			session.setSessionID(sessionID);
			System.out.println("�α��� �Ǿ����ϴ�.");
			System.out.println(session.getSessionID()+"�� ȯ���մϴ�.");
		}else{
			System.out.println("���̵� Ȥ�� ��й�ȣ�� Ȯ�����ּ���");
		}
	}
	
	private static Member findMember(String id){
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]!=null&&memberArray[i].getId().equals(id)){
				return memberArray[i];	
				
			}
		}
		return null;
		
	}
	
	
	private static Board findBoard(int boardNum){
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]!=null&&boardArray[i].getBoardNum()==boardNum){
				return boardArray[i];	
				
			}
		}
		return null;
		
	}
	private static int findBoard2(int boardNum){
		for(int i=0; i<boardArray.length;i++){
			if(boardArray[i]!=null&&boardArray[i].getBoardNum()==boardNum){
				return i;	
				
			}
		}
		return -1;
		
	}
	
	private static boolean findID(String id){
		for(int i=0; i<memberArray.length;i++){
			if(memberArray[i]!=null&&memberArray[i].getId().equals(id)){
				return false;	
				
			}
		}
		return true;
		
	}
}
