package me.a8kj.mattc.tokenizer.exception;

import lombok.Getter;
import me.a8kj.mattc.tokenizer.error.TokenizerError;

@Getter
public class TokenizerException extends RuntimeException {

    private final TokenizerError<?> error;

    public TokenizerException(TokenizerError<?> error) {
        super(error.toString());
        this.error = error;
    }

}
