package me.a8kj.mattc.tokenizer.error.reasons;

import me.a8kj.mattc.tokenizer.error.TokenizerErrorReason;

public enum DefaultTokenizerErrorReason implements TokenizerErrorReason {
    UNKNOWN_CHARACTER {
        @Override
        public String description() {
            return "Character not recognized by any tokenizer rule.";
        }
    }

}
