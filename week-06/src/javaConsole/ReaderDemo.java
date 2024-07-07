package javaConsole;

import java.io.FileReader;
import java.io.Reader;

public class ReaderDemo {
    public static void main(String[] args) {
        try{
            Reader reader = new FileReader("D:\\CS201-202\\JAVA\\Java202\\week-06\\output.txt");
            int data = reader.read();
            while(data!= -1){
                System.out.print((char) data);
                data = reader.read();
            }
            reader.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
