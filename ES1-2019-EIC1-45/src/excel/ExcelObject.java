package excel;


import java.util.ArrayList;
import java.util.List;

public class ExcelObject {
	
	InfoObj i;
	List<InfoObj> list = new ArrayList<InfoObj>();
	
	public ExcelObject(ExcelFile f) {
		
		//atributos são inicializados aqui baseados na info do ficheiro importado.
		for(int l=0; l<10; l++/*substituir por n de linhas do ficheir*/) {
			i = new InfoObj(f,l);
			list.add(i);
		}
	}
	
	
}
