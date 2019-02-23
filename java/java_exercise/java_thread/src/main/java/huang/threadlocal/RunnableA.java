package huang.threadlocal;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/22 21:26
 * @Description:
 */
public class RunnableA implements  Runnable
{

    private Bank bank;

    @Override
    public void run()
    {
        bank.increment();
    }
}
