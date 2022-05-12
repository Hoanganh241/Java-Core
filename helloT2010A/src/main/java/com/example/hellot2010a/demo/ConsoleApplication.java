package com.example.hellot2010a.demo;

import com.example.hellot2010a.entity.Customer;
import com.example.hellot2010a.model.CustomerModel;
import com.example.hellot2010a.model.InMemoryCustomerModel;
import com.example.hellot2010a.model.MySqlCustomerModel;
import com.sun.tools.jdeprscan.scan.Scan;
import org.glassfish.jersey.internal.inject.Custom;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class ConsoleApplication {
    private static CustomerModel customerModel;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please choose type of model: ");
            System.out.println("--------------------------");
            System.out.println("1. In memory model.");
            System.out.println("2. My SQL model.");
            System.out.println("--------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextInt();
            switch (choice) {
                case 1:
                    customerModel = new InMemoryCustomerModel();
                    break;
                case 2:
                    customerModel = new CustomerModel();
                    break;
            }
            generateMenu();
        }
    }
    private static void generateMenu(){
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-------------Student Manager--------------");
            System.out.println("1. Create new student");
            System.out.println("2. Show all student");
            System.out.println("3. Update student");
            System.out.println("4. Delete student");
            System.out.println("5. Exit");
            System.out.println("------------------------------------------");
            System.out.println("Please enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    creatNewCustomer();
                    break;
                case 2:
                    showCustomer();
                    break;
                case 3:
                    updateCustomer();
                    break;
                case 4:
                    deleteCustomer();
                    break;
                case 5:
                    System.out.println("Bye!");
                    break;
            }
            if (choice ==5) {
                break;
            }
        }
    }

    private static void deleteCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter you id to update: ");
        String Id = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(Id);
        if (existingCustomer == null) {
            System.out.println("404. Customer not found!");
        }else {
            if (customerModel.delete(Id)) {
                System.out.println("Action Succsess!");
            }  else {
                System.out.println("Action fails, please try agains!");
            }
        }
    }
    private static void updateCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter id to update: ");
        String Id = scanner.nextLine();
        Customer existingCustomer = customerModel.findById(Id);
        if ( existingCustomer == null) {
            System.out.println("404. Id not found");
        }else{
            System.out.println("Please enter full name: ");
            String name = scanner.nextLine();;
            existingCustomer.setName(name);
            if (customerModel.update(Id, existingCustomer) != null) {
                System.out.println("Action success!");
            }else{
                System.out.println("Action fails, please tru again!");
            }
        }
    }

    private static void showCustomer() {
        List<Customer> list = customerModel.findAll();
        for (Customer customer :
                list) {
            System.out.println(customer.toString());
        }
    }

    private static void creatNewCustomer() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter ID: ");
        String id = scanner.nextLine();
        System.out.println("Please enter your name: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(id, name, "0981251615",  LocalDateTime.of(2000, 10, 10, 10, 10));
        if (customerModel.save(customer) != null) {
            System.out.println("Create customer success!");
        }else  {
            System.err.println("Svae student fails, please tru again later!");
        }
    }
}
