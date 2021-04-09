/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiralabra.tietorakennevertailut.test;

import java.util.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oleg
 */
public class JUnitTest {
    
    List testList;
    
    public JUnitTest() {
        testList = new ArrayList<String>();
    }
    
    @Before
    public void setUp() {
        for(int i = 0; i < 10000; i++) testList.add(i);
    }
    
    @After
    public void tearDown() {
        testList = new ArrayList<String>();
    }

    @Test
    public void test1() {
        assertTrue(testList.indexOf(4444) == 4444);
    }
}
