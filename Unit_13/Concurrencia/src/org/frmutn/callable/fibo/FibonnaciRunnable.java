package org.frmutn.callable.fibo;

public class FibonnaciRunnable  implements Runnable{
private long n;
private long resultado;


public FibonnaciRunnable(long n) {
	super();
	this.n = n;
}

@Override
public void run() {
	resultado = getFibo(n);
	
}

public long getResultado() {
	return resultado;
}

private long getFibo(long n) {
	if(n==0 || n ==1) {
		return n;
	}else {
		return getFibo(n-1) +getFibo(n-2);
	}
}




}
