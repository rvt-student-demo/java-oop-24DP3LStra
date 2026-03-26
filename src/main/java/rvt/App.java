package rvt;

public class App {
    public static void main(String[] args) {
        System.out.println("\u001B[34m"
            + "Hello Colored console"
            + "\u001B[0m"
        );
        System.out.println("RVT!");

    }
    public static void setPractice(MansEnum group){
        if (group == MansEnum.DP2_1){
            String strGroup = MansEnum.DP2_1.value;
        }
    }
}