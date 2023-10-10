class Monster(
    name: String,
    attack: Byte,
    defense: Byte,
    health: Int,
    damageRange: IntRange
) : Creature(name, attack, defense, health, damageRange) {
}