package ch11.exam03;

public class MemberExample {

	public static void main(String[] args) {
		Member member = new Member("blue");
		System.out.println(member.toString());
		System.out.println(member);
		
		String result = member + " good!";
		System.out.println(result);
	}

}
