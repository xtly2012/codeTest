package com.warshall.test;

import java.util.ArrayList;
import java.util.List;

public class WarshallTest
{
    public static int[][] T = 
        {
            {0, 1, 0, 0},
            {0, 0, 0, 1},
            {0, 0, 0, 0},
            {1, 0, 1, 0}
        };
    
    public static int[][] S = 
        {
            {0, 45, 0, 0},
            {0, 0, 0, 100},
            {0, 0, 0, 0},
            {70, 0, 10, 0}
        };
    
    public static void main(String[] argus)
    {
        for (int k = 0; k < T.length; k++)
        {
            for (int i = 0; i < T[k].length; i++)
            {
                for (int j = 0; j < T.length; j++)
                {
                    if (T[k][i] == 1 && T[j][k] == 1)
                    {
                        T[j][i] = 1;
                        if (S[j][i] == 0)
                        {
                            S[j][i] = S[k][i] + S[j][k];
                        }
                        else if (S[j][i] > S[k][i] + S[j][k])
                        {
                            S[j][i] = S[k][i] + S[j][k];
                        }
                    }
                }
            }
        }
        
        System.out.println("T = ");
        for (int i = 0; i < T.length; i++)
        {
            for (int j = 0; j < T[i].length; j++)
            {
                System.out.print(" " + T[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("S = ");
        for (int i = 0; i < S.length; i++)
        {
            for (int j = 0; j < S[i].length; j++)
            {
                System.out.print(" " + S[i][j]);
            }
            System.out.println();
        }
        
    }
}
