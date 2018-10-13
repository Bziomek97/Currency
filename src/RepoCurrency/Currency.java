package RepoCurrency;

public class Currency {
    private String Code,Name;
    private double Rate;
    private int Converter;

    Currency(String Name,int Converter, String Code, double Rate ){
        this.Name=Name;
        this.Converter=Converter;
        this.Code=Code;
        this.Rate=Rate;
    }

    String getCode(){
        return this.Code;
    }

    double getRate(){
        return this.Rate;
    }

    int getConverter(){
        return this.Converter;
    }

    String getName(){
        return this.Name;
    }

    void setConverter(int Converter){
        this.Converter=Converter;
    }

    void setRate(double Rate){
        this.Rate=Rate;
    }
}
