package umsorted.无限集中的最小数字_2336;

import java.util.*;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {

        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);
        smallestInfiniteSet.popSmallest();
        smallestInfiniteSet.popSmallest();
        smallestInfiniteSet.popSmallest();
        smallestInfiniteSet.addBack(1);
        smallestInfiniteSet.popSmallest();
        smallestInfiniteSet.popSmallest();

    }
}
class SmallestInfiniteSet {
    //初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
    ArrayList<Integer> list=new ArrayList<>();
    public SmallestInfiniteSet() {
        list.add(1);
    }

    public int popSmallest() {
        //移除 并返回该无限集中的最小整数。
        int ret=list.get(0);
        list.remove(0);
        //如果list集合只有一个p，然后+1放回去
        if(list.size()==0){
            list.add(ret+1);
        }
        return ret;
    }

    public void addBack(int num) {
        //如果正整数 num 不存在于无限集中，则将一个 num 添加到该无限集中。
        if(num> list.get(list.size()-1))
            return;
        else if (list.contains(num)) {
            return;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if(num<list.get(i)){
                    list.add(i,num);
                    return;
                }
            }
        }
    }
}
