package com.github.shoothzj.demo.netty;

import com.github.shoothzj.demo.netty.allocate.ByteBufAllocatorBuilder;
import com.github.shoothzj.demo.netty.allocate.PoolingPolicy;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.PooledByteBufAllocator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author hezhangjian
 */
@Slf4j
public class ByteBufScaleTest {

    @Test
    public void byteBufScale() throws Exception {
        ByteBufAllocatorBuilder builder = ByteBufAllocatorBuilder.create()
                .pooledAllocator(PooledByteBufAllocator.DEFAULT);

        builder.poolingPolicy(PoolingPolicy.UnpooledHeap);

        final ByteBufAllocator byteBufAllocator = builder.build();
        final ByteBuf byteBuf = byteBufAllocator.buffer(600);
        System.out.println(byteBuf);
    }

}
