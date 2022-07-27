import java.util.Scanner;
public class Loan1
{
    /*
    Preconditions: true
    Postconditions:
    - If parameters are either 0 or negative value, throw IllegalArgumentException.
    - If payment amount isn't large enough to drive principal to zero, throw IllegalArgumentException.
    - Else, calculate the number of months it takes to repay the loan (initial principal amount with interest).  
    */
    /*
    @param principal:  Amount of the initial principal
    @param rate:       Annual interest rate  (8% rate expressed as rate = 0.08)
    @param payment:    Amount of the monthly payment
    */
    public static int months (int principal, double rate, int payment)
    {
        /*
        How this method works?
        - Calculates monthly interest, adds it to the pricipal amount and subratcts the payment. Each iteration of the loop is 
          1 month added. 
        - If, after a certain number of months, the principal amount isn't zero, it means that payment amount is small, and is
          not sufficient to drive the principal to zero (As principal increases due to interest rate)
        - We have kept the threshold to be 360 months (ie 30 years), if loan cannot be repayed in 30 years, that implies payment amount
          is small, which throws an IllegalArgumentException.
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
        if(months>360){
            throw new IllegalArgumentException("Payment not large enough to drive principal to zero.");
        }
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
        if(principal<=0 || rate<=0 || payment<=0)
        {
            throw new IllegalArgumentException("Necessary parameters should be non-zero positive values.");
        }
        else
        {
        int months = months(principal, rate, payment);
        System.out.println("Loan is paid back after "+months+" months");
        }
        input.close();
    }
}
