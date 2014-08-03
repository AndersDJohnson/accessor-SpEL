package me.andrz.accessor;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class Accessor {

    private Set<Setting> settings = EnumSet.noneOf(Setting.class);

    public static enum Setting {
        AUTO_SAFE_NAVIGATION
    };

    public static final Setting[] DEFAULT_SETTINGS = {
            Setting.AUTO_SAFE_NAVIGATION
    };

    public static final Accessor DEFAULT = new Accessor();

    public Accessor() {
        for (Setting setting : DEFAULT_SETTINGS) {
            settings.add(setting);
        }
    }

    public Object get(Object rootObject, String expression) {
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setRootObject(rootObject);

        if (settings.contains(Setting.AUTO_SAFE_NAVIGATION)) {
            expression = autoSafeNavigation(expression);
        }

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression(expression);

        return exp.getValue(context);
    }

    private String autoSafeNavigation(String expression) {
        return expression.replaceAll("([^\\\\])\\.", "$1?.");
    }

    public void setting(Setting setting, boolean value) {
        if (value == false) {
            settings.remove(setting);
        }
        else {
            settings.add(setting);
        }
    }

    public void setting(Setting setting) {
        settings.add(setting);
    }

}
