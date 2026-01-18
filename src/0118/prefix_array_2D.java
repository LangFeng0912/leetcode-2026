import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //n行
        int m = sc.nextInt(); //m列

        int[][] prefix = new int[n+1][m+1];

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                int culVal = sc.nextInt();
                prefix[i][j] = culVal + prefix[i-1][j] 
                    + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }

        int total= prefix[n][m];

        int minDiff = Integer.MAX_VALUE;
        //横向
        for(int i = 1; i<n; i++){
            int cur = prefix[i][m];
            int remain = total-cur;
            minDiff = Math.min(minDiff, Math.abs(cur-remain));
        }

        //纵向
        for(int i = 1; i<m; i++){
            int cur = prefix[n][i];
            int remain = total-cur;
            minDiff = Math.min(minDiff, Math.abs(cur-remain));
        }

        System.out.println(minDiff);
    }
}