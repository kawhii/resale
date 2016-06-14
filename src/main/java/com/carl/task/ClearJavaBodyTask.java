package com.carl.task;

import com.carl.util.JavaByteCodeUtil;
import com.carl.util.PackageUtil;
import javassist.ClassClassPath;
import javassist.ClassPool;
import javassist.CtClass;
import org.apache.tools.ant.BuildException;
import org.apache.tools.ant.Task;

import java.util.List;



/**
 * @author Carl
 * @date 2016/6/13
 * <p>
 * 版权所有.(c)2008-2016.广州市森锐科技股份有限公司
 */
public class ClearJavaBodyTask extends Task {
    //是否清空方法体
    private boolean clearMethodBody = true;
    //是否清空构造函数体
    private boolean clearConstructorBody = true;
    //目标路径
    private String toPath;
    //清空包名字
    private String clearPackageName;

    @Override
    public void execute() throws BuildException {
        String packageName = clearPackageName;
        System.out.println("清空包：" + packageName);
        System.out.println("是否清空方法体：" + clearMethodBody);
        System.out.println("是否清空构造函数：" + clearConstructorBody);
        System.out.println("目标目录：" + toPath);
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(this.getClass()));
        //获取到所有classes
        List<String> classNames = PackageUtil.getClassName(packageName, true);
        for (String clzName : classNames) {
            try {
                CtClass cc = pool.get(clzName);

                if (clearConstructorBody) {
                    JavaByteCodeUtil.get(pool).clearConstructor(clzName);
                }

                if (clearMethodBody) {
                    JavaByteCodeUtil.get(pool).clearMethodBody(clzName);
                }

                cc.writeFile(toPath);
                cc.detach();//释放内存
            } catch (Exception e) {
                throw new BuildException(e);
            }
        }
    }
    public void setClearMethodBody(boolean clearMethodBody) {
        this.clearMethodBody = clearMethodBody;
    }

    public void setClearConstructorBody(boolean clearConstructorBody) {
        this.clearConstructorBody = clearConstructorBody;
    }

    public void setToPath(String toPath) {
        this.toPath = toPath;
    }

    public void setClearPackageName(String clearPackageName) {
        this.clearPackageName = clearPackageName;
    }
}
