package leeZac;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*** Created by zaclee on 10/17/16. ***/

public class Apples {

    final String item = "Apples";

    String[] stringArray;
    String stringPrices = "";
    Map<String, Integer> mapOfPrices = new HashMap<String, Integer>();
    String outputString = "";
    String[] priceStringArray;
    List<String> listOfPrices = new ArrayList<String>();

    String jsonString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";

    public int countTotal(String str) {

        String regex = "(a|A)....(s|S)";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(jsonString);
        int count = 0;
        while(m.find()) {
            count++;
        }
        return count;
    }

    public List<String> makeListOfPrices(String str) {
        String regex = "(a|A)....(s|S)([;:, @, ^, *, %])(p|P)...(e|E)([;:, @, ^, *, %])";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(jsonString);
        while(m.find()) {
            String price = "";
            price += jsonString.substring(m.end(), m.end()+4);
            listOfPrices.add(price);
        }
        return listOfPrices;
    }

    public Map<String,Integer> makeMapOfPrices(List<String> listOfPrices) {
        for(String string : listOfPrices) {
            if(!string.isEmpty()){
                if(mapOfPrices.containsKey(string)) {
                    mapOfPrices.put(string,mapOfPrices.get(string)+1);
                }
                else {
                    mapOfPrices.put(string,1);
                }
            }
        }
        return mapOfPrices;
    }

    public String makeOutputString(String str) {

        makeMapOfPrices(makeListOfPrices(str));

        String equals = "============     ==============";
        String minus ="------------     -------------- \n";

        outputString = String.format("%s %6s %10s %s", "name:", item, "seen: ", countTotal(jsonString) + " times \n");
        outputString += String.format(equals + "\n");
        for(String string : mapOfPrices.keySet()) {
            outputString += String.format("%s %5s %10s %s", "Price:", string, "seen: ", mapOfPrices.get(string) + " times \n");
        }
        outputString += minus + "\n";
        return outputString;

    }


}
