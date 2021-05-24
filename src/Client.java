import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {

    public static double AMOUNT = 30;
    public static void main(String[] args) throws UnknownHostException, RemoteException, NotBoundException, MalformedURLException {

        String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + ":52334/BankAccount";
        BankAccount bankAccount = (BankAccount) Naming.lookup(url);

        System.out.println("------------- Welcome to the bank ------------");
        System.out.println("Current Amount in the bank is : "+ bankAccount.getBalance());
        System.out.println("Deposit --> "+ AMOUNT);
        bankAccount.deposit(AMOUNT);
        System.out.println("Amount after deposit is : "+ bankAccount.getBalance());
        System.out.println("Withdraw --> "+ AMOUNT);
        bankAccount.withdraw(AMOUNT);
        System.out.println("Amount after withdraw is : "+ bankAccount.getBalance());
        System.out.println("--------------- Thank you -----------------");

    }
}
