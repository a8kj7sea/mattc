package me.a8kj.mattc.tokenizer.context;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

@Getter
@RequiredArgsConstructor
@Setter
public class TokenizerContext {
    private final String input;
    private int position = 0;
    private int line = 1;
    private int lineStart = 0;

    private final Deque<Integer> positionStack = new ArrayDeque<>();
    private final Deque<Integer> lineStack = new ArrayDeque<>();
    private final Deque<Integer> lineStartStack = new ArrayDeque<>();

    public boolean hasNext() {
        return position < input.length();
    }

    public char currentChar() {
        return hasNext() ? input.charAt(position) : '\0';
    }

    public char peek() {
        return peek(1);
    }

    public char peek(int ahead) {
        int index = position + ahead;
        return (index < input.length()) ? input.charAt(index) : '\0';
    }

    public void advance() {
        if (!hasNext())
            return;

        char ch = input.charAt(position++);
        if (ch == '\n') {
            line++;
            lineStart = position;
        }
    }

    public void retreat() {
        if (position > 0) {
            position--;
            if (input.charAt(position) == '\n') {
                line--;
            }
        }
    }

    public void mark() {
        positionStack.push(position);
        lineStack.push(line);
        lineStartStack.push(lineStart);
    }

    public void resetToMark() {
        if (!positionStack.isEmpty()) {
            position = positionStack.pop();
            line = lineStack.pop();
            lineStart = lineStartStack.pop();
        }
    }

    public void skipWhile(Predicate<Character> condition) {
        while (hasNext() && condition.test(currentChar())) {
            advance();
        }
    }

    public void skipWhitespace() {
        skipWhile(Character::isWhitespace);
    }

    public String substring(int start, int end) {
        return input.substring(start, end);
    }

    public int getColumn() {
        return position - lineStart + 1;
    }

    public String getCurrentLine() {
        int lineEnd = input.indexOf('\n', lineStart);
        if (lineEnd == -1)
            lineEnd = input.length();
        return input.substring(lineStart, lineEnd);
    }
}
