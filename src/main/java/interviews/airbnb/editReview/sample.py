class TrieNode:
    def __init__(self):
        self.children = {}
        self.end = None
 
class Trie:
    def __init__(self):
        self.root = TrieNode()
 
    def add_word(self, word, entity):
        self.cur = self.root
        for ch in word:
            if ch not in self.cur.children:
                self.cur.children[ch] = TrieNode()
            self.cur = self.cur.children[ch]
        self.cur.end = entity
 
    def search(self, s):
        self.cur = self.root
        last_entity = None
        last_pos = None
        for i in range(len(s)):
            ch = s[i].lower()
            if self.cur.end is not None:
                last_entity = self.cur.end
                last_pos = i
            if ch not in self.cur.children:
                return [last_entity,last_pos]
            self.cur = self.cur.children[ch]
        return [last_entity,last_pos]
 
class solution:
    def __init__(self):
        self.token_seperator = [" "]
 
    def parse(self, review, words):
        trie = Trie()
        for keyword, entity in words.items():
            trie.add_word(keyword.lower(), entity)
        start_pos = 0
        annotated_review = ""
        while start_pos < len(review):
            entity, last_pos = trie.search(review[start_pos:])
 
            #if entity matched
            if entity is not None:
                annotated_review += "[" + entity +"]{" + review[start_pos: start_pos+last_pos]+ "}"
                start_pos = start_pos + last_pos
 
            #if entity not matched, then add original text till token seperator hits
            while start_pos < len(review) and review[start_pos] not in self.token_seperator:
                annotated_review += review[start_pos]
                start_pos += 1
 
            #add token seperator in
            if start_pos < len(review):
                annotated_review += review[start_pos]
            start_pos += 1
 
        return annotated_review
 
review = "I booked a house on Airbnb for my trip in san francisco. It was a lovely experience."
words = {"Airbnb": "business", "san francisco": "city", "san": "name"}
s = solution()
print(s.parse(review, words))