package com.carl;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Scanner;


public class HardWareUtils {
    public static void cpu() throws Exception {
        long start = System.currentTimeMillis();
        Process process = Runtime.getRuntime().exec(
                new String[]{"wmic", "cpu", "get", "ProcessorId"});
        process.getOutputStream().close();
        Scanner sc = new Scanner(process.getInputStream());
        String property = sc.next();
        String serial = sc.next();
        System.out.println(property + ": " + serial);
        System.out.println("time:" + (System.currentTimeMillis() - start));
    }


    /*众所周知，Java操作硬件底层的API是非常痛苦的事情，如果JDK本身没有提供相关的API，还要自己使用底层的开发语言如C、C++来调用系统级别的API来进行硬件的操作。如简单的获取计算机网卡物理地址的这么一个操作，也非常的痛苦，各种奇葩的方法。
    JDK1.7开始，获取网卡物理地址（MAC）就简单了。下面的代码获取了所有网卡的MAC地址（如果有的话）
*/
    public static void mac() throws Exception {
        System.out.println("---------");
        //获取所有的网卡
        Enumeration<NetworkInterface> ints = NetworkInterface.getNetworkInterfaces();
        while (ints.hasMoreElements()) {
            NetworkInterface net = ints.nextElement();
            //获取网卡的硬件地址，有可能是空的
            byte[] mac = net.getHardwareAddress();
            System.out.print(net.getDisplayName() + " 的 MAC 地址为：");
            if (mac != null) {
                System.out.println(toHex(mac));
            } else {
                System.out.println("空");
            }
        }
    }

    private static String toHex(byte[] bytes) {
        String s = "";
        for (byte b : bytes) {
            String tmp = Integer.toHexString(b & 0xFF).toUpperCase();
            if (!s.isEmpty())
                s += "-";//加上间隔符
            if (tmp.length() < 2)
                s += "0" + tmp;//保证两个字符
            else
                s += tmp;
        }
        return s;
    }

    public static String getSerialNumber(String drive) {
        String result = "";
        try {
            File file = File.createTempFile("realhowto",".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);
            String vbs = "Set objFSO = CreateObject(\"Scripting.FileSystemObject\")\n"
                    +"Set colDrives = objFSO.Drives\n"
                    +"Set objDrive = colDrives.item(\"" + drive + "\")\n"
                    +"Wscript.Echo objDrive.SerialNumber";  // see note
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());
            BufferedReader input =
                    new BufferedReader
                            (new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return result.trim();
    }


    public static void main(String[] args) throws Exception {
        mac();
//        cpu();
//        System.out.println(getSerialNumber("d"));
    }

    @Test
    public void date() throws Exception {

    }
}
