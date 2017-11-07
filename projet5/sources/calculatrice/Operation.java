package calculatrice;

public enum Operation {
    PLUS("+"), MOINS("-"), FOIS("*"), DIV("/"), PUISS("^");
    private final String code_operation;

    Operation(String code_operation){
	this.code_operation = code_operation;
    }

    public String toString(){
	return code_operation;
    }

    public Double eval(Double x, Double y){
	switch (this){
	case PLUS : return x+y;
	case MOINS : return x-y;
	case DIV : return x/y;
	case FOIS : return x*y;
	case PUISS : return Math.pow(x,y);
	default : return null;
	}
    }
}
