import java.util.HashMap;
public class Trie
{
    private String currentKey; 
    // implementing a HashMap for the Trie
    private HashMap<Character, HashMap> trie;
  
    // trie constructor
    public Trie()
    {
        trie = new HashMap<Character, HashMap>();
    }
  
    public Trie(String starting)
    {
        trie = new HashMap<Character, HashMap>();
        add(starting);
    }

    // adds to the trie
    private void add(String str)
    {
        HashMap<Character, HashMap> node = trie;
        int i = 0;
        while (i < str.length()) 
        {
            // if node already has that key then point to it instead
            if (node.containsKey(str.charAt(i))) 
            {
                node = node.get(str.charAt(i));
            }
            else 
            {
                // else make a new hashmap
                node.put(str.charAt(i), new HashMap<Character, HashMap>());
                node = node.get(str.charAt(i));
            }
            i++;
        }
        node.put('\0', new HashMap<Character, HashMap>(0));
        currentKey += str;
    }

    public String findWordAtKey(String key)
    {
        HashMap<Character, HashMap> currentNode = trie;
        int i = 0;
        while (i < key.length()) 
        {
            if (currentNode.containsKey(key.charAt(i))) 
            {
                currentNode = currentNode.get(key.charAt(i));
            }
            else 
            {
                return "";
            }
            i++;
        }

        if (currentNode.containsKey('\0')) 
        {
            String s = "" +(currentNode.get('\0')).get(currentKey);
            return s;
        }
        else 
        {
            return "";
        }
    }

    @Override
    public String toString() 
    {
        return findWordAtKey(currentKey);
    }
  
}
