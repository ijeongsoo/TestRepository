package ch11.exam05;

public class Member {
	//Field
	private String id;
	
	//Constructor
	public Member(String id){
		this.id = id;
	}
	
	@Override
	protected void finalize() throws Throwable {
		System.out.println(id+"°¡ Á¦°ÅµÊ ");
	}
	
	//Method
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member){
			Member target = (Member)obj;
			if(this.id.equals(target.id)){
				return true;
			}
		}return false;
	}
}
