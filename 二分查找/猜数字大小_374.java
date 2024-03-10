package 二分查找;

class  GuessGame{
    int pick;

    public GuessGame(int pick) {
        this.pick = pick;
    }

    int guess(int num){
        if(num<pick)
            return 1;
        else if (num>pick) {
            return -1;
        }else
            return 0;
    }
}
public class 猜数字大小_374 {
    public static void main(String[] args) {
        Solution solution=new Solution(1702766719);
        System.out.println(solution.guessNumber(2126753390));
    }
    public static class Solution  extends GuessGame{
        public Solution(int pick) {
            super(pick);
        }

        public int guessNumber(int n) {
            if(n==1)
                return 1;
            if(guess(n)==0)
                return n;
            if(guess(1)==0)
                return 1;


            long l=0,r=n;
            while(true){
                long mid=(l+r)/2;
                long tmp=guess((int)mid);
                if(tmp==0)
                    return (int)mid;
                else if(tmp==-1){//大了
                    r=mid;
                }else {//小了
                    l=mid;
                }
            }
        }

    }
}





