package Tests;

import modules.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {
    static TravelPackage travelPackage1;
    static TravelPackage travelPackage2;

    static Destination d1,d2,d3,d4,d5,d6,d7,d8,d9;

    static PremiumClass gold,platinum,standard;
    static Passenger p1,p2,p3,p4,p5,p6,p7;
    @BeforeAll
    public static void init(){
        TravelPackageTest.init();
        travelPackage1=TravelPackageTest.travelPackage1;
        travelPackage2=TravelPackageTest.travelPackage2;
        d1=TravelPackageTest.d1;
        d2=TravelPackageTest.d2;
        d3=TravelPackageTest.d3;
        d4=TravelPackageTest.d4;
        d5=TravelPackageTest.d5;
        d6=TravelPackageTest.d6;
        d7=TravelPackageTest.d7;
        d8=TravelPackageTest.d8;
        d9=TravelPackageTest.d9;
        gold=TravelPackageTest.gold;
        standard=TravelPackageTest.standard;
        platinum=TravelPackageTest.platinum;
        p1=TravelPackageTest.p1;
        p2=TravelPackageTest.p2;
        p3=TravelPackageTest.p3;
        p4=TravelPackageTest.p4;
        p5=TravelPackageTest.p5;
        p6=TravelPackageTest.p6;
        p7=TravelPackageTest.p7;
    }

    @Test
    void add_travel_pkg(){
        Activity activity=new Activity("bunjee jump","jump",1000,2,d1);
        activity.register_passenger(p1);
        assertTrue(p1.getRegistered_travelPackages().contains(travelPackage1));
        assertTrue(p1.getRegistered_activities().contains(activity));
        p1.remove_activity(activity);
        assertFalse(p1.getRegistered_activities().contains(activity));
    }
}