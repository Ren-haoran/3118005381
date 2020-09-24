package doc_algorithm;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
		
	public static void main(String[] args) throws IOException {
		
		File file1=new File(args[0]);
		 File file2=new File(args[1]);//��д�ļ����ı�


		 InputStream in1=new FileInputStream(file1);
		 byte[] b=new byte[in1.available()];
		 in1.read(b);
		 String s1 =new String(b,"UTF-8");
		s1 = s1.replaceAll("[^(\\u4e00-\\u9fa5)]", "");//���˷��ź�Ӣ����ĸ
		 
		 InputStream in2=new FileInputStream(file2);
		 byte[] c=new byte[in2.available()];
		 in2.read(c);
		 String s2 =new String(c,"UTF-8");
		s2 = s2.replaceAll("[^(\\u4e00-\\u9fa5)]", "");//����
				
		ArrayList text=new ArrayList();
		ArrayList name=new ArrayList();
		name.add("һ");
		name.add("��");
		text.add(s1);
        text.add(s2);
        
		// ��һ������������
		ChaChong chaCong=new ChaChong();
		// �ڶ����������㷨���õ��������
		Object[] o=chaCong.EDcalculate(text, name);
		// ���������������֣����ƶȣ���ȡ�õ��Ķ����еĽ��
		ArrayList outname= (ArrayList) o[0];
		ArrayList outsimilarity=(ArrayList) o[1];
		// ���Ĳ���ѭ��ȡ������
		String a = null;
		for(int i=0;i<outsimilarity.size();i++){
			System.out.println(outsimilarity.get(i));//������ƶ�
			a= (String) outsimilarity.get(i);
		}
		OutputStream out =new FileOutputStream(args[2]);
		byte[] bytes = a.toString().getBytes();
		out.write(bytes);
		out.flush();
		}

	}

