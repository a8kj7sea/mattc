package me.a8kj.mattc.utils.regex;

import java.util.regex.Pattern;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

public abstract class RegexScanner {

    final String regex;
    final Pattern pattern;

    @Getter
    @Setter
    String text;

    protected RegexScanner(final @NonNull String regex, @NonNull String text) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
        this.text = text;
    }

    protected RegexScanner(final @NonNull String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex);
        this.text = null;
    }

    public boolean matches() {
        return pattern.matcher(text).matches();
    }

}