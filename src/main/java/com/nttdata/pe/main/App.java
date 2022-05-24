package com.nttdata.pe.main;

import com.nttdata.pe.main.model.UserApiResponse;
import com.nttdata.pe.main.model.UserResponse;
import com.nttdata.pe.main.model.UsersApiResponse;
import com.nttdata.pe.main.service.UserService;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Demo Retrofit
 *
 */
public class App {
	public static final String BASE_URL = "https://reqres.in/";

	public static void main(String[] args) {
		OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(BASE_URL)
				.addConverterFactory(GsonConverterFactory.create())
				.client(httpClient.build()).build();

		UserService service = retrofit.create(UserService.class);
		
		getUserMainAsync(service);
		getUsersMainAsync(service);
		createUserMainAsync(service);
		updateUserMainAsync(service);
		deleteUserMainAsync(service);
	}
	
	public static void getUserMainAsync(UserService service) {
		System.out.println("getUser Async");
		Call<UserApiResponse> callSyncGet = service.getUser(12);
		callSyncGet.enqueue(new Callback<UserApiResponse>() {			
			@Override
			public void onResponse(Call<UserApiResponse> call, Response<UserApiResponse> response) {
				UserApiResponse usersApi = response.body();
				System.out.println("Response code: " + response.code());
				System.out.println(usersApi);
			}
			
			@Override
			public void onFailure(Call<UserApiResponse> call, Throwable t) {
				call.cancel();
				System.err.println("Mensaje: " + t.getMessage() + "\nCausa: " + t.getCause());
			}
		});		
	}
	
	public static void getUserMainSync(UserService service) {
		System.out.println("getUser Sync");
		Call<UserApiResponse> callSyncGet = service.getUser(12);
		try {
			Response<UserApiResponse> responseGet = callSyncGet.execute();
			UserApiResponse apiResponse = responseGet.body();
			System.out.println("Response code: " + responseGet.code());
			System.out.println(apiResponse);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void getUsersMainAsync(UserService service) {
		System.out.println("getUsers Async");
		Call<UsersApiResponse> callSyncGets = service.getUsers(10, 2);
		callSyncGets.enqueue(new Callback<UsersApiResponse>() {
			@Override
			public void onResponse(Call<UsersApiResponse> call, Response<UsersApiResponse> response) {
				UsersApiResponse usersApi = response.body();
				System.out.println("Response code: " + response.code());
				System.out.println(usersApi);
			}

			@Override
			public void onFailure(Call<UsersApiResponse> call, Throwable t) {
				call.cancel();
				System.err.println("Mensaje: " + t.getMessage() + "\nCausa: " + t.getCause());
			}
		});
	}

	public static void getUsersSync(UserService service) {
		System.out.println("getUsers Sync");
		Call<UsersApiResponse> callSyncGets = service.getUsers(10, 2);
		try {
			Response<UsersApiResponse> responseGets = callSyncGets.execute();
			UsersApiResponse apiResponse2 = responseGets.body();
			System.out.println("Response code: " + responseGets.code());
			System.out.println(apiResponse2);
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static void createUserMainAsync(UserService service) {
		System.out.println("createUser Async");
		UserResponse userCreate = new UserResponse("Carlos", "developer");
		Call<UserResponse> callSyncCreate = service.createUser(userCreate);
		callSyncCreate.enqueue(new Callback<UserResponse>() {
			@Override
			public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
				UserResponse userCreated = response.body();
				System.out.println("Response code: " + response.code());
				System.out.println(userCreated);
			}

			@Override
			public void onFailure(Call<UserResponse> call, Throwable t) {
				call.cancel();
				System.err.println("Mensaje: " + t.getMessage() + "\nCausa: " + t.getCause());
			}
		});
	}

	public static void updateUserMainAsync(UserService service) {
		System.out.println("updateUser Async");
		UserResponse userUpdate = new UserResponse("Carlos Augusto", "TL");
		Call<UserResponse> callSyncUpdate = service.updateUser(2, userUpdate);
		callSyncUpdate.enqueue(new Callback<UserResponse>() {
			@Override
			public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
				UserResponse userUpdated = response.body();
				System.out.println("Response code: " + response.code());
				System.out.println(userUpdated);
			}

			@Override
			public void onFailure(Call<UserResponse> call, Throwable t) {
				call.cancel();
				System.err.println("Mensaje: " + t.getMessage() + "\nCausa: " + t.getCause());
			}
		});
	}

	public static void deleteUserMainAsync(UserService service) {
		System.out.println("deleteUser Async");
		Call<Void> callSyncDelete = service.deleteUser(2);
		callSyncDelete.enqueue(new Callback<Void>() {
			@Override
			public void onResponse(Call<Void> call, Response<Void> response) {
				System.out.println("Response code: " + response.code());
			}

			@Override
			public void onFailure(Call<Void> call, Throwable t) {
				call.cancel();
				System.err.println("Mensaje: " + t.getMessage() + "\nCausa: " + t.getCause());
			}
		});
	}
}
