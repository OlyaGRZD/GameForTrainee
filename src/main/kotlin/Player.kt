class Player(
    name: String,
    attack: Byte,
    defense: Byte,
    health: Int,
    damageRange: IntRange
) : Creature(name, attack, defense, health, damageRange) {
    private var healCount = 0

    override fun heal(){
        if(healCount < 4){
            super.heal()
            healCount++
        } else {
            println("$name больше не может исцеляться:(")
        }
    }
}