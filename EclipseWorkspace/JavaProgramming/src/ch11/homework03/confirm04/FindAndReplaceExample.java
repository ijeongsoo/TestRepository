package ch11.homework03.confirm04;

public class FindAndReplaceExample {

	public static void main(String[] args) {
		String str="������α׷��� �ڹ� ���� ���ߵ� �� �ִ�.";
		int index=str.indexOf("�ڹ�");
		if(index ==-1){
			System.out.println("�ڹٹ��ڿ��� ���ԵǾ� ���� �ʽ��ϴ�.");
		}else{
			System.out.println("�ڹٹ��ڿ��� ���ԵǾ� �ֽ��ϴ�.");
			str =str.replace("�ڹ�", "JAVA");
			System.out.println("->"+str);
		}
	}

}
