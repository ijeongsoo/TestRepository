package ch10.homework01.exam09;

public class Window {
	Button button1 = new Button();
	Button button2 = new Button();
	
	Button.OnClickListener listener = new Button.OnClickListener() {
		
		@Override
		public void onClick() {
			System.out.println("TV���մϴ�. ");
		}
	};
	
	Window(){
		button1.setListener(listener);
		button2.setListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("�޽����� �����ϴ�. ");
				
			}
		});
	}
}
