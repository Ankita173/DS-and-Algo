Solving practice.neetcode practice problems: https://practice.neetcode.io/practice
Cheat sheet for Array questions:
1. Find duplicate in an array - 
    Solution 1: T: o(n) S:o(n)
        Iterate the element of array and check if present else insert it in a set. When duplicate element encounters set would already be having it.
2. Validate 2 string as anagram: Anagram where both words has same letters
    Solution 1: T: o(s+k) S: o(s+k)
        Find frequency of each object and check compare frequencies.
    Solution 2: T(n+c) S: o(c) where c = 26
        initialize int array[26] and loop over the both words(in a single loop) and increment index by 1 for first word and decrement index by 1 for second word. If both the words are same array[26] will have all 0's at the end.
3. Find 2 elements in an array whose sum is target. 
    Solution 1: T: o(n) S: o(n)
        If the array is not sorted. Use hashmap to store the target-element diff and lookup in map if the element is present.
    Solution 2: T: o(logN) s: o(1) 
        If the array is sorted. Use two pointer i=0 j=length-1. and either i++ or j-- based on arrya[i]+array[j] compares to target.
4. Group Anagram : Group list of words that are same anagram.
    Solution 1: T: o(NlogN) S: o(N)
        Sort each word and group it st1 == str2 belongs to same group.    
    Solution 2: T: o(N*M) S: o(N*M)
        Calculate frequency of the one word construct a sorted string key like "1a1c1t" and add it to hash set <"1a1c1t", ["cat"]> then evaluate the next word if it s key is same append to the list otherwise insert.
5. Top K frequency of element in an array
    Solutioin 1: T: o(NlogN) s(N)
        Create frequency map of all the elements and desc sort it based on value and loop k times and return the values 
    Solution 2: Using bucket sort for frequency T: o(N) S: o(N)
        Create frequency map of all the elements. Create an array of List[N] and map the frequncy to index an =d value as list of element with that frequency. Then loop the list[] backwards till K elements are not found
6. Product array Except Self: in o(N) and without using divide operation
    Solution 1: T: o(n) + o(n) S: o(1)      
        Update output with forward product output[i] = output[i-1] * nums[i] and then perform backward product output[i] = output[i+1] * product(p*=nums[i])
7. Validate Sudoku: if there is no duplicate value in a row, colunm or block
    Solution 1: T: o(N2) S: o(n2)
    Create List<set> lookup for row, column and block(i/3+j/3) 
8. Longest consequtive sequence: 100,4,200,1,3,2 => 1,2,3,4
    Solution 1: T: o(N) S: 0(N)
        Make a set out of input array. iterate through each i in nums and assuming that i is a start of a sequence and lookup till i+1..i+n is present in set return the max n found for each independent sequence.
        
     
  
