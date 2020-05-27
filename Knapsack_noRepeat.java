import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        int value[][]=new int[w.length+1][W+1];
	for(int i=0;i<=w.length;i++)
		value[i][0]=0;
	for(int i=0;i<=W;i++)
		value[0][i]=0;
	for(int i=1;i<=w.length;i++)
	{
		for(int wt=1;wt<=W;wt++)
		{
			value[i][wt]=value[i-1][wt];
			if(w[i-1]<=wt)
			{
				int val=value[i-1][wt-w[i-1]]+w[i-1];
				if(value[i][wt]<val)
					value[i][wt]=val;
			}
		}
	}
	return value[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

