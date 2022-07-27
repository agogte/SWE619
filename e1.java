import java.io.File; 
import java.io.FileNotFoundException;
import java.util.Scanner;

public class e1{
	public static void main(String[] args)
	{
		try
		{
			File f1 = new File("f1.txt");
			Scanner input = new Scanner(f1);
			while(input.hasNextLine())
			{
				String data = input.nextLine();
				data= data.replaceAll("\\s", "");
				System.out.println(data);
			}
			input.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
      		e.printStackTrace();
		}
		
	}
}