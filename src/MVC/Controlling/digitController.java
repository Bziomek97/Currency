package MVC.Controlling;

public class digitController extends controlInteface{

    @Override
    public boolean check(String name) {
        if(name.contains(",")){
            name=name.replace(",",".");
        }
        try
        {
            double d = Double.parseDouble(name);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
