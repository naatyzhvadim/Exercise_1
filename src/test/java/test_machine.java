import org.junit.Test;

import java.util.Scanner;

public class test_machine {
    @Test
    public void test_0(){
        Scanner scan = new Scanner(System.in);
        String number = scan.nextLine();
        System.out.println ("Вы ввели число " + number);
    }

    @Test
    public void test_1(){
        int[] tmp = new int[2];
        tmp[0] = 1;
        tmp[1] = 2;
        int sum = 10000;
        CashExchange bank = new CashExchange(tmp, sum);
        bank.CalcResults();
        bank.PrintRes();
    }

    @Test
    public void test_2(){
        int[] tmp = new int[3];
        tmp[0] = 3;
        tmp[1] = 4;
        tmp[2] = 7;
        int sum = 17;
        CashExchange bank = new CashExchange(tmp, sum);
        bank.CalcResults();
        bank.PrintRes();
    }

    @Test
    public void test_4(){
        int[] tmp = new int[4];
        tmp[0] = 2;
        tmp[1] = 5;
        tmp[2] = 10;
        tmp[3] = 22;
        int sum = 28;
        CashExchange bank = new CashExchange(tmp, sum);
        bank.CalcResults();
        bank.PrintRes();
    }

}
