package me.a8kj.mattc.tokenizer;

import lombok.NonNull;
import me.a8kj.mattc.tokenizer.attributes.TokenizerResult;

public interface Tokenizer {
    TokenizerResult tokenize();
    TokenizerResult tokenize(@NonNull String input);
}
