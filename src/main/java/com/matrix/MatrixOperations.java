package com.matrix;

/**
 * Created by Matexo on 2015-12-09.
 */
public interface MatrixOperations {

    public Matrix add(Matrix m);
    public Matrix subtract(Matrix m);
    public Matrix multiply(Matrix m);
    public Matrix inversion();
    public Matrix transposition();

}
