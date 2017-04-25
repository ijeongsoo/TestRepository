package ch11.homework01.exma04;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {

	public static void main(String[] args) {
		//테스팅 문자열
		String str ="123";
		
		try{
			//UTF-16으로 디코딩 
			byte[] bytesUTF16 = str.getBytes("UTF-16LE");
			
			//UTF-16으로 디코딩된 길이 출력 
			System.out.println("bytesUTF16.length: "+bytesUTF16.length);

			//UTF-16으로 디코딩된 내용 출;
			for(int i=0; i<bytesUTF16.length; i++){
				System.out.print(bytesUTF16[i]+ " ");
				
			}
			System.out.println();
			
			//다시 UTF-16으로 인코딩 
			String strUTF16 =new String(bytesUTF16, "UTF-16BE");
			
			//변환된 스트링 출력 
			System.out.println("bytesUTF16->StringUTF16 : "+strUTF16);
			
			
			
			System.out.println("------------------------------------------");
			
			//UTF-16LE로 디코딩
			byte[] bytesUTF16LE = str.getBytes("UTF-16LE");
			
			//UTF-16LE로 디코딩된 길이 출력 
			System.out.println("bytesUTF16LE.length: "+bytesUTF16LE.length);
			
			//UTF-16LE로 디코딩된 내용 출력 
			for(int i=0; i<bytesUTF16LE.length; i++){
				System.out.print(bytesUTF16LE[i]+ " ");				
			}
			System.out.println();
			
			//다시 UTF-16LE로 인코딩 
			String strUTF16LE =new String(bytesUTF16LE, "UTF-16LE");
			
			//변환된 스트링 출력 
			System.out.println("bytesUTF16LE->StringUTF16LE : "+strUTF16LE);
			
			
			
			
			System.out.println("------------------------------------------");
			
			
			
			//UTF-16BE로 디코딩 
			byte[] bytesUTF16BE = str.getBytes("UTF-16BE");
			
			//UTF-16BE으로 디코딩된 길이 출력 
			System.out.println("bytesUTF16BE.length: "+bytesUTF16BE.length);
			
			//UTF-16BE로 디코딩된 내용 출
			for(int i=0; i<bytesUTF16BE.length; i++){
				System.out.print(bytesUTF16BE[i]+ " ");				
			}
			System.out.println();
			
			//다시 UTF-16BE으로 인코딩 
			String strUTF16BE =new String(bytesUTF16BE, "UTF-16BE");
			
			//변환된 스트링 출력 
			System.out.println("bytesUTF16BE->StringUTF16BE : "+strUTF16BE);
			
			
		}catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
	}

}
