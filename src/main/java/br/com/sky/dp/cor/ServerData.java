package br.com.sky.dp.cor;

import java.util.HashMap;
import java.util.Map;

public class ServerData {

    private Map<String, User> users = new HashMap<>();

    public void addUser(String user, String password, UserType userType) {
        users.putIfAbsent(user, new User(user, password, userType));
    }

    public boolean isValidUser(String user, String password) {
        if (users.containsKey(user)) {
            return users.get(user).password.equals(password);
        }
        return false;
    }

    public UserType getUserType(String user) {
        return users.get(user).type;
    }

    private record User(String user, String password, UserType type) {

    }
}
