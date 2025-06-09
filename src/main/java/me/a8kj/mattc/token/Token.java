package me.a8kj.mattc.token;

import me.a8kj.mattc.token.attributes.TokenCategory;
import me.a8kj.mattc.token.attributes.TokenLocation;

public interface Token {

    String getValue();

    Enum<? extends TokenCategory> getKind();

    TokenLocation getLocation();

}
