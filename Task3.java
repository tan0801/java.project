package javatask;

	import java.util.ArrayList;
	import java.util.Random;
	import java.util.Scanner;

	class BankAcc {
	    private String name;
	    private int accNumber;
	    private int Balance;
	    private int pin;

	    BankAcc(String UserName, int accNum, int initialAmount, int pin){
	        this.name = UserName;
	        this.accNumber = accNum;
	        this.Balance = initialAmount;
	        this.pin = pin;
	    }

	    public String getName(){
	        return this.name;
	    }

	    public int getAccNumber(){
	        return this.accNumber;
	    }

	    public int getBalance(){
	        return Balance;
	    }

	    public int getPin(){
	        return this.pin;
	    }

	    public void depositRequest(int amount){
	        this.Balance = this.Balance + amount;
	    }

	    public void withdrawRequest(int amount){
	        if(amount <= this.Balance){
	            this.Balance = this.Balance - amount;
	            System.out.println("Successfully withdraw amount from the bank.");
	        }
	        else{
	            System.err.println("Less money in the bank then withdraw request amount.");
	        }
	    }
	}

	class ATM {

	    // should contain methods to deposit,withdraw,check bank balance

	    ATM(){}

	    public void Deposit(BankAcc userAcc, int amount){
	        userAcc.depositRequest(amount);
	    }

	    public void Withdraw(BankAcc userAcc, int amount){
	        userAcc.withdrawRequest(amount);
	    }

	    public int CheckBalance(BankAcc userAcc){
	        return userAcc.getBalance();
	    }

	}

	class Task3 {
	    public static void main(String args[]){
	        Scanner sobj = new Scanner(System.in);
	        int option = 0;
	        boolean state = true;
	        ArrayList<BankAcc> accounts = new ArrayList<BankAcc>();

	        System.out.println("Welcome to ABC Bank : ");

	        while(state){
	            System.out.println("1.Create bank account.\n2.ATM\n3.Exit");
	            System.out.println("Select option : ");
	            option = sobj.nextInt();

	            switch(option){
	                case 1 : 
	                    // logic to create bank acc
	                    System.out.println("\nEnter your name : ");
	                    sobj.nextLine();
	                    String name = sobj.nextLine();
	                    System.out.println("Deposit some money : ");
	                    int balance = sobj.nextInt();

	                    // logic to generate acc number
	                    Random random = new Random();
	                    int accNumber = random.nextInt(1000000000);
	                    int pin = random.nextInt(1000,9999);

	                    BankAcc bobj = new BankAcc(name, accNumber, balance, pin);
	                    accounts.add(bobj);

	                    System.out.println("\nBank account created successfully!\nHere are your credentials : \nName : "+name+"\nAccount number : "+accNumber+"\nPin : "+pin+"\nPlease dont forget your credentials!\n");

	                    break;
	                case 2 : 
	                    // logic to get user acc number and find his account and if not found then redirect him to create a acc

	                    System.out.println("Enter account number : ");
	                    int accountNumber = sobj.nextInt();
	                    System.out.println("Enter your pin number : ");
	                    int accountPin = sobj.nextInt();

	                    int i = 0;
	                    for(i = 0; i < accounts.size(); i++){
	                        BankAcc userAcc = accounts.get(i);
	                        if(accountNumber == userAcc.getAccNumber() && accountPin == userAcc.getPin()){
	                            int atmOption = 0;
	                            boolean atmState = true;
	                            
	                            while(atmState){
	                                System.out.println("\n1.Deposit.\n2.Withdraw\n3.Check Balance.\n4.Exit");
	                                System.out.println("Select option : ");
	                                atmOption = sobj.nextInt();

	                                switch(atmOption){
	                                    case 1 : 
	                                        // logic to deposit amount in atm
	                                        System.out.println("Enter amount you want to deposit : ");
	                                        int depositAmount = sobj.nextInt();

	                                        ATM atmObjDeposit = new ATM();
	                                        atmObjDeposit.Deposit(userAcc, depositAmount);
	                                        System.out.println("Succesfully deposit money in the bank.");

	                                        break;
	                                    case 2 : 
	                                        // logic to withdraw amount from atm
	                                        System.out.println("Enter amount you want to withdraw : ");
	                                        int withdrawAmount = sobj.nextInt();

	                                        ATM atmObjWithdraw = new ATM();
	                                        atmObjWithdraw.Withdraw(userAcc, withdrawAmount);

	                                        break;
	                                    case 3 : 
	                                        // logic to get user bank balance

	                                        ATM atmObjBalance = new ATM();
	                                        int accBalance = atmObjBalance.CheckBalance(userAcc);
	                                        System.out.println("Account balance is : "+accBalance);

	                                        break;
	                                    case 4 : 
	                                        // exit the atm interface
	                                        atmState = false;
	                                        break;
	                                    default : 
	                                }
	                            }

	                            break;
	                        }
	                    }

	                    if(i > accounts.size()){
	                        System.err.println("Incorrect credentials!");
	                    }

	                    break;
	                case 3 : 
	                    // exit the main application
	                    System.out.println("Thank you your time. Have a nice day");
	                    state = false;
	                    break;
	                default : 
	                    System.err.println("Invalid option!");
	            }
	        }

	        sobj.close();
	    }
	}
