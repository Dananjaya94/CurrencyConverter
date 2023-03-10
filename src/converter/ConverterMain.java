/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.List;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Currency;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;


/**
 *
 * @author nuwan
 */
public class ConverterMain extends javax.swing.JFrame {

    /**
     * Creates new form ConverterMain
     */
    
    String SelectedCurrencyOne;
    String SelectedCurrencyTwo;
    
    public ConverterMain() throws IOException {
        initComponents();
        GetCurrencyData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CurrencyTwo = new javax.swing.JTextField();
        CurrencyOne = new javax.swing.JTextField();
        CurrencySelectorTwo = new javax.swing.JComboBox<>();
        CurrencySelectorOne = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        CurrencyTwo.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        getContentPane().add(CurrencyTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 330, -1));

        CurrencyOne.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        getContentPane().add(CurrencyOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 330, -1));

        CurrencySelectorTwo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        CurrencySelectorTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencySelectorTwoActionPerformed(evt);
            }
        });
        getContentPane().add(CurrencySelectorTwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 250, 60));

        CurrencySelectorOne.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        CurrencySelectorOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrencySelectorOneActionPerformed(evt);
            }
        });
        getContentPane().add(CurrencySelectorOne, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 250, 60));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jButton1.setText("CONVERT");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CurrencySelectorOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrencySelectorOneActionPerformed

        SelectedCurrencyOne = CurrencySelectorOne.getSelectedItem().toString();
    }//GEN-LAST:event_CurrencySelectorOneActionPerformed

    private void CurrencySelectorTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrencySelectorTwoActionPerformed

        SelectedCurrencyTwo = CurrencySelectorTwo.getSelectedItem().toString();
    }//GEN-LAST:event_CurrencySelectorTwoActionPerformed

    private void GetCurrencyData() throws IOException, IOException{
        // Setting URL
        String url_str = "https://v6.exchangerate-api.com/v6/1f8d4b047c7c026dd68b9ae2/latest/USD";
        
        // Making Request
        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        // Convert to JSON
        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        // Accessing json object
        JsonObject crrncyrat = (JsonObject) jsonobj.get("conversion_rates");
       
        System.out.println(crrncyrat);
        
        //Extract Currency keys from json object
        Set<String> keyset = crrncyrat.keySet();
        System.out.println(keyset);
        
        String curr[] = keyset.toArray(new String[keyset.size()]);
        
        //Adding currency keys to dropdown 1
        for(int i =0; i<curr.length; i++){
            CurrencySelectorOne.addItem(curr[i]);
        }
        
        //Adding currency keys to dropdown 1
        for(int i =0; i<curr.length; i++){
            CurrencySelectorTwo.addItem(curr[i]);
        }
    }
    
    private void ConvertCurrency(String SelectioOne, String SelectionTwo){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ConverterMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConverterMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConverterMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConverterMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new ConverterMain().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(ConverterMain.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CurrencyOne;
    private javax.swing.JComboBox<String> CurrencySelectorOne;
    private javax.swing.JComboBox<String> CurrencySelectorTwo;
    private javax.swing.JTextField CurrencyTwo;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
