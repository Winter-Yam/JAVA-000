package my.homework;

import my.homework.bean.XmlBean;
import my.homework.school.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SchoolXmlTest {

    @Test
    public void testSchool(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        XmlBean xmlBean1 = (XmlBean) context.getBean("xmlBean1");
    }

    @Test
    public void testSchool2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-school.xml");
        School school = (School) context.getBean("school1");
        System.out.println(school.toString());
    }
}
