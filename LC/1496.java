import java.util.HashMap;

import java_helper.GeneralHelper;

class Solution1496 {
  public boolean isPathCrossing(String path) {
    HashMap<Integer, int[]> coordinatesVisited = new HashMap<>();
    int x = 0;
    int y = 0;
    int offset = path.length();

    coordinatesVisited.put(y, new int[(path.length() * 2) + 1]);
    coordinatesVisited.get(y)[x + offset] = 1;

    for (char character : path.toCharArray()) {
      switch (character) {
        case 'N': y += 1; break;
        case 'S': y -= 1; break;
        case 'E': x += 1; break;
        case 'W': x -= 1; break;
      }

      if (!coordinatesVisited.containsKey(y)) {
        coordinatesVisited.put(y, new int[(path.length() * 2) + 1]);
      }

      int[] row = coordinatesVisited.get(y);

      if (row[x + offset] == 1) return true;
      
      row[x + offset] = 1;
    }

    return false;
  }

  public static void main(String[] args) {
    Solution1496 sol = new Solution1496();

    String[] testCases = {
      "NES",                 // Simple path, no crossing                → expected: false
      "NESWW",               // Crosses origin again                    → expected: true
      "N",                   // Single move                             → expected: false
      "NS",                  // Back to origin                          → expected: true
      "NSEW",                // Returns to origin after loop            → expected: true
      "NNNN",                // Only goes north                         → expected: false
      "NENW",                // Small square, returns to start          → expected: true
      "NNSS",                // Moves up and back down along same line  → expected: true
      "NEESSW",              // Ends at new point, no crossing          → expected: false
      "NWNES",               // Crosses at midpoint                     → expected: true
      "EEEEE",               // Long straight east path, no cross       → expected: false
      "NESWNESW",            // Multiple loops, crosses multiple times  → expected: true
      "NSSENNWWS",           // Complex path, returns to origin         → expected: true
      "NNNNSSSSEEEEWWWW",    // Full box, crosses edges                 → expected: true
      "ENWS",                // Smallest loop (1 of each direction)     → expected: true
      "EEEEEEEEEE",          // Long path, no crossing (performance)    → expected: false,
      "NSEWNSEWNSEW",        // Repeated loops                          → expected: true
      "EWSN",                // Crosses origin at the end               → expected: true,
      "NWNWNWNWNW",          // Zig-zag, never revisits                 → expected: false,
      "NSEWSENW",            // Random mixed path                       → expected: true
    };

    for (String path : testCases) {
      boolean result = sol.isPathCrossing(path);
      GeneralHelper.printResult(path, result);
    }
  }
}