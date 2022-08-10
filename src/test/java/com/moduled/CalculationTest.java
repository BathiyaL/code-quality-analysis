package com.moduled;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class CalculationTest {

  @Test
  public void cubeTest() {
	  System.out.println("test case cube");  
      assertEquals(27,Calculation.cube(3));
  }

  @Test
  public void reverseWordTest() {
	  System.out.println("test case reverse word");  
      assertEquals("ym eman si mas ",Calculation.reverseWord("my name is sam"));  
  }
}
