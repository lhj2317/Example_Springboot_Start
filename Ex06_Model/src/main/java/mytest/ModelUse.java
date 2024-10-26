package mytest;

import java.util.HashMap;
import java.util.Map;

public class ModelUse {

	public static void main(String[] args) 
	{
		Map<String, String> model1 = new HashMap<>();
		String sReturn = root(model1);
		printData(sReturn, model1);
	}
	
	public static String root(Map model2)
	{
		model2.put("name1", "홍길동");
		model2.put("name2", "전우치");
		return "Hello";
	}

	private static void printData(String s, Map model3) 
	{
		String str1 = (String)model3.get("name1");
		System.out.println(str1);
		System.out.println("WEB-INF/views/" + s + ".jsp");
	}

}