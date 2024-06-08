import java.util.Random;

public class generateMaxMin {
    //Random rand = new Random();
    //int randomNum = rand.nextInt(max - min + 1) +min;
    public static void main(String[] args){
        Random rand = new Random();
        int max = 100, min = 50;
        System.out.println("Generated numbers are within "+ min +" and "+ max);
        System.out.println(rand.nextInt(max - min +1) + min);
        System.out.println(rand.nextInt(max - min +1) + min);
        System.out.println(rand.nextInt(max - min +1) + min);

    }
}
