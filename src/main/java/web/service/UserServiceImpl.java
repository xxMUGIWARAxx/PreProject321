package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private int userId;
    List<User> users;

    public UserServiceImpl() {
        users = new ArrayList<>();
        users.add(new User(++userId,"Ace","Ace@onepiece.com","Ace123"));
        users.add(new User(++userId,"Luffy","Luffy@onepiece.com","Luffy123"));
        users.add(new User(++userId,"Zoro","Zoro@onepiece.com","Zoro123"));
    }
    @Override
    public List<User> getAllUsers(int count) {
        return users.stream()
                .limit(Math.max(0, Math.min(count, users.size())))
                .toList();
    }
}
