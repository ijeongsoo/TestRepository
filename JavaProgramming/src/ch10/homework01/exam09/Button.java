package ch10.homework01.exam09;

public class Button {
	private OnClickListener listener;
	
	public void setListener(OnClickListener listener){
		this.listener=listener;
	}
	
	void touch(){
		listener.onClick();
	}
	
	interface OnClickListener{
		void onClick();
	}
}
