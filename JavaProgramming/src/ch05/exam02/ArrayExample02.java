package ch05.exam02;

public class ArrayExample02 {

	public static void main(String[] args) {
		int[] v1={10, 20, 30};
		
		int[] v2;
		//v2={10,20,30};
		v2=new int[] {10, 20, 30};	//�ΰ� �ؼ��� �Ȱ����� �ȵǴ� ������ �����ϱ�� , �����Ϸ��� ��Ȯ�ϰ� �󸶸� �Ҵ����� ���ϴµ� �̷��� �ϸ� �󸶸� �ϴ��� ���� ������ �̷��� �ϸ� v2�� �������� �ʾҴµ� �����ϴ� ��ó�� �޾Ƶ帲
		
		int result1= sum(v1);
		int result2=sum(v2);
		//sum({10,20,30});   //v2={10,20,30} �� ���� ���
		int result3=sum(new int[] {10,20,30});	//�̷������� �־��־�� �Ѵ�. 
		System.out.println(result1 + result2 + result3);
	}

	public static int sum(int[] args){
		int sum=0;
		for(int i=0; i<args.length; i++){
			sum+=args[i];	
		}
		
		return sum;
				
	}
}
