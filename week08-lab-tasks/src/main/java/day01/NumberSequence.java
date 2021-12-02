package day01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberSequence {
    private List<Integer> numbers = new ArrayList<>();

    public NumberSequence(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public NumberSequence(int count, int min, int max) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int n = random.nextInt(min, max + 1);
            this.numbers.add(n);
        }
    }

    public List<Integer> closeToAverage(int value) {
        List<Integer> result = new ArrayList<>();
        int szum=0;
        for (int n:numbers) {
            szum+=n;
        }
        double avg=szum*1.0/ numbers.size();
        for (int n:numbers) {
            if(Math.abs(n*1.0-avg)<=value){
                result.add(n);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> nList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            nList.add(i+1);
        }
        NumberSequence numsec = new NumberSequence(nList);
        System.out.println(numsec.closeToAverage(1));
    }
}
