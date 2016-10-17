package leeZac;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*** Created by zaclee on 10/17/16. ***/

public class GroceryItemTest {

    String[] stringArray;
    String stringPrices = "";
    Map<String, Integer> mapOfPrices = new HashMap<String, Integer>();
    String outputString = "";
    String[] priceStringArray;
    String jsonString;
    GroceryItem groceryItem;



    @Before
    public void setup() {
        jsonString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        groceryItem = new GroceryItem("Milk");
    }

    @Test
    public void makeListOfPricesTest() {
        int expected = 6;
        int actual = groceryItem.makeListOfPrices(jsonString).size();
        Assert.assertEquals("should have 6 prices",expected,actual);
    }

    @Test
    public void getTotalofItemTest() {
        int actual = groceryItem.getTotalofItem(jsonString);
        int expected = 6;
        Assert.assertEquals("counts number of times milk seen in json string", expected, actual);
    }

    @Test
    public void makeMapOfPricesTest() {
        mapOfPrices = groceryItem.makeMapOfPrices(groceryItem.makeListOfPrices(jsonString));
        System.out.println(mapOfPrices);
        int expected = 2;
        int actual = mapOfPrices.size();
        Assert.assertEquals("should have map size of 2",expected,actual);
    }

    @Test
    public void OutputTest() {
        String str = groceryItem.makeOutputString(jsonString);
        System.out.println(str);
        Assert.assertTrue(outputString instanceof String);
    }

    @Test
    public void OutputTest2() {
        GroceryItem groceryItem1 = new GroceryItem("Cookies");
        String str = groceryItem1.makeOutputString(jsonString);
        System.out.println(str);
        Assert.assertTrue(outputString instanceof String);
    }

    @Test
    public void OutputTest3() {
        GroceryItem groceryItem1 = new GroceryItem("Bread");
        String str = groceryItem1.makeOutputString(jsonString);
        System.out.println(str);
        Assert.assertTrue(outputString instanceof String);
    }

    @Test
    public void OutputTest4() {
        GroceryItem groceryItem1 = new GroceryItem("Apples");
        String str = groceryItem1.makeOutputString(jsonString);
        System.out.println(str);
        Assert.assertTrue(outputString instanceof String);
    }

    @Test
    public void convertToRegexExp() {
        GroceryItem groceryItem2 = new GroceryItem("Apple");
        System.out.println(groceryItem2.regex);
    }





}

