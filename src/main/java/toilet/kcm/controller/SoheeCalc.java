package toilet.kcm.controller;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Scanner;

public class SoheeCalc {
    public static void main(String[] args){
        int a = 0;
        int b = 0;
        String sign = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("계산기 만들기");

        while(true) {
            System.out.print("첫번째 숫자 : ");
            a = scan.nextInt();

            if (1==1) { //scan.hasNextInt()
                System.out.print("두번째 숫자 : ");
                b = scan.nextInt();
                System.out.print("+-*/ 중에 고르세요 : ");
                sign = scan.next();
            } else {
                System.out.println("숫자를 입력하세요");
            }

            if (sign.equals("+")) {
                System.out.println(a + "+" + b + "=" + (a + b));
            } else if (sign.equals("-")) {
                System.out.println(a + "-" + b + "=" + (a - b));
            } else if (sign.equals("*")) {
                System.out.println(a + "*" + b + "=" + (a * b));
            } else if (sign.equals("/")) {
                System.out.println(a + "/" + b + "=" + (a / b));
            } else {
                System.out.println("부호를 다시 입력하세요!");
            }
        }
    }
}
