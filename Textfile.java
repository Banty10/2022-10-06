package JavaProgram1;

	import java.io.BufferedReader;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import java.io.FileReader;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Arrays;
	 
public class Textfile{
	 
	    public static void main(String arg[]){
	        StringBuilder sb = new StringBuilder();
	        String strLine = "";
	        List<String> list = new ArrayList<String>();
	        try {
	             BufferedReader br = new BufferedReader(new FileReader("\"D:\\banty.txt\""));
	              while (strLine != null)
	               {
	                strLine = br.readLine();
	                sb.append(strLine);
	                sb.append(System.lineSeparator());
	                strLine = br.readLine();
	                if (strLine==null)
	                   break;
	                list.add(strLine);
	            }
	         System.out.println(Arrays.toString(list.toArray()));
	             br.close();
	        } catch (FileNotFoundException e) {
	            System.err.println("file not found");
	        } catch (IOException e) {
	            System.err.println("Unable to read the file.");
	        }}
	        
	}

