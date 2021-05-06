package hw5;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Map;

public class PhoneUtil {

    /**
     * adds a 1 to the beginning of each 10-digit BigInteger
     * @param m Type of Map,Store username and 10 digit phone number
     */
    public static void prependOne(Map<String, BigInteger> m){
        //Get the iterator of map
        Iterator entries = m.entrySet().iterator();

        //while loop ,determine whether entries are empty by the method of hasNext()
        while (entries.hasNext()) {
            //Get an element from entries
            Map.Entry entry = (Map.Entry) entries.next();
            String  key = (String)entry.getKey();
            BigInteger value = (BigInteger) entry.getValue();
            // adds a 1 to the beginning of each 10-digit BigInteger
            String  addOne = "1" + value.toString();
            // Put the processed data in the map (m)
            m.put(key,new BigInteger(addOne));
        }
    }
}
