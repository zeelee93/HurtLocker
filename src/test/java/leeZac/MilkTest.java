package leeZac;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*** Created by zaclee on 10/17/16. ***/

public class MilkTest {

    StringManipulator stringManipulator;
    Milk milk;
    String jsonString;
    String firstLine;

    String[] stringArray;
    String stringMilkPrices = "";
    ArrayList<String> listMilkPrices = new ArrayList<String>();
    Map<String, Integer> mapOfMilkPrices = new HashMap<String, Integer>();


    @Before
    public void setup() {
        stringManipulator = new StringManipulator();
        firstLine = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;";
        jsonString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        milk = new Milk();
    }


    @Test
    public void splitOnHash() {
        stringArray = stringManipulator.splitOnHash(firstLine);
        int size = stringArray.length;
        int expected = 3;
        int actual = size;
        Assert.assertEquals("should split into three strings", expected, actual);
    }

    @Test
    public void splitOnHash2() {
        String[] str = stringManipulator.splitOnHash(jsonString);
        int size = str.length;
        int expected = 28;
        int actual = size;
        Assert.assertEquals("should split into three strings", expected, actual);
    }

    @Test
    public void countMilkTest() {
        milk.countTotal(firstLine);
        int expected = 1;
        int actual = milk.countTotal(firstLine);;
        Assert.assertEquals("counts milk in first line", expected, actual);
    }

    @Test
    public void countMilkTest2() {
        milk.countTotal(jsonString);
        int expected = 8;
        int actual = milk.countTotal(jsonString);;
        Assert.assertEquals("counts number of times milk seen in json string", expected, actual);
    }

    @Test
    public void countTotalMilkPriceTest1() {
        milk.countTotal(jsonString);
        int expected = 6;
        int actual = milk.countTotalMilkPrice(jsonString);

        Assert.assertEquals("counts number of times milk seen in json string", expected, actual);
    }

    @Test
    public void getStringOfMilkPricesTest() {
        String stringOfMilkPrices = milk.getStringOfPrices(jsonString);
        System.out.println(stringOfMilkPrices);
        Assert.assertTrue(stringOfMilkPrices instanceof String);
    }

    @Test
    public void getStringMilkPriceArrayTest() {
        String[] milkPriceStringArrays = milk.getStringPriceArray(milk.getStringOfPrices(jsonString));
        for(String string : milkPriceStringArrays) {
            System.out.println(string);
        }
        Assert.assertTrue(milkPriceStringArrays instanceof String[]);
    }

    @Test
    public void makeMapOfPricesTest() {
        mapOfMilkPrices = milk.makeMapOfPrices(milk.getStringPriceArray(milk.getStringOfPrices(jsonString)));
        System.out.println(mapOfMilkPrices);
        Assert.assertTrue(mapOfMilkPrices instanceof Map);
    }

    @Test
    public void milkOutputTest() {
        String milkOutputString = "";
        milk.makeOutputString(jsonString);
        System.out.println(milkOutputString);
    }





}

