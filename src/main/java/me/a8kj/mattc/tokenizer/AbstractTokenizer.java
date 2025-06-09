package me.a8kj.mattc.tokenizer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.mattc.tokenizer.registry.RuleRegistry;

@AllArgsConstructor
public abstract class AbstractTokenizer implements Tokenizer {
    
    @Setter
    protected String input;

    @Getter
    protected final RuleRegistry ruleRegistry = new RuleRegistry();

    protected TokenizerContext createContext() {
        return new TokenizerContext(input != null ? input : "");
    }
}
