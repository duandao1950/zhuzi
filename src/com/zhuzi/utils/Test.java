package com.zhuzi.utils;

import java.util.Random;

public class Test {

	private static Random random = new Random();
	private static String[] contentstrings = {"Íô·å","ÁõÊ«Ê«","Õ²Ä·Ë¹","»¦ÊĞ","Ğ¡Ã×","ÌïÁÁ","ÁÖÖ¾Ó±","ÕÅÕÙÖÒ","½ğ²ÓÈÙ","ÂŞÔ®"};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(random.nextInt(9));
		}
	}

}
