import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;

public class Lozinki {
    public static void main(String[] args) throws IOException {
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(b.readLine());
        Hashtable<String, String> hash = new Hashtable<>();
        for (int i = 1; i <= N; i++) {
            String namepassword = b.readLine();
            String[] tmp = namepassword.split(" ");
            hash.put(tmp[0], tmp[1]);
        }
        int najaven=1;
        while (najaven!=0)
        {
            String red = b.readLine();
            if (red.equals("KRAJ"))
            {
                break;
            }
            String[] podatoci = red.split(" ");
            if (hash.containsKey(podatoci[0]) && hash.get(podatoci[0]).equals(podatoci[1]))
            {
                System.out.println("Najaven");
                najaven=0;
            }
            else
            {

                System.out.println("Nenajaven");
            }
        }
    }
}