package com.ftninformatika.cas017;

import java.util.ArrayList;
import java.util.List;

public class NamesProvaider {

    private static List<String> names;
    public static List<String>getAllNames(){
        init();
        return names;

    }
    public static String getNameById(int id){
        init();
        if ((id>=0)&&(id<names.size())){
            return names.get(id);
        }
        return null;
    }
    private static void init(){
        if (names==null){
            names=new ArrayList<>();
            names.add("Pera");
            names.add("Mika");
            names.add("Djoka");
            names.add("Laza");
        }
    }

}
