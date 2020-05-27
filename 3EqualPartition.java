import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        int k=3,sum=0;
        for(int i=0;i<A.length;i++)
            sum+=A[i];
        if(sum%3!=0)
            return 0;
        if(canPartition(0,A,new boolean[A.length],3,0,sum/3))
            return 1;
        return 0;
    }
    private static boolean canPartition(int start,int[] arr,boolean[] used,int k,int currsum,int targetsum)
    {
        if(k==1)
            return true;
        if(currsum==targetsum)
            return canPartition(0,arr,used,k-1,0,targetsum);
        if(currsum>targetsum)
            return false;
        for(int i=start;i<arr.length;i++)
        {
            if(!used[i])
            {
                used[i]=true;
                if(canPartition(i+1,arr,used,k,currsum+arr[i],targetsum))
                {
                    return true;
                }
                used[i]=false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

