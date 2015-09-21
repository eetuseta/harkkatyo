/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package harkkatyo;

import junit.framework.TestCase;

/**
 *
 * @author jaakk_000
 */
public class LevytTest extends TestCase {
    
    public LevytTest(String testName) {
        super(testName);
    }

    /**
     * Test of lue method, of class Levyt.
     */
    public void testLue() {
        System.out.println("lue");
        Levyt instance = new Levyt();
        boolean expResult = false;
        boolean result = instance.lue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
