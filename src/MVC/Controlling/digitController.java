package MVC.Controlling;

public class digitController extends controlInteface{

    @Override
    public boolean check(String name) {
        name=this.point(name);
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

    public String point(String name){
        if(name.contains(",")){
            return name.replace(",",".");
        }
        return name;
    }
}
