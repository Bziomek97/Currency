package MVC.Controlling;

import RepoCurrency.Repository;

public class currController extends controlInteface {

    @Override
    public boolean check(String name) {
        Repository tmp=new Repository();
        return tmp.getCurrByCode(name) != null;
    }
}
