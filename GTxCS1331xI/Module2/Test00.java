public class Test00 {
    public static void main(String[] args) {
        double test = 1.234567;
        System.out.printf("%.1f\n", test);
        System.out.printf("%.2f\n", test);
        System.out.printf("%.3f\n", test);

        String test2 = "abcd";
        System.out.printf("%10s---\n", test2); //10 width and 右寄せ
        System.out.printf("%-10s---\n", test2);//10 width and 左寄せ
        System.out.printf("%2s---\n", test2);  //2 width and 右寄せ
        System.out.printf("%-2s---\n", test2); //2 width and 左寄せ

        double test3 = 1234567.9012;
        System.out.printf("%.1f\n", test3); 
        System.out.printf("%,.1f\n", test3); //, をつけて3桁区切り文字あり

    }
}