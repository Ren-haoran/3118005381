package doc_algorithm;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ChaChong {
	//�༭�����㷨�����ƶ�
	public Object[] EDcalculate(ArrayList text,ArrayList name)
	{
		EditDistance ed=new EditDistance();//�༭�����㷨
		// ���弯�ϵĶ�ά���鴢�����Ƶ��ı�����
		ArrayList TotalNameList = new ArrayList(new ArrayList()),  
				TotalSimilarity = new ArrayList(new ArrayList());
		for(int i=0;i<text.size();i++)
		{
			for(int j=1;j<text.size();j++)
			{
				if (i >= j)
					continue;
				char a[], b[];
				a = new char[((String) text.get(i)).length()];
				b = new char[((String) text.get(j)).length()];
				((String) text.get(i)).getChars(0, ((String) text.get(i)).length(), a, 0);
				((String) text.get(j)).getChars(0, ((String) text.get(j)).length(), b, 0);
				int result = ed.edit(a, b, a.length, b.length);
				float maxLength = ((String) text.get(i)).length() > ((String) text.get(j)).length() ?((String) text.get(i)).length() : ((String) text.get(j)).length();
						float similarity = 1 - (result / maxLength);
										
							java.text.NumberFormat percentFormat = java.text.NumberFormat.getPercentInstance();// �����ƶ�ת��Ϊ�ٷֱ���ʾ
							percentFormat.setMaximumFractionDigits(3);
							String pesimilarity = percentFormat.format(similarity);
							TotalNameList.add(name.get(i));
							TotalNameList.add(name.get(j));
							TotalSimilarity.add(pesimilarity);
						
			}
		}
		Object[] o = {  TotalNameList,TotalSimilarity };// ���洢�����ı����ݵļ��ϴ洢��Object��
		return o;
	}
	//���Ҷ��������ƶ�
	public Object[] CalculateSimilarityAlgrithm(String text[],String name[]) throws IOException
	 {
		 CosineSimilarAlgorithm csa=new  CosineSimilarAlgorithm();  //���Ҷ����㷨
			// ���弯�ϵĶ�ά���鴢�涯̬���Ƶ�����
		ArrayList TotalNameList = new ArrayList(new ArrayList()), 
		TotalSimilaity = new ArrayList(new ArrayList());
		for (int i = 0; i < text.length; i++) // �������ƶ�
		{
			for (int j = 1; j <text.length; j++) {
				if (i >= j)
					continue;
				float result= (float) csa.getSimilarity(text[i], text[j]);
									
							java.text.NumberFormat percentFormat = java.text.NumberFormat
									.getPercentInstance();// �����ƶ�ת��Ϊ�ٷֱ���ʾ
							percentFormat.setMaximumFractionDigits(3);
							String pesimilarity = percentFormat.format(result);
							// �����Ƶ����ּ��뵽����
							TotalNameList.add(name[i]);
							TotalNameList.add(name[j]);
							TotalSimilaity.add(pesimilarity);//���ƶ�
			}
		}
		Object[] o = { TotalNameList,TotalSimilaity };// ���洢���Ƶ����ֵļ��ϴ洢��Object��
		return o;
	}
		public void savePersimilaity(Object[] object) {
			ArrayList TotalNameList = (ArrayList) object[0];
			ArrayList TotalSimilarity = (ArrayList) object[1];
			String stu_id=null;
			String stu_name=null;
			String stu_similarity=null;
			String sql2="UPDATE similarity SET similarity = '"+stu_similarity+" ' WHERE id= '"+stu_id+"'";
			String sql1="select id from stu_login"; 
			ResultSet rs1;
			ResultSet rs2;
			DBConnection dbConnection=new DBConnection();
			Statement sta=dbConnection.getStatement();
			for(int i=0;i<TotalNameList.size();i++){
				stu_name=(String) TotalNameList.get(i);
				System.out.println(stu_name);
				try {
					rs1=sta.executeQuery(sql1);	
					System.out.println(rs1.getString(1));
					if(rs1.next()){
						System.out.println("3");
						stu_id=rs1.getString("id");
					stu_similarity=(String) TotalSimilarity.get(i);
					System.out.println(stu_similarity);
					System.out.println(stu_id);
					}
					stu_similarity=(String) TotalSimilarity.get(i);
					sta.executeUpdate(sql2);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
}
