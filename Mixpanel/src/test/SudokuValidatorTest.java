package test;

import main.SudokuValidator;

import org.junit.Assert;
import org.junit.Test;

public class SudokuValidatorTest {
  @Test
  public void test() {
    Assert
        .assertTrue(SudokuValidator
            .isValidSolution("835416927296857431417293658569134782123678549748529163652781394981345276374962815"));
    Assert
        .assertFalse(SudokuValidator
            .isValidSolution("885416927296857431417293658569134782123678549748529163652781394981345276374962815"));
    Assert.assertFalse(SudokuValidator.isValidSolution("hello"));
    Assert
        .assertFalse(SudokuValidator
            .isValidSolution("88541692729685743141729365856913478212367854974852916365278139498134527637496"));
    Assert.assertFalse(SudokuValidator.isValidSolution(null));
    Assert.assertFalse(SudokuValidator.isValidSolution(""));
    Assert.assertFalse(SudokuValidator.isValidSolution(Integer.toString(1)));
    Assert
        .assertFalse(SudokuValidator
            .isValidSolution("8354169272968574314172936585691347821236785497485291636527 1394981345276374962815"));
    Assert
        .assertFalse(SudokuValidator
            .isValidSolution("8354169272968574314172936585691347821236785497485291636527-1394981345276374962815"));
  }
}
