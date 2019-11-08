package excel;

public class ExcelObject {

	String method;
	int loc;
	int cyclo;
	int atfd;
	double laa;
	
	public ExcelObject(ExcelFile f) {
		//atributos são inicializados aqui baseados na info do ficheiro importado.
	}

	public String getMethod() {
		return method;
	}

	public int getLoc() {
		return loc;
	}

	public int getCyclo() {
		return cyclo;
	}

	public int getAtfd() {
		return atfd;
	}

	public double getLaa() {
		return laa;
	}
}
