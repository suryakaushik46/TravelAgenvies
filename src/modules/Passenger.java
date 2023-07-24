package modules;

import java.security.PrivateKey;
import java.util.HashSet;
import java.util.Set;

public class Passenger {

    private String name;
    private int passenger_number;

    private PremiumClass premiumClass;

    private int balance;

    private Set<TravelPackage> registered_travelPackages;

    private Set<Activity> registered_activities;

    public Passenger(String name, int passenger_number, PremiumClass premiumClass) {
        this.name = name;
        this.passenger_number = passenger_number;
        this.premiumClass = premiumClass;
        this.balance=this.premiumClass.getBalance();
        this.registered_travelPackages= new HashSet<>();
        this.registered_activities=new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassenger_number() {
        return passenger_number;
    }

    public void setPassenger_number(int passenger_number) {
        this.passenger_number = passenger_number;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "name='" + name + '\'' +
                ", passenger_number=" + passenger_number +
                '}';
    }

    public PremiumClass getPremiumClass() {
        return premiumClass;
    }

    public void setPremiumClass(PremiumClass premiumClass) {
        this.premiumClass = premiumClass;
    }

    public void print_details(){
        System.out.println("name: "+name+" Passenger_number: "+ passenger_number);
        if(premiumClass.getDiscount()!=100){
            System.out.println("balance: "+premiumClass.getBalance());
        }
        for(Activity activity:registered_activities){
            System.out.println("destination: "+activity.getDestination());
            System.out.println("activity name: "+activity.getName()+"cost passenger paid for activity: "+(activity.getCost()-(activity.getCost()*premiumClass.getDiscount())/100));
        }
    }

    public void add_travel_package(TravelPackage travelPackage){
        registered_travelPackages.add(travelPackage);
    }
    public void remove_travel_package(TravelPackage travelPackage){
        registered_travelPackages.remove(travelPackage);
    }
    public void add_activity(Activity activity){
        for(TravelPackage travelPackage:registered_travelPackages){
            for(Destination destination:travelPackage.getItinerary()){
                if(activity.getDestination().equals(destination)){
                    registered_activities.add(activity);
                }
            }
        }
        registered_activities.add(activity);
    }
    public void remove_activity(Activity activity){
        registered_activities.remove(activity);
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Set<TravelPackage> getRegistered_travelPackages() {
        return registered_travelPackages;
    }

    public void setRegistered_travelPackages(Set<TravelPackage> registered_travelPackages) {
        this.registered_travelPackages = registered_travelPackages;
    }

    public Set<Activity> getRegistered_activities() {
        return registered_activities;
    }

    public void setRegistered_activities(Set<Activity> registered_activities) {
        this.registered_activities = registered_activities;
    }
}
