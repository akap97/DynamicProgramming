import java.util.*;

public class PlacingParentheses {
    private static int getMaximValue(String exp) {
     	int len=exp.length();
	int ndig=(len+1)/2;
	int nop=len-ndig;
	int dig[]=new int[ndig];
	String op[]=new String[nop];
	int ind=0;
	String[] arr = exp.split("(?<=\\d)(?=\\D)|(?<=\\D)(?=\\d)");
	int ind1=0,ind2=0;
	for(int i=0;i<arr.length;i++)
	{
		if(numornot(arr[i]))
		{
			dig[ind1]=Integer.parseInt(arr[i]);
			ind1++;
		}
		else
		{
			op[ind2]=(arr[i]);
			ind2++;
		}
	}
	int m[][]=new int[ndig][ndig];
	int M[][]=new int[ndig][ndig];
	for(int i=0;i<ndig;i++)
		for(int j=0;j<ndig;j++)
			{
				m[i][j]=0;
				M[i][j]=0;
			}
	for(int i=0;i<ndig;i++)
	{
		m[i][i]=dig[i];
		M[i][i]=dig[i];
	}
	for(int s=1;s<ndig;s++)
	{
		for(int i=0;i<(ndig-s);i++)
		{
			int j=i+s;
			int res[]=new int[2];
			res=minmax(i,j,op,m,M);
			m[i][j]=res[0];
			M[i][j]=res[1];
		}
	}
	

      return M[0][ndig-1];
    }
	private static boolean numornot(String s)
	{
		try
		{
			Integer.parseInt(s);
		}
		catch(NumberFormatException ex)
		{
			return false;
		}
		return true;
	}
	private static int[] minmax(int i,int j,String[] op,int[][] m,int[][] M)
	{
		int mmin=100000;
		int mmax=-100000;
		for(int k=i;k<j;k++)
		{
			int a=eval(M[i][k],M[k+1][j],op[k]);
			int b=eval(M[i][k],m[k+1][j],op[k]);
			int c=eval(m[i][k],M[k+1][j],op[k]);
			int d=eval(m[i][k],m[k+1][j],op[k]);
			mmin=Math.min(Math.min(Math.min(Math.min(c,d),b),a),mmin);
			mmax=Math.max(Math.max(Math.max(Math.max(c,d),b),a),mmax);
		}
		int res[]=new int[2];
		res[0]=mmin;
		res[1]=mmax;
		return res;
	}

	

    private static int eval(int a, int b, String op) {
        if (op == "+") {
            return a + b;
        } else if (op == "-") {
            return a - b;
        } else if (op == "*") {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

