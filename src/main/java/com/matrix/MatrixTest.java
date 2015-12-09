package com.matrix;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * MatrixTDD
 * Created by Piotrek on 09-12-2015.
 */
public class MatrixTest {
    private Matrix jednostkowa;
    private Matrix zerowa;
    private Matrix zwyklaKwadratowa;
    private double delta;

    @Before
    public void setUp() throws Exception {
        /* delta do porównywania
        * przykładowa, jeśli ktoś chce to niech ją zmieni */
        delta = Double.MIN_VALUE * Math.pow(10,3);
        jednostkowa = new Matrix(3,3);
        zerowa = new Matrix(3,3);
        zwyklaKwadratowa = new Matrix(3,3);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    jednostkowa.set(i,j,1);
                else
                    jednostkowa.set(i,j,0);
                zerowa.set(i,j,0);
            }
        zwyklaKwadratowa.set(0,0,6);
        zwyklaKwadratowa.set(0,1,3);
        zwyklaKwadratowa.set(0,2,6);
        zwyklaKwadratowa.set(1,0,2);
        zwyklaKwadratowa.set(1,1,3);
        zwyklaKwadratowa.set(1,2,5);
        zwyklaKwadratowa.set(2,0,-1);
        zwyklaKwadratowa.set(2,1,2);
        zwyklaKwadratowa.set(2,2,4);
    }

    @Test
    public void testAdd() throws Exception {

    }

    @Test
    public void testSubtract() throws Exception {

    }

    @Test
    public void testMultiply() throws Exception {

    }

    @Test
    public void testInversion() throws Exception {
        
    }

    @Test
    public void testTransposition() throws Exception {

    }
}