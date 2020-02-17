package com.example;

import io.jaegertracing.Configuration;
import io.jaegertracing.internal.JaegerTracer;
import io.jaegertracing.internal.samplers.ConstSampler;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName="echoServletFilterkptest", urlPatterns="/echo/*")
public class EchoServletFilterKpTest implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("EchoServletFilter filtering a request");
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		EchoServletFilteredRequest filteredRequest = new EchoServletFilteredRequest(httpRequest);

		//Add or Override Request Parameters Here
		filteredRequest.addParameter("extraParam1","Added in servlet filter");
		filteredRequest.addParameter("extraParam2","Also added in servlet filter");

		//Passed the FilteredRequest Along the Chain:

//		Span span = GlobalTracer.get().buildSpan("testFilter").start();

		chain.doFilter(filteredRequest, response);
//		span.finish();
		System.out.println("EchoServletFilter request filtering done");
	}

	@Override
	public void destroy() {

	}
}
