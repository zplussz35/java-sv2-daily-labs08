package day04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinDiffTest {
    MinDiff minDiff = new MinDiff();
    @Test
    void testFind(){

        int day=minDiff.findMinTemperatureDay("weather.dat");
        assertEquals(14,day);
    }

    @Test
    void testFindSmallestDifference(){
        String teamName=minDiff.findSmallestDifference("football.dat");
        assertEquals("Aston_Villa",teamName);
    }

}