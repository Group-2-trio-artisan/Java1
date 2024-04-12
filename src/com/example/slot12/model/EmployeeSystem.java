package com.example.slot12.model;

import com.example.slot12.entity.Employee;


import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class CustomerException extends Exception {

    private  static final long serialVersionUID = 1L;

    public CustomerException(String str) {
        super();
        System.out.println(str);
        EmployeeSystem.operations();
    }
}

public class EmployeeSystem {
    public static Map<Integer, Employee> map = new HashMap<>();

    public static void addEmployee(String name, int age, int id) {
        Employee emp = new Employee(name, age, id);
        map.put(id, emp);

        operations();
    }
    public static void deleteEmployee(int Empid) throws CustomerException {
        if(map.containsKey(Empid)) {
            map.remove(Empid);
            System.out.println("Successfully deleted from the list !!");
        }else {
            throw new CustomerException("Not found exception");
        }

        operations();
    }

    public static void searchEmployee(int Empid) throws CustomerException {
        if (map.containsKey(Empid)) {
            System.out.println("Employee Details :- " + map.get(Empid));
        }else {
            throw new CustomerException("Not found exception");
        }

        operations();
    }

    public static void employeeList() {
        System.out.println(map.toString());
    }
    public static void operations() {
        System.out.println("\n****** Employee management system *********");
        System.out.println("1. Add Employee");
        System.out.println("2. Delete Employee");
        System.out.println("3. Search Employee");
        System.out.println("4. Employee List");

        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();

        if (userInput == 1) {
            System.out.println("Enter Employee Details(Name, Age, ID)");
            Scanner scanner1 = new Scanner(System.in);

            String name = scanner1.nextLine();
            int age = scanner1.nextInt();
            int id = scanner1.nextInt();

            if (!name.equals("") && age !=0 && id !=0) {
                addEmployee(name, age, id);
            }
        }else if (userInput == 2) {
            System.out.println("Enter Employee Id");
            Scanner scanner2 = new Scanner(System.in);

            int Empid = scanner2.nextInt();
            try {
                deleteEmployee(Empid);
            }catch (CustomerException e){
                // e.printStackTrace();
            }

        }else if (userInput == 3) {
            System.out.println("Enter Employee Id");
            Scanner scanner3 = new Scanner(System.in);

            int Empid = scanner3.nextInt();

            try {
                searchEmployee(Empid);
            }catch (CustomerException e) {
                // e.printStackTrace();
            }

            operations();
        } else if (userInput == 4) {
            employeeList();

            operations();
        }
    }
    public static void main(String[] args) {
        operations();
    }

}
