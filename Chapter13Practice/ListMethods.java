import java.util.ArrayList;

public class ListMethods
{
    public static ArrayList makeList(int n)
    {
        ArrayList<Integer> tempList = null;
        if (n <= 0)  // The smallest list we can make
        {
            tempList = new ArrayList<Integer>();

        }
        else        // All other size lists are created here
        {
            tempList = makeList(n-1);
            tempList.add(new Integer(n));
        }
        return tempList;
    }

    public static ArrayList<Integer> reverseList(ArrayList<Integer> list) 
    {
        if (list.size() < 2)
        {
            return list;
        }
        
        Integer front = list.get(0);
        Integer back = list.get(list.size() -1);
        list.remove(0);
        list.remove(list.size() -1);
        list = reverseList(list);
        list.add( 0, back);
        list.add(front);
        return list;
    }
}
