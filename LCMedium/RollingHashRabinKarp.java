package LeetCodeMedium;

public class RollingHashRabinKarp {
        // d is the number of characters in the input alphabet
        public final static int radix = 26;

        static void search(String pat, String txt, int primeNum)
        {
            int patternLen = pat.length();
            int textLen = txt.length();

            int i, j;

            int patternHash = 0; // hash value for pattern
            int textHash = 0; // hash value for txt

            int shiftRightVal = 1;
            //// The value of shiftRightVal would be "pow(d, patternLen-1)%primeNum" but pow return double
            for (i = 0; i < patternLen-1; i++){
                shiftRightVal = (shiftRightVal* radix)%primeNum;
            }
            //System.out.println("HASH: " + shiftRightVal);

            // Calculate the hash value of pattern and first
            // window of text
            for (i = 0; i < patternLen; i++)
            {
                patternHash = (radix *patternHash + pat.charAt(i))%primeNum;
                textHash = (radix *textHash + txt.charAt(i))%primeNum;
            }
            System.out.println(patternHash);

            // Slide the pattern over text one by one
            for (i = 0; i <= textLen - patternLen; i++)
            {

                // Check the hash values of current window of text
                // and pattern. If the hash values match then only
                // check for characters on by one
                if ( patternHash == textHash ) {
                    /* Check for characters one by one */
                    for (j = 0; j < patternLen; j++)
                    {
                        if (txt.charAt(i+j) != pat.charAt(j))
                            break;
                    }

                    // if patternHash == textHash and pat[0...patternLen-1] = txt[i, i+1, ...i+patternLen-1]
                    if (j == patternLen)
                        System.out.println("Pattern found at index " + i);
                }

                // Calculate hash value for next window of text: Remove
                // leading digit, add trailing digit
                if ( i < textLen-patternLen )
                {
                    int prevWord = txt.charAt(i) * shiftRightVal;
                    int nextWord = txt.charAt(i+patternLen);
                    //System.out.println("currWord: "+currWord);
                    textHash = ((radix * (textHash - prevWord)) + nextWord)%primeNum;
                    if (textHash < 0){
                        textHash = (textHash + primeNum);
                    }


                   // System.out.println("textHash: "+textHash);
                }
               // System.out.println(textHash);
            }
        }

        public static void main(String[] args)
        {
            String txt = "ABCCDEAAB";
            String pat = "CDE";
            int q = 53; //101
            search(pat, txt, q);
        }
}
