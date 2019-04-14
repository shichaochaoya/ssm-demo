package xml_demo;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException, DocumentException {
        /**
         * 配置文件的读写
         * */

       /* Properties pop = new Properties();//是一个key value 文件
        pop.load(new FileInputStream("resources/test.properties"));//把pop加载到代码里，get加载属性读取配重
        System.out.println(pop.getProperty("url")+"\n"+pop.getProperty("driver"));//获取配置*/



        /**
         * xml的读写（dom4j）
         * */

        SAXReader reader = new SAXReader();
        Document doc = reader.read(new File("resources/demo.xml"));//返回一个Document(文档)
        Element eml = doc.getRootElement();//xml的根节点
/*        System.out.println(eml.getText());
        System.out.println(eml.getName());
        System.out.println(eml.getQualifiedName());*/
        System.out.println(eml.attribute("color").getValue());
        List<Element> list = eml.elements("student");
        for (Element em:list){     //获取子节点
            System.out.println(em.element("name").getText());
            System.out.println(em.element("age").getText());
        }
        // XPath 是一种路径标识符 专门为xml 用一定标识符显示路径




        /**
         * 写xml文件
         * */
/*
Document doc1 = DocumentHelper.createDocument();//创建了一个document
        XMLWriter writer = new XMLWriter();
        writer.
*/

    }
}
