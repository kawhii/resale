package javassist;

/**
 * @author Carl
 * @date 2016/6/13
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class TestPoint {
    private String x = "TestPoint x";
    private float y = 0;
    private TestPoint mine;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public TestPoint getMine() {
        System.out.println("getMine");
        return mine;
    }

    public void setMine(TestPoint mine) {
        System.out.println("setMine");
        this.mine = mine;
    }

    @Override
    public String toString() {
        return "TestPoint{" +
                "x='" + x + '\'' +
                ", y=" + y +
                ", mine=" + mine +
                '}';
    }
}
