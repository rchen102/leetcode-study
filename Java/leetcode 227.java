class Solution {
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            queue.offer(ch);
        }
        return calculate(queue);
    }

    int calculate(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            if (isdigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            // 递归处理括号
            if (ch =='(') {
                // 开始递归计算
                num = calculate(queue);
            }
            
            // 注意，如果是最后一个元素，也需要将前一组计算入栈了
            // 因此，这里也不是 else if
            if (!isdigit(ch) || queue.isEmpty()) {
                switch(sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                }
                // 准备下一轮计算
                sign = ch;
                num = 0;
            }
            // 必须，放在后面，举例：(1+(4+5)-3) 需要让，-3 先入栈
            if (ch == ')') {
                break;
                // 直接跳出循环，返回当前已经完成计算的部分
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    boolean isdigit(char ch) {
        return Character.isDigit(ch);
    }
}


//Solution1: stack T: O(n) S: O(n)
class Solution {
    public int calculate(String s) {
        if(s.length() == 0 || s == null) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            if(Character.isDigit(s.charAt(i)))
                num = num * 10 + s.charAt(i) - '0';
            if(!Character.isDigit(s.charAt(i)) && s.charAt(i) != ' ' || i == s.length() - 1) {
                if(sign == '+') stack.push(num);
                if(sign == '-') stack.push(-num);
                if(sign == '*') stack.push(stack.pop() * num);
                if(sign == '/') stack.push(stack.pop() / num);
                sign = s.charAt(i);
                num = 0;
            }
        }
        int sum = 0;
        for(int i : stack)
            sum += i;
        return sum;
    }
}