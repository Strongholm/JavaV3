package HomeWorkTask_2_3;

public class Task3 {

    public static void main(String[] args) {
        int[][] a = {{1,1,4,1,4},{1,2,3,4,5},{2,2,3,3,5},{}};
        try {
            boolean[] aa = task(a);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean[] task(int[][] start) throws RuntimeException {
        boolean[] result = new boolean[start.length];
        for (int i = 0; i < start.length; i++) {
            System.out.println("Test " + (i + 1));
            boolean b = false;
            for (int j = 0; j < start[0].length; j++) {
                if ((start[i][j] == 1) || (start[i][j] == 4))
                    b = true;
            }
            result[i] = b;
            System.out.println(b);
            System.out.println();
        }
        return result;
    }

}
