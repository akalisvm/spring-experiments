package ioc.component;

public class HappyController {
    private HappyService happyService;

    public HappyService getHappyService() {
        return happyService;
    }

    public void setHappyService(HappyService happyService) {
        this.happyService = happyService;
    }
}
