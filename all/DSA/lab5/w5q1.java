import java.util.*;
import java.lang.*;

class Linearsearch{
void Search(float arr[], int n, float key){
long startTime = System.nanoTime();
int iter=0;
for(int i=0;i<n;i++){
iter++;
System.out.println("Current Index:"+i);
if (arr[i]==key){
long endTime = System.nanoTime();
long executionTime = (endTime - startTime) / 1000000;
System.out.println("FOUND! at "+i);
break;
}
    long endTime = System.nanoTime();
    long executionTime = (endTime - startTime) / 1000000;
    System.out.print("Value could not be found");
    System.out.print("Time Taken:"+executionTime+"ms, No of Iterations:"+iteratio
}}}



class BinarySearch{
int BinarySearch(float arr[], int n, float key) {
long startTime = System.nanoTime();
    int low = 0, high = n - 1;
    int iterations = 0;
    while (low <= high) {
        iterations++;
        int mid = low + (high - low) / 2;
        System.out.println("Binary Search Checking index:" + mid);
        if (arr[mid] == key){ 
        long endTime = System.nanoTime();
        long executionTime = (endTime - startTime) / 1000000;
        System.out.print("Time Taken:"+executionTime+"ms, No. of Iterations:"+iterations+", the value is found in Index:"+mid);
        return mid;}
        else if (arr[mid] < key) low = mid + 1;
        else high = mid - 1;
    }
    long endTime = System.nanoTime();
    long executionTime = (endTime - startTime) / 1000000;
    System.out.print("Value could not be found");
    System.out.print("Time Taken:"+executionTime+"ms, No of Iterations:"+iterations);
    return -1;
}
}


class w5q1{
public static void main(String[] args){
Scanner sc= new Scanner(System.in);
float ar[]= new float[1000];
for (int i=0;i<1000;i++){
ar[i]=i;
}

Linearsearch lizs= new Linearsearch();
lizs.Search(ar,1000,69.0f);
}
}