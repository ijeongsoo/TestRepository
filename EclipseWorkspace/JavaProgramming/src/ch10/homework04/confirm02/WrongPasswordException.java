package ch10.homework04.confirm02;

public class WrongPasswordException extends Exception{
	public WrongPasswordException() {
	
	}
	public WrongPasswordException(String message){
		super(message);
	}
}