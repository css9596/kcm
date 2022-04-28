package kcm.project.commonApi.test;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Scanner;

public class SoheeCalc {
    public static void main(String[] args){
        int a = 0;
        int b = 0;
        String sign = "";

        Scanner scan = new Scanner(System.in);

        System.out.println("계산기 만들기");
        System.out.print("첫번째 숫자 : ");
        a = num(a);

        if(isInt(a) == true) {
            System.out.print("두번째 숫자 : ");
            //b = scan.nextInt();
            b = num(a);
        }else{
            System.out.print("숫자를 입력하세요");
        }

        if(isInt(b) == true) {
            System.out.print("부호 : ");
            sign = scan.next();
            isSign(sign,a,b);
        }else{
            System.out.print("숫자를 입력하세요");
        }

    }

    // 정수 입력받기
    public static int num(int x){
        Scanner scan = new Scanner(System.in);
        x = scan.nextInt();
        return x;
    }

    // 정수를 입력했는지 확인하는 메소드
    public static boolean isInt(Object obj){
        boolean isInt = false;
        Integer integerData = obj instanceof Integer ? ((Integer) obj) : null;
        if(integerData != null){
            isInt = true;
        }
        return isInt;
    }

    // 사칙연산 부호와 숫자 2개를 입력받는 메소드
    public static Object isSign(String str, int a, int b){
        String sign = str;
        int x = a;
        int y = b;
        Object result = 0;

        //null check

//        System.out.println(a + sign + b + "=" + (a + sign + b));

        if (sign.equals("+")) {
            System.out.println(a + "+" + b + "=" + (a + b));
//            result = System.out.println(a + "++" + b + "=" + (a + b));
//            result = a+b;
        } else if (str.equals("-")) {
            System.out.println(a + "-" + b + "=" + (a - b));
//            result = a-b;
        } else if (str.equals("*")) {
            System.out.println(a + "*" + b + "=" + (a * b));
//            result = a*b;
        } else if (str.equals("/")) {
            System.out.println(a + "/" + b + "=" + (a / b));
//            result = a/b;
        } else {
            System.out.println("부호를 다시 입력하세요!");
        }
        return result;
    }
}
