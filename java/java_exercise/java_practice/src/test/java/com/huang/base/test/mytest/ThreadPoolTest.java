package com.huang.base.test.mytest;

import com.huang.thread.study.runnable.PrintRunnable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/21 11:07
 * @Description: 还不知道干嘛。
 * <p>
 * .::::.
 * .::::::::.
 * :::::::::::
 * ..:::::::::::'
 * '::::::::::::'
 * .::::::::::
 * '::::::::::::::..
 * ..::::::::::::.
 * ``::::::::::::::::
 * ::::``:::::::::'        .:::.
 * ::::'   ':::::'       .::::::::.
 * .::::'      ::::     .:::::::'::::.
 * .:::'       :::::  .:::::::::' ':::::.
 * .::'        :::::.:::::::::'      ':::::.
 * .::'         ::::::::::::::'         ``::::.
 * ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 * '.:::::'                    ':'````..
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/applicationContext.xml")
public class ThreadPoolTest
{
    public static final Logger LOG = LoggerFactory.getLogger(ThreadPoolTest.class);
    @Resource(name = "taskExecutor")
    private  ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void test1()
    {
//      ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);


        cachedThreadPool.execute(new Runnable()
        {
            @Override
            public void run()
            {
                LOG.info("fffffffffff");
            }
        });

    }

    @Test
    public void test2()
    {
        Runnable run = new PrintRunnable();
        threadPoolTaskExecutor.execute(run);
    }

    @Test
    public void test3()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(15);
        executor.setKeepAliveSeconds(1);
        executor.setQueueCapacity(5);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        executor.execute(new Runnable()
        {
            @Override
            public void run()
            {
                LOG.info("hahahahahah");
            }
        });


    }

}
