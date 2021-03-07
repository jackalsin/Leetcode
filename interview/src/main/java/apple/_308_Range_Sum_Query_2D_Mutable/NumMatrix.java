package apple._308_Range_Sum_Query_2D_Mutable;

/**
 * @author jacka
 * @version 1.0 on 3/3/2021
 */
public interface NumMatrix {

   void update(int row, int col, int val);

   int sumRegion(int row1, int col1, int row2, int col2);
}
