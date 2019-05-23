package com.zcj.spring_login.eneity;

public class testa {

    public static void main(String[] args) {
        String arry[] = new String[]{"a", "b", "c", "d", "e", "f"};
//        System.out.println(kkf(1));
        jkl(arry, arry.length - 1);
    }


    public static int kk(int k) {
        if (k == 7) {
            return 2;
        }
        return (kk(k + 1) + 1) * 2;
    }


    public static int kkf(int k) {
        if (k == 10) {
            return 1;
        }
        return (kkf(k + 1) + 1) * 2;
    }


    public static void jkl(String k[], int kf) {
        System.out.println(k[kf]);
        if (kf > 0) {
            jkl(k, (kf - 1));
        }
    }
}
