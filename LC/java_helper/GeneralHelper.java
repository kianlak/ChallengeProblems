package java_helper;
import java.util.Arrays;

public class GeneralHelper {
    private static int caseNum = 1;
    
    /* Input int[]
     * Result int
    */
    public static void printResult(int[] nums, int result) {
        System.out.println("Test Case #" + caseNum++);
        System.out.println("Input : " + Arrays.toString(nums));
        System.out.println("Result: " + result);
        System.out.println();
    }
}