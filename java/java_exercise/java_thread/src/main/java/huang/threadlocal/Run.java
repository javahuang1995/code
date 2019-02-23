package huang.threadlocal;

import com.huang.threadpool.MyThreadPool;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/22 21:31
 * @Description:
 */
public class Run
{
    public static void main(String[] args)
    {
        RunnableB runnableB = new RunnableB();

        long start = System.currentTimeMillis();
        //给你开十个线程，够意思吧。
//        for (int i = 0; i < 10; i++)
//        {
//            MyThreadPool.getThreadPool().execute(runnableB);
//        }

        MyThreadPool.getThreadPool().execute(runnableB);

        while(runnableB.getCount().get() < 100){

            synchronized (runnableB){
                try
                {
                    runnableB.wait();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }

        }
        long end = System.currentTimeMillis();
        System.out.println("time is:"+(end-start));

    }
}
