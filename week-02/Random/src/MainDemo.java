import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainDemo {
    public static void main(String[] args) {
        Random rand = new Random();
        List<String> givenList = new ArrayList<>(Arrays.asList("one", "two","three","four"));
        int numberOfElements = 4;
        for(int i= 0; i<numberOfElements; i++){
            int randomIndex = rand.nextInt(givenList.size());
            String randomElement = givenList.get(randomIndex);
            givenList.remove(randomIndex); //no two same element in the arrayList will be picked.
            System.out.println(randomElement);
        }
    }
}