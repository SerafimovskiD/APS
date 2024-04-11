
import java.util.Scanner;
public class PushZero
{
    static void pushZerosToBeginning(int arr[], int n)
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n-1; j++)
            {
                if(arr[j]!=0&&arr[j+1]==0)
                {
                    int pomosna = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = pomosna;
                }
            }
        }
    }

    public static void main (String[] args)
    {
        Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        int arr[]=new int[N];
        for(int i=0;i<N;i++)
        {
            arr[i]=input.nextInt();
        }
        pushZerosToBeginning(arr,N);
        System.out.print("Transformiranata niza e: \n");
        for(int i=0;i<N;i++)
        {
            System.out.print(arr[i]+ " ");

        }
    }
}