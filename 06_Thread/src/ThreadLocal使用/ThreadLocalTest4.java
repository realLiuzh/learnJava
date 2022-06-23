package ThreadLocal使用;

/**
 * @author 志昊的刘
 * @date 2022/6/22
 */
public class ThreadLocalTest4 {
    private static final ThreadLocal threadSession=new ThreadLocal();

//    public static Session getSession() throws Exception{
//        Session s=(Session)threadSession.get();
//        if(s==null){
//            s=getSessionFactory().openSession();
//            threadSession.set(s);
//        }
//        return s;
//    }




}
