package com.github.shoothzj.demo.basic;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author hezhangjian
 */
@Slf4j
public class FileTest {

    @Test
    public void fileTest() throws Exception {
        final File file = new File("/Users/akka/aaa.log");
        file.setReadable(true, true);
        file.setWritable(true, true);
        FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
    }

}
