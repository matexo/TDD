package com.matrix;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

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
        delta = Double.MIN_VALUE * Math.pow(10, 3);
        jednostkowa = new Matrix(3, 3);
        zerowa = new Matrix(3, 3);
        zwyklaKwadratowa = new Matrix(3, 3);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                if (i == j)
                    jednostkowa.set(i, j, 1);
                else
                    jednostkowa.set(i, j, 0);
                zerowa.set(i, j, 0);
            }
        zwyklaKwadratowa.set(0, 0, 6);
        zwyklaKwadratowa.set(0, 1, 3);
        zwyklaKwadratowa.set(0, 2, 6);
        zwyklaKwadratowa.set(1, 0, 2);
        zwyklaKwadratowa.set(1, 1, 3);
        zwyklaKwadratowa.set(1, 2, 5);
        zwyklaKwadratowa.set(2, 0, -1);
        zwyklaKwadratowa.set(2, 1, 2);
        zwyklaKwadratowa.set(2, 2, 4);
    }

    @Test(expected = ArithmeticException.class)
    public void isMatrixSquareAdd()
    {
        Matrix a = new Matrix(1 , 2);
        Matrix b = new Matrix(2 , 1);
        Matrix c = a.add(b);
    }

    @Test
    public void adding2Matrix()
    {
        Matrix c = jednostkowa.add(jednostkowa);
        double expected[] = {  2.0 , 0.0 , 0.0 ,
                               0.0 , 2.0 , 0.0 ,
                               0.0 , 0.0 , 2.0  };

        for(int i = 0 ; i < jednostkowa.getCols() ; i++)
            for(int j = 0 ; j < jednostkowa.getRows() ; j++)
                Assert.assertEquals(expected[i*3 + j] , c.get(i , j) , delta);

    }

    @Test(expected = ArithmeticException.class)
    public void isMatrixSquareSub()
    {
        Matrix a = new Matrix(1 , 2);
        Matrix b = new Matrix(2 , 1);
        Matrix c = a.subtract(b);
    }

    @Test
    public void subtract2Matrix()
    {
        Matrix c = jednostkowa.subtract(jednostkowa);
        double expected[] = {  0.0 , 0.0 , 0.0 ,
                                0.0 , 0.0 , 0.0 ,
                                0.0 , 0.0 , 0.0  };

        for(int i = 0 ; i < jednostkowa.getCols() ; i++)
            for(int j = 0 ; j < jednostkowa.getRows() ; j++)
                Assert.assertEquals(expected[i*3 + j] , c.get(i , j) , delta);

    }



    @Test
    public void testMultiply() throws Exception {
        Matrix result = new Matrix(3,3);
        result.set(0,0,36);
        result.set(0,1,39);
        result.set(0,2,75);
        result.set(1,0,13);
        result.set(1,1,25);
        result.set(1,2,47);
        result.set(2,0,-6);
        result.set(2,1,11);
        result.set(2,2,20);



        Matrix r = new Matrix(3,3);
        assertEquals(zwyklaKwadratowa.getCols(), zwyklaKwadratowa.getRows());
        r = zwyklaKwadratowa.multiply(zwyklaKwadratowa);
        assertTrue(result.equals(r));
    }


    @Test
    public void testUnitMatrixInversion() throws Exception {
/* test na macierzy jednostkowej
* wynikowa macierz to macierz jednostkowa o tych samych wymiarach */
        Matrix wynik = jednostkowa.inversion();
        for (int i = 0; i < jednostkowa.getRows(); i++)
            for (int j = 0; j < jednostkowa.getCols(); j++)
                Assert.assertEquals(jednostkowa.get(i,j), wynik.get(i,j), delta);
    }

    @Test
    public void testTransposition() throws Exception {

        Matrix m = new Matrix(3,3);
        for(int i = 0 ; i < 3 ; i++)
            for(int j = 0 ; j < 3 ; j++)
                m.set(i , j , i*3 + j);

        double expected[] = {   0.0 , 3.0 , 6.0 ,
                                1.0 , 4.0 , 7.0 ,
                                2.0 , 5.0 , 8.0  };

        m.transposition();

        for(int i = 0 ; i < m.getCols() ; i++)
            for(int j = 0 ; j < m.getRows() ; j++)
                Assert.assertEquals(expected[i*3 + j] , m.get(i , j) , delta);
    }
}