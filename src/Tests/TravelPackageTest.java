package Tests;

import modules.Destination;
import modules.Passenger;
import modules.PremiumClass;
import modules.TravelPackage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TravelPackageTest {
    static TravelPackage travelPackage1;
    static TravelPackage travelPackage2;

    static Destination d1,d2,d3,d4,d5,d6,d7,d8,d9;

    static PremiumClass gold,platinum,standard;
    static Passenger p1,p2,p3,p4,p5,p6,p7;
    @BeforeAll
    public static void init(){
        travelPackage1=new TravelPackage("aruku",5);
        travelPackage2=new TravelPackage("goa",6);
        d1=new Destination("waterfall-1","new waterfall-1",travelPackage1);
        d2=new Destination("waterfall-2","new waterfall-2",travelPackage1);
        d3=new Destination("waterfall-3","new waterfall-3",travelPackage1);
        d4=new Destination("waterfall-4","new waterfall-4",travelPackage1);
        d5=new Destination("waterfall-5","new waterfall-5",travelPackage1);
        d6=new Destination("waterfall-6","new waterfall-6",travelPackage1);
        d7=new Destination("waterfall-7","new waterfall-7",travelPackage2);
        d8=new Destination("waterfall-8","new waterfall-8",travelPackage2);
        d9=new Destination("waterfall-9","new waterfall-9",travelPackage2);



        gold=new PremiumClass(10,10000);
        platinum=new PremiumClass(100,0);
        standard=new PremiumClass(0,10000);

        p1=new Passenger("p1",1,gold);
        p2=new Passenger("p2",2,platinum);
        p3=new Passenger("p3",3,standard);
        p4=new Passenger("p4",4,gold);
        p5=new Passenger("p5",5,platinum);
        p6=new Passenger("p6",6,platinum);
        p7=new Passenger("p7",7,standard);
        travelPackage1.add_passenger(p1);
        travelPackage1.add_passenger(p2);
    }

    @Test
    void test_add_destination(){
        Destination d10=new Destination("waterfall-10","new waterfall-10",travelPackage2);
        travelPackage2.add_destination(d10);
        assertTrue(travelPackage2.getItinerary().contains(d10));
    }
    @Test
    void test_remove_destination(){
        travelPackage2.remove_destination(d9);
        assertFalse(travelPackage2.getItinerary().contains(d9));
    }

    @Test
    void test_add_passenger(){
        travelPackage1.add_passenger(p1);
        travelPackage1.add_passenger(p2);
        travelPackage1.add_passenger(p3);
        travelPackage1.add_passenger(p4);
        assertTrue(travelPackage1.getPassengers().contains(p4));
        travelPackage1.add_passenger(p5);
        travelPackage1.add_passenger(p6);
        assertFalse(travelPackage1.getPassengers().contains(p6));
    }

    @Test
    void test_remove_passenger(){
        travelPackage1.remove_passenger(p1);
        assertFalse(travelPackage1.getPassengers().contains(p1));
    }
    @Test
    void test_print_passengers(){
        travelPackage1.print_passengers();
    }

    @Test
    void test_print_itinerary(){
        travelPackage1.print_itinerary();
    }
}