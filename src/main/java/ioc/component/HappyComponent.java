package ioc.component;

public class HappyComponent {

    private String componentName;
    private HappyMachine happyMachine;

    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }

    public HappyMachine getHappyMachine() {
        return happyMachine;
    }

    public void setHappyMachine(HappyMachine happyMachine) {
        this.happyMachine = happyMachine;
    }

    public void doWork() {
        System.out.println("component do work...");
    }

    public void happyInitMethod() {
        System.out.println("HappyComponent初始化");
    }

    public void happyDestroyMethod() {
        System.out.println("HappyComponent销毁");
    }

}
