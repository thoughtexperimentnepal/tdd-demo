package com.example.tdddemo.sum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class LogicalSumTest {

    LogicalSum logicalSum = new LogicalSum();

    @Test
    public void firt0Test(){
        int a = 5, b = 4;
        int actual = logicalSum.logcialSum(a,b);

        Assert.assertEquals(1, actual);
    }

    @Test
    public void firt1Test(){
        int a = 4, b = -5;
        int actual = logicalSum.logcialSum(a,b);

        Assert.assertEquals(-9, actual);
    }

    @Test
    public void second0Test(){
        int a = 3, b = -5;
        int actual = logicalSum.logcialSum(a,b);

        Assert.assertEquals(-8, actual);
    }

    @Test
    public void second1Test(){
        int a = 3, b = -4;
        int actual = logicalSum.logcialSum(a,b);

        Assert.assertEquals(-1, actual);
    }

    @Test
    public void third0Test(){
        int a = 3, b = 3;
        int actual = logicalSum.logcialSum(a,b);

        Assert.assertEquals(6, actual);
    }
}