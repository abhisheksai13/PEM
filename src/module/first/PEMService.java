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

    public PEMService(){
        prepareSampleData();
    }
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
        System.out.println("Enter date(dd/mm/yyyy) :");
        String dateAsString=in.nextLine();
        Date date=DateUtil.stringToDate(dateAsString);

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
            String dateString=DateUtil.dateToString(exp.getDate());
            System.out.println((i+1)+". "+catName+", "+exp.getAmount()+", "+exp.getRemark()+", "+dateString);

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


    public void prepareSampleData(){

        Category catParty=new Category("Party");
        delay();
        Category catShopping =new Category("Shopping");
        delay();
        Category catGift =new Category("Gift");

        repo.catList.add(catGift);
        repo.catList.add(catParty);
        repo.catList.add(catShopping);

        //JAN 2016
        Expense e1 =new Expense(catParty.getCategoryId(),1000.0F,DateUtil.stringToDate("01/01/2016"),"N/A");
        Expense e2 =new Expense(catParty.getCategoryId(),2000.0F,DateUtil.stringToDate("25/01/2016"),"N/A");

        //FEB 2016
        Expense e3 =new Expense(catGift.getCategoryId(),1000.0F,DateUtil.stringToDate("01/02/2016"),"gift");
        Expense e4 =new Expense(catGift.getCategoryId(),1500.0F,DateUtil.stringToDate("20/02/2016"),"gift 2nd");

        //MAR 2016
        Expense e5 =new Expense(catShopping.getCategoryId(),1000.0F,DateUtil.stringToDate("01/03/2016"),"Shop#1");
        Expense e6 =new Expense(catShopping.getCategoryId(),1000.0F,DateUtil.stringToDate("15/03/2016"),"Shop#2");

        //JAN 2017
        Expense e7 =new Expense(catParty.getCategoryId(),1000.0F,DateUtil.stringToDate("15/01/2017"),"Party#17#2");

        //FEB17
        Expense e8 =new Expense(catShopping.getCategoryId(),1000.0F,DateUtil.stringToDate("15/02/2017"),"Shop#17#2");

        //MAR17
        Expense e9 =new Expense(catGift.getCategoryId(),1000.0F,DateUtil.stringToDate("15/03/2017"),"GIFT#2");


        repo.expList.add(e1);
        repo.expList.add(e2);
        repo.expList.add(e3);
        repo.expList.add(e4);
        repo.expList.add(e5);
        repo.expList.add(e6);
        repo.expList.add(e7);
        repo.expList.add(e8);
        repo.expList.add(e9);



    }

    private void delay(){
        try {
            Thread.sleep(10);
        }catch (InterruptedException ex){
            ex.printStackTrace();
        }
    }


}