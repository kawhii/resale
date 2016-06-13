package shiro;

import com.carl.resale.util.StringUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Scanner;

/**
 * @author Carl
 * @date 2016/4/30
 * @modify 版权所有.(c)2008-2016.广州市森锐电子科技有限公司
 */
public class ScanTest {
    public static void main(String[] args) throws Exception{
        ScanTest test = new ScanTest();
        test.handleLine(new File("C:\\Users\\Administrator\\Desktop\\收银员\\收银员考证技能考核题库3.txt"));
    }

    public String handleLine(File f) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileReader(f));
        int index = 0;
        String names[] = new String[] {"","A", "B", "C", "D", "E", "F"};
        if(scanner.hasNextLine()) {
            scanner.nextLine();
        }
        String preTitle = "";
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine();
            //System.out.println(line);
            String lines[] = line.split("\t");
            if(lines == null || lines.length == 0)
                continue;
            if(lines.length < 3) {
                preTitle = lines[0];
                continue;
            } else {
                index++;
                String ppTitle = lines[0];
                int preI = 1;
                if(StringUtil.isNull(ppTitle) || ppTitle.equals(" ") || ppTitle.equals("\t") ||  ppTitle.equals("\n")) {
                    ppTitle = lines[1];
                    preI = 2;
                }
                String title = index + "." + preTitle + " " + ppTitle;
                preTitle = "";
                String content = "";
                for(int i = preI; i < lines.length; i ++) {
                    String l = lines[i];
                    int nIndex = i;
                    if(preI > 1) {
                        nIndex = nIndex - 1;
                    }
                    content += names[nIndex] + "." + l + "\t";
                }
                System.out.println(title);
                System.out.println(content);
            }
        }
        return null;
    }

    public boolean noShould(String s) {
        if("0101".equals(s)) {
            return false;
        }
        return true;
    }
}
