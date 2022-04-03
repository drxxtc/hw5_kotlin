@Suppress("UNUSED_EXPRESSION")
class Service(cars: List<Car>) {
    var car= cars.asSequence()
    var priceCourse=75
    // перевод на английский названий и цену по курсу
    fun toEnglish()=
        car.map {
            Car(
                translate(it.brand),
                translate(it.name),
                translate(it.body),
                it.price*priceCourse,
                it.gasoline
            )}.sortedBy { it.price }.toList()
    //группировка по типу кузова
    fun groupByBody()= car.groupBy { it.body }

    //фильтрация по предикату
    fun filterByPredicate(pred: (Car) -> Boolean)=
        car.filter(pred).map { it.name }.take(3).toList()

    //переводчик
    private fun translate(word:String): String {
        val translates = when (word){
            "Тойота" -> "Toyota"
            "Митсубиси" -> "Mitsubishi"
            "Киа" -> "Kia"
            "Форд" -> "Ford"
            "Марк 2" -> "Mark 2"
            "Мустанг" -> "Mustang"
            "Королла" -> "Corolla"
            "Эклипс" -> "Eclipse"
            "Рио" -> "Rio"
            "нп" -> "np"
            "пр" -> "pr"
            else -> {"Nope"}
        }
        return translates
    }
}

