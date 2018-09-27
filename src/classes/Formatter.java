package classes;
import java.util.*;

public class Formatter {
    String toString(List<Integer> poly) {
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
    
    List<Integer> toPoly(String str){
        
    }
}
