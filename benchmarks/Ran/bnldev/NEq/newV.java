package demo.benchmarks.Ran.bnldev.NEq;
public class newV{
    public static double snippet (double pp,  int n, int idumx, int idum) {//idum is global Var
        idum = idumx;
        double PI=3.141592653589793238;
        double j=0;
        double nold=-1;
        double am=0;
        double em=0;
        double g=0;
        double angle=0;
        double p=0;
        double bnl=0;
        double sq=0;
        double t=0;
        double y=0;
        double pold=(-1.0);
        double pc = 0;
        double plog = 0;
        double pclog = 0;
        double en = 0;
        double oldg = 0;
        if (pp <= 0.5)
            p = pp;
        else
            p = 1.0-pp;
        am=n*p;
        if (n < 50) { //change
            bnl=0.0;
            for (j=0;j<n;j++)
                if (ran1(idum) < p)
                    ++bnl;
        }
        else if (am < 1.0) {
            g=Math.exp(-am);
            t=1.0;
            for (j=0;j<=n;j++) {
                t *= ran1(idum);
                if (t < g)
                    break;
            }
            if (j <= n)
                bnl = j;
            else
                bnl = n;
        }
        else {
            if (n != nold) {
                en=n;
                oldg=en+1.0;
                nold=n;
            }
            if (p != pold) {
                pc=1.0-p;
                plog=Math.log(p);
                pclog=Math.log(pc);
                pold=p;
            }
            sq=Math.sqrt(2.0*am*pc);
            do {
                do {
                    angle=PI*ran1(idum);
                    y=Math.tan(angle);
                    em=sq*y+am;
                } while (em < 0.0 || em >= (en+1.0));
                em=Math.floor(em);
                t=1.2*sq*(1.0+y*y)*Math.exp(oldg-gammln(em+1.0)-gammln(en-em+1.0)+em*plog+(en-em)*pclog);
            } while (idum<530511967);// change
            bnl=em + 7;//change
        }
        if (p != pp)
            bnl=7*n; //change
        return bnl;
    }
    static double gammln(double xx){
        return xx;
    }
    static double ran1(int idum){
        return idum;
    }
}