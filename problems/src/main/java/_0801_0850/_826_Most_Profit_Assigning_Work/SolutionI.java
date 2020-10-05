package _0801_0850._826_Most_Profit_Assigning_Work;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author jacka
 * @version 1.0 on 9/1/2020
 */
public final class SolutionI implements Solution {
  @Override
  public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
    final int n = difficulty.length;
    final List<Job> jobs = new ArrayList<>();
    for (int i = 0; i < n; ++i) {
      final int d = difficulty[i], p = profit[i];
      jobs.add(new Job(d, p));
    }
    jobs.sort((j1, j2) -> Integer.compare(j1.difficulty, j2.difficulty));
    Arrays.sort(worker);
    int max = 0, sum = 0;
    for (int jobId = 0, workerId = 0; workerId < worker.length; workerId++) {
      final int w = worker[workerId];
      while (jobId < n && jobs.get(jobId).difficulty <= w) {
        final Job curJob = jobs.get(jobId);
        max = Math.max(curJob.profit, max);
        jobId++;
      }
      sum += max;
    }

    return sum;
  }

  private static final class Job {
    private final int difficulty, profit;

    private Job(int difficulty, int profit) {
      this.difficulty = difficulty;
      this.profit = profit;
    }
  }

}
