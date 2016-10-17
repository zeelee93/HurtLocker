package leeZac;

import java.util.HashMap;
import java.util.Map;

/*** Created by zaclee on 10/17/16. ***/

public class Milk {

    final String item = "Milk";

    StringManipulator stringManipulator = new StringManipulator();
    String[] stringArray;
    String stringPrices = "";
    Map<String, Integer> mapOfPrices = new HashMap<String, Integer>();
    String outputString = "";
    String priceStringArray;

    String jsonString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";


    public int countTotal(String str) {
        stringArray = str.split("(m|M)..(k|K)");
        return stringArray.length-1;
    }

    public int countTotalMilkPrice(String str) {
        stringArray = str.split("((m|M)..(k|K))([;:, @, ^, *, %])(p|P)...(e|E)([;:, @, ^, *, %])\\d\\.\\d\\d");
//        for(String str : str
//            System.out.println(stringArray[i]);
//        }
        return stringArray.length-1;
    }

    public String getStringOfPrices(String str) {
        stringArray = str.split("((m|M)..(k|K))([;:, @, ^, *, %])(p|P)...(e|E)([;:, @, ^, *, %])");
        for (String string : stringArray) {
            stringPrices += string.substring(0, 4) + " ";
        }
        return stringPrices;
    }

    public String[] getStringPriceArray(String str) {
        String[] milkPriceStringArray = str.split("[^(\\d|\\.)]");
        return milkPriceStringArray;
    }

    public Map<String,Integer> makeMapOfPrices(String[] stringMilkPriceArray) {
        for(String string : stringMilkPriceArray) {
            if(!string.isEmpty()){
                if(mapOfPrices.containsKey(string)) {
                    mapOfPrices.put(string, mapOfPrices.get(string)+1);
                }
                else {
                    mapOfPrices.put(string,1);
                }
            }
        }
        return mapOfPrices;
    }

    public String makeOutputString(String str) {

        makeMapOfPrices(getStringPriceArray(getStringOfPrices(str)));


        String equals = "============     ==============";
        String minus ="------------     -------------- \n";




        outputString = String.format("%s %6s %10s %s", "name:", item, "seen: ", countTotal(jsonString) + " times \n");
        outputString += String.format(equals + "\n");

        for(String string : mapOfPrices.keySet()) {
            outputString += String.format("%s %5s %10s %s", "Price:", string, "seen: ", mapOfPrices.get(string) + " times \n");
            outputString += String.format(minus);
        }

//        System.out.println(outputString);

        outputString += "\n";

        return outputString;

    }

}
