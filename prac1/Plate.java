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

		if (!(other instanceof Plate)) {
			throw new RuntimeException("Other no es una instancia de Plate");
		}
		
		
		Plate a=(Plate) other;
		int codi=compararCode(a);
		if (codi==0) {
			int pref=this.getPrefix().compareTo(a.getPrefix());
			if(pref==0) {
				return this.getSuffix().compareTo(a.getSuffix());
			} else return pref;
			
		} 

		return codi;
	}
	// funcions per a les comparacions
	private int compararCode(Plate a){
		return this.getAreaCode()-a.getAreaCode();
	}
	
	
	@Override
	public boolean equals(Object other) {
		/* COMPLETE */

		if (!(other instanceof Plate)) {
			throw new RuntimeException("Other no es una instancia de Plate");
		}
		
		Plate a=(Plate)other;
		return( suffix.equals(a.getSuffix()) && prefix.equals(a.getPrefix()) && areaCode==a.getAreaCode() );
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