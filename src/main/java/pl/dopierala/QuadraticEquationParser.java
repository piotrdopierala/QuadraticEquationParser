package pl.dopierala;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuadraticEquationParser {

    public static QuadraticEquation parse(String data){

        double a=0;
        double b=0;
        double c=0;

        //language=RegExp
        String patX0 = "(-|\\+|^)\\d+(?=(=|-|\\+|$))";
        //language=RegExp
        String patX1 = "(-|\\+|^)\\d*x(?=(=|-|\\+|$))";
        //language=RegExp
        String patX2 = "(-|\\+|^)\\d*x\\^2(?=(=|-|\\+|$))";

        c= computeCoefficient(data,patX0);
        b= computeCoefficient(data,patX1);
        a= computeCoefficient(data,patX2);

        return new QuadraticEquation(a,b,c);
    }

    private static double computeCoefficient(String data, String pattern){
        Pattern pat = Pattern.compile(pattern);
        Matcher mach = pat.matcher(data);
        String found="0";
        double resultCoefficient=0;

        Pattern patNumber = Pattern.compile("(-|\\+|^)\\d+");

        while(mach.find()){
            found = mach.group();
            Matcher machNumber = patNumber.matcher(found);
            if(machNumber.find())
                found = machNumber.group();
            else
                found = found.startsWith("-")? "-1" : "1";
            resultCoefficient+=Double.valueOf(found);
        }

        return resultCoefficient;
    }

}
