/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mau.tablemodel;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import br.com.mau.model.Mercadoria;

/**
 *
 * @author Mauricio
 */
public class MercadoriaTableModel extends AbstractTableModel{

    private List<Mercadoria> mercadorias;

    public MercadoriaTableModel(List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }
      
    @Override
    public int getRowCount() {
        return mercadorias.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Mercadoria m = mercadorias.get(rowIndex);
        
        switch(columnIndex){
            case 0:
                return m.getNome();
            case 1: 
                return m.getDescricao();
            case 2: 
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy h:m:s");
                return sdf.format(m.getValidade());
            case 3:
                 Locale locale = new Locale("pt", "BR"); 
                 NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
                 
                return numberFormat.format(m.getValor());
        }
        
        return null;
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0: 
                return "Nome";
            case 1: 
                return "Descrição";
            case 2: 
                return "Validade";
            case 3: 
                return "Preço";
        }
        return "";
    }
    
    
    
}
