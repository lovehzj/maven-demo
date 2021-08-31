package com.github.shoothzj.demo;

import com.jerolba.jmnemohistosyne.HistogramEntry;
import com.jerolba.jmnemohistosyne.Histogramer;
import com.jerolba.jmnemohistosyne.MemoryHistogram;
import lombok.extern.slf4j.Slf4j;

/**
 * @author hezhangjian
 */
@Slf4j
public class ClassHistoPrint {

    public static void main(String[] args) {
        Histogramer histogramer = new Histogramer();
        MemoryHistogram histogram = histogramer.createHistogram();

        HistogramEntry arrayList = histogram.get("java.util.ArrayList");
        System.out.println(arrayList.getInstances());
        System.out.println(arrayList.getSize());

        for (HistogramEntry entry : histogram) {
            System.out.println(entry);
        }
    }

}
