package com.example.luxr;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jenniferhu on 7/11/17.
 */

public class MakeHash extends HashMap {

    public static HashMap<String, HashMap<String, ArrayList<String>>> closet;
    private static HashMap<String, ArrayList<String>> topColor;
    private static HashMap<String, ArrayList<String>> bottomColor;
    private static HashMap<String, ArrayList<String>> dressColor;
    private static HashMap<String, ArrayList<String>> jumpsuitColor;
    private static HashMap<String, ArrayList<String>> shoeColor;
    private static HashMap<String, ArrayList<String>> jacketColor;
    private static HashMap<String, ArrayList<String>> accessoriesColor;

    private static ArrayList<String> topFiles;
    private static ArrayList<String> bottomFiles;
    private static ArrayList<String> dressFiles;
    private static ArrayList<String> jumpsuitFiles;
    private static ArrayList<String> shoeFiles;
    private static ArrayList<String> jacketFiles;
    private static ArrayList<String> accessoriesFiles;

    public MakeHash() {
        closet = new HashMap<>();

        topColor = new HashMap<>();
        bottomColor = new HashMap<>();
        dressColor = new HashMap<>();
        jumpsuitColor = new HashMap<>();
        shoeColor = new HashMap<>();
        jacketColor = new HashMap<>();
        accessoriesColor = new HashMap<>();

        topColor = putColors(topColor);
        bottomColor = putColors(bottomColor);
        dressColor = putColors(dressColor);
        jumpsuitColor = putColors(jumpsuitColor);
        shoeColor = putColors(shoeColor);
        jacketColor = putColors(jacketColor);
        accessoriesColor = putColors(accessoriesColor);

        closet.put("Accessories", accessoriesColor);
        closet.put("Bottoms", bottomColor);
        closet.put("Dresses", dressColor);
        closet.put("Jackets", jacketColor);
        closet.put("Jumpsuits", jumpsuitColor);
        closet.put("Shoes", shoeColor);
        closet.put("Tops", topColor);
    }

//    public void addItem(String type, String color, String mCurrentPhotoPath) {
//        if (type == "Accessories") {
//            accessoriesColor.put(color, mCurrentPhotoPath);
//        }
//
//    }



    private HashMap<String, ArrayList<String>> putColors(HashMap<String, ArrayList<String>> map) {
        map.put("Red", new ArrayList<String>());
        map.put("Blue", new ArrayList<String>());
        map.put("Green", new ArrayList<String>());
        map.put("Yellow", new ArrayList<String>());
        map.put("Brown", new ArrayList<String>());
        map.put("Orange", new ArrayList<String>());
        map.put("Purple", new ArrayList<String>());
        map.put("Pink", new ArrayList<String>());
        map.put("Silver", new ArrayList<String>());
        map.put("White", new ArrayList<String>());
        map.put("Grey", new ArrayList<String>());
        map.put("Black", new ArrayList<String>());
        map.put("Gold", new ArrayList<String>());
        return map;
    }


}
