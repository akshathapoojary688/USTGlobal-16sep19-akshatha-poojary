package com.ustglobal.stringclass;

public class TestA {
	
	public static void main(String[] args) {
		
		String s1 = "aishu";
		String s2 = "deepika";
		
		String s3 = new String("aishu");
		String s4 = new String("aishu");
		String s5 = "aishu";
		
		System.out.println(s1.equals(s2));  //it will compare the content 
		System.out.println(s3.equals(s4));   //equals method is an ovrrideen in string class
		System.out.println(s1.equals(s5));
		
		String s6 = s1.toLowerCase();
		System.out.println(s6);
		
		String s7 = s1.toUpperCase();
		System.out.println(s7);
		
		char c = s1.charAt(0);
		System.out.println(c);
		
		Boolean b = s1.equalsIgnoreCase("AISHu");
		System.out.println(b);

		System.out.println(s1.length());
		
		System.out.println("*******************");
		
		StringBuffer sb1 = new StringBuffer("kavya");
		sb1.append("priya");
		System.out.println(sb1);
		
		
		
		
		
		
		
		
		
		
		
	}

}
