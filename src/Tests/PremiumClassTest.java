package Tests;

import modules.PremiumClass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PremiumClassTest {
    @Test
    void test_gold(){
        PremiumClass gold=new PremiumClass(10,10000);
        assertEquals(gold.getDiscount(),10);
        assertEquals(gold.getBalance(),10000);
    }

    @Test
    void test_platinum(){
        PremiumClass platinum=new PremiumClass(100,0);
        assertEquals(platinum.getDiscount(),100);
        assertEquals(platinum.getBalance(),0);
    }

    @Test
    void test_standard(){
        PremiumClass standard=new PremiumClass(0,10000);
        assertEquals(standard.getDiscount(),0);
        assertEquals(standard.getBalance(),10000);

    }
}