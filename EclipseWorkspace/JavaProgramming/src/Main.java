
import java.io.BufferedInputStream;
import java.io.InputStream;


public class Main{
   public static void main(String[] args) throws Exception{
       InputStream is = System.in;
	   
	   byte[] data= new byte[100];
	   int bytes=-1;
	   while(true){
		   bytes=is.read(data);
		   if(bytes==-1)
			   break;
		   System.out.print(new String(data,0,bytes));
	   }
	   
   }
}
