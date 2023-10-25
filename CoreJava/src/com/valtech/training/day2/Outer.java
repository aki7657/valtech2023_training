package com.valtech.training.day2;

public class Outer {

	private int x;

	public Inner createInner() {
		return new Inner(); /* Same as this.new Inner() */
	}

	public static interface abcd {

	}

	public abstract static class StaticInner implements abcd {

		public void jumpby10(Outer o) {

			o.x = o.x + 10;

		}

		public void jumpby100(Outer o) {

		}

	}

	private class Inner {

		public void printX() {
			System.out.println("X = " + x);

		}

		public void increment() {
			x++;
		}

	}

	public static void main(String[] args) {
		Outer o = new Outer();
		Outer o1 = new Outer();
		Outer.Inner i = o.createInner();
		Outer.Inner i1 = o.createInner();
		Outer.Inner i2 = o.createInner();
		Outer.Inner i3 = o1.createInner();
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
		i1.increment();
		i.printX();
		i3.increment();
		i3.printX();
		i3.increment();
		i3.printX();
		new Outer().createInner().printX();
		StaticInner si = new StaticInner() {

			@Override
			public void jumpby100(Outer o) {
				o.x = o.x + 100;
			}

		};
		
		si.jumpby10(o);
		si.jumpby100(o);
		i.printX();
		
		Arithmetic a = new Arithmetic() {
			
			@Override
			public int sub(int a, int b) {
				return 0;
			}
			
			@Override
			public int mul(int a, int b) {
				return 0;
			}
			
			@Override
			public int div(int a, int b) throws DivideByZeroException {
				return 0;
			}
			
			@Override
			public int add(int a, int b) {
				return 0;
			}
		};

	}

}
