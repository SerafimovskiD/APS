import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ZigZagSequence {
    static int najdiNajdolgaCikCak(int a[]) {
        int br=1;
        int max=0;
        for(int i=1;i<a.length;i++)
        {
            if((a[i]<0 && a[i-1]>0)||(a[i]>0 && a[i-1]<0))
            {
                br+=1;
            }
            else
            {
                br=1;
            }
            max=Math.max(br,max);
        }
        return max;
    }
    public static void main(String[] args) throws Exception {
        int i;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int a[] = new int[N];
        for (i=0;i<N;i++)
            a[i] = Integer.parseInt(br.readLine());

        int rez = najdiNajdolgaCikCak(a);
        System.out.println(rez);

        br.close();
    }

}