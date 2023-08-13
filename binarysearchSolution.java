import java.util.Scanner;
abstract class binarySearch{
    public int[][] matrix;
    public int target;
    public binarySearch(int[][] matrix,int target){
        this.matrix=matrix;
        this.target=target;
    }
    public int[][] getMatrix(){
        return matrix;
    }
    public int getTarget(){
        return target;
    }
    abstract public boolean targetFound();
    public void getDetails(){
        System.out.println("Method: "+ this.getClass().getSimpleName());
        System.out.println("");
        System.out.println("Do target found in matrix: "+ this.targetFound());
    }


}
class binaySearchA extends binarySearch{
    public binaySearchA(int[][] matrix,int target) {
        super(matrix,target);
    }
    @Override
    public boolean targetFound(){
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }
}
class binarySearchB extends binarySearch{
    public binarySearchB(int[][] matrix,int target){
        super(matrix,target);
    }
    @Override
    public boolean targetFound(){
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m-1;
        while(low<=high){
            int mid = (low + high) /2;
            if(target>=matrix[mid][0] && target<=matrix[mid][n-1]){
                boolean found = binarSearchin1Darray(matrix[mid],target);
                return found;
            }
            if(target<matrix[mid][0]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
    public boolean binarSearchin1Darray(int[] arr,int k){
        int len = arr.length;
        int low = 0;
        int high = len-1;
        while(low<=high){
            int mid = (low +high) /2;
            if(k==arr[mid]){
                return true;
            }
            if(k<arr[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}
class binarySearchC extends binarySearch{
    public binarySearchC(int[][] matrix,int target){
        super(matrix,target);
    }
    @Override
    public boolean targetFound(){
        int m = matrix.length;
        int n= matrix[0].length;
        int i=m-1,j=0 ;
        while(i>=0 && j<n){
            if(target==matrix[i][j]){
                 return true;
            }
            if(target<matrix[i][j]){
                i--;
            }
            else{
                j++;
            }
        }
        return false;
    }
}
public class binarysearchSolution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter rows of array: ");
        int m = sc.nextInt();
        System.out.println("enter column of array: ");
        int n =sc.nextInt();
        int[][] matrix=new int[m][n];
        System.out.println("enter array element in non-decreasing order: ");
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=sc.nextInt();
            }
        }
        System.out.println("enter target element: ");
        int target = sc.nextInt();
        binarySearch a = new binaySearchA(matrix,target);
        binarySearch b = new binarySearchB(matrix, target);
        binarySearch c = new binarySearchC(matrix, target);
        a.getDetails();
        b.getDetails();
        c.getDetails();
        sc.close();
    }
}