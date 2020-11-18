package my;

import my.homework.bean.AutoBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = AutoBean.class)
public class AutoBeanTest {

    @Autowired
    private AutoBean autoBean;

    @Test
    public void testAutoBean(){
        System.out.println(autoBean.getName());
    }

}
