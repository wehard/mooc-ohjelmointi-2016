
public class Main {

    public static void main(String[] args) {
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(muotoile(t));
    }

    public static String muotoile(int[] t) {
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < t.length; i++) {
            if (i % 4 == 0) {
                sb.append("\n ");
            }
            if (i < t.length - 1) {
                sb.append(t[i] + ", ");
            } else {
                sb.append(t[i]);
            }
        }
        sb.append("\n}");
        return sb.toString();
    }
}
