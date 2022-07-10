package br.com.sda.bootstrap.sdabootstrap.api.app.adapters.`in`.webflux.mapper

import br.com.sda.bootstrap.sdabootstrap.api.core.domain.Name

fun Name.Companion.splitFromString(source: String): Name =
    source.split(" ")
        .let { toTriple(it) }
        .let { Name(it.first, it.second, it.third) }

private fun toTriple(source: List<String>): Triple<String, String, String> {
    val mutableList = source.toMutableList()

    mutableList.removeFirst()
    if (mutableList.size > 0) {
        mutableList.removeLast()
    }

    return Triple(
        source.first(),
        mutableList.joinToString(separator = " "),
        if (source.size > 1) { source.last() } else { "" }
    )
}
