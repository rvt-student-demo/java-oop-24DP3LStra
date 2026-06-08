package rvt;

public class Person1 {
    private String name;
    private String address;


    public Person1(String name, String address){
        this.name = name; // this - ir kaa adrese uz konkretu prieksmetu
        this.address = address;
        
    }


    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String toString() {
        return this.name + "\n\t" + this.address ;
    }

    public String person(){
        return getName() + getAddress() + toString() ;
    }
}
