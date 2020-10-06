
package mangement.panel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mangement.MySqlConnect;

public class Request_for_Blood extends javax.swing.JPanel {

    /**
     * Creates new form Request_of_Blood
     */
    public Request_for_Blood() {
        initComponents();
        
        try {
            
            Connection conn = MySqlConnect.ConnectDB();
            String query = "SELECT * FROM blood_management_system.request_for_blood";
            
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            
            DefaultTableModel table = (DefaultTableModel)data_table.getModel();
            table.setRowCount(0);
            
            while(rs.next()){
                
                Object obj[] = {rs.getString("name"),rs.getString("phoneNumber"),rs.getString("location"),rs.getString("bloodGroup")
                ,rs.getString("amount_of_blood")};
                
                table.addRow(obj);
            }
            conn.close();
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, "Something error","Not found",JOptionPane.PLAIN_MESSAGE);
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        data_table = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        data_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Phone Number", "Location", "Blood Group", "Quantity of Blood"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(data_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 540));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable data_table;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}