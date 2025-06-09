package me.a8kj.mattc.token.impl;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.token.attributes.TokenCategory;
import me.a8kj.mattc.token.attributes.TokenLocation;

@Data
@RequiredArgsConstructor
public class LexerToken implements Token {
    private final String value;
    private final Enum<? extends TokenCategory> kind;
    private final TokenLocation location;

    @Override
    public String toString() {
        return String.format("Token(type=%s, value='%s', line=%d, column=%d)",
                kind, value, location.getLine(), location.getColumn());
    }

}
