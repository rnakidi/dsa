SlidingWindow high level template

public <return> slidingWindowFunc() {
  int left = 0;
  int right = 0;
  while (right < length) {
    // Apply logic involved with right index
    right++;
      while(condition && left <= right) {
        // Apply logic involved with left index
        if (condition) { // Apply base case if needed
        }
          left++;
      }
      // Collect base case results
  }
  return <return_value>;
}
