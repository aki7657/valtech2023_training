package firstWeb;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class CounterFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("Destory if Counter Filter ...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("Do Filter of Counter Filter");
		Map<String, Integer> counters = (Map<String, Integer>) request.getServletContext().getAttribute("counters");
		HttpServletRequest req = (HttpServletRequest)request;
		String uri = req.getRequestURI();
//		counters.put(uri, counters.containsKey(uri) ? counters.get(uri) + 1 : 1)
		if(counters.containsKey(uri)) {
			//increment 
			counters.put(uri, counters.get(uri)+1);
		} else {
//			init to 1
			counters.put(uri, 1);
		}
		printCounter(counters);
		long a =  System.currentTimeMillis();
		long c = System.nanoTime();
//		long c = System.currentTimeNano()
		chain.doFilter(request, response);
		long b =  System.currentTimeMillis();
		long d = System.nanoTime();
		System.out.println(b -a);
		System.out.println(d-c);
//		this function lets us pass the value of the filter to the next filter/servlet etc so that it can do the needful
//		here if we use the dispatcher method, then we can reroute the user to the say for example login page 
	}

	private void printCounter(Map<String, Integer> counters) {
		for(String s:counters.keySet()) {
			System.out.println("Uri = "+" Counter "+counters.get(s));
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Init of Counter Filter ...");
		Map<String, Integer> counters = new HashMap<>();
		filterConfig.getServletContext().setAttribute("counters", counters);
		
	}
	
}
