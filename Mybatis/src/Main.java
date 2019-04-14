import dao.StudentMapper;
import dao.TeacherMapper;
import entity.Student;
import entity.Teacher;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws Exception {
        InputStream in = Main.class.getResourceAsStream("resource/mybatis-cfg.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        TeacherMapper mapper1 = session.getMapper(TeacherMapper.class);
       /* Teacher teacher = new Teacher();
        teacher.setPassword("123456");
        teacher.setUsername("123456");
        mapper1.insertSelective(teacher);*/
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Teacher> list = mapper1.selectByTids(ids);
        Teacher teacher1 = list.get(1);
        Teacher teacher2 = list.get(0);
        System.out.println(teacher1.getTname());
        System.out.println(teacher2.getTname());
       /* Student student = new Student();
        student.setSid("15");
        student.setSagenum(56);
        student.setSname("inster");
        student.setTid(teacher.getTid());

        mapper.insertSelective(student);*/
        //teacher = mapper1.selectByPrimaryKeyWithStudent(1);
        /*Student student = new Student();*/
        /*student.setId(22);
        student.setAge(23);
        student.setName("wang1");
        student.settId(1);*/

        /*student  = mapper.selectOneById(9);
        System.out.println(student.getName());*/
        /*student = mapper.selectByPrimaryKey("01");*/
        /*System.out.println(student);*/
        /*System.out.println(student.getSname());*/
        session.commit();
        session.close();
    }
}
