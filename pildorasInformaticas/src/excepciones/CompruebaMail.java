package excepciones;

import javax.swing.JOptionPane;

public class CompruebaMail {
	public static void main(String[] args) {
		String mail = JOptionPane.showInputDialog("Introduce tu email");
		try{
			examinaMail(mail);
		}catch(Exception e){
			System.out.println("El mail tiene que tener más de 3 caracteres");
		}
	}
	static void examinaMail(String mail) throws LongitudMailErronea {
		int arroba = 0;
		boolean punto = false;
		
		if(mail.length() <= 3){
			//RuntimeException e = new RuntimeException();
			throw new LongitudMailErronea("El mail es muy corto");
		}else{
			for(int i=0; i<mail.length(); i++){
				if(mail.charAt(i) == '@'){
					arroba++;
				}
				if(mail.charAt(i) == '.'){
					punto = true;
				}
			}
			
			if(arroba==1 && punto==true){
				System.out.println("El mail es correcto");
			}else{
				System.out.println("El mail no es correcto");
			}
		}
	}
}

@SuppressWarnings("serial")
class LongitudMailErronea extends Exception{
	public LongitudMailErronea(){
		
	}
	public LongitudMailErronea(String msg){
		super(msg);
	}
}