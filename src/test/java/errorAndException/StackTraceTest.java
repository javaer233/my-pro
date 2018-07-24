package errorAndException;

/**
 * @Author kai
 * @Description 测试stackTrace，存储了堆栈的调用情况，可用于测试
 * @Create 2018-05-10 9:29
 **/
public class StackTraceTest {
    public static int getFactorial(Integer n){
        System.out.println("factorial(" + n + ")");
        Throwable throwable = new Throwable();
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            System.out.println(stackTrace[i]);
        }
        int r = 1;
        if (n <= 1) {
            r = 1;
        } else {
            r = n* getFactorial(n-1);
        }
        System.out.println("return " + r);
        return r;
    }

    public static void main(String[] args) {
        getFactorial(4);
    }
}
