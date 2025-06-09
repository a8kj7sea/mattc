package me.a8kj.mattc.tokenizer.registry;

import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class RuleRegistry {

    private final List<TokenizerRule> rules;

    public RuleRegistry() {
        this.rules = new ArrayList<>();
    }

    public void addRule(TokenizerRule rule) {
        rules.add(rule);
    }

    public void removeRule(TokenizerRule rule) {
        rules.remove(rule);
    }

    public void clearRules() {
        rules.clear();
    }

    public List<TokenizerRule> getRules() {
        return Collections.unmodifiableList(rules);
    }
}
