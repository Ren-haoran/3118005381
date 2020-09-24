package doc_algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		File file1=new File("C:\\Users\\89368\\Desktop\\test\\orig.txt");
		 File file2=new File("C:\\Users\\89368\\Desktop\\test\\orig_0.8_add.txt");//读写文件的文本
		
		 
		 InputStream in1=new FileInputStream(file1);
		 byte[] b=new byte[in1.available()];
		 in1.read(b);
		 String s1 =new String(b,"UTF-8");

		 
		 InputStream in2=new FileInputStream(file2);
		 byte[] c=new byte[in2.available()];
		 in2.read(c);
		 String s2 =new String(c,"UTF-8");
	
				
		ArrayList text=new ArrayList();
		ArrayList name=new ArrayList();
		name.add("一");
		name.add("二");
		text.add(s1);
        text.add(s2);
        
		// 第一步，建立对象
		ChaChong chaCong=new ChaChong();
		// 第二步，调用算法，得到结果对象。
		Object[] o=chaCong.EDcalculate(text, name);
		// 第三步，建立名字，相似度，获取得到的对象中的结果
		ArrayList outname= (ArrayList) o[0];
		ArrayList outsimilarity=(ArrayList) o[1];
		// 第四步，循环取出数据
		for(int i=0;i<outsimilarity.size();i++){
		    System.out.println(outsimilarity.get(i));//输出相似度
		}

	}

}