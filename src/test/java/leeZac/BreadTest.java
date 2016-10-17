package leeZac;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*** Created by zaclee on 10/17/16. ***/

public class BreadTest {

    StringManipulator stringManipulator = new StringManipulator();
    String[] stringArray;
    String stringBreadPrices = "";
    Map<String, Integer> mapOfBreadPrices = new HashMap<String, Integer>();
    String breadOutputString = "";
    String[] breadPriceStringArray;


    Bread bread;
    String jsonString;



    @Before
    public void setup() {
        stringManipulator = new StringManipulator();
        jsonString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        bread = new Bread();
    }

    @Test
    public void totalBreadCounter() {
        int num = bread.countTotal(jsonString);
        int expected = 6;
        int actual = num;
        Assert.assertEquals("total times bread was seen in string", expected,actual);
    }

    @Test
    public void getStringOfBreadPricesTest() {
        String stringOfBreadPrices = bread.getStringOfPrices(jsonString);
        System.out.println(stringBreadPrices);
        Assert.assertTrue(stringBreadPrices instanceof String);
    }

    @Test
    public void getStringBreadPriceArrayTest() {
        String[] stringBreadPriceArray = bread.getStringPriceArray(bread.getStringOfPrices(jsonString));
        for(String string : stringBreadPriceArray) {
            System.out.println(string);
        }
        Assert.assertTrue(stringBreadPriceArray instanceof String[]);
    }

    @Test
    public void makeMapOfPricesTest() {
        mapOfBreadPrices = bread.makeMapOfPrices(bread.getStringPriceArray(bread.getStringOfPrices(jsonString)));
        System.out.println(mapOfBreadPrices);
        Assert.assertTrue(mapOfBreadPrices instanceof Map);
    }

    @Test
    public void milkOutputTest() {
        bread.makeOutputString(jsonString);
        System.out.println(breadOutputString);
        Assert.assertTrue(breadOutputString instanceof String);
    }










}
