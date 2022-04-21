package toilet.kcm.controller;

import ch.qos.logback.core.net.SyslogOutputStream;

import java.util.Scanner;

public class SoheeCalc {

    public static void main(String[] args){
        System.out.println("계산기 만들기");

        int a = 0;
        int b = 0;

        String sign = "";

        Scanner scan = new Scanner(System.in);

        System.out.print("첫번째 숫자 : ");
        a = scan.nextInt();

        System.out.print("두번째 숫자 : ");
        b = scan.nextInt();

        System.out.print("+-*/ 중에 고르세요 : ");
        sign = scan.next();

        if(sign.equals("+")){
            System.out.println(a+"+"+b+"="+(a+b));
        }
        else if(sign.equals("-")){
            System.out.println(a+"-"+b+"="+(a-b));
        }
        else if(sign.equals("*")){
            System.out.println(a+"*"+b+"="+(a*b));
        }
        else if(sign.equals("/")){
            System.out.println(a+"/"+b+"="+(a/b));
        }
        else {
            System.out.println("다시 입력하세요!");
        }

    }
}
