package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import main.HeapSort;
import main.InsertionSort;
import main.MergeSort;
import main.QuickSort;
import main.SelectionSort;

import org.junit.Before;
import org.junit.Test;

public class SortingTest {
  private int[] numbers;
  private static int Size = 7;
  private static int Limit = 20;
  
  @Before
  public void setup() throws Exception {
    numbers = new int[Size];
    Random generator = new Random();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = generator.nextInt(Limit);
    }
  }

  @Test
  public void testInsertionSort() throws Exception {
    InsertionSort is = new InsertionSort(numbers, Size);
    is.sort();
    testSorting();
  }

  private void testSorting() {
    for (int i = 0; i < numbers.length - 1; i++) {
      if (numbers[i] > numbers[i + 1]) {
        fail("Array is not sorted...");
      }
    }
    assertTrue(true);
  }

  @Test
  public void testSelectionSort() throws Exception {
    SelectionSort ss = new SelectionSort(numbers, Size);
    ss.sort();
    testSorting();
  }

  @Test
  public void testMergeSort() throws Exception {
    MergeSort ms = new MergeSort();
    ms.sort(numbers);
    testSorting();
  }

  @Test
  public void testHeapSort() throws Exception {
    HeapSort hs = new HeapSort(numbers, Size);
    hs.sort();
    testSorting();
  }

  @Test
  public void testQuickSort() throws Exception {
    QuickSort qs = new QuickSort(numbers);
    qs.sort(0, Size - 1);
    testSorting();
  }
}
