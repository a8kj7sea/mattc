package me.a8kj.mattc.utils;

import me.a8kj.mattc.token.Token;
import me.a8kj.mattc.tokenizer.attributes.TokenizerResult;

public class TokenizerOutputFormatter {

    public static String format(TokenizerResult result) {
        StringBuilder output = new StringBuilder();

        output.append("========== Tokens ==========\n");
        output.append(String.format("%-20s | %-15s | %s\n", "Value", "Category", "Location"));
        output.append("-------------------------------------------------------------\n");

        for (Token token : result.getTokens()) {
            output.append(String.format("%-20s | %-15s | %s\n",
                    token.getValue(),
                    token.getKind().name(),
                    token.getLocation().toString()));
        }

        if (result.hasErrors()) {
            output.append("\n========== Errors ==========\n");
            result.getErrors().forEach(error -> output.append("• ").append(error.getMessage()).append("\n"));
        }

        return output.toString();
    }
}
