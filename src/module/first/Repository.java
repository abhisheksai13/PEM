package module.first;

import java.util.List;

public class Repository {
    public List<Expense> expList;
    public List<List> catList;
    private static Repository repository;
    private Repository() {
    }

    public static  Repository getRepository(){
       if (repository== null){
           repository=new Repository();
       }
       return repository;
    }
}
