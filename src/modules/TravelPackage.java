package modules;

import java.util.HashSet;
import java.util.Set;

public class TravelPackage {
    private String name;
    private int passenger_capacity;
    private Set<Destination> itinerary;
    private Set<Passenger> passengers;

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public TravelPackage(String name, int passenger_capacity) {
        this.name = name;
        this.passenger_capacity = passenger_capacity;
        this.itinerary = new HashSet<>();
        this.passengers = new HashSet<>();
    }
    public void add_destination(Destination destination){
        this.itinerary.add(destination);
    }

    public void remove_destination(Destination destination){
        this.itinerary.remove(destination);
    }

    public void add_passenger(Passenger passenger){
        if(passengers.size()>=passenger_capacity){
            System.out.println("travel package is full");
            return;
        }
        this.passengers.add(passenger);
    }

    public void remove_passenger(Passenger passenger){
        this.passengers.remove(passenger);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassenger_capacity() {
        return passenger_capacity;
    }

    public void setPassenger_capacity(int passenger_capacity) {
        this.passenger_capacity = passenger_capacity;
    }

    public void print_itinerary(){
        for (Destination destination : itinerary) {
            System.out.println(destination.toString());
        }
    }

    public void print_passengers(){
        System.out.println("Package Name: "+name+" Passenger_capacity: "+passenger_capacity);
        System.out.println("Passengers_enrolled: "+passengers.size());
        for(Passenger passenger: passengers){
            System.out.println(passenger.toString());
        }
    }

    public Set<Destination> getItinerary() {
        return itinerary;
    }

    public void setItinerary(Set<Destination> itinerary) {
        this.itinerary = itinerary;
    }
    public void remove_itinerary(){
        itinerary.clear();
    }
    public void remove_passengers(){
        passengers.clear();
    }
}
