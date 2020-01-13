package creational.factory_method

import kotlin.random.Random

interface Animal {
    val name: String
}

class Cat : Animal {
    override val name = "Cat"
}

class Dog(race: DogRaces) : Animal {
    override val name = "Dog"

}

class AnimalFactory {
    private val dogFactory = DogFactory()
    fun createAnimal(animalType: String): Animal {
        return when (animalType.trim().toLowerCase()) {
            "cat" -> Cat()
            "dog" -> dogFactory.createDog()
            else -> throw RuntimeException("Unknown animal $animalType")
        }
    }
}

class DogFactory{
    fun createDog() = Dog(DogRaces.values()[Random.nextInt(DogRaces.values().size)])
}
enum class DogRaces {
    DOBERMAN, MIXED, SHEPHERD, TERRIER
}
