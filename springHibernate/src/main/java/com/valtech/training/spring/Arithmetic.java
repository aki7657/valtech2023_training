package com.valtech.training.spring;

public interface Arithmetic {

	int ZERO = 0;
//	all variables should always be initialized so that it is a constant. It becomes public static final.

	int add(int a, int b);

//	interfaces don't have protected or default, only public
	int sub(int a, int b);

	int mul(int a, int b);

	int div(int a, int b);

//	methods can be overloaded with different variables inside

}
