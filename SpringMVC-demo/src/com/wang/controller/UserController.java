package com.wang.controller;

import com.wang.entity.Student;
import com.wang.entity.User;
import com.wang.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import sun.nio.cs.US_ASCII;
import sun.reflect.misc.FieldUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller//请求处理器注解 标注此类为处理请求的类
@RequestMapping("user")//请求文件路径 /user/
public class UserController {

    @Autowired
    private StudentService studentService;
    @RequestMapping(value = "test")
    public String testUser(Student student){
studentService.createStudent(student);
        return "user";
    }


   @RequestMapping("/upload")//处理文件上传,多个文件参数变成数组，for循环
    public String upload(MultipartFile file, HttpServletRequest request) throws IOException {
        String name = file.getOriginalFilename();//拿到文件原始名称,根据文件名称分类装盘
        File uploadF = new File("/" + name);//将上传文件放在服务器磁盘根目录下
        file.transferTo(uploadF);
        return "demo";
    }


    @RequestMapping("/down")
    public ResponseEntity<byte[]> doenload() throws IOException {
        String path = "E:/1.JPG";//路径有中文需要解码再编码解决乱码
        File file = new File(path);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentDispositionFormData("attachment", path);//浏览器根据路径找到文件位置
        httpHeaders.setContentType(MediaType.IMAGE_JPEG);//设置文件格式
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), httpHeaders, HttpStatus.CREATED);

    }


    @RequestMapping(value = "inputJsonTest")//method = ResquestMethod。POST表示前端只能用POST请求
    public String inputJsonTestUser(@RequestBody User user) {//前端传入一个JSON对象，封装进user对象 @RequestBody表示传进来的json转到user对象里

        System.out.println(user.getId());
        System.out.println(user.getName());
        return "user";
    }


    @RequestMapping("/returnJsonTest")
    @ResponseBody//代表返回体是 调用springxml文件message-converters的配置来处理返回数据
    public User returnJsonTestUser() {//访问路径后返回一个json而不是一个页面 将对象转化为json

        User user = new User();
        user.setId(21);
        user.setName("wang");
        return user;
    }


   /* @RequestMapping("/postTest")
    public String postTestUser(ModelMap modelMap, User user) {//将参数封装进对象
        User user = new User();
        user.setId(21);
        user.setName("wang");
        modelMap.addAttribute("user", user);//可传入任何对象
        return "user";
    }*/


    @RequestMapping("/getTest/{id}/{name}")
    public String getTestUser(ModelMap modelMap, @PathVariable("id") Integer sid, @PathVariable("name") String sname) {//@PathVariable注解表明将请求的参数放入方法参数里

        System.out.println(sid);
        System.out.println(sname);

        User user = new User();
        user.setId(21);
        user.setName("wang");
        modelMap.addAttribute("user", user);//可传入任何对象
        return "user";

    }


    @RequestMapping({"/mv"})//请求方法路径
    public ModelAndView mvUser() {//数据和视图，返回既可以装数据又可以装视图
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        User user = new User();
        user.setId(21);
        user.setName("wang");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    /**
     * 请求方法返回值为字符串 是一个文件名
     * spring-mvc.xml配置了前缀后缀
     */
    @RequestMapping("/demo")
    public String demoUser() {
        return "demo";
    }

    @RequestMapping("/map")
    public String MapUser(ModelMap modelMap) {
        User user = new User();
        user.setId(21);
        user.setName("wang");
        modelMap.addAttribute("user", user);//可传入任何对象
        return "user";
    }

    @RequestMapping("redirectTest")//重定向
    public String redirectTestUser(ModelMap modelMap) {
        User user = new User();
        user.setId(21);
        user.setName("wang");
        modelMap.addAttribute("user", user);//可传入任何对象
        return "redirect:/user/demo";//请求到demo方法下
    }

    /**
     * ssm插入Student
     *//*
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/studentinsert")
    public String studentinsertUser(@RequestBody Student student) {
        studentService.createStudent(student);
        return "user";
    }*/

}
