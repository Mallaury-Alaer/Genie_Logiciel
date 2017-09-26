/**
 *Classe permettant la représentation de nombres rationnels
 *@author Mallaury Alaer
 **/
public class Rationnel{
    int n=0,a=0,b=0;

    /**
     *Constructeur
     *@param n partie entiere
     *@param a numérateur
     *@paral b dénominateur
     */
    public Rationnel(int n, int a, int b){
	this.n = n;
	if( a < 0 && b < 0){
	    this.a = -a;
	    this.b = -b;
	}else if( a < 0 || b < 0){
	    a = (a<0) ? -a : a;
	    this.b = (b<0) ? -b : b;
	    
	    if( a < b){
		this.n -= 1;
		this.a = this.b-a;
	    }
	    else if(a > b){
		this.n -= a/this.b+1;
		if(b > a%b)
		    this.a = b-a%b;
		else{
		    this.a = a%b;
		}
	    }
	}else{
	    this.b=b;
	    if( a < b){
		this.a = a;
	    }else if(a > b){
		this.n += a/this.b;
		this.a = a%b;
	    }
	}
    }

    /**
     *Constructeur permettant de construire un rationnel dont la partie décimale est nulle
     *@param n : la partie entière
     */
    public Rationnel(int n){
        this.n = n;
    }

    /**
     *Constructeur permettant de construire un rationnel dont la partie entière est nulle
     *@param a le numérateur
     *@param b le denominateur
     */
    public Rationnel(int a, int b){
        if( a < 0 && b < 0){
	    this.a = -a;
	    this.b = -b;
	}else if( a < 0 || b < 0){
	    a = (a<0) ? -a : a;
	    this.b = (b<0) ? -b : b;
	    if( a < b){
		this.n -= 1;
		this.a = this.b-a;
	    }else if(a > b){
		this.n -= a/this.b+1;
		if(b > a%b)
		    this.a = b-a%b;
		else{
		    this.a = a%b;
		}
	    }
	}else{
	    this.b=b;
	    if( a < b){
		this.a = a;
	    }else if(a > b){
		this.n += a/this.b;
		this.a = a%b;
	    }
	}
    }

    /**
     *Méthode permettant de déteriner si le nombre rationnel est nul ou non
     *@return true si le rationnel est nul, false si non
     */
    public boolean estNul(){
	return this.a ==0 && this.b == 0 && this.n == 0;
    }

    /**
     *Méthode permettant d'obtenir l'inverse d'un nombre rationnel
     *@return l'inverse du rationnel courant
     */
    public Rationnel inverse(){
	int a = this.b;
	int b = (this.n !=0) ? this.b * this.n + this.a : this.a;
	if(a==0)
	    return new Rationnel(1,this.n);
	return new Rationnel(a, b);
    }

    /**
     *Méthode d'addition de deux rationnels
     *@param r le rationnel a ajouter
     *@return la somme des deux rationnels (type Rationnel)
     */
    public Rationnel ajouter(Rationnel r){
	//Manque le cas ou this.n ou r.n est egal a 0
	int den  = this.b * r.b;
	int num = (this.n !=0 && r.n !=0) ? r.b*(this.n*this.b + this.a) + this.b*(r.n*r.b+r.a) : r.b*this.a+this.b*r.b;
	if(this.a == 0 && r.a == 0){
	    return new Rationnel(this.n+r.n);
	}else if(this.a == 0){
	    den = r.b;
	    num = r.b*(this.n+r.n)+r.a;
	}else if(r.a == 0){
	    den = this.b;
	    num = this.b*(this.n+r.n)+this.a;
	}
	return new Rationnel(num, den);
    }

    /**
     *Méthode effectuat le produit de deux rationnels
     *@param le rationnel a multiplier
     *@return le produit des deux rationnels (type Rationnel)
     */
    public Rationnel multiplier(Rationnel r){
	//Manque le cas ou this.n ou r.n est egal a 0
	int den = this.b * r.b;
	int num;
	if(this.n != 0 && r.n !=0)
	    num = this.b*r.b*this.n*r.n + this.b*this.n*r.a + r.b*r.n*this.a+this.a*r.a;
	else
	    num = this.a*r.a;

	if (this.a == 0 && r.a == 0){
	    return new Rationnel(this.n*r.n);
	}else if(this.a == 0){
	    num = this.n*(r.b*r.n+r.a);
	    den = r.b;
	}else if (r.a == 0){
	    num = r.n*(this.b*this.n+this.a);
	    den = this.b;
	}
	return new Rationnel(num, den);
    }

    /**
     *Méthode de comparaison de deux rationnels
     *@param r rationnel avec lequel comparer le rationnel courant
     *@return 0 si les rationnels sont égaux, -1 si le rationnel courant est plus petit que r, 1 si il est plus grand
     */
    public int compareTo(Rationnel r){
	if(this.n > r.n)
	    return 1;
	else if(this.n < r.n)
	    return -1;
	else{
	    if(this.a == 0 || r.a == 0)
		return 0;
	    if(this.a*r.b > this.b*r.a)
		return 1;
	    else if(this.a * r.b < this.b * r.a)
		return -1;
	    else return 0;
	}
    }

    /**
     *Méthode permettant de récupérer la partie entière sous forme de chaine de caracteres
     *@return la partie entiere
     */
    public String getPartieEntiere(){
	return ""+n;
    }

    /**
     *Méthode permettant de récuperer la partie décimale sous forme de chaine de caratcteres
     *@return la partie décimale
     */
    public String getDecimale(){
	return a + "/" + b;
    }

    public String toString(){
	if(this.estNul())
	    return "0";
	if(a==0 || b == 0)
	    return this.getPartieEntiere();
	else if(n==0)
	    return this.getDecimale();
	return n + " + " + a + "/" + b;
    }

    public static void main(String [] args){
        Rationnel r = new Rationnel(1,2,7);
	System.out.println(r.compareTo(new Rationnel(1,2,3)));
	System.out.println(new Rationnel(-15,6));
    }
}
