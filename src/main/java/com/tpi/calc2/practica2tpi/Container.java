/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tpi.calc2.practica2tpi;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author cmargueiz
 */
public class Container {

    List<Package> contents;

    public Container() {
        contents = new LinkedList<Package>();
    }

    public boolean add(Package b) {
        return !contents.contains(b) && contents.add(b);
    }

    public boolean remove(Package b) {
        return contents.remove(b);
    }

    public double getVolume() {
        int sum = 0;
        for (Package b : contents) {
            sum += b.getVolume();
        }
        return sum;
    }

    public int size() {
        return contents.size();
    }

    public void clear() {
        contents.clear();
    }

    public boolean contains(Package b) {
        return contents.contains(b);
    }
}
