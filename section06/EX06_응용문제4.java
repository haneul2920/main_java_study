package section06;
public class EX06_응용문제4 {

    public static void main(String[] args) {
        int n = 5;  // 5x5 마방진
        int[][] magicSquare = new int[n][n];
        
        // 시작 위치 (0, 2) 설정
        int row = 0;
        int col = 2;
        
        // 1부터 n*n까지 숫자를 채움
        for (int i = 1; i <= n * n; i++) {
            magicSquare[row][col] = i;  // 현재 위치에 숫자 배치
            
            // 다음 위치 계산 (오른쪽 위 대각선)
            int newRow = (row - 1 + n) % n; // 한 행 위로 이동, 범위를 벗어나면 마지막 행으로
            int newCol = (col + 1) % n;     // 한 열 오른쪽으로 이동, 범위를 벗어나면 첫 열로
            
            // 이미 숫자가 있으면 아래로 한 칸 이동
            if (magicSquare[newRow][newCol] != 0) {
                row = (row + 1) % n;
            } else {
                row = newRow;
                col = newCol;
            }
        }
        
        // 마방진 출력
        System.out.println("5x5 마방진 (시작 위치: (0, 2)):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(magicSquare[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
