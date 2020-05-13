
import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        int[] minops=new int[n+1];
        minops[0]=0;
        minops[1]=0;
        for(int i=2;i<=n;i++)
        {
            int min1=minops[i-1];
            int min2=Integer.MAX_VALUE;
            int min3=Integer.MAX_VALUE;
            if(i%2==0)
                min2=minops[(int)i/2];
            if(i%3==0)
                min3=minops[(int)i/3];
            int min=Math.min(Math.min(min1,min2),min3);
            minops[i]=min+1;
        }
        List<Integer> sequence=new ArrayList<>();
        while (n > 0)
        {
        sequence.add(n);
        if (n % 2 != 0 && n % 3 != 0)
            n = n - 1;
        else if (n % 2 == 0 && n % 3 == 0) 
            n = (int) n / 3;
        else if (n % 2 == 0)
            {
            if (minops[n-1] < minops[(int)n/2])
                n = n-1;
            else
                n = (int)n /2;
            }
        else if (n % 3 == 0)
            {
            if (minops[n-1] < minops[(int)n/3])
                n = n-1;
            else
                n = (int)n /3;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

