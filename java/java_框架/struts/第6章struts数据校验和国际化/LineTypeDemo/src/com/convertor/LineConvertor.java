package com.convertor;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

//public class LineConvertor extends DefaultTypeConverter{
//  @Override
// public Object convertValue(Map<String, Object> context, Object value, Class toType) 
//  {
//	//字符串转向Line类类型
//	if(toType==Line.class)
//	{
//		//请求参数为字符串数组
//		String[] params=(String[])value;
//		String param=params[0];
//		//创建Line实例
//		Line line=new Line();
//		StringBuilder temp=new StringBuilder();
//		char ch;
//		int j=0;
//		//字符串正确形式为(x1,y1,x2,y2)
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
//		//返回结果Line实例
//		return (Object)line;
//	}
//	//将对象转换为字符串
//	else if(toType==String.class)
//	{
//		//强制转换为Line类型
//		Line line=(Line)value;
//		return (Object)("("+line.getX1()+","+line.getY1()+","+line.getX2()+","+line.getY2()+")");
//		
//	}
//	return null;
//  }
//}
public class LineConvertor extends StrutsTypeConverter{
	//字符串转向指定类型
	public Object convertFromString(Map contenxt, String[] values, Class totype) {
		//请求参数为字符串数组
		String[] params=(String[])values;
		String param=params[0];
		//创建Line实例
		Line line=new Line();
		StringBuilder temp=new StringBuilder();
		char ch;
		int j=0;
		//字符串正确形式为(x1,y1,x2,y2)
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

	//将对象转换为字符串
	public String convertToString(Map context, Object o) {
		//强制转换为Line类型
		Line line=(Line)o;
		return "("+line.getX1()+","+line.getY1()+","+line.getX2()+","+line.getY2()+")";
	}
}
