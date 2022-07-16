/**
 * @author 志昊的刘
 * @date 2022/6/23
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC hook = null;


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("FinalizeEscapeGC.finalize");
        hook = this;
    }

    public static void main(String[] args) throws InterruptedException {
        hook = new FinalizeEscapeGC();

        hook = null;
        System.gc();
        Thread.sleep(1000);
        if (hook == null) {
            System.out.println("die");
        } else {
            System.out.println("alive");
        }


        hook = null;
        System.gc();
        Thread.sleep(1000);
        if (hook == null) {
            System.out.println("die");
        } else {
            System.out.println("alive");
        }

    }
}
