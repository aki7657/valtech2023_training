package com.valtech.training.spring;

public class SimpleInterestImpl implements SimpleInterest {

	private Arithmetic arithmetic;

//	to generate setter, right click then source then getters and setters. Or write set + ctrl + space and enter

	public SimpleInterestImpl(Arithmetic arithmetic) {
		// TODO Auto-generated constructor stub
		this.arithmetic = arithmetic;
	}

	public void setArithmetic(Arithmetic arithmetic) {
		this.arithmetic = arithmetic;
	}

	@Override
	public double computeInterest(int principle, int roi, int duration) {

		int result = arithmetic.mul(principle, roi);
		result = arithmetic.mul(result, duration);
		return arithmetic.div(result, 100);
//		PTR/100 for simple interest
		
	}
	
	public static void main(String[] args) {
		Arithmetic arithmetic = new ArithmeticImpl();
		SimpleInterest si = new SimpleInterestImpl(arithmetic);
		System.out.println(si.computeInterest(200, 3, 4));
	}

	public SimpleInterestImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	
