
import java.util.Scanner;
class QuarterlySales {

    private int numOfSales;
    private int [] revenues;
    private int quarterNo;

    public QuarterlySales(int numOfSales, int[] revenues, int quarterNo) {
        this.numOfSales = numOfSales;
        this.revenues = revenues;
        this.quarterNo = quarterNo;
    }
    public void setRevenues(int []revenues)
    {
        this.revenues = revenues;
    }
    public int sumQuarter()
    {
        int sum=0;
        for(int i=0;i<numOfSales;i++)
        {
            sum+=revenues[i];
        }
        return sum;
    }
    public String toString() {
        return sumQuarter() + "";
    }

}

class SalesPerson {

    private String name;
    private QuarterlySales [] quarters;

    int total()
    {
        int sum=0;
        for(int i=0;i<quarters.length;i++)
        {
            sum+=quarters[i].sumQuarter();
        }
        return sum;
    }
    public String getName()
    {
        return name;
    }
    public SalesPerson(String name, QuarterlySales[] quarters) {
        this.name = name;
        this.quarters = quarters;
    }
    public String toString() {
        int total=0;
        String s = new String();
        s = name;
        for(int i=0;i<quarters.length;i++)
        {
            s = s + "   " + quarters[i];
            total = total + quarters[i].sumQuarter();
        }
        return s + "   " + total;
    }

}



public class Main {

    public static SalesPerson salesChampion(SalesPerson [] arr)
    {
        int max=arr[0].total();
        int index=0;
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i].total() > max)
            {
                max = arr[i].total();
                index =i;
            }
        }
        return arr[index];
    }
    public static void table(SalesPerson [] arr)
    {
        System.out.println("SP   1   2   3   4   Total");
        for(int i=0;i<arr.length;i++)
        {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        int n;
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        SalesPerson [] arr = new SalesPerson[n];

        for(int i=0;i<n;i++)
        {
            String name = input.next();
            QuarterlySales [] q = new QuarterlySales[4];
            int x = input.nextInt();
            int tempRevenue[] = new int[x];
            for(int j=0;j<x;j++)
            {
                tempRevenue[j] = input.nextInt();
            }
            q[0] = new QuarterlySales(x,tempRevenue,1);
            x = input.nextInt();
            int tempRevenue1[] = new int[x];
            for(int j=0;j<x;j++)
            {
                tempRevenue1[j] = input.nextInt();
            }

            q[1] = new QuarterlySales(x,tempRevenue1,2);
            x = input.nextInt();
            int tempRevenue2[] = new int[x];
            for(int j=0;j<x;j++)
            {
                tempRevenue2[j] = input.nextInt();
            }
            q[2] = new QuarterlySales(x,tempRevenue2,3);
            x = input.nextInt();
            int tempRevenue3[] = new int[x];
            for(int j=0;j<x;j++)
            {
                tempRevenue3[j] = input.nextInt();
            }
            q[3] = new QuarterlySales(x,tempRevenue3,4);
            arr[i] = new SalesPerson(name,q);
        }

        table(arr);
        System.out.println("\nSALES CHAMPION: " + salesChampion(arr).getName());

    }
}