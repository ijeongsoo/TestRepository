package ch11.exam04;

public class SystemExample {

	public static void main(String[] args) {
		System.setSecurityManager(new SecurityManager(){
			@Override
			public void checkExit(int status) {
				if(status != 1892){
					throw new SecurityException();
				}
			}
		});
		for(int i=0; i<10 ; i++){
			System.out.println(i);
			if(i==5){
				try{
					System.exit(1892);
				}catch(SecurityException e){
					
				}
			}
		}
		
	}

}
