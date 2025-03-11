

public class OperaPilha {
	private Pilha pilha;
	public OperaPilha(Pilha pilha) {
		this.pilha = pilha;
	}
	public void soma() {
		int[] veto = new int[2];
		for(int i =0 ; i <2 ; i++) {
			veto[i]=pilha.pop();
		}
		int resul = veto[1] + veto[0];
		pilha.push(resul);
	}
	public void sub() {
		int[] veto = new int[2];
		for(int i =0 ; i <2 ; i++) {
			veto[i]=pilha.pop();
		}
		int resul = veto[1] - veto[0];
		pilha.push(resul);
	}
	public void multi() {
		int[] veto = new int[2];
		for(int i =0 ; i <2 ; i++) {
			veto[i]=pilha.pop();
		}
		int resul = veto[1] * veto[0];
		pilha.push(resul);
	}
	public void div() {
		int[] veto = new int[2];
		for(int i =0 ; i <2 ; i++) {
			veto[i]=pilha.pop();
		}
		int resul = veto[1] / veto[0];
		pilha.push(resul);
	}
	public void expo() {
		int[] veto = new int[2];
		for(int i =0 ; i <2 ; i++) {
			veto[i]=pilha.pop();
		}
		int resul = (int) Math.pow(veto[1], veto[0]);
		pilha.push(resul);
	}

}
