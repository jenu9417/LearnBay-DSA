# Huffman Coding

#### Motivation
While sending data over network or other constrained resources, we need to send the data in a more efficient way. ie, Sending the data without sending it as it is. This urged the discovery of various encoding schemes.
  - Fixed Length Encoding
  - Variable Length Encoding

##### Fixed Length Encoding
 Here we use, fixed length codes assigned to each character in a message, and we will send both character-code mapping as well as the message in reduced form.
 
##### Variable Length Encoding
This was an improvisation over fixed length encoding, where we use non-conflicting variable length codes instead of fixed length code. We use this variable length code to assigned to each distinct character in the message and we will send both character-code mapping as well as the message in reduced form.

#### Huffman Encoding
Huffman Coding (a.k.a "Huffman Encoding") is an alogorithm, widely used for loseless data compression. It makes use of variable-length code. Originally developed by **Davaid.A.Huffman** in 1952.

Inorder to find Huffman encoding, we need to construct a tree based on the frequency of each character in the message. This tree is known as **Huffman Tree**. The characters will form each of the lead nodes and we will build the tree, bottom-up. Now based of the relative position of the edges, the path from root to leaf, of each character represents the huffman code for the character.

The 2 procedures involved in Huffman Coding are:
 - Constructing the Huffman tree
 - Parsing the Huffman tree and assigning code to character.

##### Construct the Huffman tree
 - Create leaf-node for each unique character.
 - Add them to a priority-queue(min-heap), by comparing the frequency of character.
 - Take out the first two elements from priority-queue. Combine the frequency value of the two nodes to
   form the root node. Assign the two elements take-out as the left and right child. Add the newly formed
   root node back to the priority-queue.
 - Repeat the above step, until the priority queue contains only one node. This will be the actual root node of Huffman Tree.


##### Parse the Huffman tree and assign code to character
 - Do a DFS traversal from the root. Assume that we assign "0" to the left edge and "1" to the right edge.
 - As and when you visit a leaf node, the root to leaf path consisting of 0's and 1's will be the code for that character.
