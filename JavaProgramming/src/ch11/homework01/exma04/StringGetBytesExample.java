package ch11.homework01.exma04;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) {
		//�׽��� ���ڿ�
		String str ="123";
		
		try{
			//UTF-16���� ���ڵ� 
			byte[] bytesUTF16 = str.getBytes("UTF-16LE");
			
			//UTF-16���� ���ڵ��� ���� ��� 
			System.out.println("bytesUTF16.length: "+bytesUTF16.length);

			//UTF-16���� ���ڵ��� ���� ��;
			for(int i=0; i<bytesUTF16.length; i++){
				System.out.print(bytesUTF16[i]+ " ");
				
			}
			System.out.println();
			
			//�ٽ� UTF-16���� ���ڵ� 
			String strUTF16 =new String(bytesUTF16, "UTF-16BE");
			
			//��ȯ�� ��Ʈ�� ��� 
			System.out.println("bytesUTF16->StringUTF16 : "+strUTF16);
			
			
			
			System.out.println("------------------------------------------");
			
			//UTF-16LE�� ���ڵ�
			byte[] bytesUTF16LE = str.getBytes("UTF-16LE");
			
			//UTF-16LE�� ���ڵ��� ���� ��� 
			System.out.println("bytesUTF16LE.length: "+bytesUTF16LE.length);
			
			//UTF-16LE�� ���ڵ��� ���� ��� 
			for(int i=0; i<bytesUTF16LE.length; i++){
				System.out.print(bytesUTF16LE[i]+ " ");				
			}
			System.out.println();
			
			//�ٽ� UTF-16LE�� ���ڵ� 
			String strUTF16LE =new String(bytesUTF16LE, "UTF-16LE");
			
			//��ȯ�� ��Ʈ�� ��� 
			System.out.println("bytesUTF16LE->StringUTF16LE : "+strUTF16LE);
			
			
			
			
			System.out.println("------------------------------------------");
			
			
			
			//UTF-16BE�� ���ڵ� 
			byte[] bytesUTF16BE = str.getBytes("UTF-16BE");
			
			//UTF-16BE���� ���ڵ��� ���� ��� 
			System.out.println("bytesUTF16BE.length: "+bytesUTF16BE.length);
			
			//UTF-16BE�� ���ڵ��� ���� ��
			for(int i=0; i<bytesUTF16BE.length; i++){
				System.out.print(bytesUTF16BE[i]+ " ");				
			}
			System.out.println();
			
			//�ٽ� UTF-16BE���� ���ڵ� 
			String strUTF16BE =new String(bytesUTF16BE, "UTF-16BE");
			
			//��ȯ�� ��Ʈ�� ��� 
			System.out.println("bytesUTF16BE->StringUTF16BE : "+strUTF16BE);
			
			
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}

}
