public class ATM{
    private int balance;
    private int pin;

    public ATM(int balance, int pin){   //default Constructor
        this.balance=balance;
        this.pin=pin;
    }
// define the menu
    public void displayMenu(){
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Change Pin");
        System.out.println("5. Exit");
    }
//deposit function
    public void deposit(int amount){
        balance+=amount;
    }
//withdrawal of money
    public void withdrawal(int amount){
        if(balance<amount){
            System.out.println("Insufficient Funds!");
            return;
        }
        balance-=amount;
    }
//getBalance amount
    public int getBalance(){
        return balance;
    }

// validating pin
    public boolean validatePin(int pin){
        return this.pin==pin;
    }

//changing the pin
    public void changePin(int newPin){
        pin = newPin;
        System.out.println("Pin Changed");
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000, 1234);
        
        System.out.print("Enter the Pin:");
        int pin = Integer.parseInt(System.console().readLine());
        System.out.println("Entered Pin: "+pin);
        if(atm.validatePin(pin)){
            
            int option  = 0;
            while(option!=5){
                atm.displayMenu();
                option = Integer.parseInt(System.console().readLine());
                switch (option) {
                    case 1:
                        System.out.println("Balance: "+atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter Amount: ");
                        int amount = Integer.parseInt(System.console().readLine());
                        atm.deposit(amount);
                        break;
                    case 3:
                        System.out.print("Enter Amount: ");
                        amount = Integer.parseInt(System.console().readLine());
                        atm.withdrawal(amount);
                        break;
                    case 4:
                        System.out.print("Enter new pin: ");
                        int newPin = Integer.parseInt(System.console().readLine());
                        atm.changePin(newPin);
                        break;
                    case 5:
                        System.out.println("Thank You for using ATM!");
                        break;
                
                    default:
                        break;
                }
            }
        }
        else{
            System.out.println("Invalid Pin");
        }
    }
}