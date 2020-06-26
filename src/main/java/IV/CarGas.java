package IV;

public class CarGas {

  public static void main (String[] args) {
      int n = 100;
      int[] b = new int[n];
    int[] a = new int[n];


    int min=0;
    for (int i=0;i<a.length;i++){
      if(a[i]>=b[i]){
        if(i+1<a.length) {
          if (checkRecur (a, b, i + 1, a[i], b[i], i)) {
            min = i;
            break;
          }
        }else{
          if (checkRecur (a, b, 0, a[i], b[i], i)) {
            min = i;
            break;
          }
        }
      }
    }

    System.out.println (min);
  }




  private static boolean checkRecur (int[] a, int[] b, int current,int sum_a,int sum_b,int end) {

    if(current==end){
      return sum_a+a[current]>=sum_b+b[current];
    }else{
      if(sum_a+a[current]>=sum_b+b[current]){
        if(current+1<a.length){
          return checkRecur (a,b,current+1,sum_a+a[current],sum_b+b[current],end);
        }else{
          return checkRecur (a,b,0,sum_a+a[current],sum_b+b[current],end);
        }
      }else{
        return false;
      }
    }


  }
}
