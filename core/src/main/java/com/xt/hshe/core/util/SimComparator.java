package com.xt.hshe.core.util;

import com.xt.hshe.core.pojo.entity.Submission;

import java.math.BigInteger;
import java.util.Comparator;

public class SimComparator implements Comparator<Submission> {
    @Override
    public int compare(Submission o1, Submission o2) {
        BigInteger bi1 = new BigInteger(o1.getCreateTime());
        BigInteger bi2 = new BigInteger(o2.getCreateTime());
        return bi1.compareTo(bi2);
    }
}
