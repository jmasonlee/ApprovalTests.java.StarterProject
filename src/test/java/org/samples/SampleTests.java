package org.samples;


import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SampleTests
{
  @Test
  public void testNormalJunit()
  {
    assertEquals(5, 5);
  }

  @Test
  public void testACellWithOneNeighborsIsDoomed() {
    Cell cell = new Cell();
    cell.addNeighbor(new Cell());
    assertTrue(cell.amIDoomed());
  }

  @Test
  public void testACellWithTwoNeighborsGetsToLiveAnotherDay() {
    Cell cell = new Cell();
    cell.addNeighbor(new Cell());
    cell.addNeighbor(new Cell());
    assertFalse(cell.amIDoomed());
  }

  @Test
  public void testACellWithThreeNeighborsAlsoGetsToLiveAnotherDay() {
    Cell cell = new Cell();
    cell.addNeighbor(new Cell());
    cell.addNeighbor(new Cell());
    cell.addNeighbor(new Cell());
    assertFalse(cell.amIDoomed());
  }

  @Test
  public void testACellWithFourNeighborsIsRightOut() {
    Cell cell = new Cell();
    cell.addNeighbor(new Cell());
    cell.addNeighbor(new Cell());
    cell.addNeighbor(new Cell());
    cell.addNeighbor(new Cell());
    assertTrue(cell.amIDoomed());
  }

  /*
      .xx
      .?x
      ...  all three x's should respond true to amIAParent; AND everybody else responds false
   */
  @Test
  public void testParentScenarioOne() {
    Cell c1 = new Cell(); Cell c2 = new Cell(); Cell c3 = new Cell();
    Cell c4 = new Cell(); Cell c5 = new Cell(); Cell c6 = new Cell();
    Cell c7 = new Cell(); Cell c8 = new Cell(); Cell c9 = new Cell();
    c2.addNeighbor(c3); c3.addNeighbor(c2);
    c2.addNeighbor(c6); c6.addNeighbor(c2);
    c3.addNeighbor(c6); c6.addNeighbor(c3);
    assertTrue(c2.amIAParent());
    assertTrue(c3.amIAParent());
    assertTrue(c6.amIAParent());
  }

  /*
      .xx
      .?.
      .x.  all three x's should respond true to amIAParent; AND everybody else responds false
   */
  @Test
  public void testParentScenarioTwo() {
    Cell c1 = new Cell(); Cell c2 = new Cell(); Cell c3 = new Cell();
    Cell c4 = new Cell(); Cell c5 = new Cell(); Cell c6 = new Cell();
    Cell c7 = new Cell(); Cell c8 = new Cell(); Cell c9 = new Cell();
    c2.addNeighbor(c3); c3.addNeighbor(c2);
    c2.addCoparent(c8); c8.addCoparent(c2);
    c3.addNeighbor(c8); c8.addNeighbor(c3);
    assertTrue(c2.amIAParent());
    assertTrue(c3.amIAParent());
    assertTrue(c8.amIAParent());
  }
}
