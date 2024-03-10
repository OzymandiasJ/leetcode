package 数组字符串.O1时间插入删除和获取随机元素_380;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    /**
     * 实现RandomizedSet 类：
     *
     * RandomizedSet() 初始化 RandomizedSet 对象
     * bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。
     * bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。
     * int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。
     * 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1)
     */
    public static void main(String[] args) {
        RandomizedSet solution=new RandomizedSet();
        System.out.println(solution.insert(1));
        System.out.println(solution.remove(2));
        System.out.println(solution.insert(2));
        System.out.println(solution.getRandom());
        System.out.println(solution.remove(1));
        System.out.println(solution.insert(2));
        System.out.println(solution.getRandom());
    }
}
class RandomizedSet {
    /**
     * 标准答案:变长数组 + 哈希表
     *
     */
    List<Integer> list;
    public RandomizedSet() {
        list =new ArrayList<>();
    }

    public boolean insert(int val) {
        if(list.contains(val))
            return false;
        else {
            list.add(val);
            return true;
        }
    }

    public boolean remove(int val) {
        if(list.contains(val)){
            int index=list.indexOf(val);
            list.remove(index);
            return true;
        }else
            return false;
    }

    public int getRandom() {
        Random random=new Random();
        int index=random.nextInt(list.size());
        return list.get(index);
    }
}
