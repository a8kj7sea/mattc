package me.a8kj.mattc.tokenizer;

import lombok.RequiredArgsConstructor;
import me.a8kj.mattc.tokenizer.attributes.TokenizerResult;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;

@RequiredArgsConstructor
public abstract class AbstractTokenizer implements Tokenizer {
    protected final String input;

    public abstract TokenizerResult tokenize();

    protected TokenizerContext createContext() {
        return new TokenizerContext(input);
    }
} 
