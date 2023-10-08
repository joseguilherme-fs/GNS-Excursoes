import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Excursao {
	private int codigo;
	private double preço;
	private int max;
	private ArrayList<String> listaReservas = new ArrayList<>();
	
	public Excursao(int codigo, double preço, int max) throws Exception {
		if (codigo<=0 || max <=0 || preço <=0) {
			throw new Exception("Valor inválido.");
		}
		else {
			this.codigo = codigo;
			this.preço = preço;
			this.max = max;
			this.listaReservas = new ArrayList<>();
		}};
		
	public Excursao(int codigo) throws Exception {
		if (codigo<=0) {
			throw new Exception("Valor inválido.");
		}
		else {
			this.codigo = codigo;
			this.preço = 0.0;
			this.max = 0;
			this.listaReservas = new ArrayList<>();
		}
	}
	
	public void criarReserva(String CPF, String nome) throws Exception {
			if (listaReservas.size() < max) {
				for (int i = 0; i < listaReservas.size(); i++) {
					String cpf_nome[] = (listaReservas.get(i)).split("/");
					
						if (cpf_nome[1].equals(nome)) {
							throw new Exception("Desculpe, a reserva já existe.");
						}
				}
				if (CPF.equals("") || nome.equals("")) {
					throw new Exception("Campo CPF ou Nome vazio.");
				}   
				else if (this.isNumeric(CPF) == false || this.containsDigits(nome) == true) {
					throw new Exception("Campo CPF ou Nome com formato errado.");
				}
				else {
					String reserva = CPF + "/" + nome;
					listaReservas.add(reserva);
				}
				
			}
			else {
				throw new Exception("Desculpe, a excursão está lotada. Não é possível fazer mais reservas.");
			}
		
	};
		
		
	public void cancelarReserva(String cpf, String nome) throws Exception {
	    String reservaParaCancelar = cpf + "/" + nome;
	        if (listaReservas.contains(reservaParaCancelar)) {
	            listaReservas.remove(reservaParaCancelar);
	            System.out.println("Reserva para " + nome + " (CPF: " + cpf + ") cancelada com sucesso!");
	        } else {
	            throw new Exception("Reserva para " + nome + " não encontrada. Não foi possível cancelar.");
	        } 
	};
	
	public void cancelarReserva(String cpf) throws Exception {
	    ArrayList<String> reservasParaRemover = new ArrayList<>();

	    for (String reserva : listaReservas) {
	        String cpfReserva = reserva.split("/")[0];
	        if (cpfReserva.equals(cpf)) {
	            reservasParaRemover.add(reserva);
	        }
	    }

	    if (!reservasParaRemover.isEmpty()) {
	        listaReservas.removeAll(reservasParaRemover);
	        System.out.println("Todas as reservas para o CPF " + cpf + " foram canceladas com sucesso!");
	    } else {
	        throw new Exception("Nenhuma reserva encontrada para o CPF " + cpf + ".");
	    }
	};
	
	
	
	public ArrayList<String> listarReservasPorCpf(String digitos){
	    ArrayList<String> reservasPorCpf = new ArrayList<>();

	    for (String reserva : listaReservas) {
	        String cpfReserva = reserva.split("/")[0];
	        if (digitos.equals("")) {
	        	return listaReservas;
	        }
	        if (cpfReserva.contains(digitos)) {
	            reservasPorCpf.add(reserva);
	        }
	    }
	    return reservasPorCpf;
	};
	
	public ArrayList<String> listarReservasPorNome(String texto){
	    ArrayList<String> reservasPorNome = new ArrayList<>();

	    for (String reserva : listaReservas) {
	        String nomeReserva = reserva.split("/")[1];
	        if (texto.equals("")) {
	        	return listaReservas;
	        }
	        if (nomeReserva.contains(texto)) {
	            reservasPorNome.add(reserva); 
	        }
	    }	
	    return reservasPorNome;
	}

	
	
	public double calcularValorTotal() {
	    return this.preço * listaReservas.size();
	}

	
	@Override
	public String toString() {
		
		String Reservas = "";
		for (String reserva : listaReservas) {
			Reservas += reserva + "\n";
		}
		return "Código = " + codigo + "\nPreço = " + preço + "\nCapacidade máxima = " + max + "\nCapacidade total = " + listaReservas.size()
				+ "" + "\nReservas:\n" + Reservas;
	}
	
	public void salvar() throws IOException {
		File reservas = new File(new File(".\\"+ this.codigo + ".txt").getCanonicalPath());
		FileWriter arq = new FileWriter(reservas, false);
		arq.write(preço + ";" + max + ";");
		
		for (String elemento : listaReservas) {
			arq.write(elemento + ";");
		}
		arq.close();
	}
	
	
	public void carregar() throws IOException {
		try {
			File excursoes = new File(new File(".\\"+ codigo + ".txt").getCanonicalPath());
			Scanner arquivo = new Scanner(excursoes);
			
			String linha;
			String[] dados;

			linha = arquivo.nextLine();
			dados = linha.split(";");
			double preço = Double.valueOf(dados[0]);
			int max = Integer.valueOf(dados[1]);
			
			this.preço = preço;
			this.max = max;
			int tam = dados.length;
			
			if (tam > 1) {
				for (int i = 2; i < tam; i++) {
					this.listaReservas.add(dados[i]);
				}
			}
			arquivo.close();
			
		} catch (FileNotFoundException erro) {
			throw new FileNotFoundException("Arquivo não encontrado.");
		}
	};
	
	public boolean isNumeric(String str) { 
		  try {  
		    Integer.parseInt(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}
	
	public boolean containsDigits(String str) {
	    for (char c : str.toCharArray()) {
	        if (Character.isDigit(c)) {
	            return true;
	        }
	    }
	    return false;
	}
	
}
