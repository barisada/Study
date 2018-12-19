package dailycoding;

import java.util.*;

/**
 * Implement an autocomplete system.
 * That is, given a query string s and a set of all possible query strings,
 * return all strings in the set that have s as a prefix.
 *
 * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
 *
 * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
 */
public class Problem_11 {

    public static void main(String[] args) {
        Problem_11 test = new Problem_11();
        String[] test1 = {"dog", "deer", "deep", "deeper", "deal", "dealer"};
        AutoComplte autoComplte = test.createAutocComplete(test1);

        System.out.println(autoComplte.searchPrefix("dee"));

    }

    public AutoComplte createAutocComplete(String...args){
        AutoComplte auto = new AutoComplte();
        for(String str : args){
            auto.addWord(str);
        }
        return auto;
    }

    public class AutoComplte {
        Trie root = new Trie('#');

        public void addWord(String word){
            Trie cur = root;
            for(char c : word.toCharArray()){
                Map<Character, Trie> sub = cur.sub;
                if(!sub.containsKey(c)) {
                    sub.put(c, new Trie(c));
                }
                cur = sub.get(c);
            }
            cur.isWord = true;
            cur.word = word;
        }

        public List<String> searchPrefix(String prefix){
            Trie cur = root;
            for(char c : prefix.toCharArray()){
                if(!cur.sub.containsKey(c)){
                    return Collections.emptyList();
                }
                cur = cur.sub.get(c);
            }

            return getWordsDFS(cur);

        }

        private List<String> getWordsDFS(Trie trie) {
            List<String> words = new ArrayList<>();
            if(trie.isWord) words.add(trie.word);

            Stack<Trie> stack = new Stack<>();
            stack.add(trie);
            while(!stack.isEmpty()){
                Trie cur = stack.pop();
                for(char c : cur.sub.keySet()){
                    Trie sub = cur.sub.get(c);
                    if(sub.isWord) words.add(sub.word);
                    stack.add(sub);
                }
            }
            return words;
        }
    }

    class Trie{
        char val;
        Map<Character, Trie> sub ;
        boolean isWord;
        String word;

        public Trie(char c){
            val = c;
            sub = new HashMap<>();
        }
    }
}

