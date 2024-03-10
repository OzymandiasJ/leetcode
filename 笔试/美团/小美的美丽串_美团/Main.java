package 笔试.美团.小美的美丽串_美团;

public class Main {
    /**
     * 这里写程序描述
     */
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        String str=input.nextLine();
//        int count=countBeaufifulStrings(str);
//        System.out.println(count);
//        input.close();
//    }
//    public static int countBeaufifulStrings(String input){
//        int length=input.length();
//        if(length<3){
//            return 0;//字符串长度小于3，无解
//        }
//        int[] dp=new int[length];
//        dp[0]=0;
//        dp[1]=0;
//        dp[2]=(input.substring(0,3).equals("mei"))?1:0;
//
//        for (int i = 3; i < length; i++) {
//            if(input.substring(i-2,i+1).equals("mei")){
//                dp[i]=dp[i-3]+1;
//            }else {
//                dp[i]=dp[i-1];
//            }
//        }
//        return dp[length-1]+2;
//    }

    public static void main(String[] args) {
        String s = "meili";
        System.out.println(countWays(s));
    }

    public static int countWays(String s) {
        int n = s.length();
        int[][] dp = new int[n + 1][4]; // dp[i][j]: 前i个字符形成j个"mei"

        dp[0][0] = 1; // 初始化，没有字符形成0个"mei"的方案为1
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 3; j++) {
                // 删除第i个字符
                if (i >= 2) {
                    dp[i][j] += dp[i - 2][j];
                } else {
                    dp[i][j] += dp[i - 1][j];
                }

                // 保留第i个字符
                if (j > 0 && s.charAt(i - 1) == "mei".charAt((j - 1) % 3)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= 3; i++) {
            res += dp[n][i];
        }
        return res;
    }
}
