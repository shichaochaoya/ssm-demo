package spring_demo.service;


import org.springframework.stereotype.Service;

@Service //标注容器可扫描

public class UserServiceImpl implements UserService {
    @Override
    public void say() {
        System.out.println("hahaha");
    }
}
