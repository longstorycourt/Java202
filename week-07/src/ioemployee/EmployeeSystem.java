package ioemployee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeSystem {
    private static final String fileName = "d:\\IO Java\\employee.dat";

    public static void main(String[] args) throws IOException, ClassNotFoundException{
        List<Employee> employees = readEmployees();

        int choice;
        do{
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display Employees");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = new Scanner(System.in).nextInt();

            switch(choice){
                case 1: 
                    addEmployee(employees);
                    break;
                case 2:
                    removeEmployee(employees);
                    break;
                case 3: 
                    displayEmployees(employees);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    writeEmployees(employees);
                    break;
                default:
                    System.out.println("Invalid Choice!");
            }
        }   while (choice != 4);
    }

    public static class Employee implements java.io.Serializable{
        private int id;
        private String name;
        private String department;

        public Employee (int id, String name, String department){
            this.id = id;
            this.name = name;
            this.department = department;
        }

        //Getters and Setters for each field (id, name, department)
        // ---Implement these methods---
        int getId(){ return id; }
        String getName(){  return name;}


        @Override
        public String toString(){
            return "ID: " + id + ", Name: " + name + ", Department: "+ department;
        }
    }
    private static List <Employee> readEmployees() throws IOException, ClassNotFoundException{
        List<Employee> employees = new ArrayList<>();
        try (FileInputStream fileIn = new FileInputStream(fileName); 
            ObjectInputStream in = new ObjectInputStream(fileIn)){
                employees = (List<Employee>) in.readObject();
            }
        catch(FileNotFoundException e){
            System.out.println("Employee data file not found. Creating a new one.");
        }
        return employees;
    }

    private static void writeEmployees(List<Employee> employees) throws IOException{
        FileOutputStream fileOut = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(employees);
        out.close();
        fileOut.close();
    }
    private static void addEmployee(List<Employee> employees){
        Scanner scanner = new Scanner (System.in);
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        System.out.print("Enter Employee name: ");
        String name = scanner.next();
        scanner.nextLine(); //Consume extra newline from previous input
        System.out.print("Enter Employee Department: ");
        String department = scanner.nextLine();
        Employee employee = new Employee(id, name, department);
        employees.add(employee);
    }

    private static void removeEmployee(List <Employee> employees){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Employee ID to remove: ");
        int id = scanner.nextInt();
        for(int i=0; i<employees.size(); i++){
            if(employees.get(i).getId() == id){
                employees.remove(i);
                return;
            } 
        }System.out.println("Employee with ID" + id+ "not found.");
    }

    private static void displayEmployees(List<Employee> employees){
        if(employees.isEmpty()){
            System.out.println("No employees found!");
        }
        else{
            for(Employee employee: employees){
                System.out.println(employee);
            }
        }
    }
}
