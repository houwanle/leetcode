package com.lele.leetcode;

import java.util.Stack;

/**
 * @author: lele
 * @date: 2023/5/29 19:03
 * @description: 有效的括号
 *
 * 题目描述：给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *  左括号必须用相同类型的右括号闭合。
 *  左括号必须以正确的顺序闭合。
 *  每个右括号都有一个对应的相同类型的左括号。
 *
 * 通过判断出栈的元素与当前元素是否相等及最终栈是否为空，判断该字符串是否有效。
 */

public class IsValid {
    public static void main(String[] args) {
        String s = "([{}])";
        System.out.println(isValid(s));
    }

    public static boolean isValid (String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] charArray = s.toCharArray();

        for(char ch : charArray) {
            //如果是左括号则直接入栈
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty()) {
                    if(ch == ')') {
                        if(stack.pop() != '(') {
                            return false;
                        }
                    } else if(ch == ']') {
                        if(stack.pop() != '[') {
                            return false;
                        }
                    } else if(ch == '}') {
                        if(stack.pop() != '{') {
                            return false;
                        }
                    }
                } else { //此时栈为空，但却来了个右括号，也直接返回false
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
