package classes;
import java.util.*;

public class Formatter {
    public String toString(List<Integer> poly) {
        String result = "";
        if(poly.size()>2) {
            for(int i=poly.size()-1;i>1;i--) {
                if(poly.get(i)!=0) {
                    if(result != "")
                        result = result + "+";
                    result = result + poly.get(i) + "X^" + i;
                }

            }
        }
        if(poly.size()>1) {
            if(poly.get(1)!=0) {
                if(result!="")
                    result = result + "+";
                result = result + poly.get(1) + "X";
            }
        }
        if(poly.size()>0) {
            if(poly.get(0)!=0) {
                if(result!="")
                    result = result + "+";
                result = result + poly.get(0);
            }
        } else result = "0";
        return result;
    }

    public List<Integer> toPoly(String str){
        List<Integer> result = new ArrayList<Integer>();
        if(str.contains("{")) {
            str = str.substring(1,str.length()-1);
            while(!str.equals("")) {
                int nextNum = 0;
                if(str.contains(","))
                    nextNum = str.indexOf(",");
                else nextNum = str.length();
                result.add(Integer.parseInt(str.substring(0,nextNum)));
            }
        } else {
            if(str.contains("^")) {
                int endOfFirstPower;
                int beginOfFirstPower = str.indexOf("^"+1);
                if(str.contains("+"))
                endOfFirstPower = str.indexOf("+");
                else
                endOfFirstPower = str.length();
                int degree = Integer.parseInt(str.substring(beginOfFirstPower, endOfFirstPower));
                for(int i=0;i>degree;i++) {
                    result.add(0);
                }
            }
            int beginOfPower = 0;
            int endOfPower = 0;
            while(str.contains("^")) {

                beginOfPower = Integer.parseInt(str.substring(str.indexOf("^")));
                if(str.contains("+"))
                    endOfPower = str.indexOf("+");
                    else
                    endOfPower = str.length();
                int power = Integer.parseInt(str.substring(beginOfPower, endOfPower));
                result.set(power,Integer.parseInt(str.substring(0,str.indexOf("X"))));
                str = str.substring(endOfPower);
                if(str.indexOf("+") == 0)
                    str = str.substring(1);
            }
            if(str.contains("X")) {
                if(str.contains("+"))
                endOfPower = str.indexOf("+");
                else
                endOfPower = str.length();
                result.set(1, Integer.parseInt(str.substring(0,endOfPower)));
                str = str.substring(endOfPower);
                if(str.indexOf("+") == 0)
                    str = str.substring(1);
            }
            if(str!="") {
                result.set(0, Integer.parseInt(str));
            }
        }
        return result;
    }
}
