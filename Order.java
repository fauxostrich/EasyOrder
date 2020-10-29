public class Order
{
   private String name;
   private String phone;
   private String date;
   private String time;
   private String order;
   private boolean complete;
   
   public Order(String customerName, String customerPhone, String customerDate, String customerOrder)
   {
      name = customerName;
      phone = customerPhone;
      date = customerDate;
      order = customerOrder;
   }
   
   public Order(String customerName, String customerPhone, String customerDate, String customerOrder, String customerTime)
   {
      name = customerName;
      phone = customerPhone;
      date = customerDate;
      order = customerOrder;
      time = customerTime;
   }
   
   public void setComplete(boolean isComplete)  { complete = isComplete; }
   public boolean getComplete()                 { return complete; }
   
   public String toString()
   {
      String result;
      if( time == null )
             result =   "Customer Name: \t"  + name  + "\n" +
                        "Customer Phone:\t"  + phone + "\n" +
                        "Pick-Up Date:  \t"  + date  + "\n" +
                        "Order:         \t"  + order;
      else
            result =    "Customer Name: \t"  + name  + "\n" +
                        "Customer Phone:\t"  + phone + "\n" +
                        "Pick-Up Date:  \t"  + date  + "\n" +
                        "Pick-Up Time:  \t"  + time  + "\n" +
                        "Order:         \t"  + order;
                        
     return result;
   }
}