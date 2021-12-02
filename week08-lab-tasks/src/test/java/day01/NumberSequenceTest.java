package day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NumberSequenceTest {
    @BeforeEach


    @Test
    void closeToAverage() {
        List<Integer> nList=new ArrayList<>();
        for (int i = 0; i < 100; i++) {
                nList.add(i+1);
        }
        NumberSequence s= new NumberSequence(nList);
        assertEquals(2,s.closeToAverage(1).size());
    }
}