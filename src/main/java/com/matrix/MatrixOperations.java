package com.matrix;

/**
 * Created by Matexo on 2015-12-09.
 */
public interface MatrixOperations {

    double get(int i, int j);
    void set(int i, int j, double val);
    Matrix add(Matrix m);
    Matrix subtract(Matrix m);
    Matrix multiply(Matrix m);
    Matrix inversion();
    void transposition();

}
