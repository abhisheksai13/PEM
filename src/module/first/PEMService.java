package module.first;

import java.io.IOException;
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
                    onAddCategory();
                    System.out.println("Enter categories.......");
                    pressAnyKeyToContinue();
                    break;

                case 2:
                    //TODO for category List
                    onCategoryList();
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    //TODO for expense entry
                    onExpenseEntry();
                    pressAnyKeyToContinue();
                    break;
                case 4:
                    //TODO for expense entry
                    onExpenseList();
                    pressAnyKeyToContinue();
                    break;

                case 5:
                    //TODO for yearly expense List
                    onMonthlyExpenseEntry();
                    pressAnyKeyToContinue();
                    break;
                case 6:
                    //TODO for expense entry
                    onYearlyExpenseList();
                    pressAnyKeyToContinue();
                    break;
                case 7:
                    //TODO for expense entry
                    onCategorizedExpenseEntry();
                    pressAnyKeyToContinue();
                    break;
                case 0:
                    exit();
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

    public void pressAnyKeyToContinue(){

        try {
            System.out.println("Press any key to continue........");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void onAddCategory() {
        System.out.println("adding categories");
        //TODO
    }
    private void onExpenseEntry() {
        System.out.println("expense Entry");
        //TODO
    }

    public void onExpenseList() {
    }

    private void onCategoryList() {
        System.out.println("category List");
        //TODO
    }
    private void onMonthlyExpenseEntry() {
        System.out.println("monthly Expense entry");
        //todo
    }

    public void onYearlyExpenseList() {
    }

    public void onCategorizedExpenseEntry() {
        //Todo
        System.out.println("categorized Expense entry");
    }

    public void exit(){
        System.exit(0);
    }



}