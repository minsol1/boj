import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] arr;
    public static int N;
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static boolean bfs(int min, int max) {
        if (arr[0][0] < min || arr[0][0] > max) return false;

        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = now[0] + dx[d];
                int ny = now[1] + dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (!visited[nx][ny] && arr[nx][ny] >= min && arr[nx][ny] <= max) {
                    if (nx == N - 1 && ny == N - 1) return true;
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int left = 0;
        int right = 200; // 주어진 조건에 따라 최대값을 설정합니다.
        int result = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            boolean found = false;
            for (int i = 0; i + mid <= 200; i++) {
                if (bfs(i, i + mid)) {
                    found = true;
                    break;
                }
            }

            if (found) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
