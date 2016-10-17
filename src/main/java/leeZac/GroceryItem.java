package leeZac;

import java.util.Map;

/*** Created by zaclee on 10/17/16. ***/

public interface GroceryItem {

    public void countTotal();

    public String getStringOfPrices();

    public String[] getStringPriceArray();

    public Map<String,Integer> makeMapOfPrices();

    public String makeOutputString();
}
