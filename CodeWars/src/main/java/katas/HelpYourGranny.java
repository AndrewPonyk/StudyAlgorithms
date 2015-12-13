package katas;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class HelpYourGranny {

    public static void main(String[] args) {
        test1();
    }

    public static int tour(String[] arrFriends, String[][] ftwns, Map<String, Double> h) {
        double result = 0;
        if(h.size()>0){
            result += h.get(ftwns[0][1]);
            result += h.get(ftwns[ftwns.length-1][1]);
        }

        for(int i =0;i<ftwns.length-1;i++){
            double distance = Math.sqrt( Math.pow(h.get(ftwns[i+1][1]),2) -Math.pow(h.get(ftwns[i][1]),2) );
            result +=distance;
        }

        return (int)result;
    }

    public static void test1() {
        String[] friends1 = new String[] { "A1", "A2", "A3", "A4", "A5" };
        String[][] fTowns1 = { new String[] {"A1", "X1"}, new String[] {"A2", "X2"}, new String[] {"A3", "X3"},
                new String[] {"A4", "X4"} };
        Map<String, Double> distTable1 = new HashMap<String, Double>();
        distTable1.put("X1", 100.0); distTable1.put("X2", 200.0); distTable1.put("X3", 250.0);
        distTable1.put("X4", 300.0);
        assertEquals(889, HelpYourGranny.tour(friends1, fTowns1, distTable1));
    }


}
