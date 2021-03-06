
/**
 * WC15 - This is a review of all kinds of concepts.
 * Only use AP official subset methods for ArrayLists, Strings, 1D arrays, etc.
 * These methods focus on various arrays, loops, and whatever else I think
 * you need practice on.
 * @version 1.0
 */

import java.util.ArrayList;
import java.util.List;

public class WC15
{
  private static final int TWO_FOR_SUBSTRINGS = 2;
  private static final int DIVISIOR = 2;

  /**
   * 
   * Given a string of odd length, return the string length 3 from its middle,
   * so "Candy" yields "and".
   * 
   * <pre>
   * The string length will be at least 3.
   * 
   * middleThree("Candy") -> "and" 
   * middleThree("and") -> "and"
   * middleThree("solving") -> "lvi"
   * </pre>
   * 
   * @param letters
   * @return
   */
  public static String centralThree(String letters)
  {
    return letters.substring(letters.length() / DIVISIOR - 1,
      letters.length() / DIVISIOR + DIVISIOR);
  }

  /**
   * Given a string, return a version without the first 2 chars. Except keep the
   * first char if it is 'a' and keep the second char if it is 'b'. The string
   * may be any length. Harder than it looks.
   * 
   * <pre>
   * PRECONDITION: str will be lowercase and length will be at least two
   * deFront("Hello") -> "llo" 
   * deFront("java") -> "va" 
   * deFront("away") -> "aay"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String chopFront(String str)
  {
    // TODO: Finish
    String ans = "";
    if (str.substring(0, 1).equals("a"))
    {
      ans += "a";
    }
    if (str.substring(1, TWO_FOR_SUBSTRINGS).equals("b"))
    {
      ans += "b";
    }
    ans += str.substring(TWO_FOR_SUBSTRINGS);
    return ans;
  }

  /**
   * 
   * Given a string, if one or both of the first 2 chars is 'x', return the
   * string without those 'x' chars, and otherwise return the string unchanged.
   * This is a little harder than it looks.
   * 
   * <pre>
   * withoutX2("xHi") -> "Hi" 
   * withoutX2("Hxi") -> "Hi" 
   * withoutX2("Hi") -> "Hi"
   * </pre>
   * 
   * @param str
   * @return
   */
  public static String hateX(String str)
  {
    // TODO: Finish
    String ans = "";
    boolean x1 = false;
    boolean x2 = false;
    if (str.substring(0, 1).equals("x"))
    {
      x1 = true;
    }
    if (str.substring(1, TWO_FOR_SUBSTRINGS).equals("x"))
    {
      x2 = true;
    }
    if (!x1)
    {
      ans += str.substring(0, 1);
    }
    if (!x2)
    {
      ans += str.substring(1, TWO_FOR_SUBSTRINGS);
    }
    ans += str.substring(TWO_FOR_SUBSTRINGS);
    return ans;
  }

  /**
   * Swaps all values in the specified 2 rows of mat.
   * 
   * @param mat
   *          the array
   * @param rowAIndex
   *          the index of a row to be swapped
   * @param rowBIndex
   *          the index of a row to be swapped
   */
  public static void swapRows(int[][] mat, int rowAIndex, int rowBIndex)
  {

    int[] temp = mat[rowAIndex];
    mat[rowAIndex] = mat[rowBIndex];
    mat[rowBIndex] = temp;

  }

  /**
   * Swaps all values in the specified 2 columns of mat.
   * 
   * @param mat
   *          the array
   * @param colAIndex
   *          the index of a column to be swapped
   * @param colBIndex
   *          the index of a column to be swapped
   */
  public static void swapColumns(int[][] mat, int colAIndex, int colBIndex)
  {
    int temp[] = new int[mat[0].length];

    for (int i = 0; i < mat.length; i++)
    {
      temp[i] = mat[i][colAIndex];
    }
    for (int i = 0; i < mat.length; i++)
    {
      mat[i][colAIndex] = mat[i][colBIndex];
      mat[i][colBIndex] = temp[i];
    }

  }

  /**
   * Returns an array with the specified number of rows and columns containing
   * the characters from str in row-major order. If str.length() is greater than
   * rows * cols, extra characters are ignored. If str.length() is less than
   * rows * cols, the remaining elements in the returned array contain null.
   * 
   * @param str
   *          the string to be placed in an array
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the characters from str in row-major order
   */
  public static String[][] fill2DWithLetters(String str, int rows, int cols)
  {
    String[][] arr = new String[rows][cols];
    int letters = 0;
    for (int r = 0; r < rows; r++)
    {
      for (int c = 0; c < cols && letters < str.length(); c++)
      {
        arr[r][c] = str.substring(letters, letters + 1);
        letters++;
      }
    }

    return arr;
  }

  /**
   * Returns an array with the specified number of rows and columns that
   * contains the elements of vals in the order specified below. Elements from
   * vals are placed in the array by moving down the first column, up the second
   * column and so on.
   * 
   * <pre>
   * For example, if vals was:
   * {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
   * 
   * rows was 3 and cols was 4,
   * the returned array would be:
   * { {1, 6, 7, 12},
   *   {2, 5, 8, 11},
   *   {3, 4, 9, 10} }
   * 
   * Precondition: vals.length == rows * cols
   * </pre>
   * 
   * @param vals
   *          the elements
   * @param rows
   *          the number of rows in the array to be returned
   * @param cols
   *          the number of columns in the array to be returned
   * @return an array containing the elements from vals in the specified order
   */
  public static int[][] fillDownAndUp(int[] vals, int rows, int cols)
  {
    // TODO: Finish
    int[][] arr = new int[rows][cols];
    int iterations = 0;
    for (int c = 0; c < cols; c++)
    {
      for (int r = 0; r < rows; r++)
      {
        arr[r][c] = vals[iterations];
        iterations++;
      }
      c++;
      if (c < cols)
      {
        for (int r = rows - 1; r >= 0; r--)
        {
          arr[r][c] = vals[iterations];
          iterations++;
        }
      }

    }

    return arr;
  }

  /**
   * Returns a smaller array containing the elements in the specified range of
   * the mat.
   * 
   * For example,
   * 
   * <pre>
   * mat: { {10, 9, 8, 7}, 
   *        {6, 5, 4, 3}, 
   *        {2, 1, -1, 0} }
   * 
   * startRow: 0, startCol: 1, endRow: 1, endCol: 2
   * 
   * would yield: { {9, 8},
   *                {5, 4} }
   * </pre>
   * 
   * @param mat
   *          the 2D array containing the original elements
   * @param startRow
   *          the first row to be kept
   * @param startCol
   *          the first column to be kept
   * @param endRow
   *          the last row to be kept
   * @param endCol
   *          the last column to be kept
   * @return a smaller array containing the specified elements
   */
  public static int[][] crop2D(int[][] mat, int startRow, int startCol,
      int endRow, int endCol)
  {
    // TODO: Finish
    int[][] arr = new int[endRow - startRow + 1][endCol - startCol + 1];

    int arrrow = 0;
    for (int r = startRow; r <= endRow; r++)
    {
      int arrcol = 0;
      for (int c = startCol; c <= endCol; c++)
      {
        arr[arrrow][arrcol] = mat[r][c];
        arrcol++;
      }
      arrrow++;
    }
    return arr;
  }

}