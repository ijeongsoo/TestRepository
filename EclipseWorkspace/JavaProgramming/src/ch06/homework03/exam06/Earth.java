package ch06.homework03.exam06;

public class Earth {
	//��� ����, ������ �ٷ� �ʱ�ȭ 
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
	//��� �ʱ�ȭ�� static����� ���ؼ� ������ �߱�ȭ �����ϴ�. 
	static{
		EARTH_SURFACE_AREA = 4*Math.PI*EARTH_RADIUS *EARTH_RADIUS;
	}
}
