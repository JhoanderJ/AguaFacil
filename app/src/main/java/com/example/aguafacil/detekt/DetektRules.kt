package com.example.aguafacil.detekt

import io.gitlab.arturbosch.detekt.api.CodeSmell
import io.gitlab.arturbosch.detekt.api.Config
import io.gitlab.arturbosch.detekt.api.Debt
import io.gitlab.arturbosch.detekt.api.Entity
import io.gitlab.arturbosch.detekt.api.Issue
import io.gitlab.arturbosch.detekt.api.Rule
import io.gitlab.arturbosch.detekt.api.Severity
import org.jetbrains.kotlin.psi.KtNamedFunction

class DetektRules(config: Config) : Rule(config) {

    override val issue = Issue(
        javaClass.simpleName, Severity.CodeSmell, "Detects hard-coded values in the code",
        Debt.TWENTY_MINS
    )

    override fun visitNamedFunction(function: KtNamedFunction) {
        super.visitNamedFunction(function)
        if (containsHardCodedValues(function)) {
            report(
                CodeSmell(
                    issue,
                    Entity.from(function),
                    "This function may contain hard-code values"
                )
            )
        }
    }

    private fun containsHardCodedValues(function: KtNamedFunction): Boolean {
        val bodyText = function.bodyExpression?.text ?: ""
        return bodyText.contains("\"") || bodyText.contains(
            "\'"
        )
    }
}