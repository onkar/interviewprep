package test;

import main.ExcelColumnName;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcelColumnNameTest {
  private ExcelColumnName e;

  @Before
  public void setup() {
    e = new ExcelColumnName();
  }

  @Test
  public void testExcelColumn() {
    Assert.assertEquals("ZX", e.getExcelCol(700));
    Assert.assertEquals("Z", e.getExcelCol(26));
    Assert.assertEquals("AY", e.getExcelCol(51));
    Assert.assertEquals("AZ", e.getExcelCol(52));
    Assert.assertEquals("AAC", e.getExcelCol(705));
  }
}
