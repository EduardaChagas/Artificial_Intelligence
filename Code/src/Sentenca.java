
public class Sentenca {
	//var1 -> var2
	private Character var1,var2;
	
	Sentenca(char v1,char v2){
		this.var1 = v1;
		this.var2 = v2;		
	}
	
	public boolean derivacao(char var){
		if(var == var2) return true;
		else return false;
	}
	
	public void setVar1(char v1){
		this.var1 = v1;
	}
	
	public void setVar2(char v2){
		this.var2 = v2;
	}
	
	public String getVar1(){
		return(this.var1.toString());
	}
	
	public String getVar2(){
		return(this.var2.toString());
	}

}
