package random;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ShuffleDemoRandom {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Charles Leclerc");
        myList.add("Alexandria Saint-Mleux");
        myList.add("Carlos Sainz");
        myList.add("Max Verstappen");
        myList.add("Lando Norris");
        myList.add("Oscar Piastri");

        System.out.println("Original List:\n"+ myList);
        Collections.shuffle(myList, new Random(42)); //randomize 42 times
        System.out.println("Shuffle List with Random(42):\n"+ myList);
    }
}
