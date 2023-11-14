import LinearStructures.ArrayList;
import LinearStructures.LinkedList;

public class Start {
    public static void main(String[] args) {
        ArrayList<Integer> testInt = new ArrayList<>();
        ArrayList<String> testString = new ArrayList<>();
        LinkedList<String> testStringL = new LinkedList<>();

        for(int i = 1; i <= 20; i++) {
            testInt.add(i);
        }

        testString.add("A");
        testString.add("B");
        testString.add("C");
        testString.add("D");

        testStringL.add("A");
        testStringL.add("B");
        testStringL.add("C");
        testStringL.add("D");
        testStringL.add("A");
        testStringL.add("B");
        testStringL.add("C");
        testStringL.add("D");

        System.out.println(testInt);
        System.out.println(testString);
        System.out.println(testStringL.set(1, "Z"));
        System.out.println(testStringL);
        System.out.println(testStringL.lastIndexOf("D"));

        for(String x : testString) {
            System.out.println(x);
        }


    }
}
