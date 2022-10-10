package com.assignment.airport;
import java.util.List;
import com.assignment.flight.Flight;
public class Airport {
	String abbreviationName;
	String airportName;
	int connectingTime;
	List<Flight> flights;
	public Airport(String abbreviationName, String airportName, int connectingTime, List<Flight> flights){
		super();
		this.abbreviationName=abbreviationName;
		this.airportName = airportName;
		this.connectingTime = connectingTime;
		this.flights = flights;
	}
	public String getAbbreviationName() {
		return abbreviationName;
	}
	public void setAbbreviationName(String abbreviationName) {
		this.abbreviationName = abbreviationName;
	}
	public String getAirportName(){
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public int getConnectingTime(){
		return connectingTime;
	}
	public void setConnectingTime(int connectingTime) {
		this.connectingTime = connectingTime;
	}
	public List<Flight> getFlights(){
		return flights;
	}
	public void addFlight(Flight flight){
		flights.add(flight);
	}
}
