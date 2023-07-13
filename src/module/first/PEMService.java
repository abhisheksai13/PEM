package module.first;

import java.util.Scanner;

public class PEMService {

    private  Scanner in= new Scanner(System.in);
    private int choice;
    public void showMenu(){
        while(true){
            printMenu();
            switch (choice){
                case 1:
                    //TODO for adding categories
                    System.out.println("Enter categories");
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    public  void printMenu(){
        System.out.println("-----------PEM MENU------------");
        System.out.println("1. add categories");
        System.out.println("2. category List");
        System.out.println("3. Expense Entry");
        System.out.println("4. Expense List");
        System.out.println("5. Monthly Expense List");
        System.out.println("6. Yearly Expense List");
        System.out.println("7. Categories Expense List");
        System.out.println("0. EXIT");
        System.out.println("-------------------------------");


        System.out.print("Please enter your choice : ");
        choice=in.nextInt();

    }
}