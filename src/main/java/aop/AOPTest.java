package aop;

import aop.api.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContextAOP.xml"})
public class AOPTest {

    @Autowired
    private Calculator calculator;

    @Test
    public void testAnnotationAOPAdd() {

        int add = calculator.add(10, 2);
        System.out.println("方法外部 add = " + add);

    }

    @Test
    public void testAnnotationAOPSub() {

        int sub = calculator.sub(10, 2);
        System.out.println("方法外部 sub = " + sub);

    }

    @Test
    public void testAnnotationAOPMul() {

        int mul = calculator.mul(10, 2);
        System.out.println("方法外部 mul = " + mul);

    }

    @Test
    public void testAnnotationAOPDiv() {

        int div = calculator.div(10, 2);
        System.out.println("方法外部 add = " + div);

    }

}
