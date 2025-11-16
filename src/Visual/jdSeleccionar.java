
package Visual;

import Control.*;
import Entidades.*;
import java.awt.Point;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class jdSeleccionar extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(jdSeleccionar.class.getName());

    private TratamientosData tratamientos = new TratamientosData();
    private MasajistasData masajistas = new MasajistasData();
    
    //Variable global para elegir el horario en sesión
    private LocalTime horaElegida = LocalTime.now();
    private boolean seSelecciono = false;


    private enviarSeleccion envio;

    public void setEnvio(enviarSeleccion envio) {
        this.envio = envio;
    }
    
    
    
    
    //Indice global de diaSpaTratamiento
    private int indiceTratamiento = 0;
    
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
        jbSeleccionar = new javax.swing.JButton();

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
        jtTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaMouseClicked(evt);
            }
        });
        jspPanelTabla.setViewportView(jtTabla);

        jlPresentacion2.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlPresentacion2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPresentacion2.setText("Se muestra disponibilidad según horario");

        jtfFecha.setEditable(false);
        jtfFecha.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfFecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jbSeleccionar.setBackground(new java.awt.Color(239, 242, 183));
        jbSeleccionar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbSeleccionar.setText("Seleccionar");
        jbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpPanelLayout = new javax.swing.GroupLayout(jpPanel);
        jpPanel.setLayout(jpPanelLayout);
        jpPanelLayout.setHorizontalGroup(
            jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlPresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                    .addComponent(jlPresentacion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jspPanelTabla)
                    .addComponent(jtfFecha))
                .addContainerGap())
            .addGroup(jpPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(jbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarActionPerformed

        if (envio != null) {
            
            envio.devolverHorario(horaElegida);
            
        }
        dispose();

    }//GEN-LAST:event_jbSeleccionarActionPerformed

    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        seleccion(evt.getPoint());
    }//GEN-LAST:event_jtTablaMouseClicked

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
    private javax.swing.JButton jbSeleccionar;
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
            modeloTabla.addColumn("duracion");
            modeloTabla.addColumn("Masajista");
            modeloTabla.addColumn("Horario inicial");
            modeloTabla.addColumn("Horario Final");
            modeloTabla.addColumn("Disponibilidad");
            jtTabla.setModel(modeloTabla);
        }
        
        if (eleccion.equalsIgnoreCase("Instalacion")) {
            modeloTabla.addColumn("ID Instalacion");
            modeloTabla.addColumn("uso");
            modeloTabla.addColumn("precio x30M");
            modeloTabla.addColumn("Horario");
            modeloTabla.addColumn("Disponibilidad");
            jtTabla.setModel(modeloTabla);
        }
        
    }
    
    public void fechaElegida() {
        jtfFecha.setText(fecha.toString());
    }
    
    public diaSpaTratamiento corroborarTratamiento(int codigo) {
        
        ArrayList<diaSpaTratamiento> tratamientosDiaSpa = (ArrayList) tratamientos.ListadoTratamientosDelDia(fecha, codigo);
        diaSpaTratamiento d = new diaSpaTratamiento();
        
        try {
            d = tratamientosDiaSpa.get(indiceTratamiento);
        }catch(java.lang.IndexOutOfBoundsException er) {
            return d;
        }
        
        

        return d;
        
    }
    
    //Determina si en un momento dado el masajista está disponible o no
    public boolean masajistaDisponible(LocalTime horaI,int codigo, int codMasajista) {
        
        LocalDateTime fechaHoraI = LocalDateTime.of(fecha, horaI);
        
        return tratamientos.masajistaDisponible(fechaHoraI, codigo, codMasajista);
    
    }
    
    public String noDisponible(boolean dispo) {
        
        if (dispo) {
            return "disponible";
        } else {
            return "no disponible";
        }
        
    }
    
    public void cargarTabla(String eleccion, int codigo) {
        
        Utilitario.limpiarTabla(modeloTabla);
        
        if (eleccion.equalsIgnoreCase("Tratamiento")) {
            
            try {
                //Iterator<diaSpaTratamiento> iterar = tratamientos.ListadoTratamientosDelDia(fecha, codigo).iterator();
                Tratamiento t = tratamientos.buscarTratamiento(codigo);
                
                //Se calcula cuantos tratamientos hay disponibles en el dia, segun la duracion del mismo
                int cuantasVeces;
                if (t.getDuracion().getMinute() > 0) {
                    cuantasVeces = (int) ((finJornada.getHour() - inicioJornada.getHour()) / (t.getDuracion().getHour()+1));
                } else {
                    cuantasVeces = (int) ((finJornada.getHour() - inicioJornada.getHour()) / (t.getDuracion().getHour()));
                }

                horarioDisponible.add(inicioJornada);
                
                for (int i = 0; i < cuantasVeces; i++) {
                    
                    LocalTime horarioSiguiente = horarioDisponible.getLast().plusHours(t.getDuracion().getHour());
                    
                    
                    if (t.getDuracion().getMinute() > 0) {
                        
                        horarioSiguiente = horarioSiguiente.plusHours(1);
                        System.out.println("hora agregada");
                        
                    }
                    
                    horarioDisponible.add(horarioSiguiente);
                    

                }
                

                for (int i = 0; i < cuantasVeces; i++) {
                    
                    diaSpaTratamiento d = new diaSpaTratamiento(codigo, t.getNombre(), t.getDetalle(), t.getDuracion(),
                        t.getCosto(), t.getMasajista(), horarioDisponible.get(i), horarioDisponible.get(i).plusHours(t.getDuracion().getHour()));;
                    
                    //En caso de que sea un minuto entre 1 a 59, se redondea para arriba el turno, para que no haya entrecruzamiento
                    if (t.getDuracion().getMinute() > 0) {
                        
                        d.setFin(d.getFin().plusHours(1));
                        
                    } 
                    
                    rellenarTablaTratamiento(d);

                    

                }
                
                
            } catch (java.lang.NullPointerException er) {
                
                JOptionPane.showMessageDialog(null, "Sin tratamiento seleccionado, sal de esta ventana y selecciona uno");
                System.out.println(er.getMessage());
                
            }
            
            
            
        }
        
        
    }
    
    public void rellenarTablaTratamiento(diaSpaTratamiento d) {
        
        try {

            boolean noDispo;
            /*if ((d.getInicio().isBefore(dOcupado.getInicio()) || d.getInicio().equals(dOcupado.getInicio()))
                    && (d.getFin().isAfter(dOcupado.getFin()) || d.getFin().equals(dOcupado.getFin()))) {

                noDispo = false;
                modeloTabla.addRow(new Object[]{dOcupado.getCodTrat(), dOcupado.getNombre(), dOcupado.getDuracion(),
                    dOcupado.getMasajista(), dOcupado.getInicio(), dOcupado.getFin(), noDisponible(noDispo)});
                indiceTratamiento++;

            } else */
            if (!masajistaDisponible(d.getInicio(), codigo, d.getMasajista().getMatricula())) {

                noDispo = false;
                modeloTabla.addRow(new Object[]{d.getCodTrat(), d.getNombre(), d.getDuracion(),
                    d.getMasajista().getNombreCompleto(), d.getInicio(), d.getFin(), noDisponible(noDispo)});

            } else {

                noDispo = true;
                modeloTabla.addRow(new Object[]{d.getCodTrat(), d.getNombre(), d.getDuracion(),
                    d.getMasajista().getNombreCompleto(), d.getInicio(), d.getFin(), noDisponible(noDispo)});

            }
            
        } catch(java.lang.NullPointerException er) {
            
            System.out.println(er.getMessage());
            
        }
   
    }
    
    public void seleccion(Point seleccionado) {
        
        int seleccionFila = jtTabla.rowAtPoint(seleccionado);

        int columnaHorario = 0;
        
        for (int i = 0; i < jtTabla.getColumnCount(); i++) {
            if (jtTabla.getColumnName(i).equals("Horario inicial")) {
                columnaHorario = i;
            }
        }
        
        horaElegida = (LocalTime)(jtTabla.getValueAt(seleccionFila, columnaHorario));
        System.out.println(horaElegida);
        seSelecciono = true;
        
        
    }
    



}
