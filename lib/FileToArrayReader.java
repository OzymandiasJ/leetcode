package lib;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileToArrayReader {
    public static int[][] readDataFromFile(String fileName,int rows,int cols) {
        List<int[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<Integer> row = new ArrayList<>();

                Pattern pattern = Pattern.compile("\\[(.*?)\\]");
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String dataStr = matcher.group(1);
                    String[] parts = dataStr.split(",");
                    for (String part : parts) {
                        row.add(Integer.parseInt(part.trim()));
                    }
                }

                int[] rowData = new int[row.size()];
                for (int i = 0; i < row.size(); i++) {
                    rowData[i] = row.get(i);
                }

                dataList.add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j]=dataList.get(0)[i*cols+j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String fileName = "src/lib/data.txt";
        int[][] result = readDataFromFile(fileName,3,2);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
