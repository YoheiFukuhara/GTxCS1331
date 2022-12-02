public class StringOperations {
    public static void main(String[] args) {
        String testStr = "Yohei";
        System.out.println(testStr);
        System.out.println('A' + testStr.substring(1, testStr.length()-1) + 'Z');

        String url = "www.name.tld";
        System.out.println("url: " + url);

        int firstDot = url.indexOf('.') + 1;
        int secondDot = url.substring(firstDot).indexOf('.') + firstDot;
        String nameConcat = url.substring(firstDot, secondDot) + "1331";
        System.out.println(nameConcat);
    }
}
