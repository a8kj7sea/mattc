package me.a8kj.mattc.tokenizer.attributes;

import me.a8kj.mattc.tokenizer.context.TokenizerContext;

public interface TokenizerRule {
    boolean matches(TokenizerContext context);

    TokenizerApplyResult apply(TokenizerContext context);
}

