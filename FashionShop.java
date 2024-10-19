import java.util.*;

class Orders {
    
    private String orderId;
    private String contactNumber;
    private String size;
    private int qty;
    private double ammount;
    private int status;

    Orders(String orderId ,  String contactNumber, String size, int qty,double ammount,  int status ){
        this.orderId=orderId;
        this.contactNumber=contactNumber;
        this.size=size;
        this.qty=qty;
        this.ammount=ammount;
        this.status=status;
    }

    public Orders() {
        this.orderId = "";
        this.contactNumber = "";
        this.size = "";
        this.qty = 0;
        this.ammount = 0.0;
        this.status = 0;
    }

    ///////////////// seters ///////////////////
    public void setorderId(String orderId){
        this.orderId=orderId;
    }
    public void setcontactNumber(String contactNumber){
        this.contactNumber=contactNumber;
    }
    public void setsize(String size){
        this.size=size;
    }
    public void setammount(double ammount){
        this.ammount= ammount;
    }
    public void setstatus(int status){
        this.status=status;
    }
    public void setqty(int qty){
        this.qty=qty;
    }
    ///////////////// Geters ///////////////////
    public String getorderId(){
        return orderId;
    }
    public String getcontactNumber(){
        return contactNumber;
    }
    public String getsize(){
        return size;
    }
    public int getqty(){
        return qty;
    }
    public double getammount(){
        return ammount;
    }
    public int getstatus(){
        return status;
    }

}

public class FashionShop {
    
    public static Scanner input = new Scanner(System.in);

    static int lastOrderId = 0;
    static final int PROCESSING = 0;
    static final int DELIVERING = 1;
    static final int DELIVERED = 2;

    public static Orders orderarray[] = new Orders[0];
    public static final double XS = 600;
    public static final double S = 800;
    public static final double M = 900;
    public static final double L = 1000;
    public static final double XL = 1100;
    public static final double XXL = 1200;

    public static void main(String[] args) { 
            do {
            int option = homePage();
            switch (option) {
                case 1: placeOrder();break;
                case 2: searchCustomer();break;
                case 3: searchOrder();break;
                case 4: viewReport();break;
                case 5: changeOrderStatus();break;
                case 6: deleteOrder();break;
                default:System.out.println("\t\t Invalid option. Try again....");break;           
            }
        }while (true);
        
    }



///////////////////////////////////////////////////////////////////////  view report  //////////////////////////////////////////////////////////////////////
public static void viewReport(){
    boolean repeatsearch = true;

    do{
    System.out.println("");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ===================================== VIEW REPORT ===============================================");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
    System.out.println("\n");

    System.out.println("\t\t\t\t [01] Customer Repots \n");
    System.out.println("\t\t\t\t [02] Item Repots \n");
    System.out.println("\t\t\t\t [03] Order Repots \n");

    System.out.print("\t\t\t Enter Option or press 0 to go to Privious Menu  : ");
    int opt = input.nextInt();

        switch (opt) {
            case 1: customerReport(); break;
            case 2: itemReport(); break;
            case 3: orderReport(); break;
            case 0: repeatsearch=false;break;
            default:System.out.println("\n\n\t\t\t Invalid Option......"); break;
        }
}while(repeatsearch);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////// CUSTOMER REPORT ///////////////////////////////////////////////////////////////////////
public static void customerReport(){

    boolean repeatsearch = true;

    do{
    System.out.println("");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ===================================== CUSTOMER REPORT ===========================================");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
    System.out.println("\n");

    System.out.println("\t\t\t\t [01] Best In Customer \n");
    System.out.println("\t\t\t\t [02] View Customer \n");
    System.out.println("\t\t\t\t [03] All Customer Reporte \n");

    System.out.print("\t\t\t Enter Option or press 0 to go to Privious Menu : ");
    int opt = input.nextInt();
        
    switch (opt) {
        case 1: bestInCustomer(); break;
        case 2: viewCustomer(); break;
        case 3: allCustomer(); break;
        case 0: repeatsearch=false;break;
        default:System.out.println("\n\n\t\t\t Invalid Option......"); break;
    }
}while(repeatsearch);


}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////// Best in customer  //////////////////////////////////////////////////////////////////
public static void bestInCustomer() {

    boolean repeatsearch = true;
    do{
        System.out.println("");
        System.out.println("\t\t\t\t =================================================================================================");
        System.out.println("\t\t\t\t ===================================== BEST IN CUSTOMER ==========================================");
        System.out.println("\t\t\t\t =================================================================================================");
        System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
        System.out.println("\n");
        
        bestInCustReport();
        System.out.println("\n");
        boolean rept=true;
        do{
        System.out.print("\t\t\t To access the Main Menu, please enter 0 : ");
        if (input.hasNextInt()) {
            int ans = input.nextInt(); 
            if (ans == 0) {
                rept = false;  
            } else {
                System.out.println("\t\t\t Invalid input. Please enter 0 to access the Main Menu.");
            }
        } else {
            System.out.println("\t\t\t Invalid input. Please enter a valid integer.");
            input.next(); 
        }
    }while(rept); 
    repeatsearch=false;   
    }while(repeatsearch);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////  Best In Customer report ///////////////////////////////////////////////////////


public static void bestInCustReport() {
    Orders[] bicOrderarray = new Orders[0];  
    L1: for (int i = 0; i < orderarray.length; i++) {

       
        for (int j = 0; j < bicOrderarray.length; j++) {

            if (bicOrderarray[j].getcontactNumber().equals(orderarray[i].getcontactNumber())) {
              
                bicOrderarray[j].setqty(bicOrderarray[j].getqty() + orderarray[i].getqty());
                bicOrderarray[j].setammount(bicOrderarray[j].getammount() + orderarray[i].getammount());
                bicOrderarray[j].setsize(orderarray[i].getsize());
                continue L1;
            }
        }

    
        Orders[] tmpArray = new Orders[bicOrderarray.length + 1];

       
        for (int k = 0; k < bicOrderarray.length; k++) {
            tmpArray[k] = bicOrderarray[k];
        }

        bicOrderarray = tmpArray;

      
       bicOrderarray[bicOrderarray.length - 1] = new Orders();

        bicOrderarray[bicOrderarray.length - 1].setcontactNumber(orderarray[i].getcontactNumber());
        bicOrderarray[bicOrderarray.length - 1].setqty(orderarray[i].getqty());
        bicOrderarray[bicOrderarray.length - 1].setammount(orderarray[i].getammount());
        bicOrderarray[bicOrderarray.length - 1].setsize(orderarray[i].getsize());
    }

    // Sort the array by total amount
    for (int i = 0; i < bicOrderarray.length; i++) {
        for (int j = i + 1; j < bicOrderarray.length; j++) {
            if (bicOrderarray[i].getammount() < bicOrderarray[j].getammount()) {
                Orders temp = bicOrderarray[i];
                bicOrderarray[i] = bicOrderarray[j];
                bicOrderarray[j] = temp;
            }
        }
    }

    // Print report
    System.out.println("\t\t\t\t\t +---------------+---------+---------------+");
    System.out.println("\t\t\t\t\t |  Customer ID  | All Qty |  Total Amount |");
    System.out.println("\t\t\t\t\t +---------------+---------+---------------+");

    for (int k = 0; k < bicOrderarray.length; k++) {
        System.out.println("\t\t\t\t\t |               |         |               |");
        System.out.printf("\t\t\t\t\t |   %-12s|%6d   |%12.2f   |\n", 
            bicOrderarray[k].getcontactNumber(), bicOrderarray[k].getqty(), bicOrderarray[k].getammount());
    }

    System.out.println("\t\t\t\t\t +---------------+---------+---------------+");
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////// View Customer ///////////////////////////////////////////////////////////////////
public static void viewCustomer() {
    boolean repeatsearch = true;
    do{
        System.out.println("");
        System.out.println("\t\t\t\t =================================================================================================");
        System.out.println("\t\t\t\t ======================================== VIEW CUSTOMER ==========================================");
        System.out.println("\t\t\t\t =================================================================================================");
        System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
        System.out.println("\n");

        
        viewCustomerReport();
        System.out.println("\n");
        boolean rept=true;
        do{
        System.out.print("\t\t\t To access the Main Menu, please enter 0 : ");
        if (input.hasNextInt()) {
            int ans = input.nextInt(); 
            if (ans == 0) {
                rept = false;  
            } else {
                System.out.println("\t\t\t Invalid input. Please enter 0 to access the Main Menu.");
            }
        } else {
            System.out.println("\t\t\t Invalid input. Please enter a valid integer.");
            input.next(); 
        }
    }while(rept); 
    repeatsearch=false;  
           
    }while(repeatsearch);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////View Customer Report /////////////////////////////////////////////////////////////////

public static void viewCustomerReport() {
    Orders[] tempOrderArray = new Orders[0]; 

    L1: for (int i = 0; i < orderarray.length; i++) {
        for (int j = 0; j < tempOrderArray.length; j++) {
            if (orderarray[i].getcontactNumber().equals(tempOrderArray[j].getcontactNumber())) { 
                tempOrderArray[j].setqty(tempOrderArray[j].getqty() + orderarray[i].getqty());
                tempOrderArray[j].setammount(tempOrderArray[j].getammount() + orderarray[i].getammount());
                continue L1; 
            }
        }

      
        Orders[] tmpArray = new Orders[tempOrderArray.length + 1];
        for (int k = 0; k < tempOrderArray.length; k++) {
            tmpArray[k] = tempOrderArray[k]; 
        }
        tempOrderArray = tmpArray;

        
        tmpArray[tempOrderArray.length-1] = new Orders(); 
        tmpArray[tempOrderArray.length-1].setcontactNumber(orderarray[i].getcontactNumber()); 
        tmpArray[tempOrderArray.length-1].setqty(orderarray[i].getqty()); 
        tmpArray[tempOrderArray.length-1].setammount(orderarray[i].getammount()); 

        
    }

    // Print the report
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");
    System.out.println("\t\t\t\t |  Customer ID  |      QTY       |   Total Amount  |");
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");

    for (int i = 0; i < tempOrderArray.length; i++) {
        System.out.printf("\t\t\t\t | %-13s | %-14d | %15.2f |\n",
            tempOrderArray[i].getcontactNumber(), 
            tempOrderArray[i].getqty(), 
            tempOrderArray[i].getammount()); 
    }
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////// All Curtomer//////////////////////////////////////////////////////////////////
public static void allCustomer() {
    boolean repeatsearch = true;
    do{
        System.out.println("");
        System.out.println("\t\t\t\t =================================================================================================");
        System.out.println("\t\t\t\t ======================================== ALL CUSTOMER ===========================================");
        System.out.println("\t\t\t\t =================================================================================================");
        System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
        System.out.println("\n");
        
        //vcPrint();
        viewAllCustomerReports();
        System.out.println("\n");
        boolean rept=true;
        do{
        System.out.print("\t\t\t To access the Main Menu, please enter 0 : ");
        if (input.hasNextInt()) {
            int ans = input.nextInt(); 
            if (ans == 0) {
                rept = false;  
            } else {
                System.out.println("\t\t\t Invalid input. Please enter 0 to access the Main Menu.");
            }
        } else {
            System.out.println("\t\t\t Invalid input. Please enter a valid integer.");
            input.next(); 
        }
        }while(rept); 
    repeatsearch=false;        
    }while(repeatsearch);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////  View All Customer Report  ///////////////////////////////////////////////////////////
public static void viewAllCustomerReports() {
    //String[] tempPhoneNumberArray = new String[0];
Orders tmpOrderArray[] = new Orders[0];

    if (orderarray.length > 0) {
        L1: for (int i = 0; i < orderarray.length; i++) {
            for (int j = 0; j < tmpOrderArray.length; j++) {
                if (orderarray[i].getcontactNumber().equals(tmpOrderArray[j].getcontactNumber())) {
                    continue L1;
                }
            }
          
            Orders [] tmpOrderArray1 = new Orders[tmpOrderArray.length+1];
            for (int k = 0; k < tmpOrderArray.length; k++) {
                tmpOrderArray1[k] = tmpOrderArray[k];
            }
            tmpOrderArray= tmpOrderArray1;
            tmpOrderArray[tmpOrderArray.length-1]=new Orders();

            tmpOrderArray[tmpOrderArray.length - 1].setcontactNumber(orderarray[i].getcontactNumber());
        }
    }

    System.out.println("\t\t\t\t +-----------------+---------+---------+---------+---------+---------+---------+-----------------+");
    System.out.printf("\t\t\t\t | %-15s | %-7s | %-7s | %-7s | %-7s | %-7s | %-7s | %-15s |\n", "Phone Number","XS", "S", "M",
            "L", "XL", "XXL", "Total Amount");
    System.out.println("\t\t\t\t +-----------------+---------+---------+---------+---------+---------+---------+-----------------+");

    for (int i = 0; i < tmpOrderArray.length; i++) {
        String[] tempSizeArray = { "XS", "S", "M", "L", "XL", "XXL" };
        int[] tempQtyArray = new int[6];

        for (int j = 0; j < orderarray.length; j++) {
            if (tmpOrderArray[i].getcontactNumber().equals(orderarray[j].getcontactNumber())) {
                switch (orderarray[j].getsize()) {
                    case "XS":
                        tempQtyArray[0] += orderarray[j].getqty();
                        break;
                    case "S":
                        tempQtyArray[1] += orderarray[j].getqty();
                        break;
                    case "M":
                        tempQtyArray[2] += orderarray[j].getqty();
                        break;
                    case "L":
                        tempQtyArray[3] += orderarray[j].getqty();
                        break;
                    case "XL":
                        tempQtyArray[4] += orderarray[j].getqty();
                        break;
                    case "XXL":
                        tempQtyArray[5] += orderarray[j].getqty();
                        break;
                }
            }
        }
        double total = 0;
        for (int j = 0; j < tempQtyArray.length; j++) {
            total += tempQtyArray[j] * (tempSizeArray[j].equals("XS") ? XS
                    : tempSizeArray[j].equals("S") ? S
                            : tempSizeArray[j].equals("M") ? M
                                    : tempSizeArray[j].equals("L") ? L : tempSizeArray[j].equals("XL") ? XL : XXL);
        }
        System.out.printf("\t\t\t\t | %-15s | %-7s | %-7s | %-7s | %-7s | %-7s | %-7s | %15.2f |\n",tmpOrderArray[i].getcontactNumber(),tempQtyArray[0],tempQtyArray[1],tempQtyArray[2],tempQtyArray[3],tempQtyArray[4],tempQtyArray[5],total);

    }
    System.out.println("\t\t\t\t +-----------------+---------+---------+---------+---------+---------+---------+-----------------+");

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


public static void bicSortedArray( String []bicContactNumberArray ,int[] bicQtyArray ,double[] bicTotalPriceArray ,String[] bicSizeArray){

            for(int i = 0; i< bicTotalPriceArray.length; i++){

                for(int j = i+1 ; j < bicTotalPriceArray.length;j++){

                    if(bicTotalPriceArray[i] < bicTotalPriceArray[j]){
                        
                        double temp = bicTotalPriceArray[j];
                        int temp1 = bicQtyArray[j];
                        String temp2 = bicContactNumberArray[j];
                        String temp3 = bicSizeArray[j];
 
                        bicTotalPriceArray[j]=bicTotalPriceArray[i];
                        bicQtyArray[j]=bicQtyArray[i];
                        bicContactNumberArray[j]=bicContactNumberArray[i];
                        bicSizeArray[j]=bicSizeArray[i];

                        bicTotalPriceArray[i] = temp;
                        bicQtyArray[i]=temp1;
                        bicContactNumberArray[i]=temp2;
                        bicSizeArray[i]=temp3;

                    }
                }
            }          
}
  
public static void bicExtendArray(String[] bicContactNumberArray ,String[] bicSizeArray, int[] bicQtyArray , double[] bicTotalPriceArray ){
 System.out.println("L41");
    String tempContactNumberArray[] = new String[bicContactNumberArray.length+1];
    int tempQtyArray[] = new int[ bicQtyArray.length+1];
    double tempTotalPriceArray[] = new double[bicTotalPriceArray.length+1];
    String tempSizeArray[] = new String[bicSizeArray.length+1];
    System.out.println("L42");
    for(int i = 0 ; i<bicContactNumberArray.length; i++){  
        tempContactNumberArray[i]=bicContactNumberArray[i]; 
        tempQtyArray[i] = bicQtyArray[i];
        tempTotalPriceArray[i] =bicTotalPriceArray[i];   
        tempSizeArray[i] = bicSizeArray[i];
    }
    System.out.println("L43");
        bicContactNumberArray=tempContactNumberArray;
        bicQtyArray =tempQtyArray;
        bicTotalPriceArray=tempTotalPriceArray;
        bicSizeArray=tempSizeArray;
        System.out.println("L44");
}

///////////////////////////////////////////////////////// ORDER REPORT ///////////////////////////////////////////////////////////////////////
public static void orderReport(){

    boolean repeatsearch = true;

    do{
    System.out.println("");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ===================================== ORDER REPORT ==============================================");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
    System.out.println("\n");

    System.out.println("\t\t\t\t [01] All Orders  \n");
    System.out.println("\t\t\t\t [02] Order By Ammount \n");
    
    System.out.print("\t\t\t Enter Option or 0 to go to Privious Menu : ");
    int opt = input.nextInt();
        
    switch (opt) {
        case 1: allOrders(); break;
        case 2: orderByAmount(); break;
        case 0: repeatsearch=false;break;
        default:System.out.println("\n\n\t\t\t Invalid Option......"); break;
    }

  }while(repeatsearch);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

/////////////////////////////////////////////////////////// All Odres  ////////////////////////////////////////////////////////////////////
private static void allOrders(){
    do {
        System.out.println("\t\t\t\t ============== VIEW ORDERS =================");
        ordersSortByOrderId();

        System.out.print("\nTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();
        clearConsole();
        if (choice == 0) {
            break;
        } else {
            System.out.println("\nInvalid Option...");
            continue;
        }
    } while (true);
}

public static void ordersSortByOrderId() {

    Orders []tmpOrderArray = new Orders[orderarray.length];

    for(int i = 0 ; i < orderarray.length; i++){

        tmpOrderArray[i]= new Orders();
    }

    for (int i = 0; i < orderarray.length; i++) {
        
        tmpOrderArray[i]=orderarray[i];
    }
    for (int j = 1; j < orderarray.length; j++) {
        for (int i = 0; i < orderarray.length - j; i++) {
            
            if (tmpOrderArray[i].getorderId().compareTo(tmpOrderArray[i + 1].getorderId()) < 0) {

                Orders ord = tmpOrderArray[i];
                tmpOrderArray[i]=tmpOrderArray[i+1];
                tmpOrderArray[i+1]=ord;

            }
        }
    }

    System.out.println(
            "\t\t\t\t +----------------+------------------+-----------+-----------+-----------------+-----------------+");
    System.out.println(
            "\t\t\t\t |    Order ID    |    Customer Id   |    Size   |    QTY    |     Amount      |      Status     |");
    System.out.println(
            "\t\t\t\t +----------------+------------------+-----------+-----------+-----------------+-----------------+");

    for (int i = 0; i < tmpOrderArray.length; i++) {
        System.out.printf("\t\t\t\t | %-14s | %-16s | %-9s | %-9d | %15.2f | %-15s |\n", tmpOrderArray[i].getorderId(),
                tmpOrderArray[i].getcontactNumber(), tmpOrderArray[i].getsize(), tmpOrderArray[i].getqty(), tmpOrderArray[i].getammount(),
                (tmpOrderArray[i].getstatus() == 0) ? "Processing" : (tmpOrderArray[i].getstatus() == 1) ? "Delivering" : "Delivered");
    }
    System.out.println(
            "\t\t\t\t +----------------+------------------+-----------+-----------+-----------------+-----------------+");
}


private static void orderByAmount() {
    do {
        System.out.println("\t\t\t\t =================== ORDERS BY AMOUNT =================");
        ordersSortByAmount();

        System.out.print("\nTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();
        clearConsole();
        if (choice == 0) {
            break;
        } else {
            System.out.println("\nInvalid Option...");
            continue;
        }
    } while (true);
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////Orders By AAmmount Report /////////////////////////////////////////////////////////////
public static void ordersSortByAmount() {
    Orders []tmpOrderArray = new Orders[orderarray.length];

    for(int i = 0 ; i < orderarray.length; i++){

        tmpOrderArray[i]= new Orders();
    }

    for (int i = 0; i < orderarray.length; i++) {
        
        tmpOrderArray[i]=orderarray[i];
    }
    for (int j = 1; j < orderarray.length; j++) {
        for (int i = 0; i < orderarray.length - j; i++) {
            
            if (tmpOrderArray[i].getammount() < tmpOrderArray[i+1].getammount()) {

                Orders ord = tmpOrderArray[i];
                tmpOrderArray[i]=tmpOrderArray[i+1];
                tmpOrderArray[i+1]=ord;

            }
        }
    }

    System.out.println(
            "\t\t\t\t +----------------+------------------+-----------+-----------+-----------------+-----------------+");
    System.out.println(
            "\t\t\t\t |    Order ID    |    Customer Id   |    Size   |    QTY    |     Amount      |      Status     |");
    System.out.println(
            "\t\t\t\t +----------------+------------------+-----------+-----------+-----------------+-----------------+");

    for (int i = 0; i < tmpOrderArray.length; i++) {
        System.out.printf("\t\t\t\t | %-14s | %-16s | %-9s | %-9d | %15.2f | %-15s |\n", tmpOrderArray[i].getorderId(),
                tmpOrderArray[i].getcontactNumber(), tmpOrderArray[i].getsize(), tmpOrderArray[i].getqty(), tmpOrderArray[i].getammount(),
                (tmpOrderArray[i].getstatus() == 0) ? "Processing" : (tmpOrderArray[i].getstatus() == 1) ? "Delivering" : "Delivered");
    }
    System.out.println(
            "\t\t\t\t +----------------+------------------+-----------+-----------+-----------------+-----------------+");
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////// ITEM REPORT ///////////////////////////////////////////////////////////////////////
public static void itemReport(){

    boolean repeatsearch = true;

    do{
    System.out.println("");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ===================================== ITEM REPORT ===============================================");
    System.out.println("\t\t\t\t =================================================================================================");
    System.out.println("\t\t\t\t ____________________________________________________________________________________________________");
    System.out.println("\n");

    System.out.println("\t\t\t\t [01] Best Selling Catogery Sorted By Amount \n");
    System.out.println("\t\t\t\t [02] Best Selling Catogery Sorted By QTY \n");
    

    System.out.print("\t\t\t Enter Option Or 0 to Go to Privious Menu : ");
    int opt = input.nextInt();
        
    switch (opt) {
        case 1: bestSellingCategoriesSortedByAmount(); break;
        case 2: bestSellingCategoriesSortedByQty(); break; 
        case 0: repeatsearch=false;break;
        default:System.out.println("\n\n\t\t\t Invalid Option......"); break;
    }
}while(repeatsearch);

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////// Best selling Sorted by Qty /////////////////////////////////////////////////////////////////////
private static void bestSellingCategoriesSortedByQty() {
    do {
        System.out.println("\t\t\t\t ================ SORTED BY QTY =================");
        sortedByQty();

        System.out.print("\nTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();
        clearConsole();
        if (choice == 0) {
            break;
        } else {
            System.out.println("\nInvalid Option...");
            continue;
        }
    } while (true);
}

public static void sortedByQty() {

    Orders []tmpOrderarray = new Orders[6];

    for(int i =0 ; i< tmpOrderarray.length; i++){

        tmpOrderarray[i]=new Orders();
    }


    tmpOrderarray[0].setsize("XS");
    tmpOrderarray[1].setsize("S");
    tmpOrderarray[2].setsize("M");
    tmpOrderarray[3].setsize("L");
    tmpOrderarray[4].setsize("XL");
    tmpOrderarray[5].setsize("XXL");


    for (int i = 0; i < orderarray.length; i++) {
        if (orderarray[i].getsize().equals("XS")) {
            tmpOrderarray[0].setqty(tmpOrderarray[0].getqty()+orderarray[i].getqty());
            tmpOrderarray[0].setammount(tmpOrderarray[0].getammount()+orderarray[i].getammount());
       
        } else if (orderarray[i].getsize().equals("S")) {
            tmpOrderarray[1].setqty(tmpOrderarray[1].getqty()+orderarray[i].getqty());
            tmpOrderarray[1].setammount(tmpOrderarray[1].getammount()+orderarray[i].getammount());

        } else if (orderarray[i].getsize().equals("M")) {

            tmpOrderarray[2].setqty(tmpOrderarray[2].getqty()+orderarray[i].getqty());
            tmpOrderarray[2].setammount(tmpOrderarray[2].getammount()+orderarray[i].getammount());

        } else if (orderarray[i].getsize().equals("L")) {
            
            tmpOrderarray[3].setqty(tmpOrderarray[3].getqty()+orderarray[i].getqty());
            tmpOrderarray[3].setammount(tmpOrderarray[3].getammount()+orderarray[i].getammount());

        } else if (orderarray[i].getsize().equals("XL")) {
            
            tmpOrderarray[4].setqty(tmpOrderarray[4].getqty()+orderarray[i].getqty());
            tmpOrderarray[4].setammount(tmpOrderarray[4].getammount()+orderarray[i].getammount());
   
        } else if (orderarray[i].getsize().equals("XXL")) {
            
            tmpOrderarray[5].setqty(tmpOrderarray[5].getqty()+orderarray[i].getqty());
            tmpOrderarray[5].setammount(tmpOrderarray[5].getammount()+orderarray[i].getammount());
        } else {
            continue;
        }
    }

    Orders []tmpSortArray = new Orders[6];

    for (int i = 0; i < tmpSortArray.length; i++) {
        tmpSortArray[i] = new Orders(); 
    }
    for (int i = 0; i < 6; i++) {
        tmpSortArray[i]=tmpOrderarray[i];
    }
    for (int j = 1; j < tmpOrderarray.length; j++) {
        for (int i = 0; i < tmpOrderarray.length - j; i++) {
            if (tmpSortArray[i].getqty() < tmpSortArray[i+1].getqty()) {

                Orders ord =tmpSortArray[i];
                tmpSortArray[i]=tmpSortArray[i+1];
                tmpSortArray[i+1]=ord;
            }
        }
    }

    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");
    System.out.println("\t\t\t\t |      Size     |      QTY       |   Total Amount  |");
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");

    for (int i = 0; i < tmpOrderarray.length; i++) {
        System.out.printf("\t\t\t\t | %-13s | %-14s | %15.2f |\n", tmpSortArray[i].getsize(), tmpSortArray[i].getqty(),
                tmpSortArray[i].getammount());
    }
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");
}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


////////////////////////////////////////////Best Selling cat Sorted By ammount ////////////////////////////////////////////////////////////////////////
public static void bestSellingCategoriesSortedByAmount() {
    do {
        System.out.println("\t\t\t\t ================ SORTED BY AMOUNT =================");
        sortedByAmount();

        System.out.print("\nTo access the Main Menu, please enter 0 : ");
        int choice = input.nextInt();
        clearConsole();
        if (choice == 0) {
            break;
        } else {
            System.out.println("\nInvalid Option...");
            continue;
        }
    } while (true);

}

public static void sortedByAmount() {

    Orders []tmpOrderarray = new Orders[6];
    for(int i =0 ; i<tmpOrderarray.length;i++){
        tmpOrderarray[i]=new Orders();
    }

    tmpOrderarray[0].setsize("XS");
    tmpOrderarray[1].setsize("S");
    tmpOrderarray[2].setsize("M");
    tmpOrderarray[3].setsize("L");
    tmpOrderarray[4].setsize ("XL");
    tmpOrderarray[5].setsize("XXL");

    for (int i = 0; i < orderarray.length; i++) {
        if (orderarray[i].getsize().equals("XS")) {
            tmpOrderarray[0].setqty(tmpOrderarray[0].getqty()+orderarray[i].getqty());
            tmpOrderarray[0].setammount(tmpOrderarray[0].getammount()+orderarray[i].getammount());
       
        } else if (orderarray[i].getsize().equals("S")) {
            tmpOrderarray[1].setqty(tmpOrderarray[1].getqty()+orderarray[i].getqty());
            tmpOrderarray[1].setammount(tmpOrderarray[1].getammount()+orderarray[i].getammount());

        } else if (orderarray[i].getsize().equals("M")) {

            tmpOrderarray[2].setqty(tmpOrderarray[2].getqty()+orderarray[i].getqty());
            tmpOrderarray[2].setammount(tmpOrderarray[2].getammount()+orderarray[i].getammount());

        } else if (orderarray[i].getsize().equals("L")) {
            
            tmpOrderarray[3].setqty(tmpOrderarray[3].getqty()+orderarray[i].getqty());
            tmpOrderarray[3].setammount(tmpOrderarray[3].getammount()+orderarray[i].getammount());

        } else if (orderarray[i].getsize().equals("XL")) {
            
            tmpOrderarray[4].setqty(tmpOrderarray[4].getqty()+orderarray[i].getqty());
            tmpOrderarray[4].setammount(tmpOrderarray[4].getammount()+orderarray[i].getammount());
   
        } else if (orderarray[i].getsize().equals("XXL")) {
            
            tmpOrderarray[5].setqty(tmpOrderarray[5].getqty()+orderarray[i].getqty());
            tmpOrderarray[5].setammount(tmpOrderarray[5].getammount()+orderarray[i].getammount());
        } else {
            continue;
        }
    }

    Orders []tmpSortArray = new Orders[6];

    for (int i = 0; i < tmpSortArray.length; i++) {
        tmpSortArray[i] = new Orders(); 
    }
    for (int i = 0; i < 6; i++) {
        tmpSortArray[i]=tmpOrderarray[i];
    }
    for (int j = 1; j < tmpOrderarray.length; j++) {
        for (int i = 0; i < tmpOrderarray.length - j; i++) {
            if (tmpSortArray[i].getammount() < tmpSortArray[i+1].getammount()) {

                Orders ord =tmpSortArray[i];
                tmpSortArray[i]=tmpSortArray[i+1];
                tmpSortArray[i+1]=ord;
            }
        }
    }

    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");
    System.out.println("\t\t\t\t |      Size     |      QTY       |  Total Amount   |");
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");

    for (int i = 0; i < tmpOrderarray.length; i++) {
        System.out.printf("\t\t\t\t | %-13s | %-14s | %15.2f |\n", tmpSortArray[i].getsize(), tmpSortArray[i].getqty(),
                tmpSortArray[i].getammount());
    }
    System.out.println("\t\t\t\t +---------------+----------------+-----------------+");

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////////// Delete Order ///////////////////////////////////////////////////////////////////////
    private static void deleteOrder() {
          boolean repeatSearch = true;
     do{
        System.out.println("                       _____       _      _           ____          _                    ");
        System.out.println("                      |  __ \\     | |    | |         / __ \\        | |                 ");
        System.out.println("                      | |  | | ___| | ___| |_ ___   | |  | |_ __ __| | ___ _ __          ");
        System.out.println("                      | |  | |/ _ \\ |/ _ \\ __/ _ \\  | |  | | '__/ _` |/ _ \\ '__|     ");
        System.out.println("                      | |__| |  __/ |  __/ ||  __/  | |__| | | | (_| |  __/ |            ");
        System.out.println("                      |_____/ \\___|_|\\___|\\__\\___|   \\____/|_|  \\__,_|\\___|_|    ");
        System.out.println("");
        System.out.println("                    __________________________________________________________________");
        System.out.println("");
        System.out.println("");


        System.out.print("               Enter Order ID  : ");
        String oId = input.nextLine();
        System.out.println("");
        boolean valid = isvalid(oId);
       // System.out.println(valid);
        if(valid){
            
            int index = searchOrderByOrderId(oId);
            if(index==-1){
                System.out.println("              ID Not Found...");
                System.out.println("");
                System.out.print("          Do you want Delete another order (y/n) ");
                String repeat = input.nextLine().toUpperCase();

                if (repeat.equals("Y")) {
                     continue;
                 }else if(repeat.equals("N")){     
                     repeatSearch = false;
                 }else{
                     System.out.println("         Invalid Input ");
                     break;
                 }
            }else{
                System.out.printf( "               %-14s  : %14s \n" ,"Phone Number", orderarray[index].getcontactNumber() );
                System.out.printf( "               %-14s  : %14s \n" ,"Size",orderarray[index].getsize() );
                System.out.printf( "               %-14s  : %14s \n" ,"QTY",orderarray[index].getqty() );
                System.out.printf( "               %-14s  : %14s \n" ,"Ammount",orderarray[index].getammount() );
                  int stut = orderarray[index].getstatus();    
                  String msg = "";
                  switch (stut) {
                    case 0: msg="PROCESSING"; break;
                    case 1: msg="DELEVERING"; break;
                    case 2: msg="DELEVERED"; break;        
                }
                System.out.printf( "               %-14s  : %14s \n" ,"Status",msg );

                System.out.println("\n");

                System.out.print("          Do you want Delete this Order (y/n) ");
                String repeat = input.nextLine().toUpperCase();

                if (repeat.equals("Y")) {
                 deletOrderbyId(oId);
                      System.out.println("                  Order Delete.!");
                      System.out.println("");
                      System.out.print("          Do you want delete another oder (y/n) ");
                      String repeat1 = input.nextLine().toUpperCase();
          
                      if (repeat1.equals("Y")) {
                           continue;
                       }else if(repeat1.equals("N")){     
                           repeatSearch = false;
                       }else{
                           System.out.println("         Invalid Input ");
                           break;
                       }

                }else if(repeat.equals("N")){     
                      repeatSearch = false;
                }else{
                 System.out.println("         Invalid Input ");
                 break;
                }
            }
        }else{
            System.out.println("                  Invalid Oder ID..... ");
            System.out.println("");
            System.out.print("          Do you want delete another oder (y/n) ");
            String repeat = input.nextLine().toUpperCase();

            if (repeat.equals("Y")) {
                 continue;
             }else if(repeat.equals("N")){     
                 repeatSearch = false;
             }else{
                 System.out.println("         Invalid Input ");
                 break;
             }
        }          
    }while(repeatSearch);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////// Order Stus ////////////////////////////////////////////////////////////////////////////////
    private static void changeOrderStatus() {
        boolean repeatSearch = true;

        do{
            
            System.out.println("                       ____          _                ______ _        _              ");
            System.out.println("                      / __ \\        | |              /  ____| |      | |              ");
            System.out.println("                     | | -| |_ __ __| | ___ _ ___   |  (___ | |_ __ _| |_ _   _ ____  ");
            System.out.println("                     | |  | | '__/ _  |/ _ \\ ' __|   \\___  \\| __/ _` | __| | | /  __| ");
            System.out.println("                     | |__| | | | (_| |  __/| |      ____)  | || (_| | |_| |_| \\__  \\");
            System.out.println("                      \\____/|_|  \\__,_|\\___||_|     |______/ \\__\\__,_|\\__|\\__,_|____/  ");
            System.out.println("");
            System.out.println("                   ______________________________________________________________________");
            System.out.println("");
            System.out.println("");

    
            System.out.print("               Enter Order ID  : ");
            String oId = input.nextLine();
            System.out.println("");
            boolean valid = isvalid(oId);
           // System.out.println(valid);
            if(valid){
                
                int index = searchOrderByOrderId(oId);
                if(index==-1){
                    System.out.println("              ID Not Found...");
                    System.out.println("");
                    System.out.print("          Do you want Change Oder Status, another order (y/n) ");
                    String repeat = input.nextLine().toUpperCase();
    
                    if (repeat.equals("Y")) {
                         continue;
                     }else if(repeat.equals("N")){     
                         repeatSearch = false;
                     }else{
                         System.out.println("         Invalid Input ");
                         break;
                     }
                }else{
                    System.out.printf( "               %-14s  : %14s \n" ,"Phone Number", orderarray[index].getcontactNumber() );
                    System.out.printf( "               %-14s  : %14s \n" ,"Size",orderarray[index].getsize() );
                    System.out.printf( "               %-14s  : %14s \n" ,"QTY",orderarray[index].getqty() );
                    System.out.printf( "               %-14s  : %14s \n" ,"Ammount",orderarray[index].getammount() );
    
                      int stut = orderarray[index].getstatus();
                      String msg = "";
                      switch (stut) {
                        case 0: msg="PROCESSING"; break;
                        case 1: msg="DELEVERING"; break;
                        case 2: msg="DELEVERED"; break;        
                    }
                    System.out.printf( "               %-14s  : %14s \n" ,"Status",msg );
    
                    System.out.println();
                    System.out.println("\n");
    
                    System.out.print("          Do you want Change Oder Ststus this Order (y/n) ");
                     //  input.nextLine();
                    String repeat2 = input.nextLine().toUpperCase();
    
                    if (repeat2.equals("Y")) {
                          changeOrderStatusbyId(oId);
                          System.out.println("");
                          System.out.println("");
                          System.out.print("          Do you want search another oder (y/n) ");
                          // clearConsole();
                          String repeat1 = input.nextLine().toUpperCase();
                          input.nextLine();
                           if (repeat1.equals("Y")) {
                               continue;
                           }else if(repeat1.equals("N")){     
                               repeatSearch = false;
                           }else{
                               System.out.println("         Invalid Input ");
                               break;
                           }
    
                    }else if(repeat2.equals("N")){     
                          repeatSearch = false;
                    }else{
                     System.out.println("         Invalid Input++ ");
                     break;
                    }
                }
            }else{
                System.out.println("                  Invalid Oder ID..... ");
                System.out.println("");
                System.out.print("          Do you want search another oder (y/n) ");
                String repeat = input.nextLine().toUpperCase();
    
                if (repeat.equals("Y")) {
                     continue;
                 }else if(repeat.equals("N")){     
                     repeatSearch = false;
                 }else{
                     System.out.println("         Invalid Input ");
                     break;
                 }
            }
        }while(repeatSearch);
    }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       public static int homePage() {
        System.out.println("              /$$$$$$$$                  /$$       /$$                              /$$$$$$  /$$                          ");
        System.out.println("             | $$_____/                 | $$      |__/                             /$$__  $$| $$                          ");
        System.out.println("             | $$    /$$$$$$    /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$         | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ ");
        System.out.println("             | $$$$$|______$$  /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$        |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$");
        System.out.println("             | $$__/  /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$         \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$");
        System.out.println("             | $$    /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$         /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$");
        System.out.println("             | $$   |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$        |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/");
        System.out.println("             |__/    \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/         \\______/ |__/  |__/ \\______/ | $$____/ ");
        System.out.println("                                                                                                                | $$      ");
        System.out.println("                                                                                                                | $$      ");
        System.out.println("                                                                                                                |__/      ");
        System.out.println("");
        System.out.println("            ____________________________________________________________________________________________________________________");
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("                       [1] Place Order                                                      [2] Search Customer   ");
        System.out.println("");
        System.out.println("                       [3] Search Order                                                     [4] View Reports      ");
        System.out.println("");
        System.out.println("                       [5] Change Order Status                                              [6] Delete Order      ");
        System.out.println("");
        System.out.print("                       Input Option : ");
        int option = input.nextInt();
        input.nextLine();
        return option;
    }
//////////////////////////////////////////////////////////////////////  Search Customer ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void searchCustomer(){
        boolean repeatSearch = true;
        do{ 
            System.out.println("            _______                       _         _____           _                                             ");
            System.out.println("           /  _____|                     | |       / ____|         | |                                            ");
            System.out.println("          |  (____   ____  __ _ _ __ ____| |__    | |     _   _ ___| |_ ___  _ __ ___   ___ _ __                  ");
            System.out.println("           \\____  \\ /  _ \\/  ` | '__/ ___| '_ \\   | |    | | | / __| __/ _ \\| '_ ` _ \\ / _ \\ '__|          ");
            System.out.println("           _____)  |   __/ (_| | | | (___| | | |  | |____| |_| \\__ \\ || (_) | | | | | |  __/ |                  ");
            System.out.println("          |_______/ \\____|\\__,_|_|  \\____|_| |_|   \\_____ \\__,_|___/\\__\\___/|_| |_| |_|\\___|_|            ");
            System.out.println("        ___________________________________________________________________________________________               ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.print("                 Enter Cusstomer Phone Number : ");
            String phoneNumberForSearch = input.nextLine();
            System.out.println("");
            System.out.println("");
            boolean vlid =isvalid(phoneNumberForSearch);
        if(!vlid){
            
            System.out.println("                    Invalid Input... ");
            System.out.println("");
            System.out.print("          Do you want to Search Another Customer report (y/n) : ");
            String repeat = input.nextLine().toUpperCase();

            if (repeat.equals("N")) {     
                repeatSearch = false;
            } else if (!repeat.equals("Y")) {
                System.out.println("         Invalid Input ");
                break;
            }  
            System.out.println("");
        }else{
            int []indexArray =searchConNumIndexFromArray(phoneNumberForSearch);    
            print(indexArray);

            System.out.print("          Do you want to search another customer report (y/n) :");
            String repeat = input.nextLine().toUpperCase();

           if (repeat.equals("Y")) {
                continue;
            }else if(repeat.equals("N")){     
                repeatSearch = false;
            }else{
                System.out.println("         Invalid Input ");
                break;
            }     
        }
        }while(repeatSearch);
    }
   
    public static void changeOrderStatusbyId(String orderID ){
       
    int index=-1;
    for(int i = 0; i<orderarray.length; i++ ){
         if(orderID.equals(orderarray[i].getorderId())){
                 index=i;
         }
    }   
      if(orderarray[index].getstatus()==0){
        System.out.println("                       [01] Order Delivering ");
        System.out.println("");
        System.out.println("                       [02] Order Delivered ");
        System.out.println("");
        System.out.print("                    Enter the option : ");
        int opt = input.nextInt();

            if(opt==1){
                orderarray[index].setstatus(1);//delivering
                System.out.println("");
                System.out.println("         Oder Status Changed....!");
            }else if(opt==2){
                orderarray[index].setstatus(2);//deliverd
                System.out.println("");
                System.out.println("         Oder Status Changed....!");
            }else{
                System.out.println("         Invalid Option....!   ");
            }
      }else if(orderarray[index].getstatus()==1){
         
        System.out.println("                   [01] Order Delivered ");
        System.out.println("");
        System.out.print("                  Enter the option : ");
        int opt = input.nextInt();

            if(opt==1){
                orderarray[index].setstatus(2);
                System.out.println("");
                System.out.println("                Oder Status Changed....!");
            }else{
                System.out.println("                 Invalid Option....!   ");
            }
      }else if (orderarray[index].getstatus()==2) {
        System.out.println("                    Can't change Oder Status,Because Order is allrady Deliverd...");
      }else{
         orderarray[index].setstatus(orderarray[index].getstatus());
        }
      }


    public static void deletOrderbyId(String orderID ){
           //find index
       int index=-1;
       for(int i = 0; i<orderarray.length; i++ ){
            if(orderID.equals(orderarray[i].getorderId())){
                    index=i;
            }
       }       
       for(int i = index;i<orderarray.length-1;i++ ){
        
            orderarray[i]=orderarray[i+1];
         }
            lastOrderId--;
       }

    public static boolean isvalid(String numb ) {
        if(numb.length()==10 && numb.charAt(0)=='0'){
            return true;
        }
        else if (numb.matches("ODR#\\d{5}")) {  
            return true;
        }else
        return false;
    }

    public static void print(int [] index){
        Orders tmpArray[] = new Orders[6];
  
        for (int i = 0; i < tmpArray.length; i++) {
            tmpArray[i] = new Orders(); 
        }
        
        tmpArray[0].setsize("XS");
        tmpArray[1].setsize("S");
        tmpArray[2].setsize("M");
        tmpArray[3].setsize("L");
        tmpArray[4].setsize("XL");
        tmpArray[5].setsize("XXL");

        for(int i = 0 ; i < index.length; i++){
           
            tmpArray[i].setammount(orderarray[index[i]].getammount());
            tmpArray[i].setqty(orderarray[index[i]].getqty());
    
        } 
        for(int j = 0; j<index.length; j++){
            for(int i = 0; i < 6 ; i++){

             if(orderarray[index[j]].getsize().equals(tmpArray[i].getsize())){
                String temp = tmpArray[i].getsize();
                tmpArray[i].setsize(tmpArray[j].getsize());;
                tmpArray[j].setsize(temp);
             }   
      
         }
       }

       double totalAmount=0;

        for(int i=0;i<tmpArray.length; i++ ){
            totalAmount+=tmpArray[i].getammount();
        }

        System.out.println("");
        System.out.println("                +------------+------------+------------------+ ");
        System.out.println("                |    Size    |     QTY    |      Amount      | ");
        System.out.println("                +------------+------------+------------------+ ");
        System.out.println("                |            |            |                  | ");

        System.out.printf("                | %-10s | %10d | %16.2f |\n", tmpArray[0].getsize(), tmpArray[0].getqty() ,tmpArray[0].getammount());
        System.out.println("                |            |            |                  | ");
        
        System.out.printf("                | %-10s | %10d | %16.2f |\n", tmpArray[1].getsize(), tmpArray[1].getqty() ,tmpArray[1].getammount());
        System.out.println("                |            |            |                  | ");
        
        System.out.printf("                | %-10s | %10d | %16.2f |\n", tmpArray[2].getsize(), tmpArray[2].getqty() ,tmpArray[2].getammount());
        System.out.println("                |            |            |                  | ");
        
        System.out.printf("                | %-10s | %10d | %16.2f |\n", tmpArray[3].getsize(), tmpArray[3].getqty() ,tmpArray[3].getammount());
        System.out.println("                |            |            |                  | ");
        
        System.out.printf("                | %-10s | %10d | %16.2f |\n", tmpArray[4].getsize(), tmpArray[4].getqty() ,tmpArray[4].getammount());
        System.out.println("                |            |            |                  | ");
        
        System.out.printf("                | %-10s | %10d | %16.2f |\n", tmpArray[5].getsize(), tmpArray[5].getqty() ,tmpArray[5].getammount());
        System.out.println("                |            |            |                  | ");

        System.out.println("                +------------+------------+------------------+ ");
        System.out.printf("                |      Total Amount       | %16.2f |\n", totalAmount);
        System.out.println("                +-------------------------+------------------+ ");
        System.out.println("");
        System.out.println("");
      
    }
   
    public static int searchOrderByOrderId(String odrId){

        for(int i = 0 ; i<orderarray.length ; i++){
            if(odrId.equals(orderarray[i].getorderId())){
                return i;
            }
        }
        return -1;
    }
    public static int[] searchConNumIndexFromArray(String cNumber) {
        int count = 0;
      
        for (int i = 0; i < orderarray.length; i++) {
            if (orderarray[i].getcontactNumber().equals(cNumber)) {
                count++;
            }
        }
        if (count == 0) {
            return new int[0];
        }
        int[] indexArray = new int[count];
        int index = 0;
        for (int i = 0; i < orderarray.length; i++) {
            if (orderarray[i].getcontactNumber().equals(cNumber)) {
                indexArray[index] = i;
                index++;
            }
        }
        
        return indexArray; 
    }
 
    public static void extendArray(){
        Orders tempOrderarray[] = new Orders[orderarray.length+1];
        for(int i = 0 ; i<orderarray.length; i++){
            tempOrderarray[i]=orderarray[i];
            }
            orderarray = tempOrderarray ;
    }
      
    public static void sortingArray(){
        int n = orderarray.length;      
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orderarray[j].getammount() < orderarray[j + 1].getammount()) {
                    
                    Orders odr = orderarray[j];
                    orderarray[j]=orderarray[j+1];
                    orderarray[j+1]=odr;     
                }
            }
        }
    }
    



/////////////////////////////////////////////////////////////////////////   Ssearch Order ////////////////////////////////////////////////////////////////////////////////////////////////////
 
    public static void searchOrder(){
       boolean repeatSearch = true;
        do{
        System.out.println("            _______                       _         ____          _                                   ");
        System.out.println("           /  _____|                     | |       / __ \\        | |                                 ");
        System.out.println("          |  (____   ____  __ _ _ __ ____| |__    | |  | |_ __ __| | ____ _ __                        ");
        System.out.println("           \\____  \\ /  _ \\/  ` | '__/ ___| '_ \\   | |  | | '__/ _ `|/  _ \\ '__|                  ");
        System.out.println("           _____)  |   __/ (_| | | | (___| | | |  | |__| | | | (_| |   __/ |                          ");
        System.out.println("          |_______/ \\____|\\__,_|_|  \\____|_| |_|   \\____/|_|  \\__,_|\\____|_|                    ");
        System.out.println("        ___________________________________________________________________________________________   ");
        System.out.println("");
        System.out.print("               Enter Order ID  : ");
        String oId = input.nextLine();
        System.out.println("");
        boolean valid = isvalid(oId);
       // System.out.println(valid);
        if(valid){
            
            int index = searchOrderByOrderId(oId);
            if(index==-1){
                System.out.println("              Order Not Found...");
                System.out.println("");
                System.out.print("          Do you want Search Order again (y/n) ");
                String repeat = input.nextLine().toUpperCase();

                if (repeat.equals("Y")) {
                     continue;
                 }else if(repeat.equals("N")){     
                     repeatSearch = false;
                 }else{
                     System.out.println("         Invalid Input ");
                     break;
                 }
            }else{

                System.out.printf( "               %-14s  : %14s \n" ,"Phone Number", orderarray[index].getcontactNumber() );
                System.out.printf( "               %-14s  : %14s \n" ,"Size",orderarray[index].getsize() );
                System.out.printf( "               %-14s  : %14s \n" ,"QTY",orderarray[index].getqty() );
                System.out.printf( "               %-14s  : %14s \n" ,"Ammount",orderarray[index].getammount() );
                  int stut = orderarray[index].getstatus();    

                  String msg = "";
                  switch (stut) {
                    case 0: msg="PROCESSING"; break;
                    case 1: msg="DELEVERING"; break;
                    case 2: msg="DELEVERED"; break;        
                }
                System.out.printf( "               %-14s  : %14s \n" ,"Status",msg );

                System.out.println("\n");

                System.out.print("          Do you want Search Order again (y/n) ");
                
                String repeat = input.nextLine().toUpperCase();

                if (repeat.equals("Y")) {
                 continue;
                }else if(repeat.equals("N")){     
                 repeatSearch = false;
                }else{
                 System.out.println("         Invalid Input ");
                 break;
                }
            }
        }else{
            System.out.println("                  Invalid Oder ID..... ");
            System.out.println("");
            System.out.print("               Do you want Search Order again (y/n) ");
            String repeat = input.nextLine().toUpperCase();

            if (repeat.equals("Y")) {
                 continue;
             }else if(repeat.equals("N")){     
                 repeatSearch = false;
             }else{
                 System.out.println("         Invalid Input ");
                 break;
             }
        }
            
    }while(repeatSearch);

}



    /////////////////////////////////////////////////////////////////       Place Order       ///////////////////////////////////////////////////////////////////////////////
    


    public static void placeOrder() {
            boolean repeatOrder = true;
        do{
        System.out.println("           _____  _                   ____          _                 ");
        System.out.println("          |  __ \\| |                 / __ \\        | |              ");
        System.out.println("          | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __       ");
        System.out.println("          |  ___/| |/ _` |/ __/ _ \\ | |  | |  __/ _` |/ _ \\ '__|    ");
        System.out.println("          | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |         ");
        System.out.println("          |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   ");
        System.out.println("        __________________________________________________________    ");
        System.out.println("         ");
          
        String orderId = generateOrderID();
        System.out.println("          Order ID: " + orderId);
        System.out.println();

        String contactNum = getValidContactNum();

        if (contactNum == null) return;
        System.out.println();
        
        String size = getValidSize();
        System.out.println();
        
        System.out.print("          Enter Quantity: ");
        int qty = input.nextInt();
        System.out.println();

        double totalPrice = calAmount(qty, size);
        System.out.println("          Amount: " + totalPrice);
        System.out.println();
        
        input.nextLine();
        System.out.print("          Do you want to place this order? (Y/N): ");
        String confirmation = input.nextLine().toUpperCase();
        System.out.println();

        if (confirmation.equals("Y")) {

            extendArray();
            
            Orders orders = new Orders(orderId,contactNum,size,qty,totalPrice,PROCESSING) ;
            orderarray[orderarray.length-1]=orders; 

            System.out.println("               Order Placed...! ");
            System.out.println("          Order Status: PROCESSING");
        } else {
            System.out.println("               Order Cancelled.");
             lastOrderId--;
            return;
        }

        System.out.print("          Do you want to place another order? (Y/N): ");
        String repeat = input.nextLine().toUpperCase();

        if (repeat.equals("N")) {     
            repeatOrder=false;
        } else if (!repeat.equals("Y")) {
            System.out.println("         Invalid Input ");
            break;
        }  
        System.out.println("");
   

     }while(repeatOrder);
     sortingArray( );
    }

    public static String generateOrderID() {
        lastOrderId++;
        return String.format("ODR#%05d", lastOrderId);
    }

    public static String getValidContactNum() {
        String contactNumber;
        while (true) {
            System.out.print("          Enter Contact Number: ");
            contactNumber = input.nextLine();
            if (contactNumber.length() == 10 && contactNumber.charAt(0) == '0') {
                return contactNumber;
            } else {
                System.out.println("                 Invalid Phone Number... Try again ");
                System.out.print("                   Do you want to enter the phone number again (Y/N): ");
                String retry = input.nextLine().toUpperCase();
                if (retry.equals("N")) {
                    return null;
                }
            }
        }
    }

    public static String getValidSize() {
        String size;
        while (true) {
            System.out.print("              Enter the T-Shirt Size (XS/S/M/L/XL/XXL): ");
            size = input.nextLine().toUpperCase();
            if (size.equals("XS") || size.equals("S") || size.equals("M") || size.equals("L") || size.equals("XL") || size.equals("XXL")) {
                return size;
            } else {
                System.out.println("                 Invalid Size... Try again ");
            }
        }
    }

    public static double calAmount(int qty, String size) {
        double price = 0;
        switch (size) {
            case "XS": price = 600.00; break;
            case "S": price = 800.00; break;
            case "M": price = 900.00; break;
            case "L": price = 1000.00; break;
            case "XL": price = 1100.00; break;
            case "XXL": price = 1200.00; break;
        }
        return price * qty;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public final static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c",
                        "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
            // Handle any exceptions.
        }
    }


}
