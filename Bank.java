package Account;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    String bankName;
    List<BankAccount> myAccountList;

    public Bank(String bankName){
        this.bankName = bankName;
        myAccountList = new ArrayList<>();
    }

    public void createAccount(int pin,String name,String phoneNumber,int age){
        BankAccount account = new BankAccount(pin,name,phoneNumber,age);
        myAccountList.add(account);
    }
    public  List<BankAccount> showAllAccount(){
        return myAccountList;
    }

    public int getNoOfAccount(){
        return myAccountList.size();
    }


    public BankAccount getAccount(String acctNumber){
        for(BankAccount account : myAccountList){
            if(account.getAccountNumber().equals(acctNumber)){
                return account;
            }
        }
        return null;
    }

    public boolean isExist(String accountNumber){

        for(BankAccount account : myAccountList){
            if(account.getAccountNumber().equals(accountNumber)){
                return true;
            }
        }
        return false;

    }

    public void depositAmount(String accountNumber,int amount){


        BankAccount account = getAccount(accountNumber);
        if(account == null){
            throw new IllegalArgumentException("account number not found");
        }
        account.deposit(amount);
    }

        public int checkAccountBalance(String accountNumber,int pin){
            BankAccount account = getAccount(accountNumber);
            if(account == null){
                throw new IllegalArgumentException("account number not found");
            }

            return account.checkBalance(pin);

    }

    public void withdrawAmount(String accountNumber,int amount,int pin){

        BankAccount account = getAccount(accountNumber);
        if(account == null){
            throw new IllegalArgumentException("account number not found");
        }
        account.withdraw(amount,pin);
    }

    public void deleteAccount(String accountNumber){

        BankAccount account = getAccount(accountNumber);
        if(account == null){
            throw new IllegalArgumentException("account number not found");
        }
        myAccountList.remove(account);
    }

    public void transfer(String fromAccount, int pin, String toAccount, int amount){
        BankAccount accountOne = getAccount( fromAccount);
        if(accountOne == null){
            throw new IllegalArgumentException("account number not found");
        }

        BankAccount accountTwo = getAccount( toAccount);
        if(accountTwo == null){
            throw new IllegalArgumentException("account number not found");
        }

        accountOne.withdraw(amount,pin);
        accountTwo.deposit(amount);

    }


}
