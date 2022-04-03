import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ServiceTest {
    var car= MyCollect().cars
    var serv=Service(car)
    @Test
    fun toEnglish() {
        var priceCourse=75
        var right=listOf(Car("Kia", "Rio", "np", 167890.90*priceCourse, 7.85),
            Car("Toyota", "Corolla", "pr", 230000.95*priceCourse, 6.7),
            Car("Mitsubishi", "Eclipse", "np", 456700.95*priceCourse, 7.7),
            Car("Toyota", "Mark 2", "pr", 1030000.0*priceCourse, 5.6),
            Car("Ford", "Mustang", "pr", 5678049.5*priceCourse, 8.4))
        var actual = serv.toEnglish()
        assertEquals(right, actual)
    }

    @Test
    fun groupByBody() {
        val right=mapOf(
            "пр" to listOf(
                Car("Тойота", "Королла", "пр", 230000.95, 6.7),
                Car("Тойота", "Марк 2", "пр", 1030000.0, 5.6),
                Car("Форд", "Мустанг", "пр", 5678049.5, 8.4)
            ),
            "нп" to listOf(
                Car("Митсубиси", "Эклипс", "нп", 456700.95, 7.7),
                Car("Киа", "Рио", "нп", 167890.90, 7.85))
            )
        val actual= serv.groupByBody()
        assertEquals(right, actual)
    }

    @Test
    fun filterByPredicate() {
        val right= listOf("Королла", "Марк 2")
        val actual= serv.filterByPredicate { Car -> Car.gasoline<7 }
        assertEquals(right, actual)
    }
}