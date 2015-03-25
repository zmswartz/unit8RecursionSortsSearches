import java.util.Scanner;

/**
 * Demonstrates the use of nested while loops.
 * 
 * @author Lewis/Loftus/Cocking
 */
public class PalindromeTester
{
    /**
     * Tests strings to see if they are palindromes.
     *
     */
    public static void main (String[] args)
    {
        String str, another = "y";
        int left, right;
        Scanner s = new Scanner(System.in);

        while (another.equalsIgnoreCase("y")) // allows y or Y
        {
            System.out.println ("Enter a potential palindrome:");
            str = s.nextLine();
            
            System.out.println();

            if (isPalindromeRecursive(str))
                System.out.println ("That string IS a palindrome.");
            else
                System.out.println ("That string is NOT a palindrome.");

            System.out.println();
            System.out.print ("Test another palindrome (y/n)? ");
            another = s.nextLine();
        }
    }

    private static boolean isPalindrome(String str)
    {
        int left = 0;
        int right = str.length() - 1;

        while (str.charAt(left) == str.charAt(right) && left < right)
        {
            left++;
            right--;
        }
        return left >= right;
    }
    
    private static boolean isPalindromeRecursive(String str)
    {
        if (str.length() <= 1)
        {
            return true;
        }
        
        
        if (str.charAt(0) == str.charAt(str.length() -1 ) && isPalindromeRecursive(str.substring(1, str.length() -1)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
