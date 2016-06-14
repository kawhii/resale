package javassist;


import com.carl.util.JavaTypeUtil;

/**
 * @author Carl
 * @date 2016/6/13
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class TestJavaCode {
    public static void main(String[] args) throws Exception {
        TestPoint testPoint = new TestPoint();
        System.out.println(testPoint.getX());
        ClassPool pool = ClassPool.getDefault();
        CtClass cc = pool.get("javassist.TestPoint");
        for (CtMethod cm : cc.getDeclaredMethods()) {
            CtClass returnType = cm.getReturnType();
            String code = JavaTypeUtil.caseType(returnType);

            String bodyCode = code == null  ? "{}" : "return " + code + ";";
            cm.setBody(bodyCode);
        }
        cc.writeFile("target\\test-classes");
        cc.defrost();
        TestPoint tt = new TestPoint();
        System.out.println(tt.getX());
    }
}
