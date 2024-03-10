package umsorted;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2参议院_649 {

    /**
     * 这里写程序描述
     */

    public static void main(String[] args) {
        Solution solution=new Solution();

        String s = "RD";
        System.out.println(solution.predictPartyVictory(s));
    }
    static class Solution {
        /**
         * 双队列
         * @param senate
         * @return
         */
        public String predictPartyVictory(String senate) {
            Queue<Character> queue1 = new LinkedList<Character>();
            Queue<Character> queue2 = new LinkedList<Character>();
            int numd=0,numr=0;
            for (int i = 0; i < senate.length(); i++) {
                queue2.add(senate.charAt(i));
            }
            while(true){
                if(queue1.isEmpty()){
                    while (!queue2.isEmpty()){
                        //行使权利
                        char curr=queue2.remove();
                        if(curr=='D'){
                            if(numr>0){
                                numr--;
                            }else {
                                queue1.add(curr);
                                numd++;
                            }
                        }else {
                            if(numd>0){
                                numd--;
                            }else {
                                queue1.add(curr);
                                numr++;
                            }
                        }
                        if(queue2.isEmpty()&&!queue1.contains('D'))
                            return "Radiant";
                        else if (queue2.isEmpty()&&!queue1.contains('R')) {
                            return "Dire";
                        }
                    }
                }else {
                    while (!queue1.isEmpty()){
                        //行使权利
                        char curr=queue1.remove();
                        if(curr=='D'){
                            if(numr>0){
                                numr--;
                            }else {
                                queue2.add(curr);
                                numd++;
                            }
                        }else {
                            if(numd>0){
                                numd--;
                            }else {
                                queue2.add(curr);
                                numr++;
                            }
                        }
                        if(queue1.isEmpty()&&!queue2.contains('D'))
                            return "Radiant";
                        else if (queue1.isEmpty()&&!queue2.contains('R')) {
                            return "Dire";
                        }
                    }
                }
            }
        }
    }
}

