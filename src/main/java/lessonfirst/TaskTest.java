package lessonfirst;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static lessonfirst.Main.*;

public class TaskTest {
    @Test
    public void testFirstTask(){
        List<String> listS = new ArrayList<>();
        listS.add("Ivan 5");
        listS.add("Alex 10");
        listS.add("Petr 10");
        listS.add("Ivan 6");
        listS.add("Petr 5");
        listS.add("Alex 5");
        listS.add("Ivan 1");
        System.out.println("1 task");
        System.out.println(showWinner(listS));
        System.out.println();
    }
    @Test
    public void testSecondTask(){
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
        System.out.println("2 task");
        System.out.println(getTop10(postList));
        System.out.println();
    }
    @Test
    public void testThirdTask(){
        List<Client> clientList = new ArrayList<>();
        clientList.add(new Client(1,"1",1,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "1"),new Telephone(TelephoneType.MOBILE, "111")))));
        clientList.add(new Client(100,"1",100,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "12")))));
        clientList.add(new Client(101,"1",101,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "123")))));
        clientList.add(new Client(102,"1",102,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "12345")))));
        clientList.add(new Client(2,"2",2,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "2")))));
        clientList.add(new Client(201,"201",2,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "201")))));
        clientList.add(new Client(200,"200",2,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "200")))));
        clientList.add(new Client(3,"3",3,new ArrayList<>()));
        clientList.add(new Client(4,"4",4,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "4")))));
        clientList.add(new Client(5,"5",5,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "5")))));
        clientList.add(new Client(6,"6",6,new ArrayList<>(List.of(new Telephone(TelephoneType.MOBILE, "6")))));
        clientList.add(new Client(7,"7",7,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "7")))));
        clientList.add(new Client(8,"8",8,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "8")))));
        clientList.add(new Client(9,"9",9,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "9")))));
        clientList.add(new Client(10,"10",10,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "10")))));
        clientList.add(new Client(11,"11",11,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "11")))));
        clientList.add(new Client(12,"12",12,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "12")))));
        clientList.add(new Client(13,"13",13,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "13")))));
        clientList.add(new Client(14,"14",14,new ArrayList<>(List.of(new Telephone(TelephoneType.STATIONARY, "14")))));
        workWithStreamApi(clientList);
    }
}
