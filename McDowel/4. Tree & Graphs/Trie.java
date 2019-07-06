class Trie {
	static TrieNode root;
	static final int ALPHABET_SIZE = 26;

	static class TrieNode {
		TrieNode childArray[] = new TrieNode[ALPHABET_SIZE];
		boolean isEnd;

		TrieNode() {
			for (TrieNode ech : childArray) {
				ech = null;
			}
			isEnd = false;
		}
	}

	void insert(String str) {
		TrieNode node = root;
		for (char ch : str.toCharArray()) {
			int index = ch - 'a';
			if (node.childArray[index] == null) {
				node.childArray[index] = new TrieNode();
			}
			node = node.childArray[index];
		}
		node.isEnd = true;
	}	

	boolean find(String str) {
		TrieNode node = root;
		for (char ch : str.toCharArray()) {
			int index = ch - 'a';
			if (node.childArray[index] == null) {
				return false;
			}
			node = node.childArray[index];
		}
		return node.isEnd;
	}

	public static void main(String argr[]) {
		Trie tr = new Trie();
		tr.root = new TrieNode();
		tr.insert("art");
		tr.insert("daemon");
		tr.insert("casual");

		System.out.println(tr.find("art"));/*
		String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        	String output[] = {"Not present in trie", "Present in trie"}; 
       
       
       		root = new TrieNode(); 
       
        	// Construct trie  
        	for (int i = 0; i < keys.length ; i++) 
        	    tr.insert(keys[i]); 
       
        	// Search for different keys 
        	if (tr.find("the") == true) 
            		System.out.println("the --- " + output[1]); 
        	else	System.out.println("the --- " + output[0]); 
          
        	if (tr.find("these") == true) 
	            System.out.println("these --- " + output[1]); 
	        else System.out.println("these --- " + output[0]); 
          
	        if (tr.find("their") == true) 
	            System.out.println("their --- " + output[1]); 
	        else System.out.println("their --- " + output[0]); 
	          
	        if (tr.find("thaw") == true) 
	            System.out.println("thaw --- " + output[1]); 
	        else System.out.println("thaw --- " + output[0]);*/
	}
}
