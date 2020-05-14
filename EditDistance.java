import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int dp[][]=new int[s.length()+1][t.length()+1];
    for(int i=0;i<=s.length();i++)
        dp[i][0]=i;
    for(int i=0;i<=t.length();i++)
        dp[0][i]=i;
    for(int i=1;i<=s.length();i++)
        {
            for(int j=1;j<=t.length();j++)
            {
                int insertion=dp[i][j-1]+1;
                int deletion=dp[i-1][j]+1;
                int match=dp[i-1][j-1];
                int mismatch=dp[i-1][j-1]+1;
                if(s.charAt(i-1)==t.charAt(j-1))
                    dp[i][j]=Math.min(Math.min(insertion,deletion),match);
                else
                    dp[i][j]=Math.min(Math.min(insertion,deletion),mismatch);
            }
        }
    return dp[s.length()][t.length()];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
