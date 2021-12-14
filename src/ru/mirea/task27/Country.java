package ru.mirea.task27;

import java.util.ArrayList;
import java.util.HashMap;

public class Country {
    public static void main(String[] args) {

        HashMap<String, ArrayList<String>> country = new HashMap<>();

        ArrayList<String> russia = new ArrayList<>();
        russia.add("Moscow");
        russia.add("Veliky Novgorod");
        russia.add("Chelyabinsk");
        russia.add("Yakutsk");
        russia.add("Vladimir");
        country.put("Russia", russia);

        ArrayList<String> unitedKingdom = new ArrayList<>();
        unitedKingdom.add("London");
        unitedKingdom.add("Edinburgh");
        unitedKingdom.add("Cardiff");
        unitedKingdom.add("Belfast");
        unitedKingdom.add("Glasgow");
        country.put("UnitedKingdom", unitedKingdom);

        ArrayList<String> italy = new ArrayList<>();
        italy.add("Roma");
        italy.add("Milano");
        italy.add("Napol");
        italy.add("Torino");
        italy.add("Palermo");
        country.put("Italy", italy);

        System.out.println(country);
    }
}
