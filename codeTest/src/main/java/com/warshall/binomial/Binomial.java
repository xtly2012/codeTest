package com.warshall.binomial;

/**
 * 二项式求算
 * 1.c(n,k)=c(n-1,k-1)+c(n-1,k)
 * 2.c(n,0)=c(n,n)
 * @author Administrator
 *
 */
public class Binomial
{
    public static int getBinomial(int n,int k)
    {
        int sum =0;
        Matrix.matrix = new Matrix(n+1, k+1).getMatrix();
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=min(i,k);j++)
            {
                if(j==0 ||j==i)
                {
                    Matrix.matrix[i][j]=1;
                }else
                {
                    Matrix.matrix[i][j]=Matrix.matrix[i-1][j-1]+Matrix.matrix[i-1][j];
                }
                System.out.print(Matrix.matrix[i][j]+"("+i+","+j+")"+"\t");
            }
            System.out.println();
        }
        Matrix.matrix[n][k]=Matrix.matrix[n-1][k-1]+Matrix.matrix[n-1][k];
        System.out.println(Matrix.matrix[n][k]+"("+n+","+k+")");
//        for (int i = 0; i <Matrix.matrix.length; i++)
//        {
//            for (int j = 0; j <Matrix.matrix[i].length; j++)
//            {
//                sum=Matrix.matrix[i+1][j+1];
//                System.out.print(Matrix.matrix[i+1][j+1]+"\t");
//            }
//            System.out.println();
//        }
        return Matrix.matrix[n][k];
    }
    
    public static int min(int i,int k)
    {
        if(i<k)
        {
            return i;
        }else
        {
            return k;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println(getBinomial(10, 2));
    }
}
