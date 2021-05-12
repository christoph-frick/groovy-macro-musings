package net.ofnir.groovymacromusings.macros

import org.codehaus.groovy.ast.expr.ArgumentListExpression
import org.codehaus.groovy.ast.expr.Expression
import org.codehaus.groovy.ast.expr.MethodCallExpression
import org.codehaus.groovy.ast.expr.VariableExpression
import org.codehaus.groovy.ast.tools.GeneralUtils
import org.codehaus.groovy.macro.runtime.Macro
import org.codehaus.groovy.macro.runtime.MacroContext

class ThreadingMacroMethods {

    @Macro
    static Expression threadFirst(MacroContext ctx, final Expression... exps) {
        return exps.tail().inject(exps.first()) { acc, e ->
            toCall(e).with { c ->
                new MethodCallExpression(c.objectExpression, c.method, new ArgumentListExpression([acc] + c.arguments))
            }
        }
    }

    static MethodCallExpression toCall(MethodCallExpression e) {
        return e
    }

    static MethodCallExpression toCall(VariableExpression e) {
        return GeneralUtils.callThisX(e.name)
    }

}
