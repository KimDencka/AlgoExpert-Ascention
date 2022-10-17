package dencka.kim.easy.strings;

class CaesarCipherEncryptor {
    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            int code = str.charAt(i) + (key % 26);
            if (code > 'z') {
                code -= 26;
            }

            res.append((char) code);
        }
        return res.toString();
    }
}
