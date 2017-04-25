package ch10.homework04.confirm02;

public class NotExistIDException extends Exception{
	public NotExistIDException(){
		
	}
	
	public NotExistIDException(String message){
		super(message);
	}
}
