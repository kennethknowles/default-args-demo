package defaultArgsDemo;

import java.util.ArrayList;

/**
 * This exercise is an attempt to implement (as succinctly as possible)
 * the Python example demonstrating that default arguments are evaluated
 * in the context of the `def` statement. As well as show an example of 
 * how to emulate default arguments in Java using overloading.
 * 
   	 def f(a, L=[]):
	    L.append(a)
	    return L

	versus
	
	 def f(a, L=None):
	    if L is None: L = []
	   L.append(a)
	   return L

     print(f(1))
     print(f(2))
     print(f(3))
     
 * The first function will accumulate arguments and print
   [1]
   [1, 2]
   [1, 2, 3]
   
 * The second function will return a new list each time and print
   [1]
   [2]
   [3]
    
 * 
 * @author ken
 *
 */
public class DefaultArgsDemo {

	/**
	 * function f with default arg L=[]
	 * 
	 * @param a
	 *            element
	 * @param L
	 *            list, default value = global list created at compile time
	 *            
	 * @return list with element appended
	 */
	static ArrayList<Object> fDefaultEmpty(Object a, ArrayList<Object> L) {
		L.add(a);
		return L;
	}

	static ArrayList<Object> emptyList = new ArrayList<Object>();
	
	static ArrayList<Object> fDefaultEmpty(Object a) {
		return fDefaultEmpty(a, emptyList);
	}
	
	/**
	 * function f with default arg L=None
	 * 
	 * @param a
	 *            element
	 * @param L
	 *            list, default value = null
	 *            
	 * @return list with element appended or new list of element a
	 */
	static ArrayList<Object> fDefaultNone(Object a, ArrayList<Object> L) {
		if (L == null) {
			L = new ArrayList<Object>();
		}
		L.add(a);
		return L;
	}
	
	static ArrayList<Object> noneList = null;
	
	static ArrayList<Object> fDefaultNone(Object a) {
		return fDefaultNone(a, noneList);
	}

	public static void main(String[] args) {

		System.out.println(fDefaultEmpty("check"));
		System.out.println(fDefaultEmpty(2));
		System.out.println(fDefaultEmpty("check check"));

		System.out.println(fDefaultNone(1));
		System.out.println(fDefaultNone(2));
		System.out.println(fDefaultNone(3));
		System.out.println(fDefaultNone("let's jam"));

	}

}
