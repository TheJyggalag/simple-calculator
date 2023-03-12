public class MathFunctions {
   public static void main(String[] args) {
      int num1 = 24;
      int num2 = 36;
      int gcd = gcd(num1, num2);
      int lcm = lcm(num1, num2);
      System.out.println("GCD of " + num1 + " and " + num2 + " is " + gcd);
      System.out.println("LCM of " + num1 + " and " + num2 + " is " + lcm);
   }
   
   // function to calculate GCD of two numbers
   public static int gcd(int a, int b) {
      if (b == 0) {
         return a;
      }
      else {
         return gcd(b, a % b);
      }
   }
   
   // function to calculate LCM of two numbers
   public static int lcm(int a, int b) {
      int gcd = gcd(a, b);
      return (a * b) / gcd;
   }
}

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math3.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math3.analysis.function.Sin;

public class Calculus {
    public static void main(String[] args) {
        // Define the function to be differentiated
        UnivariateFunction function = new Sin();

        // Create a differentiable function from the original function
        UnivariateDifferentiableFunction differentiableFunction = new UnivariateDifferentiableFunction() {
            @Override
            public DerivativeStructure value(DerivativeStructure x) {
                return new DerivativeStructure(1, 1, 0, function.value(x.getValue()));
            }
        };

        // Calculate the derivative of the function at a given point
        double x = 0.5;
        DerivativeStructure derivative = differentiableFunction.value(new DerivativeStructure(1, 1, 0, x));
        double value = derivative.getPartialDerivative(1);

        // Print the result
        System.out.println("The derivative of sin(x) at x = " + x + " is " + value);
    }
}
