package ioproject;

import java.io.*;

class MyObject{
    int id;
    String name;
    public MyObject (int id, String name){
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString(){
        return id + ","+ name;
    }
}

public class BufferWAR{
    public static void writeObjects(String fileName, MyObject[] objects) throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        try{
            for (MyObject obj : objects){
                writer.write(obj.toString());
                writer.newLine();
            }
        } finally{
            writer.close();
        }
    }
    public static void appendObjects(String fileName, MyObject[] objects) throws IOException{
        BufferedWriter writer = new BufferedWriter (new FileWriter(fileName, true)); //Open in append mode
        try{
            for(MyObject obj: objects){
                writer.write(obj.toString());
                writer.newLine(); //Add a newline character after each object
            }
        } finally{
            writer.close();
        }
    }

    public static MyObject[] readObjects(String fileName, int numObjects) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        MyObject [] objects = new MyObject[numObjects];
        String line;
        int i = 0;
        try{
            while((line = reader.readLine())!= null && i<numObjects){
                String[] parts = line.split(",");
                objects[i] = new MyObject(Integer.parseInt(parts[0]),parts[1]);
                i++;
            }
        }finally{
            reader.close();
        }
        return objects;
    }
    public static void main(String[] args) throws IOException {
        int numObjects = 3; //Define the number of objects to write / read
        //Create some sample objects
        MyObject[] objects1 = new MyObject[numObjects];
        for(int i = 0; i< numObjects; i++){
            objects1[i] = new MyObject(i+1,"Object_" + (i+1));
        }
        //Write objects to a file (overwrite if exists)
        writeObjects("objects.txt", objects1);

        //Create more sample objects for appending
        MyObject[] objects2 = new MyObject[2];
        for(int i =0; i<2;i++){
            objects2[i] = new MyObject(numObjects + i+ 1,"Object_"+ (numObjects+i+1));
        }

        //Append objects to the same file
        appendObjects("object.txt", objects2);

        //Read all objects from the file including appended ones
        MyObject[] readObjects = readObjects("objects.txt", numObjects+ objects2.length);

        //Print the read objects
        for(MyObject obj : readObjects){
            System.out.println(obj);
        }
    }
}