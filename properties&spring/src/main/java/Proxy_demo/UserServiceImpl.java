package Proxy_demo;

public class UserServiceImpl implements UserService {
    @Override
    public void callName(String name) {
        System.out.println(name);
    }
}
