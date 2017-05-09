package org.takastudy.data.dummydata.med.generator;

import java.time.LocalDateTime;
import java.util.Random;

public class GeneratorUtils {
	
	private static Random rnd = new Random();
	
	public static int getIntValueWithoutZero(int num){
		return rnd.nextInt(num)+1;
	}
	
	public static int getIntValue(int num){
		return rnd.nextInt(num);
	}
	
	public static LocalDateTime getDate(){
		int year = 2000 + GeneratorUtils.getIntValueWithoutZero(16);
		int month = GeneratorUtils.getIntValueWithoutZero(12);
		int day = GeneratorUtils.getIntValueWithoutZero(28);
		
		LocalDateTime d = LocalDateTime.of(year, month, day, 0, 0, 0);
		
		return d;
		
	}

	
}
