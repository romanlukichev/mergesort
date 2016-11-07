package algo.mergesort;

public class App {

    public static void main(String[] args) {
	//int[] myArray1 = { 12 , 7 , 5 , 0 , 9 , 2 };
        int[] myArray1 = { 8 , 3 , 2 , 9 , 7 , 1 , 5 , 4 };
        //int[] myArray1 = { 8 , 3   };
        //int[] myArray1 = { };

        printArray(myArray1);


        int[] myArray2 = mergeSort( myArray1 , 0 , myArray1.length - 1  );

        System.out.println(" \nsorted array");

        printArray(myArray1);
    }

    private static int[] mergeSort( int[] A , int p , int r ){

        System.out.println("\nCalling MergeSort(" + p + " " + r + " )");
        int q=0;

        // test output
        if( p==r && p<A.length ){
             System.out.println("{ " + A[p] + " }");
            // System.out.print(" p=" + p + " " );
        } else {
             System.out.print("{ ");
            for (int i = p; i <= r; i++) {
                System.out.print(A[i] + " ");
            }
           System.out.print(" }");
        }

        if(p<r){
            q = ((p+r)/2);
            //System.out.println( "midPoint=" + q );
            mergeSort(A , p   , q );
            mergeSort(A , q+1 , r );

            merge(A , p , q , r );
        }




        return A;
    }


    private static int[] merge( int[] A , int p , int q , int r ){
        System.out.println("\nCalling merge( A " + p + " " + q + " " + r + " )");

        // compute the number of elements in each sub array
        int left_cnt = q - p +1 ;  // in the left sorted array
        int right_cnt = r - q ;  // in the right sorted array

        int j = 0 ; // variable for iterating through array
        int i = 0; // variable for iterating through array

        int[] L = new int[left_cnt+1];
        int[] R = new int[right_cnt+1];
//        System.out.println("left_cnt="+left_cnt);
//        System.out.println("right_cnt="+right_cnt);

        // copy elements into new arrays
        System.out.print("\n filling left array ");
        for( i=0 ; i<left_cnt ; i++ ){

//            System.out.println("i="+left_cnt);
//            System.out.println("( p + i ) =" + ( p + i ) );
//            System.out.println("A[p+i]=" + A[ p + i ] + " copied into L["+i+"]");
            L[i] = A[ p + i ];

        }


        System.out.println(" - filling right array ");
        for( j=0 ; j<right_cnt ; j++ ){
//            System.out.println("j="+right_cnt);
//            System.out.println("( q + j ) =" + ( q + j ) );
            R[j] = A[ q + j +1 ];
        }


        L[ left_cnt  ] = 2147483647; // infinity
        R[ right_cnt  ] = 2147483647; // infinity


        printArray(L);
        printArray(R);

        i = 0;
        j = 0;

        for (int k=p ; k<=r ; k++ ){
            if( L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }
            else {
                A[k] = R[j];
                j++;
            }
        }

        System.out.println("\n returning array from merge() " );
        printArray(A);
        return A;
    }

    private static void printArray(int[] inArray1){
        System.out.print("{ ");
        for(int i=0 ; i<inArray1.length ; i++){
            System.out.print(inArray1[i] + " ");

        }
        System.out.print(" }");

    }
}
