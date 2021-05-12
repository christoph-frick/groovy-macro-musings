package net.ofnir.groovymacromusings.macros

import org.codehaus.groovy.ast.expr.Expression
import org.codehaus.groovy.ast.expr.MapEntryExpression
import org.codehaus.groovy.ast.expr.MapExpression
import org.codehaus.groovy.ast.tools.GeneralUtils
import org.codehaus.groovy.macro.runtime.Macro
import org.codehaus.groovy.macro.runtime.MacroContext

class MacroMethods {
    @Macro
    static Expression mapOf(MacroContext ctx, final Expression... exps) {
        return new MapExpression(
            exps.collect {
                new MapEntryExpression(GeneralUtils.constX(it.getText()), it)
            }
        )
    }
}
