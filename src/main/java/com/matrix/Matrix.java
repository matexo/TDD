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
        return operation(m , true);
    }

    public Matrix subtract(Matrix m) {
        isSquare(m.getRows() , m.getCols());
        return operation(m , false);
    }

    public Matrix multiply(Matrix m) {
            if (cols != m.getRows()) {
                throw new RuntimeException("Niewłaściwe wymiary macierzy");
            }
            Matrix C = new Matrix(rows, m.getCols());
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < m.getCols(); j++) {
                    for (int k = 0; k < cols; k++) {
                        C.data[i][j] += data[i][k] * m.data[k][j];
                    }
                }
            }
            return C;
        }


    public Matrix inversion() {
        if (rows != cols) throw new ArithmeticException("Macierz nie jest kwadratowa");
        int n = rows;
        Matrix inverted = new Matrix(n,n);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++)
                if (i != k)
                    inverted.set(i, k, (get(i, k) / get(k, k)));
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (i != k && j != k)
                        inverted.set(i,j,(get(i,j) - get(i,k) * get(k,j)));
            for (int j = 0; j < n; j++)
                if (j != k)
                    inverted.set(k,j,(-get(k,j)/get(k,k)));
            inverted.set(k,k,(1/get(k,k)));
        }
        return inverted;
    }

    public void transposition() {
    for(int i = 1 ; i < this.cols ; i++)
        for( int j = i ; j < this.rows ; j++)
            {
            swap(i,j);
            }

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

    private void swap( int row  , int col )
    {
        double temp = this.data[row][col];
        this.data[row][col] = this.data[col][row];
        this.data[col][row] = temp;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matrix other = (Matrix) obj;
        if (!Arrays.deepEquals(this.data, other.data)) {
            return false;
        }
        if (this.rows != other.rows) {
            return false;
        }
        if (this.cols != other.cols) {
            return false;
        }

        return true;
    }
}
