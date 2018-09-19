import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> subsequences = getSubsequences("abcd");
        System.out.println(subsequences);
        System.out.println("No. of subsequences: " + subsequences.size());
    }

    public static ArrayList<String> getSubsequences(String inputString) {
        if (inputString.length() == 0) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        // faith call that my function will return all substrings of a string, just one char smaller than actual string.
        ArrayList<String> subs = getSubsequences(inputString.substring(1));

        // we get an ArrayList of sub-sequences subs, which we first add directly to our ArrayList and
        // then add it with the first character that we separated earlier, included
        ArrayList<String> myList = new ArrayList<>(subs);
        for(String mySubstr : subs) {
            myList.add(inputString.substring(0, 1) + mySubstr);
        }

        return myList;
    }
}
