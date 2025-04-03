class Permutation {
	
	public List<String> permutation(String s) {
		if (null == s || s.isBlank()) {
			return Collections.emptyList();
		}
		
		if (1 == s.length()) {
			return List.of(s);
		}
		
		var res = new ArrayList<String>();
		helper(s, 0, res);
		return res;
	}

	private void helper(String s, int l, List<String> res) {
		if (l == s.length()) {
			res.add(s);
			return;
		}
		
		for (int i = l; i < s.length(); i++) {
			if (l != i && !canPermute(s, l, i)) {
				continue;
			}
			
			s = swap(s, l, i);
			helper(s, l+1, res);
			s = swap(s, l, i);
		}
	}

	private boolean canPermute(String s, int low, int end) {
		for (int i = low; i < end; i++) {
			if (s.charAt(i) == s.charAt(end)) {
				return false;
			}
		}
		
		return true;
	}

	private String swap(String s, int left, int right) {
		var sb = new StringBuilder(s);
		char temp = sb.charAt(left);
		sb.setCharAt(left, sb.charAt(right));
		sb.setCharAt(right, temp);
		return sb.toString();
	}
}
