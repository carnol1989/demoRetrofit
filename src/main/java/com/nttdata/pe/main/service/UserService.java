package com.nttdata.pe.main.service;

import com.nttdata.pe.main.model.UserApiResponse;
import com.nttdata.pe.main.model.UsersApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

	@GET("/api/users/{id}")
	public Call<UserApiResponse> getUser(@Path("id") long id);
	
	@GET("/api/users")
	public Call<UsersApiResponse> getUsers(@Query("per_page") int pageSize, 
			@Query("page") int currentPage);
	
}
