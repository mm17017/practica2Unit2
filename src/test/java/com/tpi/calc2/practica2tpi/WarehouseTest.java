/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi.calc2.practica2tpi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import junit.framework.TestCase;

/**
 *
 * @author edwin
 */
public class WarehouseTest extends TestCase {
    
    private Warehouse warehouse = null;
    private int num_Packages_To_Test = 5;
    private int warehouse_Volume = num_Packages_To_Test - 1;
    private Package[] b = null;
    private double package_unit_volume = 10.0;
    
    protected void setup() throws Exception {
        assertTrue("Test case error, you must test at least I Package",num_Packages_To_Test>0);
        assertTrue( "This test case is set up assuming that the Warehouse cannot contain all the Packages, please check and change parameters" , num_Packages_To_Test>warehouse_Volume);
        
        double Warehouse_capacity = 0;
        
            // We create the Packages that we need.
            b = new Package[num_Packages_To_Test];
            for (int i = 0; i<num_Packages_To_Test;i++) {
                if (i<warehouse_Volume){
                    Warehouse_capacity+=(i+1)*package_unit_volume;
                }
                b[i]= new Package((i+1)*package_unit_volume);
            }
            //Now, we create the Warehouse once we figure out how big a warehouse we
            //need.
            warehouse = new Warehouse(Warehouse_capacity);
    }

    /**
     * Test of add method, of class Warehouse.
     */
    public void testAdd() {
        warehouse.clear();
        for(int i=0; i<warehouse_Volume; i++){
            assertTrue("warehouse.add(Package) failed to add a new Package!",warehouse.add(b[i]));
            assertFalse("warehouse.add(Package) seems to allow the same Package to be added twice!", warehouse.add(b[i]));
            assertTrue("warehouse does not contain a package after it is supposed to have been added!",warehouse.contains(b[i]));
        }
        for (int i=warehouse_Volume;i<num_Packages_To_Test;i++){
            assertFalse("warehouse.add(Package) allows a package to be added even though it is already full",warehouse.add(b[i]));
        }
    }

    /**
     * Test of getPackages method, of class Warehouse.
     */
    public void testGetPackages() {
        Random rnd = new Random();
        
        warehouse.clear();
        
        //wE PUT ALL THE PACKAGES INto a list
        LinkedList<Package> list = new LinkedList<Package>();
        for( int i=0;i<warehouse_Volume;i++){
            list.add(b[i]);
        }
        //Firts we add the package to the waerehouse in some random order
        for(int i=0; i<warehouse_Volume;i++){
            warehouse.add(list.remove(rnd.nextInt(list.size())));
        }
        //nest we call he iterator and check that the packages come out in the correct order
        Iterator<Package> it = warehouse.getPackages();
        int count = 0;
        while (it.hasNext() && count < warehouse_Volume){
            Package Package = it.next();
            assertTrue("Packages are not returned by warehouse.getpackages() iterator in hte correct order", b[count]== Package);
            if (b[count]!=Package){
                break;
            }
            count++;
        }
        assertEquals("warehouse.getPackages() did not return all the Packages", warehouse_Volume, count);
    }
    
}
