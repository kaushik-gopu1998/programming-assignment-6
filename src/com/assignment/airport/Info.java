package com.assignment.airport;
import java.time.LocalTime;
public class Info implements Comparable<Info> {
	Airport airport;
	LocalTime arrivalTime;
	long duration;// includes minimum connection time
	public  Info(Airport airport,long duration,LocalTime arrivalTime){
		this.airport=airport;
		this.duration=duration;
		this.arrivalTime=arrivalTime;
	}
	@Override
	public int compareTo(Info info) {
		return Long.compare(this.duration, info.duration);
	}
}
