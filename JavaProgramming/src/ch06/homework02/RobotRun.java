package ch06.homework02;

public class RobotRun {

	public static void main(String[] args) throws Exception {
		Robot robot=new Robot();
		
		robot.powerOn();
		robot.head.mouth.welcom(robot.name);
		
		while(true){
			robot.head.mouth.tell("1. �ȱ�|2.�ɱ�|3.�Ͼ��|4.��|5.��|6.��|�׿�.����");
			robot.head.mouth.ask(">");
			robot.head.ear[0].hear();
		
			if(robot.head.ear[0].hearNum==1){
				robot.walk();
			}else if(robot.head.ear[0].hearNum==2){
				robot.seat();
			}else if(robot.head.ear[0].hearNum==3){
				robot.stand();
			}else if(robot.head.ear[0].hearNum==4){
				robot.head.mouth.tell("1.������|2.����");
				robot.head.mouth.ask(">");
				robot.head.ear[1].hear();
				robot.head.mouth.tell("1.���|2.������");
				robot.head.mouth.ask(">");
				robot.head.ear[2].hear();
				robot.arm[robot.head.ear[1].hearNum-1].move(robot.head.ear[2].hearNum);
			}else if(robot.head.ear[0].hearNum==5){
				robot.head.mouth.tell("1.����|2.�߱�");
				robot.head.mouth.ask(">");
				robot.head.ear[1].hear();
				if(robot.head.ear[1].hearNum==1){
					robot.head.eye.close();
				}else{
					robot.head.eye.open();
				}
			}else if(robot.head.ear[0].hearNum==6){
				robot.head.mouth.tell("1.���̱�|2.���|3.��β���|4.�·β���|5.��������");
				robot.head.mouth.ask(">");
				robot.head.ear[1].hear();
				robot.head.bow(robot.head.ear[1].hearNum);
			}else{
				robot.power.stop();
			}
		}
	}

}
