package doc_algorithm;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList text=new ArrayList();
		ArrayList name=new ArrayList();
		name.add("һ");
		name.add("��");
		text.add("�����������죬�����磬����������Ҫȥ����Ӱ");
text.add("���������죬�������ʣ�������Ҫȥ����Ӱ��");
		// ��һ������������
		ChaChong chaCong=new ChaChong();
		// �ڶ����������㷨���õ��������
		Object[] o=chaCong.EDcalculate(text, name);
		// ���������������֣����ƶȣ���ȡ�õ��Ķ����еĽ��
		ArrayList outname= (ArrayList) o[0];
		ArrayList outsimilarity=(ArrayList) o[1];
		for(int i=0;i<outsimilarity.size();i++){
			System.out.println(outname.get(i+i)); 
			System.out.println(outname.get(i+i+1));
		    System.out.println(outsimilarity.get(i)); //���ƶ�
		}

	}

}