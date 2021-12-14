package ru.mirea.task27;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class People {
    public static void main(String[] args) {

        HashMap<String, String> Names = new HashMap<>();

        Names.put("Бубликова", "Лидия");
        Names.put("Серебряков", "Иван");
        Names.put("Труман", "Джон");
        Names.put( "Кормаков", "Иван");
        Names.put("Архаров", "Максим");
        Names.put("Боровина", "Лиза");
        Names.put("Шлычков", "Никита");
        Names.put("Вострикова", "Лиза");
        Names.put( "Щипко", "Андрей");
        Names.put("Мировонова", "Мария");

        Map<String, String> tmp = new HashMap<String, String>();
        for (Iterator<String> it = Names.keySet().iterator(); it.hasNext();) {
            String key = it.next();
            String val = Names.get(key);
            if (!tmp.containsValue(val)) {
                tmp.put(key, val);
            }
        }
        Names.clear();
        for (Iterator<String> it = tmp.keySet().iterator(); it.hasNext();) {
            String key = it.next();
            Names.put((String) tmp.get(key), (String) key);
        }

        System.out.println(Names);

    }
}
