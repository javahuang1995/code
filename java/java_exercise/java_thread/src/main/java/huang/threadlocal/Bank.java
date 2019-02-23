package huang.threadlocal;

/**
 * @Auther: 宁哥
 * @Date: 2019/2/22 21:49
 * @Description:
 */
public class Bank
{
    private ThreadLocal<Integer> count = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue()
        {
            return 10;
        }
    };

    public int get(){
        return count.get();
    }

    public void increment(){
        count.set(get()+10);
    }
}
