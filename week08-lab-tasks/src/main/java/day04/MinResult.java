package day04;

public class MinResult {
    private int minvalue;
    private int index;

    public MinResult(int minvalue, int index) {
        this.minvalue = minvalue;
        this.index = index;
    }

    public int getMinvalue() {
        return minvalue;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return "minkülönbség: "+minvalue+", "+index+". nap";
    }
}
