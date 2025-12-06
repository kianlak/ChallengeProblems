import java_helper.GeneralHelper;

import java.util.Arrays;

class Solution2410 {
  public int matchPlayersAndTrainers(int[] players, int[] trainers) {
    int index = 0;
    int offset = 0;
    int result = 0;

    Arrays.sort(players);
    Arrays.sort(trainers);

    while ((index < players.length) && (index + offset < trainers.length)) {
      if (players[index] <= trainers[index + offset]) result++;
      else {
        offset++;

        while (index + offset < trainers.length) {
          if (players[index] <= trainers[index + offset]) {
            result++;
            break ;
          } else {
            offset++;
          }
        }
      }

      index++;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution2410 sol = new Solution2410();

    int[][] playersCases = {
      {4, 7, 9},              // Normal case
      {1, 1, 1},              // Multiple players, single trainer 
      {5, 10, 15},            // No matches possible 
      {1, 1000000000},        // Extreme values (1 and 1e9)
      {1000000000},           // Single max value 
      {2, 3, 5, 8, 13},       // Increasing sequences 
      {8, 8, 8, 8},           // All equal values
      {1},                    // Smallest input size 
      {1000000000, 999999999} // Near max values
    };
  
    int[][] trainersCases = {
      {8, 2, 5, 8},           // Normal case
      {10},                   // Multiple players, single trainer
      {1, 2, 3},              // No matches possible 
      {5, 999999999},         // Extreme values (small + near max) 
      {1000000000},           // Single max value 
      {1, 2, 3, 5, 8, 21},    // Increasing sequences
      {8, 8, 8, 8},           // All equal values
      {1},                    // Smallest input size 
      {999999999, 1000000000} // Near max values
    };

    for (int i = 0; i < playersCases.length; i++) {
      int result = sol.matchPlayersAndTrainers(playersCases[i], trainersCases[i]);
      GeneralHelper.printResult(playersCases[i], trainersCases[i], result);
    }
  }
}