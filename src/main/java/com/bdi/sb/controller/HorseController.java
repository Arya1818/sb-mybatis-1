package com.bdi.sb.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

class Horse extends Thread {
	private String horseName;
	private int speed;
	private int left = 0;

	public Horse(String horseName, int speed) {
		this.horseName = horseName;
		this.speed = speed;
	}

	public void run() {
		while (!this.isInterrupted()) {

			try {
				Thread.sleep(speed);
				left++;
				if (left != 50) {
					System.out.println(this.horseName + "," + left + "px");
				} else {
					System.out.println(this.horseName + "도착");
					this.interrupt();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int getLeft() {
		return left;
	}

	public String getHorseName() {
		return horseName;
	}
}

@RestController
@Slf4j
public class HorseController {
	private List<Horse> hList = new ArrayList<>();

	private void stopGame() {
		for (Horse h : hList) {
			h.interrupt();
		}
		hList.clear();
	}

	@PostMapping("/start/game/{cnt}")
	public List<Horse> startGame(@PathVariable("cnt") int cnt) {
		stopGame();

		Random r = new Random();

		for (int i = 1; i <= cnt; i++) {
			int speed = r.nextInt(100) + 1;
			Horse h = new Horse("말" + i, speed);
			hList.add(h);
		}
		System.out.println("시작했다고 칩시다~");
		for (int i = 0; i < hList.size(); i++) {
			hList.get(i).start();
		}

		return hList;
	}
}
