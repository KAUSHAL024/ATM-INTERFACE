import java.util.Scanner;
class ATM{
    private BankAccount acc;
    private int Pin;
    public ATM(BankAccount ac,int pin){
        this.acc=ac;
        this.Pin=pin;
    }
    public void menu(){
        System.out.println("ATM Machine Interface");
         System.out.println("1. check Balance");
         System.out.println("2. Deposit");
         System.out.println("3. Withdraw");
         System.out.println("4. Exit");
    }
    public boolean verifyPin(int entered_pin){
        return this.Pin==entered_pin;  
        }
        public void Bank_process(){
            Scanner st=new Scanner(System.in);
             int entered_pin;
             System.out.println("enter your pin :");
             entered_pin=st.nextInt();
            if(verifyPin(entered_pin)){
                int opt=0;
                while(opt!=4){
                    menu();
                    System.out.println("Enter your choice :-");
                    opt=st.nextInt();
                    switch(opt){
                        case 1:
                            System.out.println("The remaining Balance is :"+acc.getBalance());
                            break;
                            case 2:
                                System.out.println("Enter the ammount to deposit in the account: ");
                                double Amount_to_deposit=st.nextDouble();
                                acc.deposit_bal(Amount_to_deposit);
                                break;
                            case 3:
                                System.out.println("Enter the ammount to withdrow from the account :");
                                double Amount_to_withdraw=st.nextDouble();
                                acc.withdraw_bal(Amount_to_withdraw);
                                break;
                            case 4:
                                System.out.println("thank you for using the ATM");
                                break;
                                default:
                                System.out.println("You have enter the whrong choice, enter a valid option.");
                    }
                }
            }
                    else{
                        System.out.println("Incorrect pin");
                        
                    }
                    st.close();
                }
            }
            class BankAccount{
                private double bal;
                public BankAccount(double initial_bal){
                    this.bal=initial_bal;
                }
                public double getBalance(){
                    return bal;
                }
                public void deposit_bal(double amount){
                    if(amount>0){
                        bal=bal+amount;
                        System.out.println("The amount" + amount +"is deposit successfully,");
                    }
                    else{
                        System.out.println("you cannot deposit an amount less then 0,");
                        
                    }
                }
                public void withdraw_bal(double amount){
                    if(amount> 0 && amount<=bal){
                        bal=bal-amount;
                        System.out.println("The amount " + amount +"is withdrawn successfully.");
                        
                    }
                    else{
                        System.out.println("you do not have sufficient balance to withdawn");
                    }
                }
}

 public class Main{
public static void main(String args[]){
    BankAccount user_account=new BankAccount(1000.);
    int actual_pin=1234;
    ATM atm =new ATM(user_account, actual_pin);
    atm.Bank_process();
}
}