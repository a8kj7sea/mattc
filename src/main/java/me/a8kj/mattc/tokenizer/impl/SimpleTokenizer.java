package me.a8kj.mattc.tokenizer.impl;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.tokenizer.AbstractTokenizer;
import me.a8kj.mattc.tokenizer.attributes.TokenizerApplyResult;
import me.a8kj.mattc.tokenizer.attributes.TokenizerResult;
import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.mattc.tokenizer.error.TokenizerError;
import me.a8kj.mattc.tokenizer.error.reasons.DefaultTokenizerErrorReason;

import java.util.ArrayList;
import java.util.List;

import lombok.NonNull;

public class SimpleTokenizer extends AbstractTokenizer {

    public SimpleTokenizer(String input) {
        super(input);
    }

    @Override
    public TokenizerResult tokenize() {
        if (input == null || input.isEmpty()) {
            throw new RuntimeException("Loaded code cannot be null or empty.");
        }

        TokenizerContext context = createContext();
        List<Token> tokens = new ArrayList<>();
        List<TokenizerError<?>> errors = new ArrayList<>();

        List<TokenizerRule> rules = getRuleRegistry().getRules();

        while (context.hasNext()) {
            boolean matched = false;

            for (TokenizerRule rule : rules) {
                if (rule.matches(context)) {
                    TokenizerApplyResult result = rule.apply(context);

                    result.getToken().ifPresent(tokens::add);
                    result.getError().ifPresent(errors::add);

                    matched = true;
                    break;
                }
            }

            if (!matched) {
                char unknownChar = context.currentChar();
                errors.add(new TokenizerError<>(
                        DefaultTokenizerErrorReason.UNKNOWN_CHARACTER,
                        context.getLine(),
                        context.getColumn(),
                        "Unknown character: '" + unknownChar + "'"));
                context.advance();
            }
        }

        return new TokenizerResult(tokens, errors);
    }

    @Override
    public TokenizerResult tokenize(@NonNull String input) {
        setInput(input);
        return tokenize();
    }

}
