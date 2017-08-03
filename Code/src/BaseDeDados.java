import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {

	private static List<Sentenca> sentencas = new ArrayList<Sentenca>();
	private static List<Atomo> atomos = new ArrayList<Atomo>();
	
	public static void addSentenca(char v1, char v2){
		Sentenca s = new Sentenca(v1,v2);
		sentencas.add(s);
	}	
	public static void addAtomo(char v){
		Atomo a = new Atomo(v);
		atomos.add(a);
	}	
	public static List<Atomo> getAtomos(){
		return atomos;
	}
	public static List<Sentenca> getSentencas(){
		return sentencas;
	}
	public static boolean verificarDado(char v){
		boolean verificacao = true;
		int tem = 1;
		if((atomos.size() == 0) || (atomos.isEmpty())) return false;
		else{
			while(tem!=0){
				tem = 0;
				for(int i=0;i<atomos.size();i++){
					if(atomos.get(i).getVar().charAt(0) == v) {
						return true;
					}
				}	
				for(int i=0;i<sentencas.size();i++){
					if(sentencas.get(i).getVar2().charAt(0) == v){
						v = sentencas.get(i).getVar1().charAt(0);
						tem++;
						break;
					}
				}	
			}
		}
		return false;
	}
}

