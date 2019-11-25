package com.meuposto.repository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.meuposto.model.NoSQLQuery7;
import com.meuposto.model.ProjecaoQuery07;
import com.observablepattern.Observable;
import com.observablepattern.Observer;

@Service
public class AbastecimentoNoSQL implements Observer{
	
	@Autowired	
	AbastecimentoRepository abastecimentoRepository;
	private ConexaoNoSQL noSQL;
	

	public AbastecimentoNoSQL() {
		this.noSQL = new ConexaoNoSQL("abastecimentos");
	}
	public void setSQL(AbastecimentoRepository abastecimentoRepository) {
		this.abastecimentoRepository = abastecimentoRepository;
	}
	public List<NoSQLQuery7> getResult(int id, Date data) throws JsonProcessingException{
		String json;
		long dataMil, dataMil2;
		if(noSQL.getCount()==0) {
			List<ProjecaoQuery07> list = abastecimentoRepository.getAbastecimentosPosto();
			noSQL.insertList(list);
		}
		System.out.println(data.toString());
		dataMil = data.getTime() - 10800000;
		dataMil2 = dataMil + 86340000;
		System.out.println(dataMil);
		System.out.println(dataMil2);
		
		Document document = new Document();
		document.append("idPosto", id);
		document.append("data", new Document().append("$gte", dataMil).append("$lte", dataMil2));
		
		System.out.println(document.toJson());
		System.out.println(Calendar.getInstance().getTime().toString());
		
		return noSQL.toFind(document);
	}
	@Override
	public void update(Observable arg0) {
		Document query, update;
		ProjecaoQuery07 lastAdd = abastecimentoRepository.getUltimoAbastecimento().get(0);
		this.noSQL.insert(lastAdd);
		query = new Document();
		query.append("cpf", lastAdd.getCpf());
		update = new Document();
		update.append("$set", new Document().append("nomeCliente", lastAdd.getNomeCliente()));
		System.out.println(query.toJson());
		System.out.println(update.toJson());
		this.noSQL.update(query, update);
	}
}
	