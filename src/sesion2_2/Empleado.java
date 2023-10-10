package sesion2_2;

public class Empleado {
	public enum TipoEmpleado{Vendedor, Encargado, Otro};
	
	public static double calculoNominaBruta(TipoEmpleado tipo, double ventasMes, double horasExtra) {
		double salariobase = 0, primas = 0, extras = 0;
		
		if(tipo==TipoEmpleado.Encargado) {
			salariobase = 2500;
		}else if(tipo == TipoEmpleado.Vendedor) {
			salariobase = 2000;
		}
		
		if(ventasMes >= 0.5) {
			primas = 200;
		}else if(ventasMes >= 1000){
			primas = 100;
		}
		
		extras = (double) horasExtra * 30;
		
		return salariobase + primas + extras;
		//TipoEmpleado es conjunto, salariobase es rango, horasExtra es valor específico creo. 
	}
	
	public static double calculoNominaNeta(double nominaBruta) {
		double retencion = 0;
		
		if(nominaBruta > 2500) {
			retencion = 0.18f;
		}else if(nominaBruta > 2000) {
			retencion = 0.15f;
		}
		
		return (double) (nominaBruta * (1 - retencion));
	}
	
}




