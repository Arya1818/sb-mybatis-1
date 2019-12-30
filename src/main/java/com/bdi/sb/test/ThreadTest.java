package com.bdi.sb.test;

class SCV extends Thread {
	private String name;
	private int speed = 10;

	public SCV(String name) {
		this.name = name;
	}

	public void cheat(int speed) {
		this.speed = speed;
	}
	
	@Override
	public void run() {
		int sum = 0;
		for (int i = 0; i <= 50; i++) {
			try {
				Thread.sleep(this.speed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sum +=i;
			System.out.println(this.name + "SVC가 캔 미네랄 양:" + sum);
		}
		System.out.println(this.name + "미네랄 다캠!");
	}
}

public class ThreadTest {
	public static void main(String[] args) {
		Thread t1 = new SCV("첫번째");
		SCV t2 = new SCV("두번째");
		t2.cheat(5);
		t1.start(); //start를 호출했더니 run메서드를 실행해버림(쓰레드로 실행(비동기))
		t2.start();
	}
}