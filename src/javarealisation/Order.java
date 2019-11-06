package javarealisation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Order implements Comparable<Order> {

    int orderId;
    LocalDateTime creationDate;
    List<OrderLines> orderLines=new ArrayList<>();
    static List<Order> orderList=new ArrayList<>();

   static {
       OrderLines ln1=new OrderLines(1,"prod1",5,100);
       OrderLines ln2=new OrderLines(2,"prod2",4,100);
       OrderLines ln3=new OrderLines(3,"prod3",3,100);
       OrderLines ln4=new OrderLines(4,"prod4",2,100);
       OrderLines ln5=new OrderLines(5,"prod5",1,100);
       Order order1=new Order(1,LocalDateTime.of(2019,11,1,10,0,0));
       Order order2=new Order(2,LocalDateTime.of(2019,11,3,9,0,0));
       Order order3=new Order(3,LocalDateTime.of(2019,11,3,9,0,0));
       order1.orderLines.add(ln1);
       order2.orderLines.add(ln2);
       order2.orderLines.add(ln3);
       order3.orderLines.add(ln4);
       order3.orderLines.add(ln5);

orderList.add(order1);
orderList.add(order2);
orderList.add(order3);
    }
    public Order(int orderId, LocalDateTime creationDate) {
        this.orderId = orderId;
        this.creationDate = creationDate;

    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", creationDate=" + creationDate +
                ", orderLines=" + orderLines +
                '}';
    }
    Order(){

    }

    public static void main(String[] args) {
       Order ord=new Order();
        System.out.println(orderList);
        System.out.println(ord.totalDailySales(orderList)+"ASDF");
    }


     Map<DayOfWeek, Integer> totalDailySales(List<Order> orders){

       Map<DayOfWeek,Integer> result=new TreeMap<>();

//           int totalContForDate=0;
           for (Order temp:orders) {
              int countForOrder= countOrder(temp);
              DayOfWeek dayOrder=temp.creationDate.getDayOfWeek();
              Integer value=result.get(dayOrder);
              if(value==null){
                 result.put(dayOrder,countForOrder);
              }else{
                  result.put(dayOrder,value+countForOrder);
              }
              }
     return result;
    }

    private int countOrder(Order temp1) {
       int result=0;
       for(OrderLines tem: temp1.orderLines){
           result+=tem.quantity;
       }

       return result;
    }

    @Override
    public int compareTo(Order o) {

        return this.creationDate.toLocalDate().compareTo(o.creationDate.toLocalDate());
    }

}
