package com.cfyj.springcloud.zuul.hystrix;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 在zuul中使用Hystrix
 * 
 * @author exception
 *
 */
public class MyFallbackProvider implements ZuulFallbackProvider {

	@Override
	public String getRoute() {
		// TODO Auto-generated method stub
		 return "testHystrix"; 
	}

	@Override
	public ClientHttpResponse fallbackResponse() {

		return new ClientHttpResponse() {

			@Override
			public InputStream getBody() throws IOException {
				return new ByteArrayInputStream("fallback".getBytes());
			}

			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}

			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return 250;
			}

			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return "StatusText";
			}

			@Override
			public void close() {
				// TODO Auto-generated method stub

			}

		};
	}

}
