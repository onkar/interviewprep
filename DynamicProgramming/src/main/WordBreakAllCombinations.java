package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Given a string s and a dictionary of words dictionary, add spaces in s to construct a sentence
 * where each word is a valid dictionary word, return all such possible sentences. For example,
 * given s = "catsanddog", dictionary = ["cat", "cats", "and", "sand", "dog"], the solution is
 * [["cats", "and", "dog"], ["cat", "sand", "dog"]].
 * 
 * Source - http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class WordBreakAllCombinations {

  public static List<ArrayList<String>> getCombinations(String input, Set<String> dictionary) {
    List<String> result = wordBreak(input, dictionary);
    List<ArrayList<String>> outer = new ArrayList<ArrayList<String>>();
    for (String str : result) {
      ArrayList<String> inner = new ArrayList<String>();
      StringTokenizer st = new StringTokenizer(str, " ");
      while (st.hasMoreTokens()) {
        inner.add(st.nextToken());
      }
      outer.add(inner);
    }
    return outer;
  }

  /**
   * Build a hashmap by using dictionary and the input string. For input string "catsanddog", the
   * hashmap would look like this -
   * 
   * <pre>
   *           index     words
   *      c     0
   *      a     1
   *      t     2
   *      s     3        cat
   *      a     4        cats
   *      n     5
   *      d     6
   *      d     7        and, sand
   *      o     8
   *      g     9
   *            10       dog
   * 
   * </pre>
   * 
   * Once this hashmap representation is created, do a DFS like traversal starting from the last
   * element (dog in this case).
   * 
   * @param input
   * @param dictionary
   * @return
   */
  private static List<String> wordBreak(String input, Set<String> dictionary) {
    Map<Integer, ArrayList<String>> dp = new HashMap<Integer, ArrayList<String>>();
    dp.put(0, new ArrayList<String>());

    for (int i = 1; i < input.length() + 1; i++)
      dp.put(i, null);

    for (int i = 0; i < input.length(); i++) {
      if (dp.get(i) == null)
        continue;

      for (String dictionaryWord : dictionary) {
        int wordLength = dictionaryWord.length();
        int end = i + wordLength;
        if (end > input.length())
          continue;
        if (input.substring(i, end).equals(dictionaryWord)) {
          if (dp.get(end) == null) {
            dp.put(end, new ArrayList<String>());
          }
          dp.get(end).add(dictionaryWord);
        }
      }
    }

    List<String> result = new ArrayList<String>();
    if (dp.get(input.length()) == null)
      return result;

    ArrayList<String> temp = new ArrayList<String>();
    dfs(dp, input.length(), result, temp);

    return result;
  }

  private static void dfs(Map<Integer, ArrayList<String>> dp, int end, List<String> result,
      ArrayList<String> temp) {
    if (end <= 0) {
      // when end is 0, you have all the combinations in temp list. Create space separated string
      // out of those list elements and space separated string in result.
      String path = temp.get(temp.size() - 1);
      for (int i = temp.size() - 2; i >= 0; i--) {
        path = path + " " + temp.get(i);
      }
      result.add(path);
      return;
    }

    // Read values at key 'end', temporarily save it in temp list and recursively call dfs with
    // updated temp list. Then delete the added element from temp in reverse order. While
    // recursively calling dfs, make sure end is updated, i.e. subtract length of the current string
    // from end.
    for (String str : dp.get(end)) {
      temp.add(str);
      dfs(dp, end - str.length(), result, temp);
      temp.remove(temp.size() - 1);
    }
  }
}
