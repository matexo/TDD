package com.matrix;

/**
 * Created by Matexo on 2015-12-09.
 */
public class Matrix implements MatrixOperations {
    private double[][] data;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public double get(int i, int j) {
        return 0;
    }

    public void set(int i, int j, double val) {

    }

    public Matrix add(Matrix m) {
        return null;
    }

    public Matrix subtract(Matrix m) {
        return null;
    }

    public Matrix multiply(Matrix m) {
        return null;
    }

    public Matrix inversion() {
        return null;
    }

    public Matrix transposition() {
        return null;
    }
}
