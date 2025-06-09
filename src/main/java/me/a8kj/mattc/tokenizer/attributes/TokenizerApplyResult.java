package me.a8kj.mattc.tokenizer.attributes;

import java.util.Optional;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.tokenizer.error.TokenizerError;

@RequiredArgsConstructor
@Getter
public class TokenizerApplyResult {
    private final Optional<Token> token;
    private final Optional<TokenizerError<?>> error;

    public static TokenizerApplyResult success(Token token) {
        return new TokenizerApplyResult(Optional.of(token), Optional.empty());
    }

    public static TokenizerApplyResult failure(TokenizerError<?> error) {
        return new TokenizerApplyResult(Optional.empty(), Optional.of(error));
    }

}
