package hulu.multiQueue;

import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 12/16/2019
 */
public interface MultiQueue {

//  应该是Python职位.
//
//      有多个队列　比如　array 1 [0,1, 2 3]  arry 2 [4, 5 , 6, 7]
//  实现以下接口：
//      1. add( array)
//2.read(int number)  eg: read(2) return 0,1  read(3) return 2, 3,4
//      3. remove(array)

  void add(int[] arr);

  List<Integer> read(int k);

  void remove(int[] arr);
}
