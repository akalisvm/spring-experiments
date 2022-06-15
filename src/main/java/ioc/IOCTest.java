package ioc;

import ioc.component.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class IOCTest {

    private final ApplicationContext iocContainer = new ClassPathXmlApplicationContext("applicationContextIOC.xml");

    @Test
    public void testExperiment01() {

        // 从 IOC 容器对象中获取bean，也就是组件对象
        HappyComponent happyComponent = (HappyComponent) iocContainer.getBean("happyComponent");

        happyComponent.doWork();

    }

    //@Test
    public void testExperiment02() {

        HappyComponent component = iocContainer.getBean(HappyComponent.class);

        component.doWork();

    }

    @Test
    public void testExperiment03() {

        HappyComponent happyComponent3 = (HappyComponent) iocContainer.getBean("happyComponent3");

        String componentName = happyComponent3.getComponentName();

        System.out.println("componentName = " + componentName);

    }

    @Test
    public void testExperiment04() {
        HappyComponent happyComponent4 = (HappyComponent) iocContainer.getBean("happyComponent4");

        HappyMachine happyMachine = happyComponent4.getHappyMachine();

        String machineName = happyMachine.getMachineName();

        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment05() {
        HappyComponent happyComponent5 = (HappyComponent) iocContainer.getBean("happyComponent5");

        HappyMachine happyMachine = happyComponent5.getHappyMachine();

        String machineName = happyMachine.getMachineName();

        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment06() throws SQLException {
        DataSource dataSource = iocContainer.getBean(DataSource.class);

        Connection connection = dataSource.getConnection();

        System.out.println("connection = " + connection);
    }

    @Test
    public void testExperiment07() {

        HappyComponent happyComponent6 = (HappyComponent) iocContainer.getBean("happyComponent6");

        String machineName = happyComponent6.getHappyMachine().getMachineName();

        System.out.println("machineName = " + machineName);

    }

    @Test
    public void testExperiment08() {

        HappyTeam happyTeam = iocContainer.getBean(HappyTeam.class);

        System.out.println("happyTeam = " + happyTeam);

    }

    @Test
    public void testExperiment09() {

        PropValue propValue = iocContainer.getBean(PropValue.class);

        System.out.println("expression = " + propValue.getExpression());
    }

    @Test
    public void testExperiment10() {
        HappyMachine happyMachine3 = (HappyMachine) iocContainer.getBean("happyMachine3");

        String machineName = happyMachine3.getMachineName();

        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment11() {

        HappyTeam happyTeam2 = (HappyTeam) iocContainer.getBean("happyTeam2");

        List<String> memberList = happyTeam2.getMemberList();

        for (String member : memberList) {
            System.out.println("member = " + member);
        }

    }

    @Test
    public void testExperiment12() {
        HappyController happyController = iocContainer.getBean(HappyController.class);

        HappyService happyService = happyController.getHappyService();

        System.out.println("happyService = " + happyService);
    }

    @Test
    public void testExperiment13() {
        List<HappyMachine> machineList = (List<HappyMachine>) iocContainer.getBean("machineList");
        for (HappyMachine happyMachine : machineList) {
            System.out.println("happyMachine = " + happyMachine);
        }
    }

    @Test
    public void testExperiment14() {
        HappyMachine happyMachine3 = (HappyMachine) iocContainer.getBean("happyMachine4");

        String machineName = happyMachine3.getMachineName();

        System.out.println("machineName = " + machineName);
    }

    @Test
    public void testExperiment15() {
        HappyMachine happyMachine01 = (HappyMachine) iocContainer.getBean("happyMachine5");
        HappyMachine happyMachine02 = (HappyMachine) iocContainer.getBean("happyMachine5");

        System.out.println(happyMachine01 == happyMachine02);

        System.out.println("happyMachine01.hashCode() = " + happyMachine01.hashCode());
        System.out.println("happyMachine02.hashCode() = " + happyMachine02.hashCode());
    }

}
