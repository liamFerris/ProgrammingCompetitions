import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TheLastWord
{
    static String kingOfTheHill = "";
    static ArrayList<String> answers = new ArrayList<>();
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args)
    {
        int numberOfThings = s.nextInt();
        for (int i = 0; i < numberOfThings; i++)
        {
            DoIt(s.next());
            answers.add(kingOfTheHill);
            kingOfTheHill = "";
        }
        for (int i = 0; i < answers.size(); i++)
        {
            System.out.println("Case #" + (i+1) + ": " + answers.get(i));
        }
    }

    static void DoIt(String s)
    {
        r(s, s.substring(0,1));
    }

    static void r(String full, String partial)
    {
        if (full.length() == partial.length())
        {
            if (kingOfTheHill.equals(""))
                kingOfTheHill = partial;
            List<String> challenger = new ArrayList<String>();
            challenger.add(partial);
            challenger.add(kingOfTheHill);
            challenger.sort(String::compareToIgnoreCase);
            kingOfTheHill = (challenger.get(challenger.size() - 1));
            return;
        }
        String newLetter = full.substring(partial.length(),partial.length()+1);
        String addItFirst = newLetter + partial;
        String addItLast = partial + newLetter;
        r(full, addItFirst);
        r(full, addItLast);
    }
}
