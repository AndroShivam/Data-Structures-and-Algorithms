class Solution {
    public int numTrees(int n) {
        
        int[] G = new int[n + 1];
        G[0] = G[1] = 1;
        
        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}

// F(i, n) = G(i - 1) * G(n - i) , Where i is the root
// let say n = 3
//      G(n)
//   /    \       \
// F(1,3)  F(2,3)  F(3,3)
// /   \      /  \     /   \
// G(0) G(2) G(1) G(1) G(2) G(0)

// G(0) = nothing on the left side
// G(2) = there are two possibilities