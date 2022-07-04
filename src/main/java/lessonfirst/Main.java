package lessonfirst;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
    }

    //1 task
    //Написать метод, который на вход получает массив (или список) строк в формате
    //“имя_игрока количество_очков”. Требуется вывести на экран имя победителя.
    //Победителем считается тот, кто набрал больше всех очков и сделал это раньше
    //остальных (у нескольких игроков может быть одинаковое количество очков).
    //Порядок начисления очков определяется порядком следования элементов в массиве.
    public static String showWinner(List<String> competitors) {
        Map<String, Integer> map = new LinkedHashMap<>(16, 0.75f, true);
        for (String el : competitors) {
            map.merge(el.split(" ")[0], Integer.parseInt(el.split(" ")[1]), Integer::sum);
        }
        return map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(new AbstractMap.SimpleEntry<>("Илья", 9999)).getKey();
    }

    //2 task
    //Дан массив(список) из 1 млн. не отсортированных постов. Требуется найти 10 самых залайканых постов.
    //Необходимо реализовать наиболее оптимальное решение по скорости и памяти.
    public static List<Post> getTop10(List<Post> posts) {
        PriorityQueue<Post> queue = new PriorityQueue<>(Comparator.comparingInt(Post::getLikesCount));
        for (int i = 0; i < 10; i++) {
            queue.add(posts.get(i));
        }
        for (int i = 10; i < posts.size(); i++) {
            queue.add(posts.get(i));
            queue.poll();
        }
        return queue.stream().toList();
    }

    //3 task
    //Задача на Stream API. Необходимо создать класс клиента со следующими полями:
    //уникальный идентификатор, имя, возраст. Также у клиента есть список телефонов.
    //Класс телефона содержит само значение и тип (стационарный или мобильный).
    //Создать массив клиентов и выполнить следующие задания:
    //1. Рассчитать суммарный возраст для определенного имени.
    public static int sumOlds(List<Client> clientList) {
        return clientList
                .stream()
                .filter(x -> x.getName().equals("1"))
                .map(Client::getOld).reduce(Integer::sum)
                .orElse(0);
    }

    //2. Получить Set, который содержит в себе только имена клиентов в порядке их упоминания в исходном массиве.
    public static Set<String> getSetName(List<Client> clientList) {
        return clientList
                .stream()
                .map(Client::getName)
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    //3. Узнать, содержит ли список хотя бы одного клиента, у которого возраст больше заданного числа.
    public static boolean checkOldsBiggestWhen(List<Client> clientList, Integer old) {
        return clientList
                .stream()
                .anyMatch(x -> x.getOld() > old);
    }

    //4. Преобразовать массив в Map, у которой ключ - уникальный идентификатор, значение - имя. Поддержать порядок, в котором клиенты добавлены в массив.
    public static LinkedHashMap<Integer, String> getSortedMap(List<Client> clientList) {
        return clientList
                .stream()
                .collect(Collectors.toMap(Client::getId, Client::getName, (x1, x2) -> x1, LinkedHashMap::new));
    }

    //5. Преобразовать массив в Map, у которой ключ - возраст, значение - коллекция клиентов с таким возрастом.
    public static Map<Integer, List<Client>> getGroupBy(List<Client> clientList) {
        return clientList
                .stream()
                .collect(Collectors.groupingBy(Client::getOld));
    }

    //6. Получить строку, содержащую телефоны всех клиентов через запятую. Предусмотреть, что у клиента телефонов может и не быть.
    public static String getTelephonesAsString(List<Client> clientList) {
        return clientList
                .stream()
                .map(x -> x.getTelephoneList().stream().map(Telephone::getValue).collect(Collectors.toList()))
                .filter(el -> el.size() != 0)
                .map(list -> String.join(",", list))
                .collect(Collectors.joining("; "));
    }

    //7. Найти самого возрастного клиента, которой пользуется стационарным телефоном
    public static Client findOldest(List<Client> clientList) {
        return clientList
                .stream()
                .filter(x -> x.getTelephoneList()
                        .stream()
                        .anyMatch(telephone -> telephone.getType().getType().equals("stationary")))
                .max(Comparator.comparingInt(Client::getOld)).orElse(new Client());
    }

}
