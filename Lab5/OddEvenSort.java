import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OddEvenSort {

    static void oddEvenSort(int a[], int n)
    {
        // Vasiot kod tuka
        while(n!=0)
        {
            boolean flag=false;
            for(int br=1;br<a.length;br++)
            {
                if(a[br-1]%2==0&&a[br]%2==1)
                {
                    int tmp=a[br-1];
                    a[br-1]=a[br];
                    a[br]=tmp;
                    flag=true;
                }
                else if(a[br-1]%2==0&&a[br]%2==0)
                {
                    if(a[br-1]<a[br])
                    {
                        int tmp=a[br-1];
                        a[br-1]=a[br];
                        a[br]=tmp;
                        flag=true;
                    }
                }
                else if(a[br-1]%2==1&&a[br]%2==1)
                {
                    if(a[br-1]>a[br])
                    {
                        int tmp=a[br-1];
                        a[br-1]=a[br];
                        a[br]=tmp;
                        flag=true;
                    }
                }
            }
            if(flag==false)
            {
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        int i;
        BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
        String s = stdin.readLine();
        int n = Integer.parseInt(s);

        s = stdin.readLine();
        String [] pom = s.split(" ");
        int [] a = new int[n];
        for(i=0;i<n;i++)
            a[i]=Integer.parseInt(pom[i]);
        oddEvenSort(a,n);
        for(i=0;i<n-1;i++)
            System.out.print(a[i]+" ");
        System.out.print(a[i]);
    }
}