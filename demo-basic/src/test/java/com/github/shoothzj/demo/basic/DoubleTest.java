package com.github.shoothzj.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author hezhangjian
 */
@Slf4j
public class DoubleTest {

    @Test
    public void divideZero() {
        double x = 1;
        double y = 0;
        System.out.println(x / y);

    }

    @Test
    public void zeroDivide() {
        double x = 0;
        double y = 1;
        System.out.println(x / y);
    }

    @Test
    public void compareTestCase1() {
        Assert.assertTrue(compareDoublePrecision("1.7976931348623157E308", "1.7976931348623157E+308"));
    }

    private boolean compareDoublePrecision(String convert, String origin) {
        final char[] charArray = convert.toCharArray();
        final char[] originArray = origin.toCharArray();
        if (charArray.length > originArray.length) {
            return false;
        }
        int j = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] < '0' || charArray[i] > '9') {
                if (originArray[j] >= '0' && originArray[j] <= '9') {
                    return false;
                } else {
                    j++;
                    if (originArray[j] == '+') {
                        j++;
                    }
                    continue;
                }
            }
            if (charArray[i] != originArray[j]) {
                return false;
            }
            j++;
        }
        return j == originArray.length;
    }

}
