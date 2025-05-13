import java.util.*;

public class search{

public static int linear(int[] arr,int target){
     for(int i=0;i<10000;i++){
	if(arr[i] == target){
		return i;
	}
     }
     return -1;
}

public static int binary(int[] arr,int target){
   int l=0;
   int r=9999;
   while(l<=r){
        int mid = (l+r)/2;
	if(arr[mid]==target){
	  return mid;
	}
	else if(arr[mid] > target){
	 r=mid-1;
	}
	else
	 l=mid+1;
   }
   return -1;
}

public static void main(String args[]){
  int[] arr = new int[10000];
  Scanner sc = new Scanner(System.in);
  System.out.println("Enter the target element : ");
  int target = sc.nextInt();
  for(int i=0;i<10000;i++){
	arr[i]=i;
  }
  long startTime = System.nanoTime();
  int res = linear(arr,target);
  long endTime = System.nanoTime();
  long lineartime = endTime - startTime;


  

  long BstartTime = System.nanoTime();
  int bRes = binary(arr,target);
  long BendTime = System.nanoTime();
  long binaryTime = BendTime - BstartTime;


  System.out.println("Linear Index : "+res+" time :  "+(lineartime/(1e+9))+" nanoseconds");
  System.out.println("BS Index : "+bRes+"time:  "+binaryTime+" nanoseconds");
}
}
