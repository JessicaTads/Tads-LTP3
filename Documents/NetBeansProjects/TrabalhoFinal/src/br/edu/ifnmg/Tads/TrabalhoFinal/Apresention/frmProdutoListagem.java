/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.Tads.TrabalhoFinal.Apresention;


import br.edu.ifnmg.Tads.TrabalhoFinal.DataAccess.ProdutoDAO;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.ErroValidacaoException;
import br.edu.ifnmg.Tads.TrabalhoFinal.DomainModel.Produto;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Diego
 */
public class frmProdutoListagem extends javax.swing.JInternalFrame {

    ProdutoDAO DAO;
    
    /**
     * Creates new form frmProdutoListagem
     */
    public frmProdutoListagem() {
        initComponents();
        
        DAO = new ProdutoDAO();

        List<Produto> produto = DAO.ListarTodos();

        preencheTabela(produto);
        
    }
    
    private void preencheTabela(List<Produto> lista) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CodProduto");
        model.addColumn("Nome");
        model.addColumn("Preço");
        model.addColumn("Descricao");
        model.addColumn("Fornecedor");
        
        
        
        for (Produto c : lista) {
            Vector valores = new Vector();
            valores.add(0, c.getCodigo());
            valores.add(1, c.getNome());
            valores.add(2, c.getPreco());
            valores.add(3, c.getDescricao());
            valores.add(4, c.getFornecedor());
            
            
            
            model.addRow(valores);
        }
        tblListagem.setModel(model);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtFiltro = new javax.swing.JTextField();
        btnNovo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListagem = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        tblListagem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nome", "Preco", "Descricao", "CodFornecdor"
            }
        ));
        tblListagem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListagemMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListagem);

        btnBuscar.setText("Buscar");
        btnBuscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBuscarMouseClicked(evt);
            }
        });
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar)
                .addGap(24, 24, 24)
                .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Produto c = new Produto();
        ProdutoDAO d = new ProdutoDAO();
        frmProdutoEditar janela = new frmProdutoEditar(c, d);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnNovoActionPerformed

    private void tblListagemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListagemMouseClicked
        Object valor = tblListagem.getValueAt(tblListagem.getSelectedRow(), 0);
        Produto c = DAO.Abrir((int) valor);
        frmProdutoEditar janela = new frmProdutoEditar(c, DAO);
        this.getParent().add(janela);
        janela.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_tblListagemMouseClicked

    private void btnBuscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBuscarMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarMouseClicked

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Produto c = new Produto();
        try {
            c.setNome(txtFiltro.getText());
        } catch (Exception ex) {
            Logger.getLogger(frmProdutoListagem.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Produto> lista = null;
        try {
            lista = DAO.buscar(c);
        } catch (ErroValidacaoException ex) {
            Logger.getLogger(frmProdutoListagem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(frmProdutoListagem.class.getName()).log(Level.SEVERE, null, ex);
        }

        preencheTabela(lista);
    }//GEN-LAST:event_btnBuscarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblListagem;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
