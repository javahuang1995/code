package com.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

//public class LineConvertor extends DefaultTypeConverter{
//  @Override
// public Object convertValue(Map<String, Object> context, Object value, Class toType) 
//  {
//	//�ַ���ת��Line������
//	if(toType==Line.class)
//	{
//		//�������Ϊ�ַ�������
//		String[] params=(String[])value;
//		String param=params[0];
//		//����Lineʵ��
//		Line line=new Line();
//		StringBuilder temp=new StringBuilder();
//		char ch;
//		int j=0;
//		//�ַ�����ȷ��ʽΪ(x1,y1,x2,y2)
//		for(int index=0;index<param.length();index++)
//		{
//			ch=param.charAt(index);
//			if(ch!=','&&ch!='('&&ch!=')')
//			{
//			   temp.append(ch);
//			}else if(ch==','||ch==')')
//			{
//				switch (j) {
//				case 0:
//				{
//					line.setX1(Integer.parseInt(temp.toString()));
//					temp.delete(0,temp.length());
//					break;
//				}
//				case 1:
//				{
//					line.setY1(Integer.parseInt(temp.toString()));
//					temp.delete(0,temp.length());
//					break;
//				}
//				case 2:
//				{
//					line.setX2(Integer.parseInt(temp.toString()));
//					temp.delete(0,temp.length());
//					break;
//				}
//				case 3:
//				{
//					line.setY2(Integer.parseInt(temp.toString()));
//					temp.delete(0,temp.length());
//					break;
//				}
//				default:
//					break;
//				}
//				j++;
//			}
//		}
//		//���ؽ��Lineʵ��
//		return (Object)line;
//	}
//	//������ת��Ϊ�ַ���
//	else if(toType==String.class)
//	{
//		//ǿ��ת��ΪLine����
//		Line line=(Line)value;
//		return (Object)("("+line.getX1()+","+line.getY1()+","+line.getX2()+","+line.getY2()+")");
//		
//	}
//	return null;
//  }
//}
public class LineConvertor extends StrutsTypeConverter{
	//�ַ���ת��ָ������
	public Object convertFromString(Map contenxt, String[] values, Class totype) {
		//�������Ϊ�ַ�������
		String[] params=(String[])values;
		String param=params[0];
		//����Lineʵ��
		Line line=new Line();
		StringBuilder temp=new StringBuilder();
		char ch;
		int j=0;
		//�ַ�����ȷ��ʽΪ(x1,y1,x2,y2)
		for(int index=0;index<param.length();index++)
		{
			ch=param.charAt(index);
			if(ch!=','&&ch!='('&&ch!=')')
			{
			   temp.append(ch);
			}else if(ch==','||ch==')')
			{
				switch (j) {
				case 0:
				{
					line.setX1(Integer.parseInt(temp.toString()));
					temp.delete(0,temp.length());
					break;
				}
				case 1:
				{
					line.setY1(Integer.parseInt(temp.toString()));
					temp.delete(0,temp.length());
					break;
				}
				case 2:
				{
					line.setX2(Integer.parseInt(temp.toString()));
					temp.delete(0,temp.length());
					break;
				}
				case 3:
				{
					line.setY2(Integer.parseInt(temp.toString()));
					temp.delete(0,temp.length());
					break;
				}
				default:
					break;
				}
				j++;
			}
		}
		return (Object)line;

	}

	//������ת��Ϊ�ַ���
	public String convertToString(Map context, Object o) {
		//ǿ��ת��ΪLine����
		Line line=(Line)o;
		return "("+line.getX1()+","+line.getY1()+","+line.getX2()+","+line.getY2()+")";
	}
}
