// Time Complexity: O(V) // int coin
// Space Complexity - O(1) 

class LearningDS {
    public static void main(String[] args) {
        int deno[] = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int n = deno.length;

        findMin(49, deno, deno.length);
    }

    private static void findMin(int coin, int[] deno, int n) {

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = n - 1; i >= 0; i--) {
            while (coin >= deno[i]) {
                coin = coin - deno[i];
                result.add(deno[i]);
            }
        }

        System.out.println(result);
    }
}