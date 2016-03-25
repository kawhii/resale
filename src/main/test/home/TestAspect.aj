package home;

/**
 * Create by Administrator on 2016/3/24.
 */
public aspect TestAspect {
    pointcut callPointCut() : call(void home.PeopleSpeaker.say());
    before() : callPointCut() {
        System.out.println("this is before method");
    }

    public static void main(String[] args) {
        new PeopleSpeaker().say();
    }
}
