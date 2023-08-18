package com.nubank.nubankclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.nubank.nubankclone.adapter.AdapterPagamentos
import com.nubank.nubankclone.adapter.AdapterProduto
import com.nubank.nubankclone.databinding.ActivityMainBinding
import com.nubank.nubankclone.model.Pagamento
import com.nubank.nubankclone.model.Produto

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapterPagamentos: AdapterPagamentos
    private lateinit var adapterProduto: AdapterProduto
    private val listaPagamento: MutableList<Pagamento> = mutableListOf()
    private val listProdutos: MutableList<Produto> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        val recyclerIcons = binding.recycleIconsPyments
        recyclerIcons.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerIcons.setHasFixedSize(true)
        adapterPagamentos = AdapterPagamentos(this, listaPagamento)
        recyclerIcons.adapter = adapterPagamentos
        listaIconesPagamentos()

        val recyclerProdutos = binding.recycleProdutos
        recyclerProdutos.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerProdutos.setHasFixedSize(true)
        adapterProduto = AdapterProduto(this, listProdutos)
        recyclerProdutos.adapter = adapterProduto
        listaProdutosInformacao()
    }

    private fun listaIconesPagamentos() {
        val lis = listOf(
            Pagamento(R.drawable.ic_pix, "Área Pix"),
            Pagamento(R.drawable.barcode, "Pagar"),
            Pagamento(R.drawable.emprestimo, "Pegar \n Emprestimo"),
            Pagamento(R.drawable.transferencia, "Transferir"),
            Pagamento(R.drawable.depositar, "Depositar"),
            Pagamento(R.drawable.ic_recarga, "Recarga de Celular"),
            Pagamento(R.drawable.ic_monetization, "Cobrar"),
            Pagamento(R.drawable.doacao, "Doação"))
        for (pyment in lis) {
            listaPagamento.add(pyment)
        }

    }

    private fun listaProdutosInformacao() {
        val lis = listOf(
            Produto("Participe da Promoção Tudo no Roxinho e concorra a..."),
            Produto("Chegou o débito automatico da fatura do cartão"),
            Produto("Conheça a conta PJ: prática e livre de burocracia para se..."),
            Produto("Salve seus amigos da burocracia: Faça um convite..."))
        for (pro in lis) {
            listProdutos.add(pro)
        }
    }
}