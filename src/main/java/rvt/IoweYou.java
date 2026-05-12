package rvt;

import java.util.HashMap;

public class IoweYou {
    private HashMap<String, Double> depts;

    public IoweYou(){
        this.depts = new HashMap<>();
    }

    public void setSum(String toWhom, double amount){
        this.depts.put(toWhom, amount);
    }

    public double howMuchDoIOweTo(String toWhom){
        return this.depts.getOrDefault(toWhom, 0.0);
    }
}
