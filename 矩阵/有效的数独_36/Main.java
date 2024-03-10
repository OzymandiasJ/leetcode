package 矩阵.有效的数独_36;

import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    /**
     * 请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，
     * 验证已经填入的数字是否有效即可。
     *
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
     *
     * @param args
     */
    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.isValidSudoku(new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        }));
    }
}

class Solution {
    /**
     * 分别建立哈希表来存储任一个数在相应维度上是否出现过。
     *
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        int len=board.length;
        ArrayList<HashSet<Character>> rowList=new ArrayList<>();
        ArrayList<HashSet<Character>> colList=new ArrayList<>();
        ArrayList<HashSet<Character>> boxList=new ArrayList<>();
        for (int i = 0; i < len; i++)
            rowList.add(new HashSet<>());
        for (int i = 0; i < len; i++)
            colList.add(new HashSet<>());
        for (int i = 0; i < len; i++)
            boxList.add(new HashSet<>());
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if(board[i][j]!='.'){
                    HashSet<Character> currRowSet=rowList.get(i);
                    if(currRowSet.contains(board[i][j]))
                        return false;
                    else {
                        currRowSet.add(board[i][j]);
                        rowList.remove(i);
                        rowList.add(i,currRowSet);
                    }
                    HashSet<Character> currColSet=colList.get(j);
                    if(currColSet.contains(board[i][j]))
                        return false;
                    else {
                        currColSet.add(board[i][j]);
                        colList.remove(j);
                        colList.add(j,currColSet);
                    }
                    HashSet<Character> currBoxSet=boxList.get((i/3)*3+j/3);
                    if(currBoxSet.contains(board[i][j]))
                        return false;
                    else {
                        currBoxSet.add(board[i][j]);
                        boxList.remove((i/3)*3+j/3);
                        boxList.add((i/3)*3+j/3,currBoxSet);
                    }
                }
            }
        }

        return true;
    }
}