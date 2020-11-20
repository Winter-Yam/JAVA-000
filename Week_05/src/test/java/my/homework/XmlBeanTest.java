package my.homework;

import my.homework.bean.XmlBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlBeanTest {

    @Test
    public void testXmlBean(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        XmlBean xmlBean1 = (XmlBean) context.getBean("xmlBean1");
        System.out.println(xmlBean1.getName());
    }
}
