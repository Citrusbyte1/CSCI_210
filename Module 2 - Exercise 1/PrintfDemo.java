  public class PrintfDemo {
      public static void main(String[] args) {  
 
        // Define two companies
        String company1 = "Cost Plus" ;
        char category1 = 'I' ;
        int employees1 = 6127 ; 
        double revenue1 = 868024134.21 ;

        String company2 = "Joe's Market" ; 
        char category2 = 'R' ;
        int employees2 = 37 ; 
        double revenue2 = 3094291.83 ;

        // Print a ruler
        System.out.println("         1         2         3         4         5\n" +  
            "12345678901234567890123456789012345678901234567890\n") ;

        System.out.printf("%-40s*%n", company1) ;
        System.out.printf("%40s*%n", company1) ;
        System.out.printf("%10c*%n", category1) ;
        System.out.printf("%,20d*%n", employees1) ;
        System.out.printf("%,20.2f*%n", revenue1) ;



        System.out.printf("%-40s*%n", company2) ;
                System.out.printf("%40s*%n", company2) ;
        System.out.printf("%10c*%n", category2) ;
        System.out.printf("%,20d*%n", employees2) ;
        System.out.printf("%,20.2f*%n", revenue2) ;
      }
  }
