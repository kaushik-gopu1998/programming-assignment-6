package com.assignment.main;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import com.assignment.airport.Airport;
import com.assignment.airport.AirportService;
import com.assignment.flight.Flight;
public class Client {
	public static void main(String[] args){
		Airport airport1 = new Airport("CLT","Charlotte",30, new ArrayList<>());
		Airport airport2 = new Airport("DEN","Denver",40, new ArrayList<>());
		Airport airport3 = new Airport("LAX","Los Angels",30, new ArrayList<>());
		Airport airport4 = new Airport("EWR","Newark",45, new ArrayList<>());
		Airport airport5 = new Airport("DFW","Dallas",30, new ArrayList<>());
		Airport airport6 = new Airport("MIA","Miami",20, new ArrayList<>());
		Airport airport7 = new Airport("TPA","Tampa",30, new ArrayList<>());
		Flight flight1 = new Flight(LocalTime.of(11, 30),LocalTime.of(4, 30),airport1,airport2);
		Flight flight2 = new Flight(LocalTime.of(12, 00),LocalTime.of(3, 30),airport1,airport3);
		Flight flight3 = new Flight(LocalTime.of(1, 30),LocalTime.of(4, 00),airport1,airport4);
		Flight flight4 = new Flight(LocalTime.of(2, 30),LocalTime.of(5, 30),airport1,airport5);
		Flight flight5 = new Flight(LocalTime.of(5, 30),LocalTime.of(4, 30),airport2,airport3);
		Flight flight6 = new Flight(LocalTime.of(5, 00),LocalTime.of(7, 30),airport2,airport4);
		airport1.addFlight(flight1);
		airport1.addFlight(flight2);
		airport1.addFlight(flight3);
		airport1.addFlight(flight4);
		airport2.addFlight(flight5);
		airport2.addFlight(flight6);
		AirportService airportService = new AirportService();
		List<String> path=airportService.getEarilestPossibleTime(airport1, airport2, 30);
		System.out.println(path);
	}
}
