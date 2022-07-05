package lessonfirst.sellauto.impl;

import lessonfirst.sellauto.SearchService;
import lessonfirst.sellauto.User;

import java.util.*;
import java.util.stream.Collectors;

public class SearchServiceImpl implements SearchService {


    @Override
    public List<User> searchForFriendsInWidth(User me, String name) {
        Deque<User> deque = new LinkedList<>();
        List<User> allFriends = new ArrayList<>();
        deque.add(me);
        allFriends.add(me);
        while (deque.size()!=0){
            User nextUser = deque.pollFirst();
            for (User user:nextUser.getFriends()) {
                List<Long> idList =allFriends.stream().map(User::getId).toList();
                if (!idList.contains(user.getId())){
                    deque.addLast(user);
                    allFriends.add(user);
                }
            }
        }
        return allFriends.stream().filter(x->x.getName().equals("Наташа")).collect(Collectors.toList());
    }

    @Override
    public List<User> searchForFriendsInDepth(User me, String name) {
        Deque<User> deque = new LinkedList<>();
        List<User> allFriends = new ArrayList<>();
        deque.add(me);
        allFriends.add(me);
        while (deque.size()!=0){
            User nextUser = deque.pollFirst();
            for (User user:nextUser.getFriends()) {
                List<Long> idList =allFriends.stream().map(User::getId).toList();
                if (!idList.contains(user.getId())){
                    deque.addFirst(user);
                    allFriends.add(user);
                }
            }
        }
        return allFriends.stream().filter(x->x.getName().equals("Наташа")).collect(Collectors.toList());
    }
}
