package random;

import java.util.ArrayList;
import java.util.Collections;

public class ShuffleDemo {
    public static void main(String[] args) {
        ArrayList<String> myList = new ArrayList<>();
        myList.add("Charles Leclerc");
        myList.add("Alexandria Saint-Mleux");
        myList.add("Carlos Sainz");
        myList.add("Max Verstappen");
        myList.add("Lando Norris");
        myList.add("Oscar Piastri");

        System.out.println("Original List:\n"+ myList);
        Collections.shuffle(myList);
        System.out.println("Shuffle List:\n"+ myList);
        
    }
    
}
