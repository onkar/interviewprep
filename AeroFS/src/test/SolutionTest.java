package test;

import main.SearchResult;
import main.SearchType;
import main.Solution;
import main.Solution.Result;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
  @Test
  public void testAscending() {
    int[] array = {0, 2, 4, 6, 8};
    Solution sol = new Solution();

    Result r = sol.search(array, array.length, 1, -1, SearchType.LessThanEquals);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 1, 0, SearchType.LessThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 1, 0, SearchType.Equals);
    Assert.assertEquals(SearchResult.FoundExact, r.searchResult);
    Assert.assertEquals(0, r.index);

    r = sol.search(array, array.length, 1, 1, SearchType.Equals);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 1, 2, SearchType.GreaterThanEquals);
    Assert.assertEquals(SearchResult.FoundExact, r.searchResult);
    Assert.assertEquals(1, r.index);

    r = sol.search(array, array.length, 1, 2, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.FoundGreater, r.searchResult);
    Assert.assertEquals(2, r.index);

    r = sol.search(array, array.length, 1, 10, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 1, -1, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.FoundGreater, r.searchResult);
    Assert.assertEquals(0, r.index);

    r = sol.search(array, array.length, 1, 10, SearchType.LessThan);
    Assert.assertEquals(SearchResult.FoundLess, r.searchResult);
    Assert.assertEquals(4, r.index);
  }

  @Test
  public void testDescending() {
    int[] array = {8, 6, 4, 2, 0};
    Solution sol = new Solution();

    Result r = sol.search(array, array.length, 0, -1, SearchType.LessThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 0, 0, SearchType.LessThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 0, 4, SearchType.LessThanEquals);
    Assert.assertEquals(SearchResult.FoundExact, r.searchResult);
    Assert.assertEquals(2, r.index);

    r = sol.search(array, array.length, 0, 8, SearchType.Equals);
    Assert.assertEquals(SearchResult.FoundExact, r.searchResult);
    Assert.assertEquals(0, r.index);

    r = sol.search(array, array.length, 0, 5, SearchType.GreaterThanEquals);
    Assert.assertEquals(SearchResult.FoundGreater, r.searchResult);
    Assert.assertEquals(1, r.index);

    r = sol.search(array, array.length, 0, 2, SearchType.GreaterThanEquals);
    Assert.assertEquals(SearchResult.FoundExact, r.searchResult);
    Assert.assertEquals(3, r.index);

    r = sol.search(array, array.length, 0, 8, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 0, 9, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 0, 6, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.FoundGreater, r.searchResult);
    Assert.assertEquals(0, r.index);

    r = sol.search(array, array.length, 0, 5, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.FoundGreater, r.searchResult);
    Assert.assertEquals(1, r.index);

    r = sol.search(array, array.length, 0, 10, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.NotFound, r.searchResult);
    Assert.assertEquals(-1, r.index);

    r = sol.search(array, array.length, 0, -1, SearchType.GreaterThan);
    Assert.assertEquals(SearchResult.FoundGreater, r.searchResult);
    Assert.assertEquals(4, r.index);
  }

}
