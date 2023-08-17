package com.nubank.nubankclone.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nubank.nubankclone.databinding.PagamentoItemBinding
import com.nubank.nubankclone.model.Pagamento

class AdapterPagamentos(private val context: Context, private val listaPagamentos: MutableList<Pagamento>):
    RecyclerView.Adapter<AdapterPagamentos.PagamentoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagamentoViewHolder {
        val itemLista = PagamentoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return PagamentoViewHolder(itemLista)
    }

    override fun onBindViewHolder(holder: PagamentoViewHolder, position: Int) {
        holder.iconePagamento.setBackgroundResource(listaPagamentos[position].iconePagamento!!)
        holder.txtTitulo.text = listaPagamentos[position].titulo
    }

    override fun getItemCount() = listaPagamentos.size

    inner class PagamentoViewHolder(binding: PagamentoItemBinding): RecyclerView.ViewHolder(binding.root) {
        val iconePagamento = binding.icPagamento
        val txtTitulo = binding.txtTituloPagamento
    }
}