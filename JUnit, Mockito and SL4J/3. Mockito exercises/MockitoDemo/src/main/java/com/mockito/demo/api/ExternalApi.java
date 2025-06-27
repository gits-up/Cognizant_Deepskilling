package com.mockito.demo.api;

public interface ExternalApi {
	String getDataById(String id);
	void authenticate(String token);

}
