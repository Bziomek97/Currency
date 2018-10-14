package RepoCurrency;

public class Currency {
    private String Code,Name;
    private double Rate;
    private int Converter;

    public String getCode(){
        return this.Code;
    }

    public double getRate(){
        return this.Rate;
    }

    public int getConverter(){
        return this.Converter;
    }

    public String getName(){
        return this.Name;
    }

    public void setConverter(int Converter){
        this.Converter=Converter;
    }

    public void setRate(double Rate){
        this.Rate=Rate;
    }

    public void setName(String Name){
        this.Name=Name;
    }

    public void setCode(String Code){
        this.Code=Code;
    }
}
