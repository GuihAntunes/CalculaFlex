package br.com.guilhermeantunes.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)