import java.util.Scanner
fun main(){
    val monster = Monster("Монстр", 15, 5, 8, 1..6)
    val player = Player("Olga", 15, 5, 15, 1..6)
    val scanner = Scanner(System.`in`)

    println("Приветствуем вас в новой игре!")
    while (monster.health > 0 || player.health > 0){
        println("Выберите свое действие: " +
                "\n1) Атака" +
                "\n2) Восстановить здоровье")

        var choose = scanner.nextInt()
        when(choose){
            1 -> {
                player.Damage(monster)
                monster.Damage(player)
            }

            2 -> {
                player.heal()
                monster.Damage(player)
            }
            else -> println("Введите корректное значение")
        }
    }
}

