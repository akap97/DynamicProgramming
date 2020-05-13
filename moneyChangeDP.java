import java.util.*;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int mincoins[]=new int[m+1];
        mincoins[0]=0;
        int coins[]={1,3,4};
        for(int i=1;i<=m;i++){
            mincoins[i]=Integer.MAX_VALUE;
            for(int j=0;j<coins.length;j++)
            {
                if(i>=coins[j])
                    {
                        int numcoins=mincoins[i-coins[j]]+1;
                        if(numcoins<mincoins[i])
                            mincoins[i]=numcoins;
                    }
            }
        }
        
        return mincoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

