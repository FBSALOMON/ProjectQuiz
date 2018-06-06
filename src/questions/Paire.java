//FERNANDO BOEIRA SALOMON
//BOEF061287 - 06/06/2018
package questions;

public class Paire {
	private String elementA;
	private String elementB;
	
	public Paire(String[] stringElements) {
		this.elementA = stringElements[0];
		this.elementB = stringElements[1];
	}

	public String getElementA() {
		return elementA;
	}
	public void setElementA(String elementA) {
		this.elementA = elementA;
	}
	public String getElementB() {
		return elementB;
	}
	public void setElementB(String elementB) {
		this.elementB = elementB;
	}
}