package com.nttdata.pe.main.model;

import com.google.gson.annotations.SerializedName;

public class UserResponse {

	@SerializedName("name")
	public String name;
	
	@SerializedName("job")
	public String job;
	
	@SerializedName("id")
	public long id;
	
	@SerializedName("createdAt")
	public String createdAt;
	
	@SerializedName("updatedAt")
	public String updatedAt;

	public UserResponse(long id, String name, String job) {
		this.id = id;
		this.name = name;
		this.job = job;
	}
	
	public UserResponse(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "UserResponse [name=" + name + ", job=" + job + ", id=" + id + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}

}
