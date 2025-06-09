package me.a8kj.mattc.tokenizer.regisrty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.a8kj.mattc.tokenizer.attributes.TokenizerRule;
public final class RuleRegistry {

    private static final RuleRegistry INSTANCE = new RuleRegistry();

    private final List<TokenizerRule> rules;

    private RuleRegistry() {
        this.rules = new ArrayList<>();
    }

    public static RuleRegistry getInstance() {
        return INSTANCE;
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

