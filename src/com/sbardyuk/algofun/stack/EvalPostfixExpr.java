package com.sbardyuk.algofun.stack;

import java.util.Stack;

public class EvalPostfixExpr {
    private static int evaluatePostFix(String expression) {
        Stack<Integer> stack = new Stack<>();

        for(char ch : expression.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                stack.push(Character.getNumericValue(ch));
            } else {
                int val2 = stack.pop();
                int val1 = stack.pop();

                int res;
                switch(ch) {
                    case '-': res = val1 - val2; break;
                    case '+': res = val1 + val2; break;
                    case '/': res = val1 / val2; break;
                    case '*': res = val1 * val2; break;
                    default: throw new IllegalStateException("unknown op");
                }

                stack.push(res);
            }
        }

        return stack.pop();

    }

    public static void main(String[] args) {
        System.out.println(evaluatePostFix("96-2*"));
        System.out.println(evaluatePostFix("921*-8-4+"));
    }
}
