package me.a8kj.mattc.tokenizer.scanner;

import me.a8kj.mattc.tokenizer.context.TokenizerContext;
import me.a8kj.mattc.tokenizer.scanner.attributes.ScannerKind;

public interface TokenizerScanner<Result> {
    ScannerKind getKind();

    Result tokenize(TokenizerContext context);
}
