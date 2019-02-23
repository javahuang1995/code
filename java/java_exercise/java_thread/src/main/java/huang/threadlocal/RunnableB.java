package huang.threadlocal;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/22 21:58
 * @Description:
 */
public class RunnableB implements Runnable
{
    public AtomicInteger getCount()
    {
        return count;
    }

    public void setCount(AtomicInteger count)
    {
        this.count = count;
    }

    private AtomicInteger count = new AtomicInteger(0);


    @Override
    public void run()
    {
        while( count.get() < 100)
        {
            count.getAndIncrement();
            System.out.println(count.get());
        }

        synchronized (this){
            notify();
        }



    }
}
