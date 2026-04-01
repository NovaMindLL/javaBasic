public class ComplexNumber {
    private final double re;
    private final double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    public double getRe() {
        return re;
    }

    public double getIm() {
        return im;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() !=obj.getClass()) {
            return false;}
        ComplexNumber other = (ComplexNumber) obj;
        return Double.compare(this.re, other.re) == 0 && Double.compare(this.im, other.im)==0;
    }
    @Override
    public int hashCode() {
        int result = 31;
        result = result*31+Double.hashCode(re);
        result = result*31+Double.hashCode(im);
        return result;
    }
}
