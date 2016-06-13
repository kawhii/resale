package shiro;

/**
 * @author Carl
 * @date 2016/4/27
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class SubClass extends SuperClass {
    public SubClass() {
        super();
        System.out.println("SubClass");
    }
    public SubClass(String n) {
        super(n);
        System.out.println("SubClass2");
    }

    public static void main(String[] args) {
        new SubClass("");
        new SubClass();
    }
}
