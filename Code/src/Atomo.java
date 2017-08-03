
public class Atomo {

	private Character var;
	
	Atomo(char v){
		this.var = v;
	}
	
	public boolean comp(char v){
		if(var == v) return true;
		else return false;
	}
	
	public void setVar(char v){
		this.var = v;
	}
	
	 public String getVar(){
		return(this.var.toString());
	}
}
