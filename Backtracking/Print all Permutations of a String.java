import java.util.*;

class LearningDS {
    public static void main(String[] args) {

        String str = "ABC";
        List<String> result = new ArrayList<>();
        permute(str, result, 0, str.length() - 1);

        System.out.println(result);
    }

    private static void permute(String str, List<String> result, int left, int right) {
        if (left == right)
            result.add(str);
        else {
            for (int i = left; i <= right; i++) {
                str = swap(str, left, i);
                permute(str, result, left + 1, right);
                str = swap(str, left, i); // backtrack
            }
        }
    }

    private static String swap(String str, int i, int j) {
        char[] c = str.toCharArray();

        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;

        return new String(c);
    }

}