package doc_algorithm;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList text=new ArrayList();
		ArrayList name=new ArrayList();
		name.add("一");
		name.add("二");
		text.add("今天是星期天，天气晴，今天晚上我要去看电影");
text.add("今天是周天，天气晴朗，我晚上要去看电影。");
		// 第一步，建立对象
		ChaChong chaCong=new ChaChong();
		// 第二步，调用算法，得到结果对象。
		Object[] o=chaCong.EDcalculate(text, name);
		// 第三步，建立名字，相似度，获取得到的对象中的结果
		ArrayList outname= (ArrayList) o[0];
		ArrayList outsimilarity=(ArrayList) o[1];
		for(int i=0;i<outsimilarity.size();i++){
			System.out.println(outname.get(i+i)); 
			System.out.println(outname.get(i+i+1));
		    System.out.println(outsimilarity.get(i)); //相似度
		}

	}

}