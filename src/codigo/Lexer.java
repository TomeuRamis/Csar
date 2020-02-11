/* The following code was generated by JFlex 1.4.3 on 11/02/20 17:29 */

package codigo;
import java_cup.runtime.Symbol;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 11/02/20 17:29 from the specification file
 * <tt>src/codigo/Lexer.flex</tt>
 */
class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  0,  3,  4,  0,  0,  3,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     3, 31, 38,  0,  0, 26, 28,  0, 34, 35, 26, 26, 33, 27,  0, 22, 
     2,  2,  2,  2,  2,  2,  2,  2,  2,  2,  0, 32, 30, 25, 30,  0, 
     0,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1, 
     1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  1,  0, 39,  0,  0,  1, 
     0, 24,  8, 14, 20, 16, 15, 13, 18,  5,  1,  1, 10, 23,  6,  9, 
     1,  1, 12, 11,  7, 21, 19, 17,  1,  1,  1, 36, 29, 37,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  1,  0,  0,  0,  0,  0,  1,  1,  1,  0,  0,  1,  1,  0,  0, 
     0,  1,  1,  1,  0,  0,  0,  0,  0,  1,  1,  0,  1,  0,  0,  0, 
     1,  1,  0,  0,  0,  0,  0,  1,  1,  1,  0,  0,  1,  1,  0,  0, 
     0,  1,  1,  1,  0,  0,  0,  0,  0,  1,  1,  0,  1,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\14\2\1\6"+
    "\1\2\1\7\1\6\2\1\1\10\1\1\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\1\1\17\1\20\13\2"+
    "\1\4\1\2\1\21\2\0\1\22\1\0\1\23\2\2"+
    "\1\24\7\2\1\25\1\2\1\0\1\26\3\2\1\27"+
    "\1\2\1\30\1\31\1\3\2\2\1\32\1\33\1\34";

  private static int [] zzUnpackAction() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\50\0\120\0\170\0\240\0\310\0\360\0\u0118"+
    "\0\u0140\0\u0168\0\u0190\0\u01b8\0\u01e0\0\u0208\0\u0230\0\u0258"+
    "\0\u0280\0\u02a8\0\u02d0\0\u02f8\0\u0320\0\50\0\u0348\0\u0370"+
    "\0\50\0\u0398\0\50\0\50\0\u03c0\0\50\0\50\0\50"+
    "\0\u03e8\0\u0410\0\120\0\u0438\0\u0460\0\u0488\0\u04b0\0\u04d8"+
    "\0\u0500\0\u0528\0\u0550\0\u0578\0\u05a0\0\u05c8\0\u05f0\0\u0618"+
    "\0\50\0\u0640\0\u03e8\0\50\0\u0668\0\120\0\u0690\0\u06b8"+
    "\0\120\0\u06e0\0\u0708\0\u0730\0\u0758\0\u0780\0\u07a8\0\u07d0"+
    "\0\120\0\u07f8\0\u0820\0\120\0\u0848\0\u0870\0\u0898\0\120"+
    "\0\u08c0\0\120\0\120\0\50\0\u08e8\0\u0910\0\120\0\120"+
    "\0\120";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\7\1\3\1\10"+
    "\1\11\1\12\1\3\1\13\1\14\1\3\1\15\1\16"+
    "\1\17\1\20\1\3\1\21\1\22\1\3\1\23\1\24"+
    "\1\3\1\25\2\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\2\51\0"+
    "\2\3\2\0\21\3\1\0\2\3\21\0\1\4\50\0"+
    "\1\5\50\0\1\6\44\0\2\3\2\0\1\3\1\42"+
    "\10\3\1\43\6\3\1\0\2\3\20\0\2\3\2\0"+
    "\7\3\1\44\11\3\1\0\2\3\20\0\2\3\2\0"+
    "\4\3\1\45\14\3\1\0\2\3\20\0\2\3\2\0"+
    "\20\3\1\46\1\0\2\3\20\0\2\3\2\0\2\3"+
    "\1\47\16\3\1\0\2\3\20\0\2\3\2\0\13\3"+
    "\1\50\5\3\1\0\2\3\20\0\2\3\2\0\4\3"+
    "\1\51\14\3\1\0\2\3\20\0\2\3\2\0\21\3"+
    "\1\0\1\3\1\52\20\0\2\3\2\0\5\3\1\53"+
    "\13\3\1\0\2\3\20\0\2\3\2\0\15\3\1\54"+
    "\3\3\1\0\2\3\20\0\2\3\2\0\4\3\1\55"+
    "\14\3\1\0\2\3\20\0\2\3\2\0\13\3\1\56"+
    "\5\3\1\0\2\3\45\0\1\57\22\0\2\3\2\0"+
    "\21\3\1\0\1\3\1\60\50\0\1\31\4\0\1\31"+
    "\45\0\1\61\50\0\1\61\43\0\1\31\51\0\1\62"+
    "\14\0\46\63\1\64\1\65\1\0\2\3\2\0\2\3"+
    "\1\66\16\3\1\0\2\3\20\0\2\3\2\0\20\3"+
    "\1\67\1\0\2\3\20\0\2\3\2\0\4\3\1\70"+
    "\14\3\1\0\2\3\20\0\2\3\2\0\2\3\1\71"+
    "\16\3\1\0\2\3\20\0\2\3\2\0\7\3\1\72"+
    "\11\3\1\0\2\3\20\0\2\3\2\0\2\3\1\73"+
    "\16\3\1\0\2\3\20\0\2\3\2\0\1\3\1\74"+
    "\17\3\1\0\2\3\20\0\2\3\2\0\5\3\1\75"+
    "\13\3\1\0\2\3\20\0\2\3\2\0\6\3\1\76"+
    "\12\3\1\0\2\3\20\0\2\3\2\0\1\77\20\3"+
    "\1\0\2\3\20\0\2\3\2\0\1\100\20\3\1\0"+
    "\2\3\20\0\2\3\2\0\12\3\1\101\6\3\1\0"+
    "\2\3\17\0\4\57\1\0\43\57\1\0\2\3\2\0"+
    "\1\102\20\3\1\0\2\3\21\0\1\103\45\0\4\63"+
    "\1\0\43\63\1\0\2\3\2\0\13\3\1\104\5\3"+
    "\1\0\2\3\20\0\2\3\2\0\5\3\1\66\13\3"+
    "\1\0\2\3\20\0\2\3\2\0\1\105\20\3\1\0"+
    "\2\3\20\0\2\3\2\0\20\3\1\106\1\0\2\3"+
    "\20\0\2\3\2\0\6\3\1\107\12\3\1\0\2\3"+
    "\20\0\2\3\2\0\6\3\1\67\12\3\1\0\2\3"+
    "\20\0\2\3\2\0\13\3\1\110\5\3\1\0\2\3"+
    "\20\0\2\3\2\0\5\3\1\111\13\3\1\0\2\3"+
    "\20\0\2\3\2\0\17\3\1\112\1\3\1\0\2\3"+
    "\20\0\2\3\2\0\1\3\1\113\17\3\1\0\2\3"+
    "\21\0\1\103\40\0\1\114\5\0\2\3\2\0\1\3"+
    "\1\115\17\3\1\0\2\3\20\0\2\3\2\0\7\3"+
    "\1\116\11\3\1\0\2\3\20\0\2\3\2\0\2\3"+
    "\1\117\16\3\1\0\2\3\20\0\2\3\2\0\13\3"+
    "\1\120\5\3\1\0\2\3\20\0\2\3\2\0\10\3"+
    "\1\66\10\3\1\0\2\3\20\0\2\3\2\0\1\3"+
    "\1\121\17\3\1\0\2\3\17\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[2360];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\23\1\1\11\2\1\1\11\1\1\2\11"+
    "\1\1\3\11\20\1\1\11\2\0\1\11\1\0\15\1"+
    "\1\0\10\1\1\11\5\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[81];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    private String tokens = "";
    
    public String getTokens(){
        return tokens;
    }
    private Symbol symbol (int type, Object value){
        return new Symbol (type, yyline, yycolumn, value);
    }
    private Symbol symbol (int type){
        return new Symbol (type, yyline, yycolumn);
    }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 16: 
          { tokens+="<if>"; return symbol(sym.If, yytext());
          }
        case 29: break;
        case 18: 
          { tokens+="<string>"; return symbol(sym.String, yytext());
          }
        case 30: break;
        case 15: 
          { tokens+="<in>"; return symbol(sym.In, yytext());
          }
        case 31: break;
        case 20: 
          { tokens+="<out>"; return symbol(sym.Out, yytext());
          }
        case 32: break;
        case 13: 
          { tokens+="<a_llave>"; return symbol(sym.A_llave, yytext());
          }
        case 33: break;
        case 27: 
          { tokens+="<while>"; return symbol(sym.While, yytext());
          }
        case 34: break;
        case 3: 
          { tokens+="<numero>"; return symbol(sym.Numero, yytext());
          }
        case 35: break;
        case 22: 
          { tokens+="<booleano>"; return symbol(sym.Op_booleano, yytext());
          }
        case 36: break;
        case 2: 
          { tokens+="<id>"; return symbol(sym.Id, yytext());
          }
        case 37: break;
        case 26: 
          { tokens+="<const>"; return symbol(sym.Const, yytext());
          }
        case 38: break;
        case 8: 
          { tokens+="<op_relacional>"; return symbol(sym.Op_relacional, yytext());
          }
        case 39: break;
        case 23: 
          { tokens+="<else>"; return symbol(sym.Else, yytext());
          }
        case 40: break;
        case 21: 
          { tokens+="<def>"; return symbol(sym.Def, yytext());
          }
        case 41: break;
        case 28: 
          { tokens+="<return>"; return symbol(sym.Return, yytext());
          }
        case 42: break;
        case 12: 
          { tokens+="<c_par>"; return symbol(sym.C_par, yytext());
          }
        case 43: break;
        case 11: 
          { tokens+="<a_par>"; return symbol(sym.A_par, yytext());
          }
        case 44: break;
        case 14: 
          { tokens+="<c_llave>"; return symbol(sym.C_llave, yytext());
          }
        case 45: break;
        case 19: 
          { tokens+="<tipo>"; return symbol(sym.Tipo, yytext());
          }
        case 46: break;
        case 1: 
          { tokens+="<error>"; FrmPrincipal.notificarError("Error léxico: "+yytext()+" en linea: "+(yyline+1)+" columna: "+(yycolumn+1));
          }
        case 47: break;
        case 9: 
          { tokens+="<p_coma>"; return symbol(sym.PuntoYComa, yytext());
          }
        case 48: break;
        case 5: 
          { tokens+="\n";
          }
        case 49: break;
        case 6: 
          { tokens+="<op_aritmetico>"; return symbol(sym.Op_aritmetico, yytext());
          }
        case 50: break;
        case 24: 
          { tokens+="<void>"; return symbol(sym.Void, yytext());
          }
        case 51: break;
        case 10: 
          { tokens+="<coma>"; return symbol(sym.Coma, yytext());
          }
        case 52: break;
        case 25: 
          { tokens+="<main>"; return symbol(sym.Main, yytext());
          }
        case 53: break;
        case 7: 
          { tokens+="<igual>"; return symbol(sym.Igual, yytext());
          }
        case 54: break;
        case 4: 
          { /*Ignore*/
          }
        case 55: break;
        case 17: 
          { tokens+="<op_logico>"; return symbol(sym.Op_logico, yytext());
          }
        case 56: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              { return new java_cup.runtime.Symbol(sym.EOF); }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
