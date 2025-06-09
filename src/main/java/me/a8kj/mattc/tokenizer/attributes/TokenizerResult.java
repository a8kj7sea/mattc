package me.a8kj.mattc.tokenizer.attributes;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.tokenizer.error.TokenizerError;
import me.a8kj.mattc.tokenizer.error.TokenizerErrorReason;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenizerResult {
    private final List<Token> tokens;
    private final List<TokenizerError<? extends TokenizerErrorReason>> errors;

    public boolean hasErrors() {
        return errors != null && !errors.isEmpty();
    }
}
