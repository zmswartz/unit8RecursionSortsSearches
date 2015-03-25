import java.net.URL;
import java.util.Scanner;
import java.net.MalformedURLException;
import java.io.IOException;
import java.io.PrintWriter;
public class WebReader
{
    public static void main(String[] args) throws MalformedURLException, IOException
    {
        System.out.print("Enter a web address: ");
        Scanner s = new Scanner(System.in);
        String address = s.next();
        URL pageLocation = new URL(address);
        Scanner in = new Scanner(pageLocation.openStream());
        System.out.print("Enter the name of a file to save to: ");
        String file = s.next();
        PrintWriter out = new PrintWriter(file + ".txt");
        while (in.hasNextLine())
        {
            String temp = in.nextLine();
            out.println(temp);
        }
        
        in.close();
        out.close();
    }
}
