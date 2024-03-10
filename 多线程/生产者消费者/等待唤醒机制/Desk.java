package 多线程.生产者消费者.等待唤醒机制;

class Desk {//桌子
    //是否有资源 @: 没有资源 1: 有资源
    public static int foodFlag = 0;
    //资源总个数
    public static int count = 10;
    //锁对象
    public static Object lockObj = new Object();
    public Desk(int count) {
        this.count=count;
    }

}
