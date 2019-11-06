import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.*
import kotlin.collections.Map as Map1


data class Order(val orderId: Int, val creationDate: LocalDateTime, val orderLines: List<OrderLine>)
data class OrderLine(val productId: Int, val name: String, val quantity: Int, val unitPrice: Int)


class OrdersAnalyzer {
    internal fun totalDailySales(orders: List<Order>): TreeMap<DayOfWeek, Int> {
        val result = TreeMap<DayOfWeek, Int>()
        for (temp in orders) {
            val countForOrder = countOrder(temp)
            val dayOrder = temp.creationDate.dayOfWeek
            val valueOfDay = result[dayOrder]
            if (valueOfDay == null) {
                result[dayOrder] = countForOrder
            } else {
                result[dayOrder] = valueOfDay + countForOrder
            }
        }
        println(result)
        return result;
    }

    fun countOrder(temp1: Order): Int {
        var valueOfOrder = 0
        for (temp in temp1.orderLines) {
            valueOfOrder += temp.quantity
        }
        return valueOfOrder
    }


}

fun main() {
    val orderLines = OrderLine(1234, "pen", 4, 4)
    val orderLines2 = OrderLine(4567, "Pencil", 4, 4)
    val orderLines3 = OrderLine(7643, "Marker", 4, 4)
    val orderLines4 = OrderLine(6428, "Eraser", 4, 4)

    val order1 = Order(554, LocalDateTime.of(2017, 3, 23, 13, 0), listOf(orderLines, orderLines2))
    val order2 = Order(555, LocalDateTime.of(2017, 3, 25, 12, 0), listOf(orderLines2, orderLines3))
    val order3 = Order(554, LocalDateTime.of(2017, 3, 23, 13, 0), listOf(orderLines4, orderLines))
    val ordersAnalyzer = OrdersAnalyzer().totalDailySales(listOf(order1, order2, order3))

}
