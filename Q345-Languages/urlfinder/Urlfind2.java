package urlfinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Urlfind2
{
	//private static ArrayList<String> store_strArrayList;
	
	

	
	 static void finder(String filename, String pattern) throws Exception
	{
		File file = new File("W3C Web Pages/"+filename);
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder sBuilder = new StringBuilder();
		String str = null;
		Pattern r = Pattern.compile(pattern);
		while((str= reader.readLine())!=null)
		{
			sBuilder.append(str);
			sBuilder.append("\n");
		}
		//System.out.println(sBuilder);
		Matcher m = r.matcher(sBuilder.toString());
		  while (m.find( )) 
		  {
			  str = m.group(0);
		      System.out.println("Found value: " + str );
		      //store_strArrayList.add(str);
		      
		  } 
	}
	public static void main(String[] args) throws Exception
	{
		
		File directory = new File("W3C Web Pages");
		String[] children = directory.list();
		
		//store_strArrayList = new ArrayList<>();
		for (String str:children)
		{
			String strx = str.substring(str.lastIndexOf(".")+1);
			
			if (strx.equals("htm"))
			{
				//System.out.println(str);
				finder(str, "((http|ftp|https)://)?([\\w_-]+(?:(?:\\.[\\w_-]+)+))(/(?:[\\w_-]+))+");
			}
		}

	}
}
