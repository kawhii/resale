package home;

/**
 * @author Carl
 * @date 2016/3/24
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class PeopleSpeaker {
    public void say() {
        System.out.println("I am people speaker, I want to tell you something");
    }

    public static void main(String[] args) {
        new PeopleSpeaker().say();
    }
}
