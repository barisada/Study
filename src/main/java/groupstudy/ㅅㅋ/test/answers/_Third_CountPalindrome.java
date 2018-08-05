package groupstudy.ㅅㅋ.test.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jw on 2017-07-14.
 * https://algospot.com/judge/problem/read/COUNTPALIN
 */
public class _Third_CountPalindrome {
    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        System.out.println("adfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjasdlkfjlaksdjflkasjdflkajsldkfjlkasdjflkasjdlkfjalksdjflkasjdflkajsdlkfjalksdjflkajsdlfkjasldkfjlkadsjfljasdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjasdlkfjlaksdjflkasjdflkajsldkfjlkasdjflkasjdlkfjalksdjflkasjdflkajsdlkfjalksdjflkajsdlfkjasldkfjlkadsjfljasdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjasdlkfjlaksdjflkasjdflkajsldkfjlkasdjflkasjdlkfjalksdjflkasjdflkajsdlkfjalksdjflkajsdlfkjasldkfjlkadsjfljasdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajdsfkljasldkfjalskdjflkasjdflkjasldkfjlkasjdflkjasdlkfjlaksdjflkasjdflkajsldkfjlkasdjflkasjdlkfjalksdjflkasjdflkajsdlkfjalksdjflkajsdlfkjasldkfjlkadsjfljasdlkfjalksdjflkajsdklfjlaksdjflkjasdlkfjlakdsjflkasjdlfkjaslkdjflkasjdflkjasldkjflaksjdfklajsdlkfjalskdfjkasjdfkjasldadfajdklfjaklaaadjfkajskdlffljaksdjfkajsdlkfjasdjflkajdlkfjaklsdjflkajsldkfjalksdjflkajdlkfjalksdjflajds".length());
        int total = sc.nextInt();
        List<Integer> count = new ArrayList<>();
        for(int i = 0; i < total;i++){
            int length = sc.nextInt();
            String text = sc.next();

            List<String> palindromes= findAllPalindromes(text, length);
            System.out.println(palindromes);
            count.add(palindromes.size());
        }
        count.forEach(System.out::println);
        sc.close();
    }

    private static List<String> findAllPalindromes(String text, int length) {
        List<String> palindromes = new ArrayList<>();
        for(int i = 0; i < length; i++){
            for(int j = length; j > i + 1; j--){
                String sample = text.substring(i, j);
                if(isPalindrome(sample)) palindromes.add(sample);
            }
        }
        return palindromes;
    }

    private static boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = str.length()-1; i >=0; i--){
            sb.append(str.charAt(i));
        }
        return str.equals(sb.toString());
    }
}
