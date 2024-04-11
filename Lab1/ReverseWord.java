

import java.util.Scanner;
public class ReverseWord {

    public static void printReversed(String word)
    {
        String PrevIme="";
        for(int i=word.length()-1;i>=0;i--)
        {
            PrevIme=PrevIme+word.charAt(i);
        }
        System.out.println(PrevIme);
    }

    public static void main(String[] args)
    {
        Scanner scanner=new Scanner(System.in);
        int N=scanner.nextInt();
        String ime;
        scanner.nextLine();
        for(int i=0;i<N;i++)
        {
            ime=scanner.nextLine();
            printReversed(ime);

        }
    }
}
