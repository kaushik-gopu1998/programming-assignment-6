package com.assignment.flight;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import com.assignment.airport.Airport;
public class Flight{
	LocalTime departureTime;
	LocalTime arrivalTime;
	Airport originAirport;
	Airport destinationAirport;
	Long duration;
	public Flight(LocalTime departureTime, LocalTime arrivalTime, Airport originAirport, Airport destinationAirport) {
		super();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.originAirport = originAirport;
		this.destinationAirport = destinationAirport;
		this.duration= ChronoUnit.MINUTES.between(departureTime, arrivalTime);
	}
	public LocalTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Airport getOriginAirport() {
		return originAirport;
	}
	public void setOriginAirport(Airport originAirport) {
		this.originAirport = originAirport;
	}
	public Airport getDestinationAirport() {
		return destinationAirport;
	}
	public void setDestinationAirport(Airport destinationAirport) {
		this.destinationAirport = destinationAirport;
	}
	public Long getDuration() {
		return duration;
	}
	public void setDuration(Long duration) {
		this.duration = duration;
	}
}
