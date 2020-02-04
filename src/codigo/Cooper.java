
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Feb 03 20:48:08 CET 2020
//----------------------------------------------------

package codigo;

import java_cup.runtime.Symbol;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Mon Feb 03 20:48:08 CET 2020
  */
public class Cooper extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public Cooper() {super();}

  /** Constructor which sets the default scanner. */
  public Cooper(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public Cooper(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\066\000\002\002\004\000\002\002\010\000\002\003" +
    "\005\000\002\003\003\000\002\004\006\000\002\004\005" +
    "\000\002\005\003\000\002\006\003\000\002\006\003\000" +
    "\002\007\005\000\002\007\003\000\002\010\003\000\002" +
    "\010\003\000\002\010\003\000\002\010\003\000\002\010" +
    "\003\000\002\010\003\000\002\010\003\000\002\011\005" +
    "\000\002\012\011\000\002\013\005\000\002\014\012\000" +
    "\002\015\004\000\002\015\006\000\002\015\003\000\002" +
    "\016\006\000\002\016\006\000\002\017\006\000\002\017" +
    "\005\000\002\020\004\000\002\021\004\000\002\021\003" +
    "\000\002\022\012\000\002\023\004\000\002\023\004\000" +
    "\002\024\004\000\002\024\003\000\002\025\005\000\002" +
    "\025\003\000\002\026\004\000\002\027\005\000\002\027" +
    "\003\000\002\030\003\000\002\030\003\000\002\030\003" +
    "\000\002\034\003\000\002\034\003\000\002\034\003\000" +
    "\002\031\005\000\002\031\003\000\002\032\003\000\002" +
    "\032\003\000\002\032\003\000\002\033\002" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\161\000\010\011\005\012\007\016\uffcc\001\002\000" +
    "\004\016\ufffe\001\002\000\004\006\ufffb\001\002\000\004" +
    "\016\050\001\002\000\004\011\005\001\002\000\004\023" +
    "\043\001\002\000\004\002\042\001\002\000\004\006\013" +
    "\001\002\000\014\006\015\010\024\023\uffcc\033\016\034" +
    "\023\001\002\000\016\021\uffd5\023\uffd5\025\uffd5\030\uffd5" +
    "\031\uffd5\032\uffd5\001\002\000\020\021\uffd6\023\uffd6\024" +
    "\033\025\uffd6\030\uffd6\031\uffd6\032\uffd6\001\002\000\016" +
    "\021\uffd4\023\uffd4\025\uffd4\030\uffd4\031\uffd4\032\uffd4\001" +
    "\002\000\012\023\ufffa\030\030\031\026\032\027\001\002" +
    "\000\004\023\ufff9\001\002\000\004\023\ufffc\001\002\000" +
    "\014\023\uffd8\025\uffd8\030\uffd8\031\uffd8\032\uffd8\001\002" +
    "\000\016\021\uffd3\023\uffd3\025\uffd3\030\uffd3\031\uffd3\032" +
    "\uffd3\001\002\000\016\021\uffd2\023\uffd2\025\uffd2\030\uffd2" +
    "\031\uffd2\032\uffd2\001\002\000\016\021\uffd7\023\uffd7\025" +
    "\uffd7\030\uffd7\031\uffd7\032\uffd7\001\002\000\012\006\uffcd" +
    "\010\uffcd\033\uffcd\034\uffcd\001\002\000\012\006\uffce\010" +
    "\uffce\033\uffce\034\uffce\001\002\000\012\006\uffcf\010\uffcf" +
    "\033\uffcf\034\uffcf\001\002\000\012\006\015\010\024\033" +
    "\016\034\023\001\002\000\014\023\uffd9\025\uffd9\030\uffd9" +
    "\031\uffd9\032\uffd9\001\002\000\014\006\015\010\024\025" +
    "\034\033\016\034\023\001\002\000\016\021\uffe5\023\uffe5" +
    "\025\uffe5\030\uffe5\031\uffe5\032\uffe5\001\002\000\004\025" +
    "\041\001\002\000\006\021\037\025\uffd0\001\002\000\012" +
    "\006\015\010\024\033\016\034\023\001\002\000\004\025" +
    "\uffd1\001\002\000\016\021\uffe6\023\uffe6\025\uffe6\030\uffe6" +
    "\031\uffe6\032\uffe6\001\002\000\004\002\001\001\002\000" +
    "\010\011\005\012\007\016\uffcc\001\002\000\004\016\uffff" +
    "\001\002\000\004\006\046\001\002\000\014\006\015\010" +
    "\024\023\uffcc\033\016\034\023\001\002\000\004\023\ufffd" +
    "\001\002\000\004\026\051\001\002\000\022\004\070\006" +
    "\066\011\005\013\064\014\062\015\054\020\065\027\uffcc" +
    "\001\002\000\004\023\ufff5\001\002\000\004\023\ufff0\001" +
    "\002\000\004\024\161\001\002\000\004\023\ufff3\001\002" +
    "\000\004\023\ufff2\001\002\000\004\023\ufff1\001\002\000" +
    "\004\027\130\001\002\000\004\023\126\001\002\000\004" +
    "\024\123\001\002\000\004\006\121\001\002\000\004\024" +
    "\104\001\002\000\012\006\015\010\024\033\016\034\023" +
    "\001\002\000\006\005\101\024\033\001\002\000\004\023" +
    "\ufff4\001\002\000\004\024\073\001\002\000\004\023\ufff6" +
    "\001\002\000\004\027\ufff7\001\002\000\012\006\015\010" +
    "\024\033\016\034\023\001\002\000\012\025\075\030\030" +
    "\031\026\032\027\001\002\000\004\026\076\001\002\000" +
    "\022\004\070\006\066\011\005\013\064\014\062\015\054" +
    "\020\065\027\uffcc\001\002\000\004\027\100\001\002\000" +
    "\004\023\uffee\001\002\000\012\006\015\010\024\033\016" +
    "\034\023\001\002\000\012\023\uffef\030\030\031\026\032" +
    "\027\001\002\000\012\023\uffe4\030\030\031\026\032\027" +
    "\001\002\000\012\006\015\010\024\033\016\034\023\001" +
    "\002\000\012\025\106\030\030\031\026\032\027\001\002" +
    "\000\004\026\107\001\002\000\022\004\070\006\066\011" +
    "\005\013\064\014\062\015\054\020\065\027\uffcc\001\002" +
    "\000\004\027\111\001\002\000\006\007\114\023\uffcc\001" +
    "\002\000\004\023\uffec\001\002\000\004\023\uffe9\001\002" +
    "\000\006\013\064\026\116\001\002\000\004\023\uffeb\001" +
    "\002\000\022\004\070\006\066\011\005\013\064\014\062" +
    "\015\054\020\065\027\uffcc\001\002\000\004\027\120\001" +
    "\002\000\004\023\uffea\001\002\000\014\006\015\010\024" +
    "\023\uffcc\033\016\034\023\001\002\000\004\023\uffed\001" +
    "\002\000\004\006\124\001\002\000\004\025\125\001\002" +
    "\000\004\023\uffe8\001\002\000\022\004\070\006\066\011" +
    "\005\013\064\014\062\015\054\020\065\027\uffcc\001\002" +
    "\000\004\027\ufff8\001\002\000\006\002\uffcc\017\134\001" +
    "\002\000\006\002\uffcc\017\134\001\002\000\004\002\uffe2" +
    "\001\002\000\004\002\000\001\002\000\006\011\005\022" +
    "\156\001\002\000\004\006\136\001\002\000\004\024\137" +
    "\001\002\000\006\011\005\025\uffcc\001\002\000\004\025" +
    "\uffdd\001\002\000\004\025\152\001\002\000\006\021\146" +
    "\025\uffcc\001\002\000\004\006\144\001\002\000\006\021" +
    "\uffda\025\uffda\001\002\000\004\025\uffdb\001\002\000\004" +
    "\011\005\001\002\000\004\025\uffde\001\002\000\006\021" +
    "\146\025\uffcc\001\002\000\004\025\uffdc\001\002\000\004" +
    "\026\153\001\002\000\022\004\070\006\066\011\005\013" +
    "\064\014\062\015\054\020\065\027\uffcc\001\002\000\004" +
    "\027\155\001\002\000\006\002\uffe1\017\uffe1\001\002\000" +
    "\004\006\uffdf\001\002\000\004\006\uffe0\001\002\000\004" +
    "\002\uffe3\001\002\000\012\006\015\010\024\033\016\034" +
    "\023\001\002\000\012\025\163\030\030\031\026\032\027" +
    "\001\002\000\004\023\uffe7\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\161\000\014\002\010\003\005\004\007\005\011\033" +
    "\003\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\004\005\044\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\016\006\020\017\024" +
    "\027\016\030\021\033\017\034\013\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\032\030" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\010\017\024\030\031\034\013\001\001\000\002\001\001" +
    "\000\012\017\024\030\035\031\034\034\013\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\012" +
    "\017\024\030\035\031\037\034\013\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\012\003\043" +
    "\004\007\005\011\033\003\001\001\000\002\001\001\000" +
    "\002\001\001\000\016\006\046\017\024\027\016\030\021" +
    "\033\017\034\013\001\001\000\002\001\001\000\002\001" +
    "\001\000\030\005\062\007\057\010\060\011\070\012\051" +
    "\013\066\014\054\016\055\017\056\020\052\033\071\001" +
    "\001\000\002\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\012\017\024\027\102\030" +
    "\021\034\013\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\002\001\001\000\002\001\001\000" +
    "\012\017\024\027\073\030\021\034\013\001\001\000\004" +
    "\032\030\001\001\000\002\001\001\000\030\005\062\007" +
    "\076\010\060\011\070\012\051\013\066\014\054\016\055" +
    "\017\056\020\052\033\071\001\001\000\002\001\001\000" +
    "\002\001\001\000\012\017\024\027\101\030\021\034\013" +
    "\001\001\000\004\032\030\001\001\000\004\032\030\001" +
    "\001\000\012\017\024\027\104\030\021\034\013\001\001" +
    "\000\004\032\030\001\001\000\002\001\001\000\030\005" +
    "\062\007\107\010\060\011\070\012\051\013\066\014\054" +
    "\016\055\017\056\020\052\033\071\001\001\000\002\001" +
    "\001\000\006\015\111\033\112\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\014\114\001\001\000\002\001" +
    "\001\000\030\005\062\007\116\010\060\011\070\012\051" +
    "\013\066\014\054\016\055\017\056\020\052\033\071\001" +
    "\001\000\002\001\001\000\002\001\001\000\016\006\121" +
    "\017\024\027\016\030\021\033\017\034\013\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\030\005\062\007\126\010\060\011\070\012" +
    "\051\013\066\014\054\016\055\017\056\020\052\033\071" +
    "\001\001\000\002\001\001\000\012\021\132\022\130\023" +
    "\134\033\131\001\001\000\012\021\157\022\130\023\134" +
    "\033\131\001\001\000\002\001\001\000\002\001\001\000" +
    "\004\005\156\001\001\000\002\001\001\000\002\001\001" +
    "\000\012\005\142\024\140\026\141\033\137\001\001\000" +
    "\002\001\001\000\002\001\001\000\006\025\146\033\144" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\006\005\142\026\147\001\001\000\002\001\001" +
    "\000\006\025\150\033\144\001\001\000\002\001\001\000" +
    "\002\001\001\000\030\005\062\007\153\010\060\011\070" +
    "\012\051\013\066\014\054\016\055\017\056\020\052\033" +
    "\071\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\012\017" +
    "\024\027\161\030\021\034\013\001\001\000\004\032\030" +
    "\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$Cooper$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$Cooper$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$Cooper$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}



    private Symbol s;
    
    public void syntax_error(Symbol s){
        this.s = s;
    }

    public Symbol getS(){
        return this.s;
}

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$Cooper$actions {
  private final Cooper parser;

  /** Constructor */
  CUP$Cooper$actions(Cooper parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$Cooper$do_action(
    int                        CUP$Cooper$act_num,
    java_cup.runtime.lr_parser CUP$Cooper$parser,
    java.util.Stack            CUP$Cooper$stack,
    int                        CUP$Cooper$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$Cooper$result;

      /* select the action based on the action number */
      switch (CUP$Cooper$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 53: // LAMBDA ::= 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("LAMBDA",25, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 52: // OPERADOR ::= Op_logico 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("OPERADOR",24, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 51: // OPERADOR ::= Op_relacional 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("OPERADOR",24, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 50: // OPERADOR ::= Op_aritmetico 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("OPERADOR",24, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 49: // EXPRS ::= EXPR 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPRS",23, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 48: // EXPRS ::= EXPR Coma EXPRS 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPRS",23, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 47: // LITERAL ::= Numero 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("LITERAL",26, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 46: // LITERAL ::= String 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("LITERAL",26, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 45: // LITERAL ::= Op_booleano 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("LITERAL",26, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 44: // EXPR ::= LITERAL 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPR",22, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 43: // EXPR ::= Id 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPR",22, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 42: // EXPR ::= CALL 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPR",22, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 41: // EXPRP ::= EXPR 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPRP",21, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 40: // EXPRP ::= EXPRP OPERADOR EXPR 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("EXPRP",21, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 39: // PARAM ::= TYPE Id 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("PARAM",20, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 38: // PARAMSP ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("PARAMSP",19, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 37: // PARAMSP ::= Coma PARAM PARAMSP 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("PARAMSP",19, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 36: // PARAMS ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("PARAMS",18, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 35: // PARAMS ::= PARAM PARAMSP 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("PARAMS",18, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 34: // DEFINICION ::= Def Void 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DEFINICION",17, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 33: // DEFINICION ::= Def TYPE 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DEFINICION",17, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 32: // FUNC ::= DEFINICION Id A_par PARAMS C_par A_llave INSTS C_llave 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("FUNC",16, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-7)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 31: // FUNCS ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("FUNCS",15, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 30: // FUNCS ::= FUNC FUNCS 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("FUNCS",15, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 29: // RET ::= Return EXPRP 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("RET",14, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 28: // CALL ::= Id A_par C_par 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("CALL",13, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 27: // CALL ::= Id A_par EXPRS C_par 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("CALL",13, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-3)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 26: // IO ::= Out A_par EXPRP C_par 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("IO",12, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-3)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // IO ::= In A_par Id C_par 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("IO",12, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-3)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // ELS ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("ELS",11, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // ELS ::= Else A_llave INSTS C_llave 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("ELS",11, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-3)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // ELS ::= Else CND 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("ELS",11, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // CND ::= If A_par EXPRP C_par A_llave INSTS C_llave ELS 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("CND",10, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-7)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // DCL ::= TYPE Id ASIGNACION 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DCL",9, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // WHL ::= While A_par EXPRP C_par A_llave INSTS C_llave 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("WHL",8, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-6)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // ASIG ::= Id Igual EXPRP 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("ASIG",7, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // INST ::= RET 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // INST ::= CALL 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // INST ::= IO 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // INST ::= CND 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // INST ::= DCL 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // INST ::= WHL 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // INST ::= ASIG 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INST",6, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // INSTS ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INSTS",5, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // INSTS ::= INST PuntoYComa INSTS 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("INSTS",5, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // ASIGNACION ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("ASIGNACION",4, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // ASIGNACION ::= EXPRP 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("ASIGNACION",4, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // TYPE ::= Tipo 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("TYPE",3, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // DECL ::= TYPE Id ASIGNACION 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DECL",2, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // DECL ::= Const TYPE Id ASIGNACION 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DECL",2, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-3)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // DECLS ::= LAMBDA 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DECLS",1, ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // DECLS ::= DECL PuntoYComa DECLS 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("DECLS",1, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-2)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // P ::= DECLS Main A_llave INSTS C_llave FUNCS 
            {
              Object RESULT =null;

              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("P",0, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-5)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          return CUP$Cooper$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= P EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)).right;
		Object start_val = (Object)((java_cup.runtime.Symbol) CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)).value;
		RESULT = start_val;
              CUP$Cooper$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$Cooper$stack.elementAt(CUP$Cooper$top-1)), ((java_cup.runtime.Symbol)CUP$Cooper$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$Cooper$parser.done_parsing();
          return CUP$Cooper$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

