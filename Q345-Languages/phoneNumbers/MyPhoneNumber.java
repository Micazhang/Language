package phoneNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MyPhoneNumber
{
	public static void PhoneNumber(String filename) throws IOException
	{
	      String pattern = "(\\()?(\\d){3}(\\))?[- ](\\d){3}-(\\d){4}";
	      String patternemailString = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";

	      // Create a Pattern object
	      Pattern r = Pattern.compile(pattern);
	      Pattern r2 = Pattern.compile(patternemailString);
	      // Now create matcher object.

		File file = new File("W3C Web Pages/Text2/"+filename);
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(file));
		StringBuilder sBuilder = new StringBuilder();
		String str = null;
		while((str= reader.readLine())!=null)
		{
			sBuilder.append(str);
		}
	      Matcher m = r.matcher(sBuilder.toString());
	      while (m.find( )) {
	          System.out.println("Found value: " + m.group(0) + " at " + m.start(0));
	      } 
	      Matcher m2 = r2.matcher(sBuilder.toString());
	      while (m2.find( )) {
	          System.out.println("Found value: " + m2.group(0) + " at " + m2.start(0));
	      } 
		
	}
	
	
    public static void main( String args[] ) throws Exception
    {
    	File directory = new File("W3C Web Pages/Text2");
		String[] children = directory.list();
    	
    
      for (String str:children)
      {
    	  PhoneNumber(str);
      }
   }
}