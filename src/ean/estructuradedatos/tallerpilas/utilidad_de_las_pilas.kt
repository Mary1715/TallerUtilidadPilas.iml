package ean.estructuradedatos.tallerpilas

/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 * <p>
 * Proyecto Taller con las Pilas
 * Autor: Universidad EAN - Marzo 18, 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

import ean.collections.*

/**
 * Objeto que permite convertir una expresión infija normal a una expresión en notación
 * postfija. Utiliza pilas para realizar la conversión.
 */
object Evaluador {

    //-------------------------------------
    // Métodos
    //-------------------------------------

    /**
     * Verifica que la expresión tiene los símbolos de agrupación bien balanceados
     * @return true si la expresión está balanceados
     */
    fun estánSímbolosAgrupaciónBalanceados(expresion: IList<String>): Boolean {
        val pilaSimbolos: IStack<String> = TLinkedStack()


        for(n in expresion){
            if (n == "(" || n == "{" || n == "["){
                pilaSimbolos.push(n)
            }
            else{
                if (n == ")" || n == "}" || n == "]"){
                    if(pilaSimbolos.isEmpty) {
                        return false
                    }
                    val tope= pilaSimbolos.peek()
                    pilaSimbolos.pop()
                    if ((tope == "(" && n != ")") || (tope == "{" && n != "}") || (tope == "[" && n != "]")){
                        return false

                    }
                }
                return pilaSimbolos.isEmpty
    }

    /**
     * Transforma la expresión, cambiando los simbolos de agrupación [] y {} por ()
     */
    fun reemplazarDelimitadoresPorParéntesis(expresion: IList<String>): Unit {
        var simbolo:String
        for (n in 0 until  expresion.size){
            if (expresion.get(n) == "[" || expresion.get(n) == "{"){
                simbolo = "("
                expresion.set(n,simbolo)
            }else if (expresion.get(n) == "]" || expresion.get(n) == "}"){
                simbolo = ")"
                expresion.set(n,simbolo)
            }

        }

    }


    /**
     * Realiza la conversión de la notación infija a postfija
     * @return la expresión convertida a postfija
     */
    fun convertirAPostfijo(expresion: IList<String>): IList<String> {
        val pila: IStack<String> = TLinkedStack()
        val lista: IList<String> = TList()

        for (n in expresion){
             if (n == "+" || n == "." || n == "*" || n == "/" || n == "%"){
                 pila.push(n)
             }
            else if (n == "("){
                continue
             }
            else if(n == ")"){
                lista.add(pila.peek())
                 pila.pop()
             }
            else{
                lista.add(n)
             }
    }

        return lista;
    }

    /**
     * Realiza la evaluación de la expresión postfija almacenada en la lista
     * llamada "expresión". Realiza las operaciones de acuerdo al algoritmo
     * presentado.
     */
    fun evaluarExpresiónPostfija(expression: IList<String>): Int {
        val pila: IStack<Int> = TLinkedStack()
        val pila: IStack<String> = TLinkedStack()
        val lista: IList<String> = TList()

        for (n in expresion){
            if (n == "+" || n == "-" || n == "*" || n == "/" || n == "%"){
                pila.push
            }else if(n == "("){
                continue
            }else if(n == ")"){
                lista.add(pila.peek())
                pila.pop()
            }
            else{
                lista.add
            }
        }
        return lista;


        return pila.peek()
    }
}
