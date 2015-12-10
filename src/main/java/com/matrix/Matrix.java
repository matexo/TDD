package com.matrix;

import java.util.Arrays;

/**
 * Created by Matexo on 2015-12-09.
 */
public class Matrix implements MatrixOperations {
    private double[][] data;
    private int rows;
    private int cols;
<<<<<<< HEAD

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

=======

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

>>>>>>> origin/master
    public int getCols() {
        return cols;
    }

    public Matrix add(Matrix m) {
        isSquare(m.getRows() , m.getCols());
        return operation(m , true);
    }

    public Matrix subtract(Matrix m) {
        isSquare(m.getRows() , m.getCols());
        return operation(m , false);
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

    private void isSquare(int rows , int cols) throws ArithmeticException
    {
        if(this.cols != cols || this.rows != rows) throw new ArithmeticException();
    }

    private Matrix operation(Matrix m , boolean isAdding)
    {
        Matrix result = new Matrix(this.rows , this.cols );
        for(int i = 0 ; i < this.getCols() ; i++)
            for(int j = 0 ; j < this.getRows() ; j++)
                if(isAdding == true) result.set(i , j , this.data[i][j] + m.get(i , j));
                else result.set(i , j , this.data[i][j] - m.get(i , j));
        return result;
    }

}
