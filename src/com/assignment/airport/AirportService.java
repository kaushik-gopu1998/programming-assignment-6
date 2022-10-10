package com.assignment.airport;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import com.assignment.flight.Flight;
public class AirportService {
	public List<String> getEarilestPossibleTime(Airport src, Airport dest,long connectingTime){
		PriorityQueue<Info> pq = new PriorityQueue<>();
		Map<String ,Long> time = new HashMap<>();
		Map<String,String> parent = new HashMap<>();
		parent.put(src.abbreviationName, null);
		pq.add(new Info(src,connectingTime,LocalTime.now()));
		time.put(src.abbreviationName,connectingTime);
		while(!pq.isEmpty()){
			Info currInfo = pq.poll();
			Airport currAirport = currInfo.airport;
			List<Flight> flights = currAirport.getFlights();
			for(Flight flight : flights){
				Airport destAirport = flight.getDestinationAirport();
				assignIntialTime(time,destAirport.abbreviationName);
				assignIntialParent(parent, destAirport.abbreviationName);
				long totalTime = currInfo.duration+flight.getDuration()+destAirport.connectingTime;
				if(isLesserThanCurrTime(totalTime,time,destAirport.abbreviationName)
						&& (currAirport.abbreviationName.equals(src) || checkFlightAvailable(currInfo.arrivalTime,flight.getDepartureTime(),currAirport.connectingTime))){
					time.put(destAirport.abbreviationName,totalTime);
					parent.put(destAirport.abbreviationName,currAirport.abbreviationName);
					pq.add(new Info(flight.getDestinationAirport(),totalTime,flight.getArrivalTime()));
				}
			}
		}
		LinkedList<String> path = new LinkedList<>();
		getPath(parent,path,dest.abbreviationName);
		path.addFirst(src.abbreviationName);
		return path;
	}
	private void assignIntialParent(Map<String, String> parent, String abbreviationName) {
		if(parent.get(abbreviationName)==null) parent.put(abbreviationName, abbreviationName);
	}
	private boolean isLesserThanCurrTime(long reqTime, Map<String, Long> time, String abbreviationName) {
		return reqTime<time.get(abbreviationName);
	}
	private void assignIntialTime(Map<String, Long> time, String abbreviationName) {
		if(time.get(abbreviationName)==null) time.put(abbreviationName,Long.MAX_VALUE);
	}
	public boolean checkFlightAvailable(LocalTime arrivalTime,LocalTime departureTime, long connectingTime){
		int val = arrivalTime.plusMinutes(connectingTime).compareTo(departureTime);
		return val>=0;
	}
	public void getPath(Map<String, String> parent, LinkedList<String> path, String name) {
		if(parent.get(name)==null) return;
		path.addFirst(name);
		getPath(parent, path, parent.get(name));
	}
}
