package com.xt.hshe.core;

import com.xt.hshe.core.pojo.entity.Submission;
import com.xt.hshe.core.util.SimComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LenTest {
    public static void main(String[] args)  {
        Submission submission = new Submission();
        submission.setCreateTime("159789789789789");
        Submission submission1 = new Submission();
        submission1.setCreateTime("158789789789789");
        Submission submission2 = new Submission();
        submission2.setCreateTime("157789789789789");
        List<Submission> list = new ArrayList<>();
        list.add(submission);
        list.add(submission1);
        list.add(submission2);
        list.sort(new SimComparator());

        System.out.println();
    }
}
