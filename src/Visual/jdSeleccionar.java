
package Visual;

import Control.*;
import Entidades.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jdSeleccionar extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jdSeleccionar.class.getName());

    private TratamientosData tratamientos = new TratamientosData();
    private MasajistasData masajistas = new MasajistasData();
    
    //Dia de spa comprendiendo entre los siguientes horarios de trabajo =
    private LocalTime inicioJornada = LocalTime.of(7, 0);
    private LocalTime finJornada = LocalTime.of(21, 0);
    
    //Horarios que se disponen (horario , intervalo)
    private ArrayList<LocalTime> horarioDisponible = new ArrayList<>();
    private int intervalo;
    
    //Datos que brindará la vistaSesion
    private String eleccion = "";
    private LocalDate fecha = LocalDate.now();
    private int codigo = -1;

    public void setEleccion(String eleccion) {
        this.eleccion = eleccion;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    
     
    
    public jdSeleccionar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

    }
    
    //Se utiliza para actualizar los datos dentro del jdSeleccionar
    public void ModificacionDatos() {
        
        columnaSeleccion(eleccion);
        fechaElegida();
        cargarTabla(eleccion,codigo);
        
    }
    
    //Se crea el modelo de la tabla, y se reemplaza el valor de celda editable a falso
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpPanel = new javax.swing.JPanel();
        jlPresentacion = new javax.swing.JLabel();
        jspPanelTabla = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jlPresentacion2 = new javax.swing.JLabel();
        jtfFecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jpPanel.setBackground(new java.awt.Color(198, 243, 247));

        jlPresentacion.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlPresentacion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPresentacion.setText("Seleccione el tratamiento que desea realizar en la fecha:");

        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jspPanelTabla.setViewportView(jtTabla);

        jlPresentacion2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlPresentacion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPresentacion2.setText("Se muestra disponibilidad según horario");

        jtfFecha.setEditable(false);
        jtfFecha.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jpPanelLayout = new javax.swing.GroupLayout(jpPanel);
        jpPanel.setLayout(jpPanelLayout);
        jpPanelLayout.setHorizontalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlPresentacion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspPanelTabla)
                    .addComponent(jtfFecha))
                .addContainerGap())
        );
        jpPanelLayout.setVerticalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlPresentacion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlPresentacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspPanelTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                jdSeleccionar dialog = new jdSeleccionar(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlPresentacion;
    private javax.swing.JLabel jlPresentacion2;
    private javax.swing.JPanel jpPanel;
    private javax.swing.JScrollPane jspPanelTabla;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextField jtfFecha;
    // End of variables declaration//GEN-END:variables

    //Se agrega las columnas con sus nombres correspondientes a la tabla, es depende que elija el usuario
    private void columnaSeleccion(String eleccion) {

        if (eleccion.equalsIgnoreCase("Tratamiento")) {
            modeloTabla.addColumn("ID Tratamiento");
            modeloTabla.addColumn("Nombre");
            modeloTabla.addColumn("detalle");
            modeloTabla.addColumn("duracion");
            modeloTabla.addColumn("costo");
            modeloTabla.addColumn("Masajista");
            modeloTabla.addColumn("Horario inicial");
            modeloTabla.addColumn("Horario Final");
            jtTabla.setModel(modeloTabla);
        }
        
        if (eleccion.equalsIgnoreCase("Instalacion")) {
            modeloTabla.addColumn("ID Instalacion");
            modeloTabla.addColumn("uso");
            modeloTabla.addColumn("precio x30M");
            modeloTabla.addColumn("Horario");
            jtTabla.setModel(modeloTabla);
        }
        
    }
    
    public void fechaElegida() {
        jtfFecha.setText(fecha.toString());
    }
    
    public void cargarTabla(String eleccion, int codigo) {
        
        Utilitario.limpiarTabla(modeloTabla);
        
        if (eleccion.equalsIgnoreCase("Tratamiento")) {
            
            try {
                Iterator<diaSpaTratamiento> iterar = tratamientos.ListadoTratamientosDelDia(fecha, codigo).iterator();

                Tratamiento t = tratamientos.buscarTratamiento(codigo);
                
                //Se calcula cuantos tratamientos hay disponibles en el dia, segun la duracion del mismo
                int cuantasVeces;
                if (t.getDuracion().getMinute() > 0) {
                    cuantasVeces = (int) ((finJornada.getHour() - inicioJornada.getHour()) - (t.getDuracion().getHour()+1));
                } else {
                    cuantasVeces = (int) ((finJornada.getHour() - inicioJornada.getHour()) - (t.getDuracion().getHour()));
                }
                
                
                System.out.println(cuantasVeces);
                
                horarioDisponible.add(inicioJornada);

                for (int i = 0; i < cuantasVeces; i++) {

                    horarioDisponible.add(horarioDisponible.getLast().plusHours(t.getDuracion().getHour()));

                }

                while (iterar.hasNext()) {
                    diaSpaTratamiento d = iterar.next();
                    //No disponible
                    modeloTabla.addRow(new Object[]{d.getCodTrat(), d.getNombre(), d.getDetalle(), d.getDuracion(), d.getCosto(),
                        d.getMasajista(), d.getInicio(), d.getFin()});
                }

                for (int i = 0; i < cuantasVeces; i++) {

                    diaSpaTratamiento d = new diaSpaTratamiento(codigo, t.getNombre(), t.getDetalle(), t.getDuracion(),
                            t.getCosto(), t.getMasajista().getNombreCompleto(), horarioDisponible.get(i), horarioDisponible.get(i).plusHours(t.getDuracion().getHour()));
                    modeloTabla.addRow(new Object[]{d.getCodTrat(), d.getNombre(), d.getDetalle(), d.getDuracion(), d.getCosto(),
                        d.getMasajista(), d.getInicio(), d.getFin()});

                }
            } catch (java.lang.NullPointerException er) {
                
                JOptionPane.showMessageDialog(null, "Sin tratamiento seleccionado, sal de esta ventana y selecciona uno");
                
            }
            
            
            
        }
        
        
    }


}
