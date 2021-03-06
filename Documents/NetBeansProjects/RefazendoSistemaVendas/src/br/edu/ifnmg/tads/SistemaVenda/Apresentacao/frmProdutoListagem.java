/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.tads.SistemaVenda.Apresentacao;

import br.edu.ifnmg.tads.SistemaVendas.DataAccess.ProdutoDAO;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.tads.SistemaVendas.DomainModel.Produto;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jessica
 */
public class frmProdutoListagem extends javax.swing.JInternalFrame {
ProdutoDAO dao;
    /**
     * Creates new form frmProdutoListagem
     */
    public frmProdutoListagem() {
        initComponents();
         dao = new ProdutoDAO();

        List<Produto> produtos = dao.ListarTodos();

        preencheTabela(produtos);
    }
     private void preencheTabela(List<Produto> lista) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CodProduto");
        model.addColumn("Nome");
        model.addColumn("Preco");

        for (Produto p : lista) {
            Vector valores = new Vector();
            valores.add(0, p.getCodigo());
            valores.add(1, p.getNome());
            valores.add(2, p.getPreco());
            model.addRow(valores);
        }
        tblListagemProduto.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagemProduto = new javax.swing.JTable();

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblListagemProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Produtos"
            }
        ));
        jScrollPane1.setViewportView(tblListagemProduto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btnBuscar)
                        .addGap(46, 46, 46)
                        .addComponent(btnNovo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       Produto p = new Produto();
        try {
            p.setNome(txtBuscar.getText());
        } catch (Exception ex) {
            Logger.getLogger(frmProdutoListagem.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Produto> lista = dao.ListarProdutos();
    try {
        lista = dao.buscar(p);
    } catch (ErroValidacaoException ex) {
        Logger.getLogger(frmProdutoListagem.class.getName()).log(Level.SEVERE, null, ex);
    }

        preencheTabela(lista);
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
         Produto p = new Produto();
        ProdutoDAO d = new ProdutoDAO();
        frmProdutoEditar janela = new frmProdutoEditar(p,d);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {                                         
        Object valor = tblListagemProduto.getValueAt(tblListagemProduto.getSelectedRow(), 0);
        Produto p = dao.Abrir((int) valor);
        frmProdutoEditar janela = new frmProdutoEditar(p, dao);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }         
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListagemProduto;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables

    
}
