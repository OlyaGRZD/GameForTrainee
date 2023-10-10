import kotlin.math.max
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.system.exitProcess

open class Creature(
    val name: String,
    var defense: Byte,
    var attack: Byte,
    var health: Int,
    val damageRange: IntRange
){
    val maxHeal = health
    init {
        require(attack in 1..30) { "Атака должна быть в диапазоне от 1 до 30" }
        require(defense in 1..30) { "Защита должна быть в диапазоне от 1 до 30" }
        require(health >= 0) { "Здоровье не может быть отрицательным" }
        require(damageRange.first >= 1 && damageRange.last >= damageRange.first) {
            "Диапазон урона должен быть корректным"
        }

    }

    // Метод атаки на противника
    open fun Damage(target: Creature){
        val attackModifier = max(attack - target.defense + 1,1)
        val success = attackModifier > 0 && (1..attackModifier)
            .any { Random.nextInt(1, 7) in listOf(5, 6) }
        if(success){
            val damage = Random.nextInt(damageRange)
            println("$name успешно атакует ${target.name} и наносит $damage урона.")
            target.takeDamage(damage)
        } else {
            println("$name не смог атаковать ${target.name}.")
        }
    }

    // Метод получения урона
    open fun takeDamage(damage: Int) {
        health -= damage
        if (health > 0) {
            println("Теперь у $name $health единиц здоровья.\n")
        } else{
            println("Увы, $name умер:(\nКонец игры!")
            exitProcess(-1)
        }
    }

    // Метод исцеления
    open fun heal() {
        if (health > 0) {
            val healAmount = (maxHeal * 0.3).toInt()
            println("$name исцеляется на $healAmount единиц здоровья.")
            health += healAmount
            println("Теперь у $name $health единиц здоровья.")
        } else {
            println("$name уже мертв и не может быть исцелен.")
        }
    }
}