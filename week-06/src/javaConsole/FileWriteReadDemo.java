package javaConsole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteReadDemo {
    public static void main(String[] args) {
        try{
            //Writing to a file using BufferedWriter
            FileWriter fileWriter = new FileWriter("inout.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("First line");
            bufferedWriter.newLine();
            bufferedWriter.write("Second line");
            bufferedWriter.newLine(); 
            bufferedWriter.write("Third line");

            System.out.println("Data written to inout.txt");
            bufferedWriter.close();

            //Reading from a file using BufferedReader
            FileReader fileReader = new FileReader("inout.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while((line = bufferedReader.readLine())!=null){
                System.out.println("Read from file: "+ line);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
