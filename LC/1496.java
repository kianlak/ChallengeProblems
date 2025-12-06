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
      "NES",                 // Simple path, no crossing
      "NESWW",               // Crosses origin again
      "N",                   // Single move
      "NS",                  // Back to origin
      "NSEW",                // Returns to origin after loop
      "NNNN",                // Only goes north
      "NENW",                // Small square, returns to start 
      "NNSS",                // Moves up and back down along same line
      "NEESSW",              // Ends at new point, no crossing
      "NWNES",               // Crosses at midpoint 
      "EEEEE",               // Long straight east path, no cross
      "NESWNESW",            // Multiple loops, crosses multiple times 
      "NSSENNWWS",           // Complex path, returns to origin
      "NNNNSSSSEEEEWWWW",    // Full box, crosses edges
      "ENWS",                // Smallest loop (1 of each direction)
      "EEEEEEEEEE",          // Long path, no crossing (performance)
      "NSEWNSEWNSEW",        // Repeated loops    
      "EWSN",                // Crosses origin at the end
      "NWNWNWNWNW",          // Zig-zag, never revisits 
      "NSEWSENW",            // Random mixed path 
    };

    for (String path : testCases) {
      boolean result = sol.isPathCrossing(path);
      GeneralHelper.printResult(path, result);
    }
  }
}