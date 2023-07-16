package module.first;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;

public class PEMService {

    Repository repo =Repository.getRepository();
    private  Scanner in= new Scanner(System.in);
    private int choice;
    public void showMenu(){
        while(true){
            printMenu();
            switch (choice){
                case 1:
                    //TODO for adding categories
                    onAddCategory();
                    pressAnyKeyToContinue();
                    break;

                case 2:
                    onCategoryList();
                    pressAnyKeyToContinue();
                    break;
                case 3:
                    onExpenseEntry();
                    pressAnyKeyToContinue();
                    break;
                case 4:
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
        // so when the user enters his choic 1 the enter enter is taken as a choice so we have to use a dummy variable
        in.nextLine();
        System.out.println("Enter the categories Name");
        String catName=in.nextLine();
        Category cat=new Category(catName);
        repo.catList.add(cat);
        System.out.println("Success: Category added");
    }
    private void onExpenseEntry() {
        System.out.println("Enter the details for expense Entry");
        onCategoryList();
        System.out.print("Choose Category");
        int catchoice=in.nextInt();
        Category selectedCat =repo.catList.get(catchoice-1);
        System.out.println("My Cat choice : "+ selectedCat.getName());

        System.out.println("Enter amount: ");
        Float amount= in.nextFloat();

        System.out.println("Enter Remark: ");
        in.nextLine();
        String remark=in.nextLine();

        //TODO date has to be taken from user
        Date date=new Date();

        //Add expense detail in expense obj

        Expense exp= new Expense();
        exp.setCategoryId(selectedCat.getCategoryId());
        exp.setAmount(amount);
        exp.setRemark(remark);
        exp.setDate(date);

        //store exp object in repo
        repo.expList.add(exp);
        System.out.println("Success: Expense added");
    }

    public void onExpenseList() {
        System.out.println("Expense List");
        List<Expense> expList=repo.expList;
        for(int i=0;i<expList.size();i++){
            Expense exp=expList.get(i);
            String catName=getCategoryNameByID(exp.getCategoryId());
            System.out.println((i+1)+". "+catName+", "+exp.getAmount()+", "+exp.getRemark()+", "+exp.getDate());

        }
    }

    private void onCategoryList() {
        System.out.println("category List");
        List<Category> clist=repo.catList;
        for(int i=0;i<clist.size();i++){
            Category c= clist.get(i);
            System.out.println((i+1)+". "+c.getName()+", ID:  "+c.getCategoryId());
        }
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

    String getCategoryNameByID(Long categoryID){
        for(Category c: repo.catList){
            if(c.getCategoryId().equals(categoryID)){
                return c.getName();
            }
        }
        return null;
    }
    public void exit(){
        System.exit(0);
    }



}