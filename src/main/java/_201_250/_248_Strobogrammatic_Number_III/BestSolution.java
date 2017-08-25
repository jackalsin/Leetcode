package _201_250._248_Strobogrammatic_Number_III;

/**
 * @author jacka
 * @version 1.0 on 8/24/2017.
 */
public class BestSolution {
  char[] one={'0','1','6','8','9'},two={'0','1','9','8','6'};
  int count=0;
  public int strobogrammaticInRange(String low, String high) {
    if(low.length()>high.length()) return 0;
    int[][] dp=new int[high.length()+1][2];
    dp[0][0]=0;
    dp[0][1]=1;
    dp[1][0]=3;
    dp[1][1]=3;
    for(int i=2;i<=high.length();i++){
      dp[i][0]=dp[i-2][1]*4;
      dp[i][1]=dp[i-2][1]*5;
    }
    recurse(low.length(),0,low.length()-1,low.toCharArray(),dp);
    int tmp=count,total=0;
    count=0;
    if(!recurse(high.length(),0,high.length()-1,high.toCharArray(),dp)) count++;
    for(int i=low.length();i<high.length();i++){
      total+=dp[i][0];
    }
    return (total-tmp+count>=0)?total-tmp+count:0;
  }
  public boolean recurse(int lvl,int start,int end,char[] arr,int[][] dp){
    if(start>end) return false;
    else if(start==end){
      if(arr[start]>'0') count++;
      if(arr[start]>'1') count++;
      if(arr[start]>'8') count++;
      if(arr[start]=='0'||arr[start]=='1'||arr[start]=='8') return false;
      return true;
    }
    else{
      for(int i=((lvl==arr.length)?1:0);i<one.length;i++){
        if(arr[start]==one[i]){
          if(!recurse(lvl-2,start+1,end-1,arr,dp)){
            if(arr[end]==two[i]) return false;
            if(arr[end]>two[i]) count++;
          }
          return true;
        }
        if(arr[start]>one[i]) count+=(dp[lvl][0]/4);
        else break;
      }
      return true;
    }
  }
}
