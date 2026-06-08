package rvt;

public class Student1 extends Person1 {
    private int credits;

    public Student1(String name, String address, int credits) {
        super(name, address);
        this.credits = credits;
    }

    public int credits(){
        return this.credits;
    }

    public int study(){
        return credits++;
    }
    public String toString() {
        return super.toString() + "\n " + "Study credits " + this.credits; 
    }
}
