package ch06.homework04.confirm04;

public class MemberService {
	//Field
	
	//Constructor
	
	//Method
	boolean login(String id, String password){
		if(id.equals("hong")&&password.equals("12345")){
			return true;
		}else{
			return false;
		}
	}
	
	void logout(String id){
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
	}
}
