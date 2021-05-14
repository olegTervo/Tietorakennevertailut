# Määrittelydokumentti

Työ on Helsingin Yliopiston Tietorakenteet ja algoritmit kursin harjoitustyö. Vertailen 4 tietorakennetta, niiden aikavaatimukset ja tarkoitukset. Selvitän, missä tilanteessa kukin on paras.

## [Trie](https://en.wikipedia.org/wiki/Trie) (1912 discribed, 1959 implementation)
- also called digital tree or prefix tree, is a type of search tree, a tree data structure used for locating specific keys from within a set. These keys are most often strings, with links between nodes defined not by the entire key, but by individual characters. In order to access a key (to recover its value, change it, or remove it), the trie is traversed depth-first, following the links between nodes, which represent each character in the key.  

![A trie for keys "A", "to", "tea", "ted", "ten", "i", "in", and "inn".](https://upload.wikimedia.org/wikipedia/commons/b/be/Trie_example.svg)

### Complexity
O(W*L) (W-words, L-average length)

## [Binomial heap](https://en.wikipedia.org/wiki/Binomial_heap) (1978)
- a data structure that acts as a priority queue but also allows pairs of heaps to be merged. It is important as an implementation of the mergeable heap abstract data type (also called meldable heap), which is a priority queue supporting merge operation. It is implemented as a heap similar to a binary heap but using a special tree structure that is different from the complete binary trees used by binary heaps. Binomial heaps were invented in 1978 by Jean Vuillemin. 

![A trie for keys "A", "to", "tea", "ted", "ten", "i", "in", and "inn".](https://upload.wikimedia.org/wikipedia/commons/6/61/Binomial-heap-13.svg)

### Complexity
getMax() - O(1)  
popMax() - O(log n)  
insert() - O(1)  
change() - O(log n)  
merge() - O(log n)

## [Fibonacci heap](https://en.wikipedia.org/wiki/Fibonacci_heap) (1984)
- a data structure for priority queue operations, consisting of a collection of heap-ordered trees. It has a better amortized running time than many other priority queue data structures including the binary heap and binomial heap. Michael L. Fredman and Robert E. Tarjan developed Fibonacci heaps in 1984 and published them in a scientific journal in 1987. Fibonacci heaps are named after the Fibonacci numbers, which are used in their running time analysis.  

![A trie for keys "A", "to", "tea", "ted", "ten", "i", "in", and "inn".](https://upload.wikimedia.org/wikipedia/commons/c/cb/Fibbonachi_kucha.GIF)

### Complexity
getMax() - O(1)  
popMax() - O(log n)  
insert() - O(1)  
change() - O(1)  
merge() - O(1)

## [Red–black tree](https://en.wikipedia.org/wiki/Red%E2%80%93black_tree) (1972)
- is a kind of self-balancing binary search tree. Each node stores an extra bit representing "color" ("red" or "black"), used to ensure that the tree remains balanced during insertions and deletions.

### Properties
- Each node is either red or black.
- All NIL leaves (figure 1) are considered black.
- If a node is red, then both its children are black.
- Every path from a given node to any of its descendant NIL leaves goes through the same number of black nodes.

![A trie for keys "A", "to", "tea", "ted", "ten", "i", "in", and "inn".](https://upload.wikimedia.org/wikipedia/commons/4/41/Red-black_tree_example_with_NIL.svg)

### Complexity
getMax() - O(log n)  
delete() - O(log n)  
insert() - O(log n)  

### Käyttö
set, map (STL-kirjasto C++)  
TreeMap Java

## Lähteet

[Wikipedia](https://en.wikipedia.org/)
