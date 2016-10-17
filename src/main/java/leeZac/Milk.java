package leeZac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*** Created by zaclee on 10/17/16. ***/

public class Milk {

    final String item = "Milk";
    String[] stringArray;
    String stringPrices = "";
    Map<String, Integer> mapOfPrices = new HashMap<String, Integer>();
    String outputString = "";
    String[] priceStringArray;
    List<String> listOfPrices = new ArrayList<String>();
    List<String> noErrorList = new ArrayList<String>();
    private int errors = 0;

    public int getErrors() {
        return errors;
    }

    public int countTotal(String str) {
        String regex = "(m|M)..(k|K)";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(str);
        int count = 0;
        while(m.find()) {
            count++;
        }
        return count;
    }

    public List<String> makeListOfPrices(String str) {
        String regex = "((m|M)..(k|K))([;:, @, ^, *, %])(p|P)...(e|E)([;:, @, ^, *, %])";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(str);
        while(m.find()) {
            String price = "";
            price += str.substring(m.end(), m.end()+4);
            listOfPrices.add(price);
        }
        return listOfPrices;
    }

    public List<String> removeErrorsInList(List<String> listOfStrings) {
        String regex = "(\\d\\.\\d\\d)";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(listOfStrings.toString());
        String string = listOfStrings.toString();
        int count = 0;
        while(m.find()) {
            count++;
            noErrorList.add(string.substring(m.start(),m.end()));
        }
        errors = listOfStrings.size() - noErrorList.size();
        return noErrorList;
    }

    public Map<String,Integer> makeMapOfPrices(List<String> listOfPrices) {
        for(String string : listOfPrices) {
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

        makeMapOfPrices(removeErrorsInList(makeListOfPrices(str)));

        String equals = "============     ==============";
        String minus ="------------     -------------- \n";

        outputString = String.format("%s %6s %10s %s", "name:", item, "seen: ", noErrorList.size() + " times \n");
        outputString += String.format(equals + "\n");

        for(String string : mapOfPrices.keySet()) {
            outputString += String.format("%s %5s %10s %s", "Price:", string, "seen: ", mapOfPrices.get(string) + " times \n");
            outputString += String.format(minus);
        }
        outputString += "\n";

        return outputString;

    }

}
