package leeZac.oldStuff;

import leeZac.oldStuff.Cookies;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*** Created by zaclee on 10/17/16. ***/

public class CookiesTest {

    String stringPrices = "";
    Map<String, Integer> mapOfPrices = new HashMap<String, Integer>();
    String outputString = "";
    String[] priceStringArray;


    Cookies cookies;
    String jsonString;



    @Before
    public void setup() {
        jsonString = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food;expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:2/25/2016##naMe:MiLK;price:3.23;type:Food^expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food%expiration:1/25/2016##naMe:CoOkieS;price:2.25;type:Food*expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;price:1.23;type:Food!expiration:4/25/2016##naMe:apPles;price:0.25;type:Food;expiration:1/23/2016##naMe:apPles;price:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food;expiration:1/04/2016##naMe:Milk;price:3.23;type:Food;expiration:1/25/2016##naME:BreaD;price:1.23;type:Food@expiration:1/02/2016##NAMe:BrEAD;price:1.23;type:Food@expiration:2/25/2016##naMe:MiLK;priCe:;type:Food;expiration:1/11/2016##naMe:Cookies;price:2.25;type:Food;expiration:1/25/2016##naMe:Co0kieS;pRice:2.25;type:Food;expiration:1/25/2016##naMe:COokIes;price:2.25;type:Food;expiration:3/22/2016##naMe:COOkieS;Price:2.25;type:Food;expiration:1/25/2016##NAME:MilK;price:3.23;type:Food;expiration:1/17/2016##naMe:MilK;priCe:;type:Food;expiration:4/25/2016##naMe:apPles;prIce:0.25;type:Food;expiration:1/23/2016##naMe:apPles;pRice:0.23;type:Food;expiration:5/02/2016##NAMe:BrEAD;price:1.23;type:Food;expiration:1/25/2016##naMe:;price:3.23;type:Food^expiration:1/04/2016##";
        cookies = new Cookies();
    }

    @Test
    public void countTotal() {
        int num = cookies.countTotal(jsonString);
        int expected = 8;
        int actual = num;
        Assert.assertEquals("total times cookies was seen in string", expected,actual);
    }

    @Test
    public void makeListOfPricesTest() {
        int expected = 8;
        int actual = cookies.makeListOfPrices(jsonString).size();
        Assert.assertEquals("should have 6 prices",expected,actual);
    }

    @Test
    public void makeMapOfPricesTest() {
        mapOfPrices = cookies.makeMapOfPrices(cookies.makeListOfPrices(jsonString));
        System.out.println(mapOfPrices);
        Assert.assertTrue(mapOfPrices instanceof Map);
    }

    @Test
    public void OutputTest() {
        String str = cookies.makeOutputString(jsonString);
        System.out.println(str);
        Assert.assertTrue(outputString instanceof String);
    }

}