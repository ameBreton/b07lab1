public class Polynomial{
    double[] coefficients;
	public Polynomial(){
	    double[] temp = {0};
	    this.coefficients = temp;
	}
	public Polynomial(double[] coefficients){
		this.coefficients = coefficients;
	}
	public Polynomial add(Polynomial other){
	    int oLen = other.coefficients.length;
	    int tLen = this.coefficients.length;
	    int size;
	    if(oLen > tLen){
	        size = oLen;
	    }
	    else{
	        size = tLen;
	    }
	    double[] tempCoef = new double[size];
	    for(int i = 0; i < size; i++){
	        if(oLen <= i){
	            tempCoef[i] = coefficients[i];
	        }
	        else if(tLen <= i){
	            tempCoef[i] = other.coefficients[i];
	        }
	        else{
	            tempCoef[i] = other.coefficients[i] + coefficients[i];
	        }
	    }
	    Polynomial addedP = new Polynomial(tempCoef);
	    return addedP;
	}
	
	public double evaluate(double x){
		double sum = 0.0;
		for(int i = 0; i < coefficients.length; i++){
		    double coefProd = 1;
		    for(int k = 0; k < i; k++){
    		    coefProd*=x;
		        //System.out.println("curr coefficient product: "+coefProd);
    		}
    		sum+=(coefficients[i]*coefProd);
    		//System.out.print("curr sum: "+sum);
    		//System.out.println(" curr coefficient: "+coefficients[i]+"\n");
		}
		return sum;
	}
	
	public boolean hasRoot(double potRoot){
		return evaluate(potRoot) == 0;
	}
}