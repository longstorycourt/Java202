package IOStudent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

class Student implements Serializable{
    String name;
    String DOB; 
    int id;

    Student(String name, int id, String DOB){
        this.name = name;
        this.id = id;
        this.DOB = DOB;
    }
    public String toString(){
        return name + "\t" + id + "\t" + DOB;
    }   
}
public class StudentData{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); //Consume newline
        Student [] students = new Student[n];
        for(int i = 0; i<students.length; i++){
            System.out.println("Enter the details of student ["+(i+1)+"]:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("ID: ");
            int id = scanner.nextInt();
            System.out.print("DOB: ");
            scanner.nextLine();
            String dob = scanner.nextLine();
            students[i] = new Student(name, id, dob);
        }
        //Serialize and write to file
        try(FileOutputStream fileOutput = new FileOutputStream("StudentData.ser");
            ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)){
                objectOutput.writeObject(students);
        }
        catch(IOException e){
                e.printStackTrace();
            }
        //Deserialize and read from file
        try(FileInputStream fileInput = new FileInputStream("StudentData.ser");
            ObjectInputStream ObjectInput = new ObjectInputStream(fileInput)){
                students = (Student[]) ObjectInput.readObject();
        }
        catch(ClassNotFoundException | IOException e){
                e.printStackTrace();
        }
        for(Student student : students){
            System.out.println(student);
        }
    }
}
