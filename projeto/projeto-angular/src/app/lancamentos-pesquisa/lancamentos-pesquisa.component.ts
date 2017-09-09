import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-lancamentos-pesquisa',
  templateUrl: './lancamentos-pesquisa.component.html',
  styleUrls: ['./lancamentos-pesquisa.component.css']
})
export class LancamentosPesquisaComponent {
  lancamentos = [
    { tipoLancamento: 'DESPESA', descricao:'Compra de Pão', dataVencimento: '20/06/2017', 
      dataPagamento: null, valor: 4.55, pessoa: 'Teste de Pessoa' },
      { tipoLancamento: 'RECEITA', descricao:'Venda de Sistema', dataVencimento: '20/06/2017', 
      dataPagamento: '10/06/2017', valor: 1000, pessoa: 'Cliente' },
      { tipoLancamento: 'DESPESA', descricao:'Colegio Menino', dataVencimento: '01/06/2017', 
      dataPagamento: null, valor: 12000, pessoa: 'Colegio' },
      { tipoLancamento: 'RECEITA', descricao:'Trabalho Fixo', dataVencimento: '05/07/2017', 
      dataPagamento: null, valor: 2000.00, pessoa: 'Contratante' },
      { tipoLancamento: 'RECEITA', descricao:'Consultoria', dataVencimento: '01/07/2017', 
      dataPagamento: null, valor: 500.00, pessoa: 'Cliente 2' },
      { tipoLancamento: 'DESPESA', descricao:'Pagamento Academia', dataVencimento: '05/07/2017', 
      dataPagamento: null, valor: 200.00, pessoa: 'Academia' },
      { tipoLancamento: 'DESPESA', descricao:'Gasolina', dataVencimento: '18/06/2017', 
      dataPagamento: null, valor: 4.55, pessoa: 'Posto de Combustive' },
      { tipoLancamento: 'RECEITA', descricao:'Consultoria2', dataVencimento: '10/07/2017', 
      dataPagamento: null, valor: 4.55, pessoa: 'Cliente' },
      { tipoLancamento: 'DESPESA', descricao:'Alimentação', dataVencimento: '20/07/2017', 
      dataPagamento: null, valor: 4.55, pessoa: 'Restaurante' },
      { tipoLancamento: 'RECEITA', descricao:'Aplicações', dataVencimento: '15/06/2017', 
      dataPagamento: null, valor: 1.55, pessoa: 'Poupança' },
      { tipoLancamento: 'DESPESA', descricao:'Pagamento Estacionamento', dataVencimento: '10/06/2017', 
      dataPagamento: null, valor: 4.55, pessoa: 'Estacionamento' }
  ];

}
