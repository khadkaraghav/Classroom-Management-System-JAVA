package com.company;

import java.util.Scanner;

public class ClassView {

    private Scanner keyboard;
    private ClassDAO classDAO;

    public ClassView(Scanner keyboard, ClassDAO classDAO) {
        this.keyboard = keyboard;
        this.classDAO = classDAO;
    }

    public void add() {


        while (true) {

            System.out.println("Add Person");
            Class cc = new Class();
            System.out.println("Enter ID: ");
            cc.setId(keyboard.nextInt());
            System.out.println("Enter Name");
            cc.setName(keyboard.next());
            System.out.println("Enter Description");
            cc.setDescription(keyboard.next());

            classDAO.insert(cc);
            System.out.println("Do you want to add more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    public void showAll() {
        System.out.println("Listing all skills");
        classDAO.getAll().forEach(s -> {
            System.out.println(s.toString());
        });
    }


    public void delete() {
        System.out.println("Delete skills");
        while (true) {
            System.out.println("Enter Id to delete");
            if (classDAO.delete(keyboard.nextInt())) {
                System.out.println("Delete Successful");
            } else {
                System.out.println("Record not found");
            }

            System.out.println("Do you want to delete more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }

        }
    }

    public void exit() {

        System.out.println("Do you really want to exit (Y/N)");

        if (keyboard.next().equalsIgnoreCase("y")) {
            System.exit(0);

        }
    }

    public void searchById() {
        System.out.println("Search by skills");
        while (true) {
            System.out.println("Enter Id to search");

            Class cc = classDAO.getById(keyboard.nextInt());

            if (cc != null) {
                System.out.println(cc.toString());
            } else {
                System.out.println("Record not found");
            }
            System.out.println("Do you want to search more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }

        }

    }


    public void search() {
        System.out.println("Search skills");
        while (true) {
            classDAO.search(keyboard.next()).forEach(s -> {
                System.out.println(s.toString());
            });
            System.out.println("Do you want to search more (Y/N)");

            if (keyboard.next().equalsIgnoreCase("n")) {
                break;
            }
        }
    }


    public void controller() {

        menu();

        switch (keyboard.nextInt()) {

            case 1:
                add();
                break;


            case 2:
                showAll();
                break;

            case 3:
                searchById();
                break;

            case 4:
                delete();
                break;

            case 5:
                System.out.println("You have total of " + classDAO.count() + " people in your classroom");
                break;

            case 6:
                search();
                break;

            case 7:
                exit();
                break;

            default:
                System.out.println("Invalid choice");
                break;

        }
    }

    public static void menu() {

        System.out.println("==================================");
        System.out.println("Welcome to Classroom Management System");
        System.out.println("===================================");

        System.out.println("1. Add Student");
        System.out.println("2. Show All Student");
        System.out.println("3. Search By Id");
        System.out.println("4. Delete Student Record");
        System.out.println("5. Count Number of Students");
        System.out.println("6. Search Student");
        System.out.println("7. Exit");
        System.out.println("Enter your choice [1-7]");


    }
}




