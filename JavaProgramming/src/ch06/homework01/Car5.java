package ch06.homework01;

public class Car5 {
	//Field
	int gas;
	
	//Constructor
	
	//Method
	//�Ű����� �޾Ƽ� gas�ʵ尪 ����
	void setGas(int gas){
		this.gas=gas;
	}
	
	//���� �� �� �� Ư�� ��� �� ���ϰ� ��ȯ
	boolean isLeftGas(){
		if(gas==0){
			System.out.println("gas�� �����ϴ�.");
			return false;
		}
		System.out.println("������ �ֽ��ϴ�.");
		return true;
	}
	
	//������ ������ �޸��� ���� ���� 
	void run(){
		while(true){
			if(gas >0){
				System.out.println("�޸��ϴ�. (gas�ܷ�:"+gas+")");
				gas-=1;
			}else{
				System.out.println("����ϴ�.(gas�ܷ�:"+gas+")");
				return; //�޼ҵ� ����
			}
		}
	}
}
