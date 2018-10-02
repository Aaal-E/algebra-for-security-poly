package classes;
import java.util.*;

public class Formatter {
    public String toString(List<Integer> poly) {
        String result = "";
        if(poly.size()>2) {
            for(int i=poly.size()-1;i>1;i--) {
                if(poly.get(i)!=0) {
                    if(!result.isEmpty())
                        if(poly.get(i) >= 0)
                            result = result + "+";
                    if(poly.get(i) != 1)
                        result = result + poly.get(i);
                    result = result + "X^" + i;
                }

            }
        }
        if(poly.size()>1) {
            if(poly.get(1)!=0) {
                if(!result.isEmpty()) {
                    if(poly.get(1) >= 0)
                        result = result + "+";
                }
                if(poly.get(1) != 1)
                    result = result + poly.get(1);
                result = result + "X";
            }
        }
        if(poly.size()>0) {
            if(poly.get(0)!=0) {
                if(!result.isEmpty())
                    if(poly.get(0) >= 0)
                        result = result + "+";
                result = result + poly.get(0);
            }
        } 
        if(result.isEmpty())
            result = "0";
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
                if(str.contains(","))
                str = str.substring(nextNum+1);
                else str = str.substring(nextNum);
            }
        } else {
            int degree = 0;
            if(str.contains("^")) {
                int endOfFirstPower;
                int beginOfFirstPower = str.indexOf("^"+1);
                if(str.contains("+"))
                endOfFirstPower = str.indexOf("+");
                else if(str.contains("-"))
                    endOfFirstPower = str.indexOf("-");
                else
                endOfFirstPower = str.length();
                degree = Integer.parseInt(str.substring(beginOfFirstPower, endOfFirstPower));
            } else if(str.contains("X")) {
                degree = 1;
            } else degree = 0;
                for(int i=0;i<=degree;i++) {
                    result.add(0);
                }
            }
            int beginOfPower = 0;
            int endOfPower = 0;
            String temp = "";
            while(str.contains("^")) {
                beginOfPower = Integer.parseInt(str.substring(str.indexOf("^")));
                if(str.contains("+") && str.contains("-"))
                    if(str.indexOf("+")<str.indexOf("-",1))
                        endOfPower = str.indexOf("+");
                    else
                        endOfPower = str.indexOf("-", 1);
                else if(str.contains("+"))
                    endOfPower = str.indexOf("+");
                else if(str.contains("-"))
                    if(str.indexOf("-") == 0)
                        endOfPower = str.indexOf("-", 1);
                    else
                        endOfPower = str.indexOf("-");
                else endOfPower = str.length();                
                int power = Integer.parseInt(str.substring(beginOfPower, endOfPower));
                temp = str.substring(0,str.indexOf("X"));
                if(temp.equals("-"))
                    result.set(power, -1);
                else if(temp.equals(""))
                    result.set(power, 1);
                else
                result.set(power,Integer.parseInt(temp));
                str = str.substring(endOfPower);
                if(str.indexOf("+") == 0)
                    str = str.substring(1);
            }
            if(str.contains("X")) {
                if(str.contains("+") && str.contains("-"))
                    if(str.indexOf("+")<str.indexOf("-",1))
                        endOfPower = str.indexOf("+");
                    else
                        endOfPower = str.indexOf("-", 1);
                else if(str.contains("+"))
                    endOfPower = str.indexOf("+");
                else if(str.contains("-"))
                    if(str.indexOf("-") == 0)
                        endOfPower = str.indexOf("-", 1);
                    else
                        endOfPower = str.indexOf("-");
                else endOfPower = str.length();
                
                temp = str.substring(0,str.indexOf("X"));
                if(temp.equals("-"))
                    result.set(1, -1);
                else if(temp.isEmpty())
                    result.set(1, 1);
                else
                result.set(1,Integer.parseInt(temp));
                str = str.substring(endOfPower);
                if(str.indexOf("+") == 0)
                    str = str.substring(1);
            }
            if(!str.equals("")) {
                result.set(0, Integer.parseInt(str));
            }
        }
        return result;
    }
}
