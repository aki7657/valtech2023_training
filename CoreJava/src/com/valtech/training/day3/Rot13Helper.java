package com.valtech.training.day3;

import java.util.Iterator;

public class Rot13Helper {
	
	public static char rotate(char achar ) {
		
		if (achar >= 'a' && achar <='m') {
			achar = (char)(achar + 13);
		}
		else if(achar >= 'n' && achar <='z') {
			achar = (char)(achar - 13);
		}
		else if(achar >= 'A' && achar <='M') {
			achar = (char)(achar + 13);
		}
		else if(achar >= 'N' && achar <='Z') {
			achar = (char)(achar - 13);
		}
		return achar;
//		Other method of doing for capital as well if (achar >= 'a' && achar <='m' || achar achar >= 'A' && achar <='M' ) and same from N to Z
	}
	
	public static void main(String[] args) {
		
		String s = "Hello World!";
		for (int i = 0; i < s.length();i++) {
			
			System.out.println(rotate(/*rotate*/(s.charAt(i))));
		
		}
		
	}

}
