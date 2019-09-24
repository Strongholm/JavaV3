package HomeWorkTask_2_3;

public class Task2 {

    public static void main(String[] args) {

        int[] a = {1,2,3,4,5,6,7,8,9};
        int[] b = {1,2,3,5,6,7,8,9};
        int[] c = {1,2,4,3,4,5,4,6,7};
        int[] d = {1,2,3,4};
        int[] f = {};

        System.out.println("Test A");
        try {
            int[] aa = task(a);
            for (int i = 0; i < aa.length; i++) {
                System.out.print(aa[i]);
                System.out.print(' ');
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        System.out.println("Test B");
        try {
            int[] bb = task(b);
            for (int i = 0; i < bb.length; i++) {
                System.out.print(bb[i]);
                System.out.print(' ');
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        System.out.println("Test C");
        try {
            int[] cc = task(c);
            for (int i = 0; i < cc.length; i++) {
                System.out.print(cc[i]);
                System.out.print(' ');
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        System.out.println("Test D");
        try {
            int[] dd = task(d);
            for (int i = 0; i < dd.length; i++) {
                System.out.print(dd[i]);
                System.out.print(' ');
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();

        System.out.println("Test F");
        try {
            int[] ff = task(f);
            for (int i = 0; i < ff.length; i++) {
                System.out.print(ff[i]);
                System.out.print(' ');
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static int[] task(int[] start) throws RuntimeException {
        int i = start.length - 1;
        while (start[i] != 4)
            i--;
        i++;
        int[] result = new int[start.length - i];
        for (int j = 0; j < result.length; j++) {
            result[j] = start[j + i];
        }
        return result;
    }

}
