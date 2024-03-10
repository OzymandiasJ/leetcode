package test.temp;

class StaticStuff {
    static int x = 10;

    static {
        x += 5; // 第一个静态初始化块，x = 15
    }

    public static void main(String args[]) {
        System.out.println("x=" + x); // 打印 x=15
    }

    static {
        x /= 3; // 第二个静态初始化块，x = 5
    }
}


