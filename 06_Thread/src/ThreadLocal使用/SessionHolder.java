package ThreadLocal使用;

/**
 * 使用ThreadLocal进行跨函数的数据传递
 * @author 志昊的刘
 * @date 2022/6/23
 */
public class SessionHolder {
    // session id
    private static final ThreadLocal<String> sidLocal=ThreadLocal.withInitial(()->"sidLocal");

//    private static final ThreadLocal<UserDTO> sessionUserLocal=ThreadLocal.withInitial(()->"sessionUserLocal");

}
