class LearningDS {
    public static void main(String[] args) {

        String str = "HELLO WORLD!";

        String lowerCaseString = toLowerCase(str);
        System.out.println(lowerCaseString);
    }

    private static String toLowerCase(String str) {
        char[] c = str.toCharArray();

        for (int i = 0; i < str.length(); i++) {
            if (c[i] >= 'A' && c[i] <= 'Z')
                c[i] = (char) (c[i] - 'A' + 'a');
        }
        return new String(c);
    }
}