package me.a8kj.mattc.token.attributes;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenLocation {
    private final int column, line, startPosition, endPosition;

    @Override
    public String toString() {
        return String.format("Line %d, Col %d [%d..%d]", line, column, startPosition, endPosition);
    }

}
