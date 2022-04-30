package com.createiq.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GetNameService {
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	public String getName() {
		String[] names= {"Raja","Rani","Roy","Joy","Balaji","Nethaji","Rajaji","Madhu"};
		return names[getRandomNumberInRange(0,7)];
	}

}
