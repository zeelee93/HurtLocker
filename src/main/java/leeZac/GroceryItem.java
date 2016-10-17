package leeZac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*** Created by zaclee on 10/17/16. ***/

public class GroceryItem {

    String itemName = "";
    String regex = "";
    String regexForPrice = "([;:, @, ^, *, %])(p|P)...(e|E)([;:, @, ^, *, %])";

    String[] stringArray;
    String stringPrices = "";
    Map<String, Integer> mapOfPrices = new HashMap<String, Integer>();
    String outputString = "";
    String[] priceStringArray;
    List<String> listOfPrices = new ArrayList<String>();
    List<String> noErrorList = new ArrayList<String>();
    private int errors = 0;


    public GroceryItem(String itemName) {
        this.itemName = itemName;
        this.regex = convertToRegexExp(itemName)+regexForPrice;
    }

    public String convertToRegexExp(String item) {
        String example = "((x|X)(z|Z))";
        String lowercase = item.toLowerCase();
        String uppercase = item.toUpperCase();
        int length = lowercase.length();
        int numDots = length-2;
        example = example.replace('x',lowercase.charAt(0));
        example = example.replace('z',lowercase.charAt(length-1));
        example = example.replace('X',uppercase.charAt(0));
        example = example.replace('Z',uppercase.charAt(length-1));
        StringBuilder regex = new StringBuilder(example);
        for(int i =0; i<numDots; i++) {
            regex.insert(6,'.');
        }
        return regex.toString();
    }



    public List<String> makeListOfPrices(String str) {
        Pattern p1 = Pattern.compile(this.regex);
        Matcher m = p1.matcher(str);
        while (m.find()) {
            String price = "";
            price += str.substring(m.end(), m.end() + 4);
            listOfPrices.add(price);
        }
        return removeErrorsInList(listOfPrices);
    }

    public List<String> removeErrorsInList(List<String> listOfStrings) {
        String regex = "(\\d\\.\\d\\d)";
        Pattern p1 = Pattern.compile(regex);
        Matcher m = p1.matcher(listOfStrings.toString());
        String string = listOfStrings.toString();
        int count = 0;
        while (m.find()) {
            count++;
            noErrorList.add(string.substring(m.start(), m.end()));
        }
        errors = listOfStrings.size() - noErrorList.size();
        return noErrorList;
    }

    public int getTotalofItem(String str) {
        return makeListOfPrices(str).size();
    }

    public Map<String, Integer> makeMapOfPrices(List<String> listOfPrices) {
        for (String string : listOfPrices) {
            if (!string.isEmpty()) {
                if (mapOfPrices.containsKey(string)) {
                    mapOfPrices.put(string, mapOfPrices.get(string) + 1);
                } else {
                    mapOfPrices.put(string, 1);
                }
            }
        }
        return mapOfPrices;
    }

    public String makeOutputString(String str) {

        makeMapOfPrices(makeListOfPrices(str));

        String equals = "=============     ==============";
        String minus = "-------------     -------------- \n";

        outputString = String.format("%s %7s %10s %s", "name:", itemName, "seen: ", noErrorList.size() + " times \n");
        outputString += String.format(equals + "\n");

        for (String string : mapOfPrices.keySet()) {
            outputString += String.format("%s %6s %10s %s", "Price:", string, "seen: ", mapOfPrices.get(string) + " times \n");
            outputString += String.format(minus);
        }
        outputString += "\n";

        return outputString;
    }
}

