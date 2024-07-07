package javaConsole;

import java.io.*;

public class WriterDemo {
    public static void main(String[] args) {
        try{
            Writer w = new FileWriter("D:\\CS201-202\\JAVA\\Java202\\week-06\\output.txt");
            String content = "I love my country.";
            w.write(content);
            w.close();
            System.out.println("Done");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
