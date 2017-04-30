package br.univel.meustestes;

import java.math.BigDecimal;

import br.univel.minhaarvore.UniArvore;
import br.univel.minhaarvore.UniArvoreImpl;
import br.univel.minhaarvore.UniNode;
import br.univel.minhaarvore.UniNodeImpl;

public class Principal {

	public Principal() {
		
		Conta contaAgua = new Conta(1, "Água", new BigDecimal("101.28"));
		UniNode<Conta> noAgua = new UniNodeImpl<>(contaAgua);
		
		Conta contaAluguel = new Conta(2, "Aluguel", new BigDecimal("900.00"));
		UniNode<Conta> noAlu = new UniNodeImpl<>(contaAluguel);
		
		Conta contaIntTel = new Conta(3, "Internet e Telefone", new BigDecimal("165.35"));
		UniNode<Conta> noIntTel = new UniNodeImpl<>(contaIntTel);
		
		Conta contaEnElet = new Conta(4, "Energia Elétrica", new BigDecimal("252.58"));
		UniNode<Conta> noEnElet = new UniNodeImpl<>(contaEnElet);
		
		
		Conta despesasAdm = new Conta(1, "Despesas Administrativas", new BigDecimal(0));
		UniNode<Conta> noDeAdm = new UniNodeImpl<>(despesasAdm);
		noDeAdm.addFilho(noAgua);
		noDeAdm.addFilho(noAlu);
		noDeAdm.addFilho(noIntTel);
		noDeAdm.addFilho(noEnElet);
		
		
		Conta despesasOper = new Conta(1, "Despesas Operacionais", new BigDecimal(0));
		UniNode<Conta> noDeOpr = new UniNodeImpl<>(despesasOper);
		noDeOpr.addFilho(noDeAdm);
		
		UniArvore<UniNode<Conta>> planoContas = new UniArvoreImpl(noDeOpr);
		
		
		
		Conta ContaBeneficios = new Conta(1, "Benefícios", new BigDecimal("102.23"));
		UniNode<Conta> noBene = new UniNodeImpl<>(ContaBeneficios);
		
		Conta ContaEncargos = new Conta(2, "Engarcos ", new BigDecimal("200.02"));
		UniNode<Conta> noenc = new UniNodeImpl<>(ContaEncargos);
		
		Conta contaSalario = new Conta(3, "Salarios", new BigDecimal("162.25"));
		UniNode<Conta> noSalario = new UniNodeImpl<>(contaSalario);
		
		
		
		Conta Gastospessoais = new Conta(1, "Gastos com Pessoal", new BigDecimal(0));
		UniNode<Conta> noDeGastosPessoais = new UniNodeImpl<>(Gastospessoais);
		noDeGastosPessoais.addFilho(noBene);
		noDeGastosPessoais.addFilho(noenc);
		noDeGastosPessoais.addFilho(noSalario);
		
		
		
		
		noDeOpr.addFilho(noDeGastosPessoais);
		

		Conta ContaServicoLimpeza = new Conta(1, "Servicos de Limpeza", new BigDecimal("101.23"));
		UniNode<Conta> noServLimp = new UniNodeImpl<>(ContaServicoLimpeza);
		
		Conta ContaServicoManutencao = new Conta(2, "Servicos de Manutençao ", new BigDecimal("202.02"));
		UniNode<Conta> noServManut = new UniNodeImpl<>(ContaServicoManutencao);
		
		
		
		
		Conta ManutencaoLimpeza = new Conta(1, "Manutençao e Limpeza", new BigDecimal(0));
		UniNode<Conta> noDeManutencaoLimpeza= new UniNodeImpl<>(ManutencaoLimpeza);
		noDeManutencaoLimpeza.addFilho(noServLimp);
		noDeManutencaoLimpeza.addFilho(noServManut);
		
		
		
		
		
		noDeOpr.addFilho(noDeManutencaoLimpeza);
		

		Conta ContaMateriasEscritorio = new Conta(1, "Materiais de Escritorio", new BigDecimal("102.23"));
		UniNode<Conta> noMatEsc = new UniNodeImpl<>(ContaMateriasEscritorio);
		
		Conta ContaMatLimp = new Conta(2, "Materiais de Limpeza ", new BigDecimal("200.02"));
		UniNode<Conta> noMatLimp = new UniNodeImpl<>(ContaMatLimp);
		
		
		
		
		Conta Materiais = new Conta(1, "Materiais", new BigDecimal(0));
		UniNode<Conta> noDeMateriais = new UniNodeImpl<>(Materiais);
		noDeMateriais.addFilho(noMatEsc);
		noDeMateriais.addFilho(noMatLimp);

		
		
		
		
		noDeOpr.addFilho(noDeMateriais);
		
		
		
		somarFilhos(planoContas);
		
		
		System.out.println("===========================================");
		
		
		planoContas.mostrarTodosConsole();
		
		
	
		
		
	}
	
	/**
	 * Percorre toda a arvore, recursivamente, encontra
	 * todas as contas analíticas (isLeaf() == true), soma
	 * seus valores e atribui o total na conta pai.
	 * 
	 * Depois pega todos os pais e somam no avô.
	 * 
	 * @param planoContas
	 */
	private void somarFilhos(UniArvore<UniNode<Conta>> planoContas) {

		BigDecimal total = BigDecimal.ZERO;
		
		for (UniNode<Conta> uniNode : planoContas.getNoRaiz().getFilhos()) {
			total = somarRecursivo(total, uniNode);
		}
		
		System.out.println("total = " + total);
		
	}

	private BigDecimal somarRecursivo(BigDecimal totalAtual, UniNode<Conta> uniNode) {
		
		totalAtual = totalAtual.add(uniNode.getConteudo().getValor());
		
		
		if(!uniNode.isLeaf()){
			for (UniNode<Conta> uniNodeFilhos : uniNode.getFilhos()) {
				totalAtual = somarRecursivo(totalAtual, uniNodeFilhos);
			}
		}
		
		
		return totalAtual;
	}

	public static void main(String[] args) {
		
		new Principal();
		
	}
	
}
