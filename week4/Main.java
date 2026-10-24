package week4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int menu, pinCode;
        String accountNo;

        accountNo = sc.nextLine();
        pinCode = sc.nextInt();

        BankAccount account =
                new BankAccount(accountNo, "", 0, pinCode);

        ADM adm = new ADM(account);

        if (adm.checkAccount(accountNo, pinCode)) {

            do {

                System.out.println("======= Main ADM System ======");
                System.out.println("กด 1 แสดงข้อมูลบัญชี");
                System.out.println("กด 2 ฝาก");
                System.out.println("กด 3 ถอน");
                System.out.println("กด 4 เช็คยอดเงิน");
                System.out.println("กด 0 ออกจากโปรแกรม");
                System.out.println("เลือกเมนู");

                menu = sc.nextInt();

                if (menu == 1) {

                    adm.showInfomation();

                } else if (menu == 2) {

                    System.out.println("ระบุจำนวนเงินที่ต้องการฝาก :");
                    double amount = sc.nextDouble();
                    adm.depositmoney(amount);

                } else if (menu == 3) {

                    System.out.println("ระบุจำนวนเงินที่ต้องการถอน :");
                    double amount = sc.nextDouble();
                    adm.withdrawmoney(amount);

                } else if (menu == 4) {

                    adm.checkBalance();

                } else if (menu == 0) {

                    System.out.println("ออกจากโปรแกรม");

                } else {

                    System.out.println("เลือกเมนูไม่ถูกต้อง");

                }

            } while (menu != 0);

        } else {

            System.out.println("ชื่อบัญชี หรือ รหัสผ่านไม่ถูกต้อง");

        }

        sc.close();
    }
}