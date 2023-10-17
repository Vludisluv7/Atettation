package org.example;

import java.util.HashMap;

public class Homework {

    // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников:Иван Иванов (и остальные)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.
    public static void main(final String[] args) {
        var telebook = new HashMap<String, String>();
        telebook.put("+78501122333", "Иван Дрогунов");
        telebook.put("+7816234662333", "Сергей Курилин");
        telebook.put("+78501112333", "Иван Курицин");
        telebook.put("+780719122432", "Андрей Здой");
        telebook.put("+78001112453", "Сергей Потапов");
        telebook.put("+78301632145", "Сергей Потапов");
        telebook.put("+780901424214", "Влад Мухин");
        telebook.put("+78601424215", "ПЕтр Первый");
        telebook.put("+78034514924216", "Адам Приветов");
        telebook.put("+783401234374", "Михаил Незлобин");

        var a = get(telebook);

        a.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }


    public static HashMap<String, Integer> get(HashMap<String, String> telebook){
        var res = new HashMap<String, Integer>();
        for (var item : telebook.entrySet()) {
            if (res.containsKey(item.getValue())) {
                var key = item.getValue();
                var value = res.get(item.getValue());
                res.replace(key, value + 1);
            } else {
                res.put(item.getValue(), 1);
            }
        }
        return res;
    }
}
