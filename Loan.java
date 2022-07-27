import java.util.Scanner;
public class Loan 
{
    /*
    @param principal:  Amount of the initial principal
    @param rate:       Annual interest rate  (8% rate expressed as rate = 0.08)
    @param payment:    Amount of the monthly payment
    */
    public static int months (int principal, double rate, int payment)
    {
        /*
            Requires: principal, rate, and payment all positive and payment is sufficiently large to drive the principal to zero.
            Effects:  return the number of months required to pay off the principal
        */
        float monthlyInterestRate = (float)(rate/12);
        int months = 0;
        float oldPrincipal = (float)(principal);
        float newPrincipal = oldPrincipal;
        while(newPrincipal>0)
        {
            newPrincipal = oldPrincipal * (1 + monthlyInterestRate) - payment;
            months++;
            oldPrincipal = newPrincipal;

        }
        return (int)(months);
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Principal amount: ");
        int principal = input.nextInt();
        System.out.println("Enter annual interest rate: ");
        double rate = input.nextDouble();
        System.out.println("Enter monthly payment: ");
        int payment = input.nextInt();
        int months = months(principal, rate, payment);
        System.out.println("Loan is paid back after "+months+" months");
        input.close();
        
    }
    
}
