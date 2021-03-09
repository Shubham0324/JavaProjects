package com.company.patterns;

public class Pattern5 {
    public static void main(String[] args) {

        for (int i = 1, k = 0; i <= 5; ++i) {
            for (int j = 1; j <=5-i; ++j) {
                System.out.print(' ');
            }
            while (k != 2 * i - 1){
                System.out.print("*");
                ++k;
                System.out.println();
            }
            System.out.println();
        }
    }
}
/*
Doesn't it looks like a dancing man :XD

    *

   *
*

  *
*

 *
*

*
*

 */