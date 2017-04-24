package ch11.homework03.confirm01;

public class Student {
	private String studentNum;
	
	public Student(String studentNum){
		this.studentNum=studentNum;
	}
	
	public String getStudentNum(){
		return studentNum;
	}
	
	@Override
	public int hashCode() {
		return Integer.parseInt(studentNum);
	}
	
	@Override
	public boolean equals(Object obj) {
		Student st=(Student)obj;
		if(studentNum.equals(st.studentNum)){
			return true;
		}
		return false;
	}

}
