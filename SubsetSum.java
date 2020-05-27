import java.util.*;
class SubsetSum {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=s.nextInt();
        int sum=s.nextInt();
        System.out.println(isSubset(arr,n,sum));
    }
    public static boolean isSubset(int[] arr,int n,int sum)
    {
        boolean dp[][]=new boolean[arr.length+1][sum+1];
        for(int i=0;i<=sum;i++)
            dp[0][i]=false;
        for(int i=0;i<=arr.length;i++)
            dp[i][0]=true;
        for(int i=1;i<=arr.length;i++)
        {
            for(int j=1;j<=sum;j++)
            {
                dp[i][j]=dp[i-1][j];
                if(arr[i-1]<=j)
                {
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
            }
        }
        return dp[arr.length][sum];
    }
} 
