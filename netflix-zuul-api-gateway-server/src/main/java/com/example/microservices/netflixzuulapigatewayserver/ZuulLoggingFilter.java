package com.example.microservices.netflixzuulapigatewayserver;



import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

Logger log=LoggerFactory.getLogger(this.getClass());

	
	/*
	 * Should the filter be executed or not
	 * */
	
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/*
	 * Logic of the filter goes here
	 * */
	
	@Override
	public Object run() throws ZuulException {
		/*
		 * just log all the request info
		 * */
				HttpServletRequest request =
						RequestContext.getCurrentContext().getRequest();
		
				log.info("request -> {} \n requestURI -> {}",request,request.getRequestURI());
				
		return null;
	}

	/*
	 * When the filter should be executed ??
	 * before the request is executed "pre", after execution? "post"
	 * only error? "error"
	 * */
	
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	
	/*
	 * Setting priority for the filter
	 * if there are multiple filters
	 * setting priority as 1 now
	 * */
	@Override
	public int filterOrder() {
		return 1;
	}

}
