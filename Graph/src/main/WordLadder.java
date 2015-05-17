package main;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation
 * sequence from start to end, such that only one letter can be changed at a time and each
 * intermediate word must exist in the dictionary. For example, given:
 * 
 * start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] One shortest transformation is
 * "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence. All words have the same length. All
 * words contain only lowercase alphabetic characters.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class WordLadder {
  public int getLength(String start, String end, Set<String> dictionary) {
    if (dictionary.isEmpty())
      return 0;
    dictionary.add(end);
    Queue<String> wordQueue = new LinkedList<String>();
    Queue<Integer> distanceQueue = new LinkedList<Integer>();
    wordQueue.add(start);
    distanceQueue.add(1);

    int result = Integer.MAX_VALUE;

    while (!wordQueue.isEmpty()) {
      String currentWord = wordQueue.poll();
      int currentDistance = distanceQueue.poll();

      if (currentWord.equals(end)) {
        result = Math.min(result, currentDistance);
      }

      for (int i = 0; i < currentWord.length(); i++) {
        char[] array = currentWord.toCharArray();
        for (char c = 'a'; c <= 'z'; c++) {
          array[i] = c;
          String newWord = new String(array);
          if (dictionary.contains(newWord)) {
            wordQueue.add(newWord);
            distanceQueue.add(currentDistance + 1);
            dictionary.remove(newWord);
          }
        }
      }
    }

    if (result < Integer.MAX_VALUE)
      return result;
    else
      return 0;
  }
}
