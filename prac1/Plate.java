package prac1;


// PLATE = (PLACA DE) MATR�CULA 

public class Plate implements Comparable, Cloneable {

	private static final int MIN_AREA_CODE = 1;
	private static final int MAX_AREA_CODE = 6;
	
	private int areaCode;
	private String prefix;
	private String suffix;
	
	public Plate (int areaCode, String prefix, String suffix) {
		checkParams(areaCode, prefix, suffix);
		this.areaCode = areaCode;
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	
	public int getAreaCode() {

		return areaCode;
	}

	public String getPrefix() {

		return prefix;
	}

	public String getSuffix() {

		return suffix;
	}



	@Override
	public int compareTo (Object other) {
		/* this is how plates are sorted:
		 	first go plates with lower area codes. If they have the same area code...
		 	... first go plates with a lower prefix. If the have the same prefix...
		 	... first go plates with a lower suffix.
		 */
		
		/* COMPLETE en principio done */
		// excepcion
		if (!(other instanceof Plate)) {
			throw new RuntimeException("Other no es una instancia de Plate");
		}
		// declaracion y comparaciones
		Plate a = (Plate) other;
		if (compararCode(a)>0) return 1;
		return -1;
	}
	// funcions per a les comparacions
	private int compararCode(Plate a){
		if(a.getAreaCode()<this.getAreaCode()){
			return 1;
		}
		return -1;
	}
	private int compararSuf(Plate a){
		if (a.getSuffix().compareTo(this.getSuffix()) < 0) {
			return 1;
		}
		return -1;
	}
	private int compararPref(Plate a){
		if (a.getPrefix().compareTo(this.getPrefix()) < 0) {
			return 1;
		}
		return -1;
	}
	
	@Override
	public boolean equals (Object other) {
		/* COMPLETE */
		// excepcion
		if (!(other instanceof Plate)) {
			throw new RuntimeException("Other no es una instancia de Plate");
		}
		// declaracion y comparaciones
		Plate a = (Plate) other;
		return a.equals(this);
	}

	@Override
	public String toString () {
		return "["+this.areaCode+" "+this.prefix+"-"+this.suffix+"]";
	}
	
	
	private void checkParams(int areaCode, String prefix, String suffix) {
		if (areaCode>MAX_AREA_CODE || areaCode<MIN_AREA_CODE)
			throw new IllegalArgumentException ("area code out of range: "+areaCode);
		if (prefix.length()!=4 || !checkNumeric(prefix))
			throw new IllegalArgumentException ("invalid prefix: "+prefix);
		if (suffix.length()!=3 || !checkLetter(suffix)) 
			throw new IllegalArgumentException ("invalid suffix: "+suffix);
	}
	
	private boolean checkNumeric (String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isDigit(c)) return false;
		}
		return true;
	}
	
	private boolean checkLetter (String s) {
		for (char c : s.toCharArray()) {
			if (!Character.isLetter(c)) return false;
		}
		return true;
	}
	
	public Object clone () {
		try {
			Object r = super.clone();
			Plate p = (Plate)r;
			p.prefix = new String(this.prefix.toCharArray());
			p.suffix = new String(this.suffix.toCharArray());
			return p;
		}
		catch(CloneNotSupportedException e) {
			throw new RuntimeException(e.getMessage());
		}
	}
	
}