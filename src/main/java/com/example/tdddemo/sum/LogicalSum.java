package com.example.tdddemo.sum;

public class LogicalSum {

    public int logcialSum(int a , int b){
        if( a > 4) {
            return a - b;
        } else if (b < -4){
            return b - a;
        }else {
            return a + b;
        }
    }
}
