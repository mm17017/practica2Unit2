/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi.calc2.practica2tpi;

import junit.framework.TestCase;

/**
 *
 * @author cmargueiz
 */
public class PackageTest extends TestCase {

    public PackageTest(String testName) {
        super(testName);
    }

    /**
     * * Test of getVolume method, of class Package.
     */
    public void testGetVolume() {
        System.out.println("getVolume");
        Package instance = new Package(1.0);
        double expResult = 1.0;
        double result = instance.getVolume();
        assertEquals(expResult, result);
    }

}
