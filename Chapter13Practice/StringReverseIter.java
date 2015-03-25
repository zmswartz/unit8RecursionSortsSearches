
public class StringReverseIter
{
    public static String reverse(String text)
    {
        if (text.length() <= 1)
        {
            return text;
        }
        
        String reverseText = "";
        
        for (int i = text.length()-1; i >= 0; i --)
        {
            char c = text.charAt(i);
            reverseText += c;
        }
        return reverseText;
    }
    
        public static void main(String[] args)
    {
        System.out.println(reverse("racecar"));
    }
}
