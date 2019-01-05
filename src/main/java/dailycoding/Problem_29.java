package dailycoding;

/**
 * Run-length encoding is a fast and simple method of encoding strings.
 * The basic idea is to represent repeated successive characters as a single count and character.
 * For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
 *
 * Implement run-length encoding and decoding.
 * You can assume the string to be encoded have no digits and consists solely of alphabetic characters.
 * You can assume the string to be decoded is valid.
 */
public class Problem_29 {
    public static void main(String[] args) {
        Problem_29 test = new Problem_29();
        String result = test.encoding("AAAABBBCCDAA");
        System.out.println(String.format("should be 4A3B2C1D2A : %s (%s)", result, "4A3B2C1D2A".equalsIgnoreCase(result)));
        result = test.decoding("4A3B2C1D2A");
        System.out.println(String.format("should be AAAABBBCCDAA : %s (%s)", result, "AAAABBBCCDAA".equalsIgnoreCase(result)));

        result = test.encoding("aaaabbbccc");
        System.out.println(String.format("should be 4a3b3c : %s (%s)", result, "4a3b3c".equalsIgnoreCase(result)));
        result = test.decoding("4a3b3c");
        System.out.println(String.format("should be aaaabbbccc : %s (%s)", result, "aaaabbbccc".equalsIgnoreCase(result)));

        result = test.encoding("abbbcdddd");
        System.out.println(String.format("should be 1a3b1c4d : %s (%s)", result, "1a3b1c4d".equalsIgnoreCase(result)));
        result = test.decoding("1a3b1c4d");
        System.out.println(String.format("should be abbbcdddd : %s (%s)", result, "abbbcdddd".equalsIgnoreCase(result)));

        result = test.encoding("wwwwaaadexxxxxxywww");
        System.out.println(String.format("should be 4w3a1d1e6x1y3w : %s (%s)", result, "4w3a1d1e6x1y3w".equalsIgnoreCase(result)));
        result = test.decoding("4w3a1d1e6x1y3w");
        System.out.println(String.format("should be wwwwaaadexxxxxxywww : %s (%s)", result, "wwwwaaadexxxxxxywww".equalsIgnoreCase(result)));
    }

    public String encoding(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length() - 1; i++){
            int j = i;
            while(j < s.length() - 1 && s.charAt(j) == s.charAt(j + 1)) j++;
            sb.append(j - i + 1);
            sb.append(s.charAt(i));
            i = j;
        }
        return sb.toString();
    }

    public String decoding(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            int num = Integer.valueOf(s.substring(i, i + 1));
            for(int j = 0; j < num; j++){
                sb.append(s.charAt(i + 1));
            }
            i++;
        }
        return sb.toString();
    }
}
