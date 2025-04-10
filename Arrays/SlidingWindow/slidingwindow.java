SlidingWindow high level template

public <output_param> slidingWindowFunc(<input_params>) {
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
  return <output_param>;
}
