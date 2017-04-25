package ch09.exam02;

public class A {
	//Field 
	int aField;
	//Constructor
	A(){
		class D{
			//Field
			//Constructor
			//Method
			void dMethod(){
				aField=10;
			}
		}
		class E{
			void eMethod(){
				aField=10;
			}
		}
	}
	//Method
	void aMethod(){
		class D{}
		class E{}
	}
	//Nested Class
	class B{
			void eMethod(){
				aField=10;
		}
	}
	static class C{
		void eMethod(){
			//aField=10;
		}
	}
	
}
