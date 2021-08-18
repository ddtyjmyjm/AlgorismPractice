// 斐波那契数列的矩阵化简形式 + 矩阵快速幂
public class Solution {
    public int Fibonacci(int n) {
    /**
     * [fib(n), fib(n-1)].T = [[1,1],[1,0]].T @ [fib(n-1),fib(n-2)].T
     *                      = ([[1,1],[1,0]].T)**(n-2) @ [fib(2),fib(1)].T
     *                      = ([[1,1],[1,0]].T)**(n-2) @ [1,1]
     */
      if(n<=0)
          return 0;
       if(n<=2)
           return 1;
      Matrix M = new Matrix(1,1,1,0);
      Matrix ans = Matrix.qpow(M, n - 2);
      return ans.a + ans.b;
    }
    
    
}

class Matrix {
    //[a b]
    //[c d] 
    int a,b,c,d;
    public Matrix (int a, int b, int c, int d){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }
    
    static public Matrix pow(Matrix A, Matrix B){
        return new Matrix(A.a*B.a + A.b*B.c,
                         A.a*B.b + A.b*B.d,
                         A.c*B.a + A.d*B.c,
                         A.c*B.b + A.d*B.d);
    }
    
    /**
     * 快速幂的矩阵形式
     */
    static public Matrix qpow(Matrix m, int n){
        Matrix ans = new Matrix(1,0,0,1); // 初始化为单位阵
        while(n>0){
            if(n % 2 != 0)
                ans = pow(ans,m);
            n = n/2;
            m = pow(m,m);
        }
        return ans;
    }
}