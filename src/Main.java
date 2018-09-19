import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> subsequences = getSubsequences("abcd");
        System.out.println(subsequences);
        System.out.println("No. of subsequences: " + subsequences.size());

        ArrayList<String> subsequencesWASCII = getSubsequencesASCII("abc");
        System.out.println(subsequencesWASCII);
        System.out.println("No. of subsequences: " + subsequencesWASCII.size());

        ArrayList<String> keyPadCombos = getKeypadCombos("179");
        System.out.println(keyPadCombos);
        System.out.println("No. of keypad combos: " + keyPadCombos.size());
    }

    // every character of the string has a choice whether to appear in the sub-sequence or not
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
        ArrayList<String> myList = new ArrayList<>(subs); // add the result where str[0] says no
        for (String mySubstr : subs) { // add the result where str[0] says yes
            myList.add(inputString.substring(0, 1) + mySubstr);
        }

        return myList;
    }

    public static ArrayList<String> getSubsequencesASCII(String inputString) {
        if (inputString.length() == 0) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        // faith call that my function will return all substrings of a string, just one char smaller than actual string.
        ArrayList<String> subs = getSubsequencesASCII(inputString.substring(1));

        // we get an ArrayList of sub-sequences subs, which we first add directly to our ArrayList and
        // then add it with the first character that we separated earlier, included
        ArrayList<String> myList = new ArrayList<>(subs); // add the result where str[0] says no
        for (String mySubstr : subs) { // add the result where str[0] says yes
            myList.add(inputString.charAt(0) + mySubstr);
            myList.add((int) inputString.charAt(0) + mySubstr);
        }

        return myList;
    }

    static String[] codes = {".", "abc", "def", "ghi", "jkl", "mno", "pqr", "st", "uvwx", "yz"};

    public static ArrayList<String> getKeypadCombos(String inputStr) {
        if (inputStr.length() == 0) {
            ArrayList<String> baseList = new ArrayList<>();
            baseList.add("");
            return baseList;
        }

        // Input will be like "179",
        String firstChar = inputStr.substring(0, 1);    // separates 1 fom 179
        String restOfString = inputStr.substring(1); // separates rest of String : 79

        // get the result for 79 using our faith call
        ArrayList<String> recursionResult = getKeypadCombos(restOfString);

        // now we already have result from 79, all we have to do is add prefixes based on the first char we separated
        ArrayList<String> myResult = new ArrayList<>();
        for (String partOfStr : recursionResult) {
            // on every element of the recursion result
            String prefix = codes[Integer.parseInt(firstChar)]; // get the prefix string from the codes array
            for (int i = 0; i < prefix.length(); i++) { // for every character in the prefix string
                myResult.add(prefix.charAt(i) + partOfStr);  // join it with the element of recursion result, add it to myList
            }
        }

        return myResult;
    }
}
