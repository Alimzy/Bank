package Account;

public class BankAccount{
    private int balance = 0;
    private int pin;
    private String name;
    private String phoneNumber;
    private int age;
    private String accountNumber = "";

    BankAccount(int pin,String name,String phoneNumber,int age){
        this.pin = validateAge(pin);
        this.name = validateName(name);
        this.phoneNumber = validatePhoneNumber(phoneNumber);
        this.age = validateAge(age);

    }


    public int checkBalance(int inputPin) {
       if(inputPin != pin){
           throw new IllegalArgumentException("incorrect Pin");
       }
            return balance;
    }

    public int validatePin(int pin) {
        if (pin < 999 || pin > 9999) {
            throw new IllegalArgumentException("invalid pin");
        }
        return pin;
    }
    public void setPin(int pin) {
        this.pin = pin;
    }

    public  String validateName(String name) {
        if(name.equals(" ")){

            throw new IllegalArgumentException("name cannot be empty");
        }
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    private int validateAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("you must be 18 before you can open account");
        }
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    private String validatePhoneNumber(String phoneNumber){
        if (phoneNumber.length() != 11){
            throw new IllegalArgumentException("phone number mus be 11 digit....... invalid pin");
        }
        return phoneNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void deposit(int amount){
        if(amount <= 0){
            throw new IllegalArgumentException("invalid amount");
        }
        else{
            balance += amount;
        }
    }

    public void withdraw(int amount, int inputPin) {
        validatePin(inputPin);
        if(amount <= 0) {
            throw new IllegalArgumentException("invalid amount");
        } else if (amount <= balance && inputPin == pin) {
            balance -= amount;
        }
    }

    public void transfer(int amount,int pin,BankAccount toAccount){
        withdraw(amount,pin);
        toAccount.deposit(amount);

    }

    public String getAccountNumber(){
        return this.accountNumber = phoneNumber.substring(1);
    }
}
