
package Visual;

import Control.*;
import Entidades.*;
import java.awt.Color;
import java.awt.Point;
import java.beans.PropertyVetoException;
import java.time.DateTimeException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaSesion extends javax.swing.JInternalFrame {
    
    //Colores de la vista
    Color verdeActivo = new Color(200,242,183);
    Color rojoInactivo = new Color(245,164,164);
    
    //Estado de situación: se utilizará un estado para determinar si la vista está preparada para guardar información o para actualizar/eliminar
    boolean estadoGuardar = false;
    
    
    //Las 4 opciones de visualizacion, el array guardará el ID de cada opción (tratamiento, dia de spa, instalación y masajista)
    int[] datos = {-1,-1,-1,-1};
    MasajistasData masajistas = new MasajistasData(); //0
    TratamientosData tratamientos = new TratamientosData(); //1
    InstalacionesData instalaciones = new InstalacionesData(); //2
    DiaSPAData diasdespa  = new DiaSPAData(); //3
    

    SesionData sesion = new SesionData(); //Se utilizará para las consultas de la base de datos
    
    //Variables globales para que se sepa que está seleccionado (fecha y (tratamiento o instalacion))
    private LocalDate fechaSeleccionada = LocalDate.now();
    private String Seleccion = "Tratamiento";
    
    
    //Se crea el modelo de la tabla, y se reemplaza el valor de celda editable a falso
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    
    private DefaultTableModel modeloTablaSecundaria = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };
    
    

    public VistaSesion() {
        initComponents();
        columnaSesion();
        cargarSesion(null, -1);
        nuevaSesion(true);
        columnasTablaSecundaria();
        cargarTablaSecundaria(datos);
        bienvenida();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgDatos = new javax.swing.ButtonGroup();
        jpDatos = new javax.swing.JPanel();
        jlTitulo = new javax.swing.JLabel();
        jlIDSesion = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jlFechaHora = new javax.swing.JLabel();
        jlFechaHoraInicio = new javax.swing.JLabel();
        jlFechaHoraFin = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jtfHoraInicio = new javax.swing.JTextField();
        jtfMinutosInicio = new javax.swing.JTextField();
        jtfHoraFin = new javax.swing.JTextField();
        jtfMinutosFin = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jlDatos = new javax.swing.JLabel();
        jtfIDDatos = new javax.swing.JTextField();
        jlIDDatos = new javax.swing.JLabel();
        jlDetalle = new javax.swing.JLabel();
        jrbTratamientos = new javax.swing.JRadioButton();
        jrbInstalacion = new javax.swing.JRadioButton();
        jrbDiasDeSpa = new javax.swing.JRadioButton();
        jtfDetalles = new javax.swing.JTextField();
        jspTablaDatos = new javax.swing.JScrollPane();
        jtTablaDatos = new javax.swing.JTable();
        jlDatos1 = new javax.swing.JLabel();
        jtfEstado = new javax.swing.JTextField();
        jbSeleccionar = new javax.swing.JButton();
        jtfFechaI = new javax.swing.JTextField();
        jtfFechaF = new javax.swing.JTextField();
        jpBotones = new javax.swing.JPanel();
        jbNuevo = new javax.swing.JButton();
        jbGuardar = new javax.swing.JButton();
        jbActualizar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbAltaLogica = new javax.swing.JButton();
        jbBajaLogica = new javax.swing.JButton();
        jpTabla = new javax.swing.JPanel();
        jspTabla = new javax.swing.JScrollPane();
        jtTabla = new javax.swing.JTable();
        jlInfoSesiones = new javax.swing.JLabel();
        jlFiltro = new javax.swing.JLabel();
        jtfFiltro = new javax.swing.JTextField();
        jbSalir = new javax.swing.JButton();

        setBackground(new java.awt.Color(222, 243, 248));
        setPreferredSize(new java.awt.Dimension(700, 500));

        jpDatos.setBackground(new java.awt.Color(198, 243, 247));
        jpDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlTitulo.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Gestor de las Sesiones");

        jlIDSesion.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlIDSesion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIDSesion.setText("ID (identificador de la sesión)");

        jtfID.setEditable(false);
        jtfID.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlFechaHora.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlFechaHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaHora.setText("Fecha y hora de la sesión");

        jlFechaHoraInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlFechaHoraInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaHoraInicio.setText("inicio");

        jlFechaHoraFin.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlFechaHoraFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFechaHoraFin.setText("fin");

        jtfHoraInicio.setEditable(false);
        jtfHoraInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfHoraInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfMinutosInicio.setEditable(false);
        jtfMinutosInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfMinutosInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfHoraFin.setEditable(false);
        jtfHoraFin.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfHoraFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfMinutosFin.setEditable(false);
        jtfMinutosFin.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfMinutosFin.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlDatos.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatos.setText("Tratamientos");

        jtfIDDatos.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfIDDatos.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlIDDatos.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlIDDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlIDDatos.setText("Identificador");

        jlDetalle.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlDetalle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDetalle.setText("Detalle");

        bgDatos.add(jrbTratamientos);
        jrbTratamientos.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jrbTratamientos.setSelected(true);
        jrbTratamientos.setText("tratamientos");
        jrbTratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTratamientosActionPerformed(evt);
            }
        });

        bgDatos.add(jrbInstalacion);
        jrbInstalacion.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jrbInstalacion.setText("instalación");
        jrbInstalacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbInstalacionActionPerformed(evt);
            }
        });

        bgDatos.add(jrbDiasDeSpa);
        jrbDiasDeSpa.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jrbDiasDeSpa.setText("Dias de spa");
        jrbDiasDeSpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDiasDeSpaActionPerformed(evt);
            }
        });

        jtfDetalles.setEditable(false);
        jtfDetalles.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfDetalles.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtTablaDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtTablaDatos.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jtTablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtTablaDatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaDatosMouseClicked(evt);
            }
        });
        jspTablaDatos.setViewportView(jtTablaDatos);

        jlDatos1.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jlDatos1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDatos1.setText("Elija la opción de los datos a visualizar");

        jtfEstado.setEditable(false);
        jtfEstado.setBackground(new java.awt.Color(245, 164, 164));
        jtfEstado.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtfEstado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfEstado.setText("INACTIVO");
        jtfEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbSeleccionar.setBackground(new java.awt.Color(239, 242, 183));
        jbSeleccionar.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbSeleccionar.setText("Seleccionar");
        jbSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSeleccionarActionPerformed(evt);
            }
        });

        jtfFechaI.setEditable(false);
        jtfFechaI.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jtfFechaI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFechaIActionPerformed(evt);
            }
        });

        jtfFechaF.setEditable(false);
        jtfFechaF.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jtfFechaF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfFechaFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlFechaHora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlIDSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfID)
                    .addComponent(jSeparator1)
                    .addComponent(jlDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlIDDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                            .addComponent(jtfIDDatos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlDetalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfDetalles)))
                    .addComponent(jspTablaDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlDatos1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlFechaHoraInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addComponent(jtfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfFechaI))
                        .addGap(18, 18, 18)
                        .addComponent(jtfEstado)
                        .addGap(18, 18, 18)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlFechaHoraFin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createSequentialGroup()
                                .addComponent(jtfHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jtfFechaF, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbInstalacion)
                            .addComponent(jrbTratamientos))
                        .addGap(46, 46, 46)
                        .addComponent(jbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jrbDiasDeSpa)))
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlIDSesion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jlFechaHora)
                .addGap(18, 18, 18)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jlFechaHoraInicio)
                            .addComponent(jlFechaHoraFin))
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpDatosLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jtfFechaI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfFechaF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfHoraFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfMinutosFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jtfEstado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDatos1)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jrbTratamientos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jrbInstalacion))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jrbDiasDeSpa))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(jlDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlIDDatos)
                    .addComponent(jlDetalle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfIDDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspTablaDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jpBotones.setBackground(new java.awt.Color(198, 243, 247));
        jpBotones.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbNuevo.setBackground(new java.awt.Color(239, 242, 183));
        jbNuevo.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbGuardar.setBackground(new java.awt.Color(214, 183, 242));
        jbGuardar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jbGuardar.setText("Guardar");
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbActualizar.setBackground(new java.awt.Color(239, 183, 242));
        jbActualizar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jbActualizar.setText("Actualizar");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbEliminar.setBackground(new java.awt.Color(245, 164, 164));
        jbEliminar.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jbEliminar.setText("Eliminar");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbAltaLogica.setBackground(new java.awt.Color(200, 242, 183));
        jbAltaLogica.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jbAltaLogica.setText("Alta lógica");
        jbAltaLogica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAltaLogicaActionPerformed(evt);
            }
        });

        jbBajaLogica.setBackground(new java.awt.Color(242, 220, 183));
        jbBajaLogica.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jbBajaLogica.setText("Baja lógica");
        jbBajaLogica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBajaLogicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBotonesLayout = new javax.swing.GroupLayout(jpBotones);
        jpBotones.setLayout(jpBotonesLayout);
        jpBotonesLayout.setHorizontalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbBajaLogica)
                    .addComponent(jbAltaLogica))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAltaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBajaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpTabla.setBackground(new java.awt.Color(198, 243, 247));
        jpTabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtTabla.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtTabla.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jtTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jtTabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTablaMouseClicked(evt);
            }
        });
        jspTabla.setViewportView(jtTabla);

        jlInfoSesiones.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlInfoSesiones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlInfoSesiones.setText("información de las sesiones");

        jlFiltro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlFiltro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFiltro.setText("Filtro (ID)");
        jlFiltro.setToolTipText("");

        jtfFiltro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfFiltro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jpTablaLayout = new javax.swing.GroupLayout(jpTabla);
        jpTabla.setLayout(jpTablaLayout);
        jpTablaLayout.setHorizontalGroup(
            jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspTabla, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
                    .addComponent(jlInfoSesiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfFiltro)
                    .addComponent(jlFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpTablaLayout.setVerticalGroup(
            jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlInfoSesiones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jbSalir.setBackground(new java.awt.Color(255, 51, 0));
        jbSalir.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbSalir.setText("salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbSalir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbTratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTratamientosActionPerformed
        columnasTablaSecundaria();
        jlDatos.setText("Tratamientos");
        Seleccion = "Tratamiento";

    }//GEN-LAST:event_jrbTratamientosActionPerformed

    private void jbAltaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaLogicaActionPerformed
        int altaLogica = Integer.parseInt(jtfID.getText());
        sesion.altaSesion(altaLogica);
        cargarSesion(null, -1);
        crearSesion();
    }//GEN-LAST:event_jbAltaLogicaActionPerformed

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        //Para crear una nueva Sesion
        crearSesion();
        
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jrbInstalacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbInstalacionActionPerformed
        columnasTablaSecundaria();
        jlDatos.setText("Instalaciones");
        Seleccion = "Instalacion";    
    }//GEN-LAST:event_jrbInstalacionActionPerformed

    private void jrbDiasDeSpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDiasDeSpaActionPerformed
        columnasTablaSecundaria();
        jlDatos.setText("Dia de spa");
    }//GEN-LAST:event_jrbDiasDeSpaActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        verificacionIngreso("GUARDAR");
        cargarSesion(null, -1);
        crearSesion();
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jtTablaDatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaDatosMouseClicked
        cargarInformacionSecundaria(evt.getPoint());
    }//GEN-LAST:event_jtTablaDatosMouseClicked

    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        //Cargar los datos al clickear la tabla general
        cargarInformacion(evt.getPoint());
    }//GEN-LAST:event_jtTablaMouseClicked

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        verificacionIngreso("ACTUALIZAR");
        cargarSesion(null, -1);
        crearSesion();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int eliminar = Integer.parseInt(jtfID.getText());
        sesion.borrarSesion(eliminar);
        cargarSesion(null, -1);
        crearSesion();
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBajaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaLogicaActionPerformed
        int bajaLogica = Integer.parseInt(jtfID.getText());
        sesion.bajaSesion(bajaLogica);
        cargarSesion(null, -1);
        crearSesion();
    }//GEN-LAST:event_jbBajaLogicaActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSeleccionarActionPerformed
        
        if (datos[3] < 0) {
           JOptionPane.showMessageDialog(null, "Debes seleccionar un dia de spa y un tratamiento/instalacion antes de ingresar a esta opción");
        } else {
            if (diasdespa.cargarDiaSpa(datos[3]).isEstado()) {
                if (jrbTratamientos.isSelected()) {

                    if (datos[1] == -1) {
                        crearVentanaEmergente();

                    } else if (!tratamientos.buscarTratamiento(datos[1]).isEstado()) {
                        int respuesta = JOptionPane.showConfirmDialog(null, "Ha seleccionado un tratamiento que está inactivo, desea seguir?", "Seleccionar sesión", JOptionPane.YES_NO_OPTION);
                        if (respuesta == 0) {
                            crearVentanaEmergente();
                        }
                    } else {
                        crearVentanaEmergente();
                    }

                } else if (jrbInstalacion.isSelected()) {

                    if (datos[2] == -1) {
                        crearVentanaEmergente();

                    } else if (!instalaciones.buscarInstalacion(datos[2]).getEstado()) {
                        int respuesta = JOptionPane.showConfirmDialog(null, "Ha seleccionado una instalación que está inactivo, desea seguir?", "Seleccionar sesión", JOptionPane.YES_NO_OPTION);
                        if (respuesta == 0) {
                            crearVentanaEmergente();
                        }
                    } else {
                        crearVentanaEmergente();
                    }

                }else {
                    JOptionPane.showMessageDialog(null, "Primero elije la opción tratamieto o instalación, para ingresar al cuadro de selección");
                }
                
            } else{
                JOptionPane.showMessageDialog(null, "Elije un dia de spa que esté habilitado/activo");
            }
        }
        


        
        
    }//GEN-LAST:event_jbSeleccionarActionPerformed

    private void jtfFechaIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFechaIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFechaIActionPerformed

    private void jtfFechaFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfFechaFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfFechaFActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDatos;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAltaLogica;
    private javax.swing.JButton jbBajaLogica;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbSeleccionar;
    private javax.swing.JLabel jlDatos;
    private javax.swing.JLabel jlDatos1;
    private javax.swing.JLabel jlDetalle;
    private javax.swing.JLabel jlFechaHora;
    private javax.swing.JLabel jlFechaHoraFin;
    private javax.swing.JLabel jlFechaHoraInicio;
    private javax.swing.JLabel jlFiltro;
    private javax.swing.JLabel jlIDDatos;
    private javax.swing.JLabel jlIDSesion;
    private javax.swing.JLabel jlInfoSesiones;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpTabla;
    private javax.swing.JRadioButton jrbDiasDeSpa;
    private javax.swing.JRadioButton jrbInstalacion;
    private javax.swing.JRadioButton jrbTratamientos;
    private javax.swing.JScrollPane jspTabla;
    private javax.swing.JScrollPane jspTablaDatos;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTable jtTablaDatos;
    private javax.swing.JTextField jtfDetalles;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfFechaF;
    private javax.swing.JTextField jtfFechaI;
    private javax.swing.JTextField jtfFiltro;
    private javax.swing.JTextField jtfHoraFin;
    private javax.swing.JTextField jtfHoraInicio;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfIDDatos;
    private javax.swing.JTextField jtfMinutosFin;
    private javax.swing.JTextField jtfMinutosInicio;
    // End of variables declaration//GEN-END:variables

    //Se agrega las columnas con sus nombres correspondientes a la tabla
    private void columnaSesion() {
        modeloTabla.addColumn("ID sesion");
        modeloTabla.addColumn("Inicio");
        modeloTabla.addColumn("Fin");
        modeloTabla.addColumn("tratamiento");
        modeloTabla.addColumn("instalacion");
        modeloTabla.addColumn("dia de spa");
        modeloTabla.addColumn("estado");
        jtTabla.setModel(modeloTabla);
    }
    
    //Ordena los valores de cada una de las columnas con sus respectivos nombres
    private int[] ordenarColumnaNombre() {

        int[] columnas = new int[jtTabla.getColumnCount()]; //Se brindará la cantidad de columnas para determinar su orden

        for (int i = 0; i < jtTabla.getColumnCount(); i++) {
            if (jtTabla.getColumnName(i).equals("ID sesion")) {
                columnas[0] = i;
            }
            if (jtTabla.getColumnName(i).equals("Inicio")) {
                columnas[1] = i;
            }
            if (jtTabla.getColumnName(i).equals("Fin")) {
                columnas[2] = i;
            }
            if (jtTabla.getColumnName(i).equals("tratamiento")) {
                columnas[3] = i;
            }
            if (jtTabla.getColumnName(i).equals("instalacion")) {
                columnas[4] = i;
            }
            if (jtTabla.getColumnName(i).equals("dia de spa")) {
                columnas[5] = i;
            }
            if (jtTabla.getColumnName(i).equals("estado")) {
                columnas[6] = i;
            }
        }

        return columnas;

    }
    
    //Se agregan todos los alumnos de la base de datos, filtro es para filtrar segun lo colocado por usuario
    private void cargarSesion(String filtro, int opcion) {

        Utilitario.limpiarTabla(modeloTabla);
        int[] columna = ordenarColumnaNombre(); //Toma el orden de las columnas con sus respectivos nombres

        Iterator<Sesion> iterar = sesion.mostrarTodasSesiones().iterator();
        while (iterar.hasNext()) {
            Sesion s = iterar.next();
            if (filtro == null && opcion == -1) {
                modeloTabla.addRow(new Object[]{s.getCodSesion(), s.getFechaIn(), s.getFechaFin(),
                    s.getTratamiento(),s.getInstalacion(),s.getDiaS(), Utilitario.estadoParaTabla(s.isEstado())});
            }

            if (columna[0] == opcion && Utilitario.compararValores(Integer.parseInt(filtro), s.getCodSesion())) { //Si la columna ID Alumno es igual al filtro
                modeloTabla.addRow(new Object[]{s.getCodSesion(), s.getFechaIn(), s.getFechaFin(),
                    s.getTratamiento(),s.getInstalacion(),s.getDiaS(), Utilitario.estadoParaTabla(s.isEstado())});
            }

        }
    }
    
    //Cambia el botón a activo o inactivo
    private void estadoSesion(boolean estado) {
        
        if(estado) {
            
            jtfEstado.setText("ACTIVO");
            jtfEstado.setBackground(verdeActivo);
            
        } else {
            jtfEstado.setText("INACTIVO");
            jtfEstado.setBackground(rojoInactivo);
        }
        
    }
    
    //Se cargará las columnas de la tabla secundaria
    private void columnasTablaSecundaria() {
        
        modeloTablaSecundaria.setColumnCount(0); //Resetea las columnas a 0
        jtTablaDatos.setModel(modeloTablaSecundaria); //Limpia la tabla
        
        if(jrbTratamientos.isSelected()) {
            
            modeloTablaSecundaria.addColumn("ID");
            modeloTablaSecundaria.addColumn("nombre");
            modeloTablaSecundaria.addColumn("detalle");
            modeloTablaSecundaria.addColumn("duración");
            modeloTablaSecundaria.addColumn("costo");
            modeloTablaSecundaria.addColumn("tipo");
            modeloTablaSecundaria.addColumn("Masajista");
            modeloTablaSecundaria.addColumn("estado");
            jtTablaDatos.setModel(modeloTablaSecundaria);
            
            cargarTablaSecundaria(datos);
                
        }
        
        if (jrbInstalacion.isSelected()) {

            modeloTablaSecundaria.addColumn("ID");
            modeloTablaSecundaria.addColumn("nombre");
            modeloTablaSecundaria.addColumn("detalle");
            modeloTablaSecundaria.addColumn("usos");
            modeloTablaSecundaria.addColumn("apto");
            modeloTablaSecundaria.addColumn("precio por 30m");
            modeloTablaSecundaria.addColumn("estado");
            jtTablaDatos.setModel(modeloTablaSecundaria);
            
            cargarTablaSecundaria(datos);

        }
        
        if (jrbDiasDeSpa.isSelected()) {

            modeloTablaSecundaria.addColumn("ID");
            modeloTablaSecundaria.addColumn("fecha y hora");
            modeloTablaSecundaria.addColumn("preferencias");
            modeloTablaSecundaria.addColumn("cliente");
            modeloTablaSecundaria.addColumn("monto");
            modeloTablaSecundaria.addColumn("estado");
            jtTablaDatos.setModel(modeloTablaSecundaria);
            
            cargarTablaSecundaria(datos);

        }
     
    }
    
    //Se cargará la información de la tabla secundaria
    private void cargarTablaSecundaria(int[] opcion) {
        
        Utilitario.limpiarTabla(modeloTablaSecundaria);
        
        if (jrbTratamientos.isSelected())
        {
           
            int columnaID = 0;
            
            for (int i = 0; i < jtTablaDatos.getColumnCount(); i++) {
                
                if (jtTablaDatos.getColumnName(i).equalsIgnoreCase("ID")) {
                    
                    columnaID = i;
                    
                }
                
            }
            
            Iterator<Tratamiento> iterar = tratamientos.mostrarTratamientos().iterator();
            while (iterar.hasNext()) {
                Tratamiento t = iterar.next();
                modeloTablaSecundaria.addRow(new Object[]{t.getCodTrat(), t.getNombre(), t.getDetalle(),
                t.getDuracion(),t.getCosto(),t.getTipo(), t.getMasajista().getNombreCompleto(), Utilitario.estadoParaTabla(t.isEstado())});                
            }
 
            if (datos[1] == -1) {
                jtfIDDatos.setText("");
            }else {
                jtfIDDatos.setText("" + datos[1]);
            }
   
        }
            
        if (jrbInstalacion.isSelected())
        {
            int columnaID = 0;
            
            for (int i = 0; i < jtTablaDatos.getColumnCount(); i++) {
                
                if (jtTablaDatos.getColumnName(i).equalsIgnoreCase("ID")) {
                    
                    columnaID = i;
                    
                }
                
            }
            
            Iterator<Instalacion> iterar = instalaciones.mostrarInstalaciones().iterator();
            while (iterar.hasNext()) {
                Instalacion i = iterar.next();
                modeloTablaSecundaria.addRow(new Object[]{i.getCodIns(), i.getNombre(), i.getDetallesUso(),
                i.getUsos(),i.getApto(),i.getPrecio30M(), Utilitario.estadoParaTabla(i.getEstado())});                
            }

            if (datos[2] == -1) {
                jtfIDDatos.setText("");
            }else {
                jtfIDDatos.setText("" + datos[2]);
            }

        }
                        
        if (jrbDiasDeSpa.isSelected())
        {
            int columnaID = 0;
            
            for (int i = 0; i < jtTablaDatos.getColumnCount(); i++) {
                
                if (jtTablaDatos.getColumnName(i).equalsIgnoreCase("ID")) {
                    
                    columnaID = i;
                    
                }
                
            }
            
            Iterator<DiaSpa> iterar = diasdespa.cargarDiasSpaActivos().iterator();
            while (iterar.hasNext()) {
                DiaSpa d = iterar.next();
                modeloTablaSecundaria.addRow(new Object[]{d.getCodPack(), d.getFecha(), d.getPrefencias(),
                d.getCliente().getNombreC(),d.getMonto(), Utilitario.estadoParaTabla(d.isEstado())});
            }
            
            if (datos[3] == -1) {
                jtfIDDatos.setText("");
            } else {
                jtfIDDatos.setText("" + datos[3]);
            }

        }
        
        
    }
    
    //Deshabilita los botones que no conciernen en cada sit (crear Sesion, actualizar/eliminar sesion)
    private void nuevaSesion(boolean crear) {
        
        if(crear) {
            jbActualizar.setEnabled(false);
            jbEliminar.setEnabled(false);
            jbAltaLogica.setEnabled(false);
            jbBajaLogica.setEnabled(false);
            jbGuardar.setEnabled(true);
            estadoGuardar = true;
        } else
        {
            jbActualizar.setEnabled(true);
            jbEliminar.setEnabled(true);
            jbGuardar.setEnabled(false);
            estadoGuardar = false;
            if(jtfEstado.getText().equalsIgnoreCase("ACTIVO")) {
                jbAltaLogica.setEnabled(false);
                jbBajaLogica.setEnabled(true); 
            } else 
            {
                jbBajaLogica.setEnabled(false); 
                jbAltaLogica.setEnabled(true);
            }
                    
        }
        

        
    }
    
    private void verificacionIngreso(String boton) {
        
        int errores = 0;
        
        try {
            
            int HoraInicio = Integer.parseInt(jtfHoraInicio.getText());
            int MinutosInicio = Integer.parseInt(jtfMinutosInicio.getText());
            
            if (String.valueOf(HoraInicio).length() > 2) {
                JOptionPane.showMessageDialog(null, "Las horas debe tener como máximo 2 digitos, por favor, corrijalo");
                errores++;
            } else if (HoraInicio < 0) {
                JOptionPane.showMessageDialog(null, "Las horas no pueden ser negativas, por favor, corrijalo");
                errores++;
            } else if (HoraInicio > 23) {
                JOptionPane.showMessageDialog(null, "Las horas no pueden mayores a las 23 horas, por favor, corrijalo");
                errores++;
            }
            
            if (String.valueOf(MinutosInicio).length() > 2) {
                JOptionPane.showMessageDialog(null, "Los minutos debe tener como máximo 2 digitos, por favor, corrijalo");
                errores++;
            } else if (MinutosInicio < 0) {
                JOptionPane.showMessageDialog(null, "Los minutos no pueden ser negativas, por favor, corrijalo");
                errores++;
            } else if (MinutosInicio > 59) {
                JOptionPane.showMessageDialog(null, "Los minutos no pueden ser más de 59 minutos, por favor, corrijalo");
                errores++;
            }
            
            Date fechaInicioDate = Utilitario.deLDaD(diasdespa.cargarDiaSpa(datos[3]).getFecha());
            
            LocalDateTime fechaInicio = null;
            
            if (fechaInicioDate == null) {
                JOptionPane.showMessageDialog(null, "Debe colocar una fecha de inicio de la sesión");
                errores++;
            } else {
                               
                //Se pasa de Date a LocalDateTime para tratarlo en nuestro sistema
                LocalDate fechaInicioLocalDate = fechaInicioDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                
                LocalTime horarioInicio = LocalTime.of(HoraInicio, MinutosInicio);
                
                fechaInicio = LocalDateTime.of(fechaInicioLocalDate, horarioInicio);

                //Se crea un formato similar a la base de datos año-mes-dia
                DateTimeFormatter formatoLocalDateTime = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");

                //Se coloca el formato en el LocalDate que será cargado a la fecha de nacimiento del Alumno
                fechaInicio.format(formatoLocalDateTime);
            }
            
            
            if (datos[0] == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un masajista de la lista");
                errores++;
            }
            if (datos[1] == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tratamiento de la lista");
                errores++;
            }
            if (datos[2] == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una instalación de la lista");
                errores++;
            }
            if (datos[3] == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar un dia de spa de la lista");
                errores++;
            }
            
            int codMasajista = datos[0];
            int codTratamientos = datos[1];
            int codInstalaciones = datos[2];
            int codDiaSpa = datos[3];
            
            

            LocalDateTime fechaFinal = null;
            
            //la fecha y hora final se calcula en base a la duración y la misma fecha del tratamiento anteriormente seleccionada
            if (datos[1] == -1) {
                JOptionPane.showMessageDialog(null, "Se necesita saber cuál es el tratamiento para brindar la fecha y hora final, por favor elige");
                errores++;
            } else if(fechaInicio == null) {
                
                JOptionPane.showMessageDialog(null, "Se necesita calcular con la fecha inicial, por favor, completalo");
                errores++;
            } else {
                Tratamiento t = tratamientos.buscarTratamiento(datos[1]);
                LocalDate fechaFinalDate = fechaInicio.toLocalDate();
                LocalTime HoraFinalDate = t.getDuracion();
                
                HoraFinalDate = HoraFinalDate.plusHours(fechaInicio.toLocalTime().getHour());
                HoraFinalDate = HoraFinalDate.plusMinutes(fechaInicio.toLocalTime().getMinute());

                fechaFinal = LocalDateTime.of(fechaFinalDate, HoraFinalDate);
                
                if (fechaInicio.getHour() > HoraFinalDate.getHour()) { 
                    //Esto quiere decir que si se ha pasado de las 23:59 horas ya se debe pasar al siguiente día
                    
                    fechaFinal = fechaFinal.plusDays(1);
                    
                }
                
                
                
            }
            
            if(errores > 0) {
                if (boton.equalsIgnoreCase("GUARDAR")) {
                    JOptionPane.showMessageDialog(null, "Debe atender a los errores anteriormente mencionados, no se pudo guardar la sesión");
                }
                if (boton.equalsIgnoreCase("ACTUALIZAR")) {
                    JOptionPane.showMessageDialog(null, "Debe atender a los errores anteriormente mencionados, no se pudo actualizar la sesión");
                }
                
            } else {
                
                if (boton.equalsIgnoreCase("GUARDAR")) {
                    Sesion s = new Sesion(fechaInicio, fechaFinal, codTratamientos, codInstalaciones, codDiaSpa, true);
                    sesion.crearSesion(s);
                    
                    //metodo que carga el monto segun la instalacion y el tratamiento
                    //sesion.cargarPrecioTotal(s);
                }
                
                if (boton.equalsIgnoreCase("ACTUALIZAR")) {
                    boolean estado = sesion.mostrarSesion(Integer.parseInt(jtfID.getText())).isEstado();
                    Sesion s = new Sesion(fechaInicio, fechaFinal, codTratamientos, codInstalaciones, codDiaSpa, estado);
                    s.setCodSesion(Integer.parseInt(jtfID.getText()));
                    sesion.actualizarSesion(s);
                    //sesion.cargarPrecioTotal(s);  
                    
                }
                
            }
                
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un formato válido, númerico");
            System.out.println(e.getMessage() + e.getStackTrace());
            
        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un formato válido, (entre 0 a 23)");
            System.out.println(e.getMessage() + e.getStackTrace());
        }
        
        
    }
    
    //Carga la información en la tabla secundaria (izquierda) según la opción elegida
    private void cargarInformacionSecundaria(Point evento) {
        
        int seleccionFila = jtTablaDatos.rowAtPoint(evento); 
        
        int columnaID = 0;
              
        if (jrbTratamientos.isSelected()) {

                
            for (int i = 0; i < jtTablaDatos.getColumnCount(); i++) {
                if (jtTablaDatos.getColumnName(i).equals("ID")) {
                    columnaID = i;
                }
            }
            
            int ID_Tratamiento = (int)(jtTablaDatos.getValueAt(seleccionFila, columnaID));
            
            datos[1] = ID_Tratamiento;
            
            jtfIDDatos.setText(""+datos[1]);
            
        //metodo para cargar los JtextField    
            
           Tratamiento t = tratamientos.buscarTratamiento(datos[1]);
           String min = String.valueOf(t.getDuracion().getMinute());
           String hora= String.valueOf(t.getDuracion().getHour());
           jtfDetalles.setText(t.getDetalle());
           jtfHoraFin.setText(hora);
           jtfMinutosFin.setText(min);
        
        }
        
        if (jrbInstalacion.isSelected()) {

            for (int i = 0; i < jtTablaDatos.getColumnCount(); i++) {
                if (jtTabla.getColumnName(i).equals("ID")) {
                    columnaID = i;
                }
            }
            
            int ID_Instalacion = (int)(jtTablaDatos.getValueAt(seleccionFila, columnaID));
            
            datos[2] = ID_Instalacion;
            
            jtfIDDatos.setText(""+datos[2]);
            
        //metodo para cargar los JtextField  
            Instalacion i = instalaciones.buscarInstalacion(datos[2]);
            jtfDetalles.setText(i.getDetallesUso());
            
        }
        
        if (jrbDiasDeSpa.isSelected()) {

            for (int i = 0; i < jtTablaDatos.getColumnCount(); i++) {
                if (jtTabla.getColumnName(i).equals("ID")) {
                    columnaID = i;
                }
            }
            
            int ID_DiaSpa = (int)(jtTablaDatos.getValueAt(seleccionFila, columnaID));
            
            datos[3] = ID_DiaSpa;
            
            jtfIDDatos.setText(""+datos[3]);
            
            DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MMM-yyyy");

            DiaSpa d = diasdespa.cargarDiaSpa(datos[3]);
            //Date fecha = Date.from(d.getFecha().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());

            jtfFechaI.setText(d.getFecha().format(formatoFecha));
            jtfFechaF.setText(d.getFecha().format(formatoFecha));

        }
 
        
    }
    
    //carga la información en la tabla principal sobre las sesiones cargadas
    private void cargarInformacion(Point evento) {
        
        int seleccionFila = jtTabla.rowAtPoint(evento);
        
        int columnaID = 0;
        
        for (int i = 0; i < jtTabla.getColumnCount(); i++) {
            if (jtTabla.getColumnName(i).equals("ID sesion")) {
                columnaID = i;
            }
        }
        
        int ID_Sesion = (int)(jtTabla.getValueAt(seleccionFila, columnaID));
        
        Sesion s = sesion.mostrarSesion(ID_Sesion);
        
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        
        jtfID.setText(""+s.getCodSesion());
   
        Date fechaInicio = Date.from(s.getFechaIn().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        jtfFechaI.setText(s.getFechaIn().format(formatoFecha));
        
        Date fechaFin = Date.from(s.getFechaFin().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        jtfFechaF.setText(s.getFechaFin().format(formatoFecha));
        
        LocalDateTime fechaHoraInicio = s.getFechaIn();
        
        jtfHoraInicio.setText(""+fechaHoraInicio.getHour());
        jtfMinutosInicio.setText(""+fechaHoraInicio.getMinute());
        
        LocalDateTime fechaHoraFin = s.getFechaFin();

        jtfHoraFin.setText("" + fechaHoraFin.getHour());
        jtfMinutosFin.setText("" + fechaHoraFin.getMinute());
        
        datos[1] = s.getTratamiento();
        datos[2] = s.getInstalacion();
        datos[3] = s.getDiaS();
        
        estadoSesion(s.isEstado());
        
        cargarTablaSecundaria(datos);
        
        nuevaSesion(false);
        
        
    }
    
    //Cuando se clickee en el botón Nuevo
    private void crearSesion() {
        
        jtfID.setText("");
        jtfFechaI.setText("");
        jtfFechaF.setText("");
        jtfHoraInicio.setText("");
        jtfHoraFin.setText("");
        jtfMinutosInicio.setText("");
        jtfMinutosFin.setText("");
        estadoSesion(true);
        nuevaSesion(true);
        datos[0] = -1;
        datos[1] = -1;
        datos[2] = -1;
        datos[3] = -1; //Es para mostrar todos los elementos de la tabla secundaria
        jtfIDDatos.setText("");
        jtfDetalles.setText("");
        cargarTablaSecundaria(datos);
        
    }
    
    private void crearVentanaEmergente() {
        
        if (jrbTratamientos.isSelected()) {
            jdSeleccionar ventanaSeleccionar = new jdSeleccionar(null, true);
            ventanaSeleccionar.setEnvio(new enviarSeleccion() {
                @Override
                public void devolverHorario(LocalTime horario) {
                    recibirHora(horario);
                }

            });
            ventanaSeleccionar.setJlPresentacion("Seleccione el tratamiento que desea realizar en la fecha:");
            ventanaSeleccionar.setEleccion(Seleccion);
            ventanaSeleccionar.setFecha(fechaSeleccionada);
            ventanaSeleccionar.setCodigo(datos[1]);
            ventanaSeleccionar.ModificacionDatos();
            ventanaSeleccionar.setLocationRelativeTo(this);
            ventanaSeleccionar.setVisible(true);
        }
        
        if (jrbInstalacion.isSelected()) {
            jdSeleccionar ventanaSeleccionar = new jdSeleccionar(null, true);
            ventanaSeleccionar.setEnvio(new enviarSeleccion() {
                @Override
                public void devolverHorario(LocalTime horario) {
                    recibirHora(horario);
                }

            });
            ventanaSeleccionar.setJlPresentacion("Seleccione la instalación que desea utilizar en la fecha:");
            ventanaSeleccionar.setEleccion(Seleccion);
            ventanaSeleccionar.setFecha(fechaSeleccionada);
            ventanaSeleccionar.setCodigo(datos[1]);
            ventanaSeleccionar.ModificacionDatos();
            ventanaSeleccionar.setLocationRelativeTo(this);
            ventanaSeleccionar.setVisible(true);
        }
        
    }
    
    //Recibe la hora del tratamiento en el cuadro de selección
    public void recibirHora(LocalTime hora) {
        jtfHoraInicio.setText(""+hora.getHour());
        jtfMinutosInicio.setText(""+hora.getMinute());
        System.out.println(tratamientos.buscarTratamiento(datos[1]).getDuracion().getHour());
        jtfHoraFin.setText(""+(hora.getHour()+tratamientos.buscarTratamiento(datos[1]).getDuracion().getHour()));
        jtfMinutosFin.setText(""+(hora.getMinute()+tratamientos.buscarTratamiento(datos[1]).getDuracion().getMinute()));
    }
    
    
    public void bienvenida() {
        
        JOptionPane.showMessageDialog(null, "BIENVENIDO AL SISTEMA DE SESIONES,"
                + " ELIGE UN DIA DE SPA, Y LUEGO EL TRATAMIENTO O INSTALACIÓN DESEADA");
        
    }
    
    
    
}
