package com.nttdata.pe.main;

import com.nttdata.pe.main.model.UserApiResponse;
import com.nttdata.pe.main.model.UsersApiResponse;
import com.nttdata.pe.main.service.UserService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Demo Retrofit
 *
 */
public class App 
{
	public static final String BASE_URL = "https://reqres.in/";
	
    public static void main( String[] args )
    {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        
        Retrofit retrofit = new Retrofit.Builder()
        		.baseUrl(BASE_URL)
        		.addConverterFactory(GsonConverterFactory.create())
        		.client(httpClient.build())
        		.build();
        
        UserService service = retrofit.create(UserService.class);
        
        Call<UserApiResponse> callSync = service.getUser(12);
        try {
        	Response<UserApiResponse> response = callSync.execute();
        	UserApiResponse apiResponse = response.body();
        	System.out.println(apiResponse);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
        
        System.out.println("");
        Call<UsersApiResponse> callSync2 = service.getUsers(10, 2);
        try {
        	Response<UsersApiResponse> response2 = callSync2.execute();
        	UsersApiResponse apiResponse2 = response2.body();
        	System.out.println(apiResponse2);
        } catch(Exception ex) {
        	ex.printStackTrace();
        }
    }
}
