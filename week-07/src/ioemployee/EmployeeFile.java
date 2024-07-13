package ioemployee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

class MyEmployee implements Serializable{
    private int id;
    private String name;
    private char sex;

    public MyEmployee(int id, String name, char sex){
        this.id = id;
        this.name = name;
        this.sex = sex;
    }
    //Getters and setters (if needed)
    int getId() { return id;}
    void setId() { this.id = id;}
    @Override
    public String toString(){
        return "Employee{" + "id= "+ id + ", name='" + name + ", sex= "+ sex + '\''+ '}'; 
    }
}
public class EmployeeFile {
    public static void main(String[] args) {
        List<MyEmployee> employees = new ArrayList<>();
        employees.add(new MyEmployee(1,"Song Heng" , 'M'));
        employees.add(new MyEmployee(2,"Ly Nasun" , 'M'));
        employees.add(new MyEmployee(3,"Long Bopha" , 'F'));
        //Write employees to a binary file
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("emp.bin"))){
            oos.writeObject(employees);
            System.out.println("Employees written to file.");
        }
        catch(IOException e){
            e.printStackTrace();
        }
        //Read employees from the binary file
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("emp.bin"))){
            List<MyEmployee> loadedEmployees = (List<MyEmployee>) ois.readObject();
                System.out.println("Loaded employees: ");
                for(MyEmployee emp : loadedEmployees){
                    System.out.println(emp);
                }
            } catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
    }
}
