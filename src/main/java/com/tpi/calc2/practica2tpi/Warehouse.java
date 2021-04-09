/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi.calc2.practica2tpi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author cmargueiz
 */
public class Warehouse extends Container{
    
    private final double maxCapacity;
    
    public Warehouse(double capacity){
        maxCapacity = capacity;
    }
    
    @Override
    public boolean add(Package b){
        if (b.getvolume() + getvolume() <= maxCapacity){
            return super.add(b);
        }
        return false;
    }
    
    public Iterator<Package> getPackages(){
        List<Package> copyContents = new ArrayList<Package>(contents);
        Collections.sort(copyContents, new Comparator<Package>(){
           
            public int compare(Package b1, Package b2){
                //return (int)b1.getVolume() - (int)b2.getVolume();
                //return (int)(b1.getVolume() - b2.getVolume());
                if (b1.getVolume() < b2.getVolume()){
                    return -1;
                }else if(b1.getVolume() == b2.getVolume()){
                    return 0;
                }else{
                    return 1;
                }
            }
        });
        return copyContents.iterator;
    }
    
}
