package com.valtech.training.spring.aop;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.aop.MethodBeforeAdvice;

public class CounterAdvice implements MethodBeforeAdvice {

	private Map<String, Integer> counters = new HashMap<String, Integer>();

	public void loadCounters() {
		try {
			File file = new File("counters.txt");
			if (file.exists()) {
				ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream(file));
				counters = (Map<String, Integer>) inputStream1.readObject();
				inputStream1.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println("loading counters" + counters);
	}

	public void saveCounters() {
		System.out.println("saving counters"+counters);
		try {
			ObjectOutputStream outputStream1 = new ObjectOutputStream(new FileOutputStream(new File("counters.txt")));
			outputStream1.writeObject(counters);
			outputStream1.flush();
			outputStream1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
//	Method is the name of the you want to invoke
//	args is the argument that will be passed to the method 
//	target is the actual object on which this method will be executed
	public void before(Method method, Object[] arg, Object target) throws Throwable {
		
		for (int i = 0; i < arg.length; i++) {
			int a = (Integer)arg[i];
			arg[i] = a % 2 == 0 ? a : - a;
		}
		
		String methodName = method.getName();
		System.out.println("Method being called is: " + methodName);
		System.out.println("Arguments being called are:" + ArrayUtils.toString(arg));
		if (counters.containsKey(methodName)) {
			counters.put(methodName, counters.get(methodName) + 1);
		} else {
			counters.put(methodName, 1);
		}
		System.out.println(counters);
	}

}
