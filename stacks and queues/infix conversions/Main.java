import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        // code
        Stack<String> postfix = new Stack<>();
        Stack<Character> optors = new Stack<>();
        Stack<String> prefix = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);

            if (ch == '(') {
                optors.push(ch);
            } else if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                postfix.push(ch + "");
                prefix.push(ch + "");
            } else if (ch == ')') {
                while (optors.peek() != '(') {
                    char optor = optors.pop();

                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postv = postv1 + postv2 + optor;
                    postfix.push(postv);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String prev = optor + prev1 + prev2;
                    prefix.push(prev);
                }
                optors.pop();
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (optors.size() > 0 && optors.peek() != '(' && precedence(ch) <= precedence(optors.peek())) {
                    char optor = optors.pop();

                    String postv2 = postfix.pop();
                    String postv1 = postfix.pop();
                    String postv = postv1 + postv2 + optor;
                    postfix.push(postv);

                    String prev2 = prefix.pop();
                    String prev1 = prefix.pop();
                    String prev = optor + prev1 + prev2;
                    prefix.push(prev);
                }
                optors.push(ch);
            }
        }
        while (optors.size() != 0) {
            char optor = optors.pop();
            String postv2 = postfix.pop();
            String postv1 = postfix.pop();
            String postv = postv1 + postv2 + optor;
            postfix.push(postv);

            String prev2 = prefix.pop();
            String prev1 = prefix.pop();
            String prev = optor + prev1 + prev2;
            prefix.push(prev);
        }
        System.out.println(postfix.pop());
        System.out.println(prefix.pop());
    }

    public static int precedence(char optor) {
        if (optor == '+') {
            return 1;
        } else if (optor == '-') {
            return 1;
        } else if (optor == '*') {
            return 2;
        } else {
            return 2;
        }
    }
}