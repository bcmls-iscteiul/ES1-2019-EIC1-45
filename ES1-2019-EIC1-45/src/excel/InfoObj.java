package excel;

public class InfoObj {
	
	String method;
	int loc;
	int cyclo;
	int atfd;
	double laa;
	
	public InfoObj(ExcelFile f, int i) {
		//f.getInfo(i);  //recebe a info do ficheiro f na linha x
	
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
