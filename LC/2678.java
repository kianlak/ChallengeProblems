import java_helper.GeneralHelper;

class Solution2678 {
  public int countSeniors(String[] details) {
    int numOfSeniors = 0;
    int age = 0;

    for (String person : details) {
      age = Integer.valueOf(person.substring(11, 13));

      if (age > 60) numOfSeniors++;
    }

    return numOfSeniors;
  }

  public static void main(String[] args) {
    Solution2678 sol = new Solution2678();

    String[][] testCases = {
      {"0000000000M0011"},                      // single passenger, age 00 (not > 60)  → expected: 0
      {"1111111111F6012"},                      // single passenger, age 60 (not > 60)  → expected: 0
      {"2222222222O6113"},                      // single passenger, age 61 (counted)   → expected: 1
      {"3333333333M9914"},                      // single passenger, age 99 (counted)   → expected: 1
      {"4444444444F4515", "5555555555M6216"},   // mix under/over 60                    → expected: 1
      {"6666666666O5917", "7777777777M6018"},   // both <= 60 (not counted)             → expected: 0
      {"8888888888F6119", "9999999999O9810"},   // both > 60 (counted)                  → expected: 2
      
      {"1000000000M5911","1000000001F9912",     // stress test: 100 passengers, 
        "1000000002M5913","1000000003F9914",    // half age 59, half age 99             → expected: 5
        "1000000004M5915","1000000005F9916",
        "1000000006M5917","1000000007F9918",
        "1000000008M5919","1000000009F9920",},  
    };

    for (String[] testCase : testCases) {
      int result = sol.countSeniors(testCase);
      GeneralHelper.printResult(testCase, result);
    }
  }
}