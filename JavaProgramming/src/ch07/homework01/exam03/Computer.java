package ch07.homework01.exam03;

public class Computer extends Calculator{
	@Override
	double areaCircle(double r) {
		System.out.println("Coumputer ��ü�� areaCircle() ����");
		return Math.PI*r*r;
	}
}
