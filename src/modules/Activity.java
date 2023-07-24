package modules;

import java.util.HashSet;
import java.util.Set;

public class Activity {
    private String name;

    private String description;

    private int cost;

    private int capacity;

    private int CAPACITY;

    private boolean is_associated;

    private Destination destination;

    private Set<Passenger> passengers;

    public Activity(String name, String description, int cost, int capacity, Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.is_associated = false;
        this.destination = destination;
        this.passengers=new HashSet<>();
        this.CAPACITY=capacity;
        this.destination.add_activity(this);
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isIs_associated() {
        return is_associated;
    }

    public void setIs_associated(boolean is_associated) {
        this.is_associated = is_associated;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        if(this.is_associated==true){
            this.destination.remove_activity(this);
            this.is_associated=false;
        }
        this.destination = destination;
        this.destination.add_activity(this);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", capacity=" + capacity +
                '}';
    }

    public boolean register_passenger(Passenger passenger){
        if(capacity<0){
            return false;
        }
        capacity--;
        passenger.setBalance(passenger.getBalance()-(this.cost-(passenger.getPremiumClass().getDiscount()*this.cost)/100));
        passengers.add(passenger);
        passenger.add_travel_package(this.getDestination().getTravelPackage());
        passenger.add_activity(this);
        return true;
    }

    public boolean remove_passenger(Passenger passenger){
        capacity++;
        passengers.remove(passenger);
        passenger.remove_activity(this);
        return true;
    }

    public void remove_allPassengers(){
        capacity=CAPACITY;
        passengers.clear();
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }
}
