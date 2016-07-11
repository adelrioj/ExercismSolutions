public class HelloWorld {

    public static final String DEFAULT_NAME = "World";
    public static final String HELLO_START = "Hello, ";
    public static final String HELLO_END = "!";

    public static String hello(String nameToGreet){
        String resultName = DEFAULT_NAME;
        
        if (isNotNull(nameToGreet)){
            resultName = nameToGreet;
        }
        
        return HELLO_START + resultName.trim() + HELLO_END;
    }

    private static boolean isNotNull(String nameToGreet) {
        if (nameToGreet == null) return false;
        if ("".equals(nameToGreet)) return false;
        return true;
    }
}
