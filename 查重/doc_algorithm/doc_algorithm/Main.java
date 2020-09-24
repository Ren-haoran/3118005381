package doc_algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		File file1=new File(args[0]);
		 File file2=new File(args[1]);//读写文件的文本


		 InputStream in1=new FileInputStream(file1);
		 byte[] b=new byte[in1.available()];
		 in1.read(b);
		 String s1 =new String(b,"UTF-8");
		s1 = s1.replaceAll("[^(\\u4e00-\\u9fa5)]", "");//过滤符号和英文字母
		 
		 InputStream in2=new FileInputStream(file2);
		 byte[] c=new byte[in2.available()];
		 in2.read(c);
		 String s2 =new String(c,"UTF-8");
		s2 = s2.replaceAll("[^(\\u4e00-\\u9fa5)]", "");//过滤
				
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
		String a = null;
		for(int i=0;i<outsimilarity.size();i++){
			System.out.println(outsimilarity.get(i));//输出相似度
			a= (String) outsimilarity.get(i);
		}
		OutputStream out =new FileOutputStream(args[2]);
		byte[] bytes = a.toString().getBytes();
		out.write(bytes);
		out.flush();
		}

	}

