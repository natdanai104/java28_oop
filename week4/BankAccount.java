package week4;

public class BankAccount{

    private String accountNo;
    private String ownerName;
    private double balance;
    private int pin;//รหัสผ่าน   

    public BankAccount(String accountNo, String ownerName, double balance, int pin) {
        this.accountNo = accountNo;
        this.ownerName = ownerName;
        this.balance = balance;
        this.pin = pin;
    }
    
    public boolean AuthAccount(String accountNo, int pin){
        this.accountNo = accountNo;
        this.ownerName = "Natdanai";
        return true;      
    }

    public String getAccountNo(){
        return accountNo;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        if(amount>0){
            balance += amount;
            System.out.println("ฝากเงินสำเร็จ" + amount + "บาท");
        }else{
            System.out.println("ยอดเงินไม่ถูกต้อง");
        }
    }

public void withdraw(double amount){
    if(amount > 0){
        if(balance >= amount){
            balance -= amount;
            System.out.println("ถอนเงิน จำนวน :"+amount+"สำเร็จ");
        }else{
            System.out.println("ยอดเงินคงเหลือไม่พอ");
        }
    }else{
        System.out.println("ระบุบจำนวนเงินไมถูกต้อง");}
    }

    public void showinfo(){
        System.out.println("หมายเลขบัญชี :" + accountNo);
        System.out.println("ชื่อบัญชี :" + ownerName);
        System.out.println("ยอดเงินคงเหลือ :" + balance);
    }
}
