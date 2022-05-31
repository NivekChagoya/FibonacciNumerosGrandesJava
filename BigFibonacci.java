import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;
import java.io.*;

public class  BigFibonacci
{
    /** Nota: un treemap es usado para almacenar los #s de fibonacci que ya hayan
     * sido calculados, y un biginteger para evitar la perdida de precision. */
     
    static Map<Integer, BigInteger> memo = new TreeMap<Integer, BigInteger>();
    
    public static void main (String[] args) throws IOException {
        BufferedReader inKb = new BufferedReader (new InputStreamReader (System.in));
        
        System.out.print("Teclee el # en la serie de fibonacci a calcular: ");
        int num             = Integer.parseInt(inKb.readLine());
        
        BigInteger numeroF  = memoizedFibonacci(num);
        System.out.printf("%n=> %-,100d", numeroF);
        System.out.printf("%n# de cifras en el numero : %,5d", numeroF.toString().length());
        System.out.printf("%n# de entradas en el mapa : %,5d%n", memo.size());
        
        System.out.println("\nContenido del arbol");
        printTM();
    }
    
    private static int fibonacci(int n) {
        if (n <= 1) return 1;   
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    private static BigInteger memoizedFibonacci(int n)
    {
        if (n <= 1) return BigInteger.ONE;
        /** Si no esta en el treemap, se calcula y se agrega a el. */
        if (memo.get(n) == null)
            memo.put(n, memoizedFibonacci(n - 1).add(memoizedFibonacci(n - 2)));
        /** return el treemap. */
        return memo.get(n);
    }
    
    private static void printTM() {
        /** pasar a un Set el TreeMap */
        Set set = memo.entrySet();

        /** Programar un iterador */
        Iterator it = set.iterator();
 
        /** imprimir el TreeMap convertido a Set */
        while(it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.printf("%,5d %-,100d%n",me.getKey(), me.getValue());
        } 
    }
}
