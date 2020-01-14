package structural.decorator

class HappyMap<K, V>(private val map: MutableMap<K, V> =                                        mutableMapOf()) :
    MutableMap<K, V> by map {

    override fun put(key: K, value: V): V? {
        return map.put(key, value).apply {
            this?.let { println("Yay! $key") }
        }
    }
}

