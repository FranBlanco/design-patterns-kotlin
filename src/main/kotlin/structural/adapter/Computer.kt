package structural.adapter

interface EUPlug
interface USPlug

fun USPlug.toEUPlug() : EUPlug {
    return object : EUPlug {}
}

fun EUPlug.toUSPlug() : USPlug {
    return object : USPlug {}
}