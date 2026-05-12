package rvt;

public class App {
    public static void main(String[] args) {
        IoweYou mattsIOU = new IoweYou();
        mattsIOU.setSum("Arthur", 51.5);
        mattsIOU.setSum("Arthur", 10.5);

        System.out.println(mattsIOU.howMuchDoIOweTo("Arthur"));
    }
}