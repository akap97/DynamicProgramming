import java.util.*;
class MatrixMul{
    public static int optimalmul(int[] arr)
    {
        int n=arr.length;
        int dp[][]=new int[n][n];
        int kvalue[][]=new int[n][n];
        int j,min,q;
        for(int d=1;d<n-1;d++)
        {
            for(int i=1;i<n-d;i++)
            {
                j=i+d;
                min=Integer.MAX_VALUE;
                for(int k=1;k<=j-1;k++)
                {
                    q=dp[i][k]+dp[k+1][j]+arr[i-1]*arr[k]*arr[j];
                    if(q<min)
                    {
                        min=q;
                        kvalue[i][j]=k;
                    }
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-1];
    }
    public static void main(String args[])
    {
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=s.nextInt();
        }
        System.out.println(optimalmul(arr));
    }
}
