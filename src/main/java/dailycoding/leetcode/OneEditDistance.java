package dailycoding.leetcode;

import org.springframework.util.Assert;

/**
 * Write a function that returns whether two words are exactly "one edit" away using the following signature:
 *
 * An edit is:
 * Inserting one character anywhere in the word (including at the beginning and end)
 * Removing one character
 * Replacing one character
 *
 * Examples:
 * OneEditApart("cat", "dog") = false
 * OneEditApart("cat", "cats") = true
 * OneEditApart("cat", "cut") = true
 * OneEditApart("cat", "cast") = true
 * OneEditApart("cat", "at") = true
 * OneEditApart("cat", "act") = false
 *
 */
public class OneEditDistance {
    public static void main(String[] args) {
        OneEditDistance test = new OneEditDistance();
        System.out.println("1. should be false : " + test.OneEditApart("cat", "dog"));
        System.out.println("2. should be true : " + test.OneEditApart("cat", "cats"));
        System.out.println("3. should be true : " + test.OneEditApart("cat", "cut"));
        System.out.println("4. should be true : " + test.OneEditApart("cat", "cast"));
        System.out.println("5. should be true : " + test.OneEditApart("cat", "cast"));
        System.out.println("6. should be true : " + test.OneEditApart("cat", "at"));
        System.out.println("7. should be false : " + test.OneEditApart("cat", "act"));

    }

    public boolean OneEditApart(String s, String t){
        int i = 0, j = 0, diff = 0;
        while(i < s.length() && j < t.length()){
            if(s.charAt(i) != t.charAt(j)){
                if(s.length() > t.length()){
                    i++;
                } else if(t.length() > s.length()){
                    j++;
                } else {
                    i++;
                    j++;
                }
                diff++;
            } else{
                i++;
                j++;
            }
        }
        diff += (s.length() - i) + (t.length() - j);
        return diff == 1;
    }
}
