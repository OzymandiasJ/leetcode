package test.IO流操作;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    /**
     * 这里写程序描述
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.NIO();
    }

}
class Solution{
    public void fileReadWrite(){
        String filePath = "src/test.IO流操作/test.txt"; // 替换为实际的文件路径

        // 写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Hello, World!");
            writer.newLine();
            writer.write("This is an example of file read and write in Java.");
        } catch (IOException e) {
            System.out.println("写入文件时出错：" + e.getMessage());
        }

        // 读取文件
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("读取文件时出错：" + e.getMessage());
        }
    }
    public void LargeFileReadExample() {
        String filePath = "src/test.IO流操作/test.txt"; // 替换为实际的大文件路径

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int bufferSize = 30; // 缓冲区大小，根据需求调整
            char[] buffer = new char[bufferSize];
            int charsRead;

            while ((charsRead = reader.read(buffer, 0, bufferSize)) != -1) {
                // 处理读取的数据
                // 在这里可以对读取到的数据做任何你需要的处理
                String data = new String(buffer, 0, charsRead);
                System.out.print(data);
            }
        } catch (IOException e) {
            System.out.println("读取文件时出错：" + e.getMessage());
        }
    }
    public void NIO(){
        //模拟一下赋值文件操作
        String sourcePath = "src/test.IO流操作/test.txt"; // 替换为实际的源文件路径
        String destinationPath = "src/test.IO流操作/test_copy.txt"; // 替换为实际的目标文件路径

        try {
            Path source = Paths.get(sourcePath);
            Path destination = Paths.get(destinationPath);

            // 复制文件
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("文件复制成功！");
        } catch (IOException e) {
            System.out.println("文件复制失败：" + e.getMessage());
        }
    }
}
