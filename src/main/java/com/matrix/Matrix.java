package com.matrix;

import java.util.Arrays;

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
        return data[i][j];
    }

    public void set(int i, int j, double val) {
        data[i][j] = val;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Matrix add(Matrix m) {
        isSquare(m.getRows() , m.getCols());
        Matrix result = new Matrix(this.rows , this.cols );
        for(int i = 0 ; i < this.getCols() ; i++)
            for(int j = 0 ; j < this.getRows() ; j++)
                result.set(i , j , this.data[i][j] + m.get(i , j));
        return result;
    }

    public Matrix subtract(Matrix m) {
        isSquare(m.getRows() , m.getCols());
        Matrix result = new Matrix(this.rows , this.cols );
        for(int i = 0 ; i < this.getCols() ; i++)
            for(int j = 0 ; j < this.getRows() ; j++)
                result.set(i , j , this.data[i][j] - m.get(i , j));
        return result;
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

    @Override
    public String toString() {
        return "Matrix{" +
                "data=" + Arrays.toString(data) +
                ", rows=" + rows +
                ", cols=" + cols +
                '}';
    }

    private void isSquare(int rows , int cols) throws ArithmeticException
    {
        if(this.cols != cols || this.rows != rows) throw new ArithmeticException();
    }
}
