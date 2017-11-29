package htmljsoup;


import java.io.*;
import org.jsoup.*;

import htmlparser.HTMLtoText;


public class HTMLJsoup
{
	static void Html2Txt(String filename) throws Exception
	{
		File file = new File(filename);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder sBuilder = new StringBuilder();
		String str = null;
		while((str= reader.readLine())!=null)
		{
			sBuilder.append(str);
		}
		String textOnly = Jsoup.parse(sBuilder.toString()).text();
		//System.out.println(textOnly);
		PrintWriter out = new PrintWriter("W3C Web Pages/Text2/" + filename.substring(filename.indexOf("/")+1, filename.lastIndexOf(".")) + ".txt");
		out.println(textOnly);
		out.close();
		
	}
	
	
	public static void main(String[] args) throws Exception
	{

		File directory = new File("W3C Web Pages");
		String[] children = directory.list();
		for (String str:children)
		{
			String strx = str.substring(str.lastIndexOf(".")+1);
			
			if (strx.equals("htm"))
			{
				//System.out.println();
				Html2Txt("W3C Web Pages" + "/"+ str);
			}
		}
	}
}
