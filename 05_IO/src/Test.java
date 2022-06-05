class Test {
    //不可变的String
    public static String appendstr(String s) {
        s =s+ "bbb";
        return s;
    }

    //可变的StringBuilder
    public static StringBuilder appendSb(StringBuilder sb) {
        return sb.append("bbb");
    }

    public static void main(String[] args) {
        //String微参数
        String s = new String("aaa");
        String ns = Test.appendstr(s);
        System.out.println("String aaa >>> " + s.toString());
        //StringBuilder做参数
        StringBuilder sb = new StringBuilder("aa");
        StringBuilder nsb = Test.appendSb(sb);
        System.out.println("StringBuilder aaa >>> " + sb.toString());
    }
}
