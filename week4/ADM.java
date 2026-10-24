package week4;

public class ADM{

    private BankAccount account;

    public ADM(BankAccount account){
        this.account = account;

    }

    public void checkBalance(){
        System.out.println("ยอดเงินคงเหลือ");//เชื่อมไปยัง method อื่น
    }

    public void depositmoney(double amount){//ฝาก
        account.deposit(amount);
        //System.out.printIn("ฝาก");
    }    
    public void withdrawmoney(double amount){//ถอน
        account.deposit(amount);
        //System.out.printIn("ถอน");
    }

    public void withdrawMoney(){
        System.out.println("ข้อมูลส่วนตัว");
    }

    public boolean checkAccount(String accountNo, int pin){

        if(accountNo =="54321" && pin == 12345){
            return true;
        }else{
            return false;
        }
    }
}