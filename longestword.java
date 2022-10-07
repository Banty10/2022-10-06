package JavaProgram1;
  
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class longestword {

	public static void main1(String[] args) { 
	
}
		 public static void main(String [ ] args) throws FileNotFoundException 
		    {
		        new longestword().findLongestWords();
		
}
		private void findLongestWords() throws FileNotFoundException {
			 String longest_word = "";
		        String current;
		        Scanner sc = new Scanner(new File("longestword"));
		        while (sc.hasNext()) 
		        {
		            current = sc.next();
		            if (current.length() > longest_word.length()) 
		            {
		                longest_word = current;
		            }
		 
		        }
		        System.out.println("\n"+longest_word+"\n");
				return longestword;
		
			
		}

}
