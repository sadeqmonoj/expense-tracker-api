package com.sadeqm.expenseTrackerApi.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.GenericFilterBean;

import com.sadeqm.expenseTrackerApi.Constants;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class AuthFilter extends GenericFilterBean {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		String authHeader = httpRequest.getHeader("Authorization");
		if(authHeader != null) {
			String[] authHeaderArr = authHeader.split("Bearer ");
			
			if(authHeaderArr.length >1 && authHeaderArr[1] != null) {
				String token = authHeaderArr[1];
				
				try {
					
					Claims claims = Jwts.parser().setSigningKey(Constants.API_SECRET_KEY)
							.parseClaimsJws(token).getBody();
					
					httpRequest.setAttribute("userId", Integer.parseInt(claims.get("userId").toString()));
					
				}catch (Exception e) {
					// TODO: handle exception
					
					httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Invalid/Expired Token");
					return;
				}
				
			}else {
				httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization header must have bearer [token]");
				return;
			}
		}else {
			httpResponse.sendError(HttpStatus.FORBIDDEN.value(), "Authorization header NOT provieded");
			return;
		}
		
		chain.doFilter(request, response);
		
	}

}
