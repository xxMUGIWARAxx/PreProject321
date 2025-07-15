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
        users.add(new User(++userId, "Ace", "Ace@onepiece.com"));
        users.add(new User(++userId, "Luffy", "Luffy@onepiece.com"));
        users.add(new User(++userId, "Zoro", "Zoro@onepiece.com"));
    }

    @Override
    public List<User> index() {
        return users;
    }

    @Override
    public User show(int id) {
        return users.stream().filter(user -> user.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(User user) {
        user.setId(++userId);
        users.add(user);
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = show(id);
        if (userToBeUpdated != null) {
            userToBeUpdated.setName(updatedUser.getName());
            userToBeUpdated.setEmail(updatedUser.getEmail());
        }
    }

    @Override
    public void delete(int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
