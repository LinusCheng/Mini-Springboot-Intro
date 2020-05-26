package MiniSpringBootIntro.constance;

import java.util.HashMap;
import java.util.Map;

public class BranchIdMap {

    // TPE CHI LA SF NY LD SG

    private static final Map<String,Integer> theMap = new HashMap<String,Integer>(){{
        put("TPE",100598888);
        put("CHI",100322599);
        put("LA", 100586772);
        put("SF", 807156326);
        put("NY", 406843525);
        put("LD", 503294843);
        put("SG", 206425965);
    }};


    public static String getBranchId(String branchName){
        return Integer.toString(theMap.get(branchName.toUpperCase()));
    }

    public static Boolean branchExists(String branchName){
        return theMap.containsKey(branchName.toUpperCase());
    }

}
