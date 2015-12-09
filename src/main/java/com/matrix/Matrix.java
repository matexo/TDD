package com.matrix;

/**
 * Created by Matexo on 2015-12-09.
 */
public class Matrix implements MatrixOperations {

    private double[][] matrix;

    public Matrix(int x , int y)
    {
        matrix = new double [x][y];
    }

    public double getValue(int x , int y)
    {
        return matrix[x][y];
    }

    @Override
    public Matrix add(Matrix m) {
        return null;
    }

    @Override
    public Matrix subtract(Matrix m) {
        return null;
    }

    @Override
    public Matrix multiply(Matrix m) {
        return null;
    }

    @Override
    public Matrix inversion() {
        return null;
    }

    @Override
    public Matrix transposition() {
        return null;
    }
}
