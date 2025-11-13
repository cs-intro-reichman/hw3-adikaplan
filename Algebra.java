// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		if(x2<0){
		for(int i=x2; i < 0 ; i++){
			x1--;
		}
	    }else{
			for(int i=1; i <= x2 ; i++){
				x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		if(x2<0){
		for(int i=0; i > x2 ; i--){
			x1++;
		}
	    }else{
			for(int i=0; i < x2 ; i++){
				x1--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		if ( x1 ==0 || x2 == 0){
			return 0;
		}else if( x1 == 1){
			return x2;
		}else if(x2 == 1){
			return x1;
		}
		int result=0;
		for(int i =1; i <= x2 ; i++){
			plus(x1,x1);
			result = plus (result ,x1 );
		}if(x1<0 && x2<0){
			result = times(-1,result);
		}
		return result;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		if(x == 0){
			return 0;
		}else if (n == 0){
			return 1;
		}
		int result=1;
		for(int i =1 ; i <= n ; i++){
			result = times(result , x);
		}
		if(x<0 && mod(n,2)!=0){
			result = times(-1,result);
		}else if(x<0 && mod(n,2)==0){
			return result;
		}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		if ( x1 < x2){
			return 0;
		}else if(x1 == x2){
			return 1;
		}else if(x2 == 1){
			return x1;
		}
		int z = 2;
		while(z <= x1){
			if(times(x2 , z) == x1){
				return z;
			}else if(times(x2 , z) < x1){
				z = plus( z, 1);
			}else if (times(x2 , z) > x1){
				z = minus(z,1);
				return z;
			}
		}
		if(x1<0 || x2<0){
			z = times(-1,z);
		}
		return z ;
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		int remainder = 0;
		if (x1 ==0){
			remainder = 0;
		}
		else if (times(x2, div (x1 , x2)) != x1 ){
			remainder = minus(x1 , times(div (x1 , x2), x2));
		}
		return remainder;
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int g = 0;
		if(x==0){
			return 0;
		}
		while(times(g , g) <= x){
			g = plus(g,1);
		}
		return  minus(g,1);
	}	  	  
}
