package com.zhuzi.utils;

import java.util.Random;

public class Test {

	private static Random random = new Random();
	private static String[] contentstrings = {"����","��ʫʫ","ղķ˹","����","С��","����","��־ӱ","������","�����","��Ԯ"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(9));
		}
	}

}
