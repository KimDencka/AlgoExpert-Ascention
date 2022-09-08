package dencka.kim.easy.other;

class RunLengthEncoding {
    public static void main(String[] args) {
        var input = "AAAAAAAAAAAAABBCCCCDD";
        System.out.println(runLengthEncoding(input));
    }

    public static String runLengthEncoding(String string) {
        StringBuilder res = new StringBuilder();
        char cur = string.charAt(0);
        int cnt = 0;

        for (char ch : string.toCharArray()) {
            if (cnt == 9 || cur != ch) {
                res.append(cnt).append(cur);
                cur = ch;
                cnt = 0;
            }
            cnt++;
        }
        if (cnt != 0) res.append(cnt).append(cur);

        return res.toString();
    }
}
