package lessonfirst;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Test 1 task
//        List<String> listS = new ArrayList<>();
//        listS.add("Ivan 5");
//        listS.add("Alex 10");
//        listS.add("Petr 10");
//        listS.add("Ivan 6");
//        listS.add("Petr 5");
//        listS.add("Alex 5");
//        listS.add("Ivan 1");
//        System.out.println(showWinner(listS));

        //Test 2 task
        List<Post> postList = new ArrayList<>();
        postList.add(new Post("1",1));
        postList.add(new Post("2",2));
        postList.add(new Post("3",3));
        postList.add(new Post("4",4));
        postList.add(new Post("5",5));
        postList.add(new Post("6",6));
        postList.add(new Post("7",7));
        postList.add(new Post("8",8));
        postList.add(new Post("9",9));
        postList.add(new Post("10",10));
        postList.add(new Post("11",11));
        postList.add(new Post("12",12));
        postList.add(new Post("13",13));
        System.out.println(getTop10(postList));


    }
    //1 задание
    public static String showWinner(List<String> competitors){
        Map<String,Integer> map = new LinkedHashMap<>(16,0.75f,true);
        for (String el:competitors) {
            map.merge(el.split(" ")[0],Integer.parseInt(el.split(" ")[1]), Integer::sum);
        }
        return  map.entrySet().stream().max(Map.Entry.comparingByValue()).orElse(new AbstractMap.SimpleEntry<>("Илья",9999)).getKey();
    }
    //2 задание
    public static List<Post> getTop10(List<Post> posts){
        PriorityQueue<Post> queue = new PriorityQueue<>(Comparator.comparingInt(Post::getLikesCount));
        for (int i = 0; i < 10; i++) {
            queue.add(posts.get(i));
        }
        for (int i = 10; i < posts.size(); i++) {
            queue.add(posts.get(i));
            queue.poll();
        }
        return  queue.stream().toList();
    }
}
