package me.a8kj.mattc.tokenizer.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class TokenizerError<T extends TokenizerErrorReason> {

    private final T reason;
    private final int line;
    private final int column;
    private final String message;

    @Override
    public String toString() {
        return String.format("Error [%s] at line %d, column %d: %s",
                reason.name(), line, column, message);
    }
}
