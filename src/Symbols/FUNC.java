/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Symbols;

/**
 *
 * @author Juan
 */
public class FUNC extends SimboloBase {

    DEFINICION definicion;
    PARAMS parametros;
    INSTS instrucciones;

    codigo.TablaSimbolos.Tipo tipo;

    public FUNC(FUNC1 func1, FUNC2 func2 ) {
        super("FUNC");

        this.tipo = func1.tipo;
        if(this.tipo != codigo.TablaSimbolos.Tipo.tNull && func2.insts.retorno != null){
            if(this.tipo != func2.insts.retorno.tipo){
                //ERROR
                System.out.println("ERROR: el tipo de retorno en la funcion "+func1.id+" no es correcto. ");
            }
        } else if(this.tipo == codigo.TablaSimbolos.Tipo.tNull && func2.insts.retorno != null){
            //ERROR
            System.out.println("ERROR: el procedimiento "+func1.id+" no debe tener 'return's");
        } else if(this.tipo != codigo.TablaSimbolos.Tipo.tNull && func2.insts.retorno == null){
            //ERROR
            System.out.println("ERROR: la función "+func1.id+" debe tener una instrucción 'return'.");
        }
        
        g.addEdge(this, func1);
        g.addEdge(this, func2);          

    }

}
