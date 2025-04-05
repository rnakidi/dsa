https://algo.monster/problems/binary-search-speedrun?questionIndex=7
left, right, pos = 0, len(history)-1, -1
while left <= right:
    mid = (left+right) // 2
    if history[mid][0] <= timestamp:
        left = mid + 1
        pos = mid
    else:
        right = mid - 1
