package com.github.shoothzj.demo.pf.print;

import com.jerolba.jmnemohistosyne.HistogramEntry;
import com.jerolba.jmnemohistosyne.Histogramer;
import com.jerolba.jmnemohistosyne.MemoryHistogram;
import lombok.extern.slf4j.Slf4j;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * @author hezhangjian
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        printCpuUsage();
        printThreadDump();
        printClassHisto();
        printDeadLock();
    }

    private static void printDeadLock() {
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        final long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        for (long deadlockedThread : deadlockedThreads) {
            final ThreadInfo threadInfo = threadMXBean.getThreadInfo(deadlockedThread);
            System.out.println(threadInfo + "deadLocked");
        }
    }

    private static void printCpuUsage() {
        final com.sun.management.OperatingSystemMXBean platformMXBean = ManagementFactory.getPlatformMXBean(com.sun.management.OperatingSystemMXBean.class);
        double cpuLoad = platformMXBean.getProcessCpuLoad();
        System.out.println(cpuLoad);
    }

    private static void printThreadDump() {
        final StringBuilder dump = new StringBuilder();
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 100代表线程堆栈的层级
        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
        for (ThreadInfo threadInfo : threadInfos) {
            dump.append('"');
            dump.append(threadInfo.getThreadName());
            dump.append("\" ");
            final Thread.State state = threadInfo.getThreadState();
            dump.append("\n   java.lang.Thread.State: ");
            dump.append(state);
            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
            for (final StackTraceElement stackTraceElement : stackTraceElements) {
                dump.append("\n        at ");
                dump.append(stackTraceElement);
            }
            dump.append("\n\n");
        }
        System.out.println(dump);
    }

    private static void printClassHisto() {
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
