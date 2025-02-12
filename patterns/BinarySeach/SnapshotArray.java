https://algo.monster/problems/binary-search-speedrun?questionIndex=5

Implement a SnapshotArray that supports the following interface:

SnapshotArray(int length) initializes an array-like data structure with the given length. Initially, each element equals 0.
void set(index, val) sets the element at the given index to be equal to val.
int snap() takes a snapshot of the array and returns the snap_id: the total number of times we called snap() minus 1.
int get(index, snap_id) returns the value at the given index, at the time we took the snapshot with the given snap_id
Example 1:

Input: ["SnapshotArray","set","snap","set","get"]

[[3],[0,5],[],[0,6],[0,0]]

Output: [null,null,0,null,5]

Explanation:

SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3

snapshotArr.set(0,5);  // Set array[0] = 5

snapshotArr.snap();  // Take a snapshot, return snap_id = 0

snapshotArr.set(0,6);

snapshotArr.get(0,0);  // Get the value of array[0] with snap_id = 0, return 5
Constraints:

1 <= length <= 5 * 104
0 <= index < length
0 <= val <= 109
0 <= snap_id < (the total number of times we call snap())
At most 5 * 104 calls will be made to set, snap, and get.
Question
Instead of copying the entire array each time we take a snapshot, we wish to only store the changes to each index. we keep track of an array histories of size n where histories[i] is an array that stores the history of the changes of array[i]'s values. We use the pair (snap_id, value) to indicate that we have updated array[i]=value at the time we took the snapshot with the given snap_id.

So when implementing get(snap_id) for index i, we will do binary search on histories[i] to find the index pos in histories[i] that contains the most recent value up to the time we took the snapshot with the given snap_id.

Given an array history of pairs (snap_id, value) sorted chronologically by snap_id, select the correct implementation for get(snap_id) that finds the index pos?
