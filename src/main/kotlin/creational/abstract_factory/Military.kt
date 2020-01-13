package creational.abstract_factory



interface Unit

interface Vehicle : Unit

interface Infantry : Unit

interface HQ {
    fun buildBarracks(): Building<InfantryUnits, Infantry>
    fun buildVehicleFactory(): Building<VehicleUnits, Vehicle>
}

interface Building<in UnitType, out ProducedUnit>
        where UnitType : Enum<*>, ProducedUnit : Unit {
    fun build(type: UnitType) : ProducedUnit
}

class Rifleman : Infantry

class RocketSoldier : Infantry

enum class InfantryUnits {
    RIFLEMEN,
    ROCKET_SOLDIER
}

class APC : Vehicle

class Tank : Vehicle

enum class VehicleUnits {
    APC,
    TANK
}

class Barracks : Building<InfantryUnits, Infantry> {
    override fun build(type: InfantryUnits): Infantry {
        return when (type) {
            InfantryUnits.RIFLEMEN -> Rifleman()
            InfantryUnits.ROCKET_SOLDIER -> RocketSoldier()
        }
    }
}

class VehicleFactory : Building<VehicleUnits, Vehicle> {
    override fun build(type: VehicleUnits) = when (type) {
        VehicleUnits.APC -> APC()
        VehicleUnits.TANK -> Tank()
    }
}

class RussianHQ : HQ {
    override fun buildBarracks(): Building<InfantryUnits, Infantry> {
        TODO("not implemented")
    }

    override fun buildVehicleFactory(): Building<VehicleUnits, Vehicle> {
        TODO("not implemented")
    }
}

class AmericanHQ : HQ {
    override fun buildBarracks(): Building<InfantryUnits, Infantry> {
        TODO("not implemented")
    }

    override fun buildVehicleFactory(): Building<VehicleUnits, Vehicle> {
        TODO("not implemented")
    }
}


