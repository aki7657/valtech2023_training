package com.valtech.training.firstspringboot.components;

//public abstract class ArithmeticImpl implements Arithmetic (If no implementations are made then abstract can remove the error because the compiler knows that we'll do it later)

public class ArithmeticImpl implements Arithmetic {

	@Override
	public int add(int a, int b) {
		return a + b;
	}

	@Override
	public int sub(int a, int b) {
		return a - b;
	}

	@Override
	public int mul(int a, int b) {
		return a * b;
	}

	@Override
	public int div(int a, int b) {
		return a / b;
	}

	public static void main(String[] args) /*
											 * throws DivideByZeroException this will remove error but try and error
											 * will give a good experience for the user
											 */ {

		Arithmetic a = new ArithmeticImpl();
		System.out.println(a.add(2, 3));
		System.out.println(a.sub(2, 3));
		System.out.println(a.mul(2, 3));
//		try {
//			System.out.println(a.div(6, 0));			
//		} catch (DivideByZeroException e) {
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println("Will this be seen...");
//		} finally {
//			System.out.println("Seen always");
//		}
		System.out.println(a.mul(4, 2));

	}

}
