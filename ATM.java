import java.util.Scanner;
public class ATM {
    private double bal;
    private String accno;
    private String pin;
    public ATM(String accno, String pin, double bal) 
    {
        this.accno = accno;
        this.pin = pin;
        this.bal = bal;
    }

    public boolean validatePin(String inputPin) 
    {
        return pin.equals(inputPin);
    }

    public double getBalance() 
     {
        return bal;
    }

    public void deposit(double amt) 
    {
        if (amt > 0) {
            bal += amt;
            System.out.println("Deposited: " + amt);
        } 
	else 
            System.out.println("Invalid");
    }

    public void withdraw(double amt) 
    {
        if (amt > 0 && amt <= bal) {
            bal -= amt;
            System.out.println("Withdrawn: " + amt);
        } else 
            System.out.println("Insufficient funds or invalid");
    }

    public static void main(String[] args) 
    {
        ATM atm = new ATM("123456", "1234", 1000.0);
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome!!!");
        System.out.print("Enter account number: ");
        String inputAccountNumber = sc.next();
        System.out.print("Enter your PIN: ");
        String inputPin = sc.next();
        if (atm.validatePin(inputPin) && inputAccountNumber.equals(atm.accno)) {
            while (true) 
	    {
                System.out.println("Options:");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Select an option: ");
                int op = sc.nextInt();
                switch (op) 
		{
                    case 1:
                        System.out.println("Balance:" + atm.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter deposit amount:");
                        double depositAmount = sc.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter withdrawal amount:");
                        double withdrawAmount = sc.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you.");
                        System.exit(0);
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } else 
            System.out.println("Invalid and Exiting.");
    }
}
