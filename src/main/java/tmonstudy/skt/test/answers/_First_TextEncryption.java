package tmonstudy.skt.test.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by jw on 2017-07-06.
 */
public class _First_TextEncryption {

    public static void main(String...args){
        Scanner sc = new Scanner(System.in);
        int total = Integer.valueOf(sc.nextLine());
        List<String> texts = new ArrayList<>();
        for(int i = 0; i < total; i++){
            texts.add(sc.nextLine());
        }
        sc.close();
        for(String text: texts) {
            String encrypted = doEncrypt(text.split(""));
            System.out.println(encrypted);
        }
    }

    private static String doEncrypt(String[] text) {
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        for(int i = 0; i < text.length; i++){
            if(i % 2 == 0){
                even.append(text[i]);
            } else {
                odd.append(text[i]);
            }
        }
        return even.toString() + odd.toString();
    }
}
