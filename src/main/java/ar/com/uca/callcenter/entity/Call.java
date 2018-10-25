package ar.com.uca.callcenter.entity;

import java.util.Random;

public class Call {
	public static final int MIN_TIME_LENGHT = 5;
	public static final int MAX_TIME_LENGHT = 10;
	private int timeLength;
	private String description;

	public Call(String description){
		timeLength = new Random().nextInt(MAX_TIME_LENGHT - MIN_TIME_LENGHT + 1) + MIN_TIME_LENGHT;
		this.description = description;
	}
	
	public int getTimeLength() {
		return timeLength;
	}

	public void setTimeLength(int timeLength) {
		this.timeLength = timeLength;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
