package main;

/**
 * Solution of the coding challenge. The solution tries to avoid as duplicate code as possible and
 * tries to keep the code maintainable. The actual APIs were given in C++ but I have used Java as my
 * preferable programming language. Since java does not support pass by reference, I have removed
 * 'index' parameter to method search(). Instead the method now returns Result, which wraps the
 * SearchResult and index in the array.
 * 
 * @author onkar.deshpande@gmail.com (Onkar Deshpande)
 *
 */
public class Solution {
  public static class Result {
    public SearchResult searchResult;
    public int index;

    public Result() {}
  }

  public Result search(int[] items, int nItems, int ascending, int key, SearchType type) {
    Result r = new Result();
    switch (type) {
      case Equals:
        r = handleEquals(items, nItems, key);
        break;
      case GreaterThan:
        r = handleGreaterThan(items, nItems, key, ascending);
        break;
      case GreaterThanEquals:
      case LessThanEquals:
        r = handleGreaterLessEquals(items, nItems, key, ascending, type);
        break;
      case LessThan:
        r = handleLessThan(items, nItems, key, ascending);
        break;
      default:
        throw new IllegalArgumentException("Wrong SearchType");
    }
    return r;
  }

  private Result handleEquals(int[] items, int nItems, int key) {
    Result result = new Result();
    int i;
    for (i = 0; i < nItems; i++) {
      if (items[i] == key)
        break;
    }
    if (i == nItems)
      setSearchResult(result, SearchResult.NotFound, -1);
    else
      setSearchResult(result, SearchResult.FoundExact, i);
    return result;
  }

  private Result handleGreaterThan(int[] items, int nItems, int key, int ascending) {
    Result result = new Result();
    switch (ascending) {
      case 0:
        calculate1(Operator.GREATER, nItems, key, items, result, SearchResult.FoundGreater);
        break;
      default:
        calculate2(Operator.GREATER, nItems, key, items, result, SearchResult.FoundGreater);
    }
    return result;
  }

  private Result handleLessThan(int[] items, int nItems, int key, int ascending) {
    Result result = new Result();
    switch (ascending) {
      case 0:
        calculate2(Operator.LESSER, nItems, key, items, result, SearchResult.FoundLess);
        break;
      default:
        calculate1(Operator.LESSER, nItems, key, items, result, SearchResult.FoundLess);
    }
    return result;
  }

  private void setSearchResult(Result result, SearchResult searchResult, int index) {
    result.searchResult = searchResult;
    result.index = index;
  }

  private Result handleGreaterLessEquals(int[] items, int nItems, int key, int ascending,
      SearchType type) {
    Result r = handleEquals(items, nItems, key);
    if (r.searchResult == SearchResult.FoundExact) {
      return r;
    } else if (type == SearchType.GreaterThanEquals) {
      r = handleGreaterThan(items, nItems, key, ascending);
    } else if (type == SearchType.LessThanEquals) {
      r = handleLessThan(items, nItems, key, ascending);
    }
    return r;
  }

  public void calculate1(Operator op, int nItems, int key, int[] items, Result result,
      SearchResult sr) {
    int i = 0;
    for (i = nItems - 1; i >= 0; i--) {
      if (op.apply(items[i], key))
        break;
    }
    if (i == -1)
      setSearchResult(result, SearchResult.NotFound, -1);
    else
      setSearchResult(result, sr, i);
  }

  public void calculate2(Operator op, int nItems, int key, int[] items, Result result,
      SearchResult sr) {
    int i;
    for (i = 0; i < nItems; i++) {
      if (op.apply(items[i], key))
        break;
    }
    if (i == nItems)
      setSearchResult(result, SearchResult.NotFound, -1);
    else
      setSearchResult(result, sr, i);
  }
}
