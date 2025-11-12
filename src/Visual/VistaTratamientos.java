
package Visual;

import Control.TratamientosData;
import Control.Utilitario;
import Entidades.Sesion;
import Entidades.Tratamiento;
import java.awt.Color;
import java.awt.Point;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.sql.Time;
import java.util.Iterator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaTratamientos extends javax.swing.JInternalFrame {

    //Colores de la vista
    Color verdeActivo = new Color(200,242,183);
    Color rojoInactivo = new Color(245,164,164);
    
    TratamientosData tratamientos = new TratamientosData();
    
    //Se crea constante global para filtrar el tipo de tratamiento
    String[] opcion = {"facial", "corporal", "relajacion", "estetico"};
    byte punteroOpcion = -1;
    
    
    //Se crea el modelo de la tabla, y se reemplaza el valor de celda editable a falso
    private DefaultTableModel modeloTabla = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int fila, int columna) {
            return false;
        }
    };

    public VistaTratamientos() {
        initComponents();
        columnaTratamientos();
        cargarTabla(-1);
        crearTratamiento();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgBotonesTratamiento = new javax.swing.ButtonGroup();
        jpFondo = new javax.swing.JPanel();
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
        jrbFacial = new javax.swing.JRadioButton();
        jrbCorporal = new javax.swing.JRadioButton();
        jrbRelajacion = new javax.swing.JRadioButton();
        jrbEstetico = new javax.swing.JRadioButton();
        jrbTodos = new javax.swing.JRadioButton();
        jlFiltroPorTipo = new javax.swing.JLabel();
        jlTitulo = new javax.swing.JLabel();
        jpDatos = new javax.swing.JPanel();
        jlID = new javax.swing.JLabel();
        jtfID = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jlPrecio = new javax.swing.JLabel();
        jtfPrecio = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jlDuracion = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jlTipo = new javax.swing.JLabel();
        jtfTipo = new javax.swing.JTextField();
        jtfEstado = new javax.swing.JTextField();
        jtfHoraInicio = new javax.swing.JTextField();
        jtfMinutosInicio = new javax.swing.JTextField();
        jlDetalle = new javax.swing.JLabel();
        scpDetalle = new javax.swing.JScrollPane();
        jtaDetalle = new javax.swing.JTextArea();
        jbEliminar1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(201, 233, 240));

        jpFondo.setBackground(new java.awt.Color(208, 244, 247));

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
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbAltaLogica)
                    .addComponent(jbBajaLogica)))
        );
        jpBotonesLayout.setVerticalGroup(
            jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBotonesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAltaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBajaLogica, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
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
        jlInfoSesiones.setText("información de las tratamientos");

        jlFiltro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlFiltro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFiltro.setText("Filtro (ID)");
        jlFiltro.setToolTipText("");

        jtfFiltro.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfFiltro.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        bgBotonesTratamiento.add(jrbFacial);
        jrbFacial.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jrbFacial.setText("Facial");
        jrbFacial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFacialActionPerformed(evt);
            }
        });

        bgBotonesTratamiento.add(jrbCorporal);
        jrbCorporal.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jrbCorporal.setText("Corporal");
        jrbCorporal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCorporalActionPerformed(evt);
            }
        });

        bgBotonesTratamiento.add(jrbRelajacion);
        jrbRelajacion.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jrbRelajacion.setText("Relajación");
        jrbRelajacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbRelajacionActionPerformed(evt);
            }
        });

        bgBotonesTratamiento.add(jrbEstetico);
        jrbEstetico.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jrbEstetico.setText("Estético");
        jrbEstetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbEsteticoActionPerformed(evt);
            }
        });

        bgBotonesTratamiento.add(jrbTodos);
        jrbTodos.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jrbTodos.setText("Todos");
        jrbTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodosActionPerformed(evt);
            }
        });

        jlFiltroPorTipo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jlFiltroPorTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlFiltroPorTipo.setText("Elija según tipo");
        jlFiltroPorTipo.setToolTipText("");

        javax.swing.GroupLayout jpTablaLayout = new javax.swing.GroupLayout(jpTabla);
        jpTabla.setLayout(jpTablaLayout);
        jpTablaLayout.setHorizontalGroup(
            jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jspTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jlInfoSesiones, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                    .addComponent(jtfFiltro)
                    .addComponent(jlFiltro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpTablaLayout.createSequentialGroup()
                        .addGroup(jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpTablaLayout.createSequentialGroup()
                                .addComponent(jrbFacial, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbCorporal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jrbRelajacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jlFiltroPorTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jrbEstetico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jrbTodos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbTodos)
                    .addComponent(jlFiltroPorTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbFacial)
                    .addComponent(jrbCorporal)
                    .addComponent(jrbRelajacion)
                    .addComponent(jrbEstetico))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jspTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jlTitulo.setFont(new java.awt.Font("Consolas", 1, 36)); // NOI18N
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Gestor de los tratamientos");

        jpDatos.setBackground(new java.awt.Color(198, 243, 247));
        jpDatos.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jlID.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlID.setText("ID (identificador)");

        jtfID.setEditable(false);
        jtfID.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfID.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlNombre.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlNombre.setText("nombre");

        jtfNombre.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlPrecio.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlPrecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlPrecio.setText("precio ($)");

        jtfPrecio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfPrecio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlDuracion.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlDuracion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDuracion.setText("duracion (hh:mm)");

        jlTipo.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlTipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTipo.setText("Tipo");

        jtfTipo.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfTipo.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfEstado.setEditable(false);
        jtfEstado.setBackground(new java.awt.Color(245, 164, 164));
        jtfEstado.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jtfEstado.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtfEstado.setText("INACTIVO");
        jtfEstado.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtfHoraInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfHoraInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jtfMinutosInicio.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtfMinutosInicio.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jlDetalle.setFont(new java.awt.Font("Consolas", 1, 18)); // NOI18N
        jlDetalle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlDetalle.setText("Detalle");

        jtaDetalle.setColumns(20);
        jtaDetalle.setFont(new java.awt.Font("Consolas", 1, 14)); // NOI18N
        jtaDetalle.setRows(5);
        scpDetalle.setViewportView(jtaDetalle);

        javax.swing.GroupLayout jpDatosLayout = new javax.swing.GroupLayout(jpDatos);
        jpDatos.setLayout(jpDatosLayout);
        jpDatosLayout.setHorizontalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jlID, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfID)
                    .addComponent(jSeparator4)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jlNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfTipo, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)))
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jtfPrecio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPrecio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfEstado))
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator2)
                    .addComponent(jlDetalle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addComponent(jlDuracion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scpDetalle))
                .addContainerGap())
        );
        jpDatosLayout.setVerticalGroup(
            jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlID)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jlTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpDatosLayout.createSequentialGroup()
                        .addComponent(jlPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jtfEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlDuracion)
                    .addComponent(jtfHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlDetalle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scpDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jbEliminar1.setBackground(new java.awt.Color(255, 51, 0));
        jbEliminar1.setFont(new java.awt.Font("Consolas", 1, 12)); // NOI18N
        jbEliminar1.setText("salir");
        jbEliminar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpFondoLayout = new javax.swing.GroupLayout(jpFondo);
        jpFondo.setLayout(jpFondoLayout);
        jpFondoLayout.setHorizontalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpFondoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpFondoLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(jlTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
        jpFondoLayout.setVerticalGroup(
            jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFondoLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jbEliminar1)
                .addGap(18, 18, 18)
                .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpFondoLayout.createSequentialGroup()
                        .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jpFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jpFondoLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jlTitulo)
                    .addContainerGap(488, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtTablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTablaMouseClicked
        elegirTratamiento(evt.getPoint());
    }//GEN-LAST:event_jtTablaMouseClicked

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        crearTratamiento();
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
        verificarInformacion("GUARDAR");   
    }//GEN-LAST:event_jbGuardarActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed
        verificarInformacion("ACTUALIZAR");
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        tratamientos.borrarTratamiento(Integer.parseInt(jtfID.getText()));
        cargarTabla(-1);
        crearTratamiento();     
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbAltaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAltaLogicaActionPerformed
        tratamientos.darDeAlta(Integer.parseInt(jtfID.getText()));
        cargarTabla(-1);
        crearTratamiento();
    }//GEN-LAST:event_jbAltaLogicaActionPerformed

    private void jbBajaLogicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBajaLogicaActionPerformed
        tratamientos.darDeBaja(Integer.parseInt(jtfID.getText()));
        cargarTabla(-1);
        crearTratamiento();
    }//GEN-LAST:event_jbBajaLogicaActionPerformed

    private void jrbFacialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFacialActionPerformed
        punteroOpcion = 0;
        cargarTabla(-1);
    }//GEN-LAST:event_jrbFacialActionPerformed

    private void jrbCorporalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCorporalActionPerformed
        punteroOpcion = 1;
        cargarTabla(-1);
    }//GEN-LAST:event_jrbCorporalActionPerformed

    private void jrbRelajacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbRelajacionActionPerformed
        punteroOpcion = 2;
        cargarTabla(-1);
    }//GEN-LAST:event_jrbRelajacionActionPerformed

    private void jrbEsteticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbEsteticoActionPerformed
        punteroOpcion = 3;
        cargarTabla(-1);
    }//GEN-LAST:event_jrbEsteticoActionPerformed

    private void jrbTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodosActionPerformed
        punteroOpcion = -1;
        cargarTabla(-1);
    }//GEN-LAST:event_jrbTodosActionPerformed

    private void jbEliminar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminar1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jbEliminar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgBotonesTratamiento;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbAltaLogica;
    private javax.swing.JButton jbBajaLogica;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbEliminar1;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JLabel jlDetalle;
    private javax.swing.JLabel jlDuracion;
    private javax.swing.JLabel jlFiltro;
    private javax.swing.JLabel jlFiltroPorTipo;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlInfoSesiones;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JLabel jlTipo;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpFondo;
    private javax.swing.JPanel jpTabla;
    private javax.swing.JRadioButton jrbCorporal;
    private javax.swing.JRadioButton jrbEstetico;
    private javax.swing.JRadioButton jrbFacial;
    private javax.swing.JRadioButton jrbRelajacion;
    private javax.swing.JRadioButton jrbTodos;
    private javax.swing.JScrollPane jspTabla;
    private javax.swing.JTable jtTabla;
    private javax.swing.JTextArea jtaDetalle;
    private javax.swing.JTextField jtfEstado;
    private javax.swing.JTextField jtfFiltro;
    private javax.swing.JTextField jtfHoraInicio;
    private javax.swing.JTextField jtfID;
    private javax.swing.JTextField jtfMinutosInicio;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfTipo;
    private javax.swing.JScrollPane scpDetalle;
    // End of variables declaration//GEN-END:variables
    
    //Completar las columnas de la tabla
    private void columnaTratamientos() {
    
            modeloTabla.addColumn("ID");
            modeloTabla.addColumn("nombre");
            modeloTabla.addColumn("detalle");
            modeloTabla.addColumn("duración");
            modeloTabla.addColumn("costo");
            modeloTabla.addColumn("tipo");
            modeloTabla.addColumn("estado");
            jtTabla.setModel(modeloTabla);
                
    }
    
    //Carga la información de la base de datos a la tabla
    private void cargarTabla(int filtro) {
        
        Utilitario.limpiarTabla(modeloTabla);
        
        Iterator<Tratamiento> iterar;
        if (punteroOpcion > -1) {
            
            iterar = tratamientos.mostrarTratamientosTipos(opcion[punteroOpcion]).iterator();
            
        } else {
            iterar = tratamientos.mostrarTratamientos().iterator();
        }
        
        while (iterar.hasNext()) {
            Tratamiento t = iterar.next();
            if (filtro == -1) {
                modeloTabla.addRow(new Object[]{t.getCodTrat(), t.getNombre(), t.getDetalle(),
                    t.getDuracion(),t.getCosto(),t.getTipo(), Utilitario.estadoParaTabla(t.isEstado())});
            }
            

        }
        
    }

    //Función cuando se clickea una opción de la información de la tabla
    private void elegirTratamiento(Point evento) {
        
        int seleccionFila = jtTabla.rowAtPoint(evento);

        int columnaID = 0;
        
        for (int i = 0; i < jtTabla.getColumnCount(); i++) {
            if (jtTabla.getColumnName(i).equals("ID")) {
                columnaID = i;
            }
        }
        
        int ID = (int)(jtTabla.getValueAt(seleccionFila, columnaID));
        
        Tratamiento t = tratamientos.buscarTratamiento(ID);
        
        // SE COMPLETAN LOS DATOS EN SUS RESPECTIVOS CASILLEROS
        
        jtfID.setText(""+t.getCodTrat());
        
        jtfNombre.setText(t.getNombre());
        
        jtfTipo.setText(t.getTipo());
        
        jtfPrecio.setText(""+t.getCosto());
        
        jtfHoraInicio.setText(""+t.getDuracion().getHour());
        
        jtfMinutosInicio.setText(""+t.getDuracion().getMinute());
        
        jtaDetalle.setText(t.getDetalle());
        
        cambiarEstado(t.isEstado());
        
        //------------------
        
        nuevoTratamiento(false);

        
    }
    
    private void cambiarEstado(boolean estado) {
        
        if (estado) {
            jtfEstado.setText("ACTIVO");
            jtfEstado.setBackground(verdeActivo);
        } else {
            jtfEstado.setText("INACTIVO");
            jtfEstado.setBackground(rojoInactivo);
        }
        
    }
    
    private void nuevoTratamiento(boolean crear) {
        
        if(crear) {
            jbActualizar.setEnabled(false);
            jbEliminar.setEnabled(false);
            jbAltaLogica.setEnabled(false);
            jbBajaLogica.setEnabled(false);
            jbGuardar.setEnabled(true);
        } else
        {
            jbActualizar.setEnabled(true);
            jbEliminar.setEnabled(true);
            jbGuardar.setEnabled(false);
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
    
    private void crearTratamiento() {
        
        jtfID.setText("");
        jtfNombre.setText("");
        jtfTipo.setText("");
        jtfPrecio.setText("");
        jtfHoraInicio.setText("");
        jtfMinutosInicio.setText("");
        jtaDetalle.setText("");
        cambiarEstado(true);
        nuevoTratamiento(true);
        
        
    }
    
    private void verificarInformacion(String boton) {
        
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
            } else if (HoraInicio > 8) {
                JOptionPane.showMessageDialog(null, "Las horas no pueden mayores a las 8 horas, por favor, corrijalo");
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

            Time tiempoDate = Time.valueOf(LocalTime.of(HoraInicio, MinutosInicio));

            LocalTime tiempo = null;

            if (tiempoDate == null) {
                JOptionPane.showMessageDialog(null, "Debe colocar la duración del tratamiento");
                errores++;
            } else {

                //Se pasa de Time a LocalTime para tratarlo en nuestro sistema
                tiempo = tiempoDate.toLocalTime();

            }

            String nombre = jtfNombre.getText();
            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El casillero nombre no puede estar vacío");
                errores++;
            } else if (nombre.length() > 50) {
                JOptionPane.showMessageDialog(null, "El nombre no puede tener más de 50 caracteres");
                errores++;
            }
            
            String tipo = jtfTipo.getText();
            if (tipo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El casillero tipo no puede estar vacío");
                errores++;
            } else if (tipo.length() > 50) {
                JOptionPane.showMessageDialog(null, "El tipo no puede tener más de 50 caracteres");
                errores++;
            }
            
            String detalle = jtaDetalle.getText();
            if (detalle.isEmpty()) {
                JOptionPane.showMessageDialog(null, "El casillero detalle no puede estar vacío");
                errores++;
            } else if (tipo.length() > 250) {
                JOptionPane.showMessageDialog(null, "El detalle no puede tener más de 250 caracteres");
                errores++;
            }
            
            int precio = Integer.parseInt(jtfPrecio.getText());                   

            if (errores > 0) {
                if (boton.equalsIgnoreCase("GUARDAR")) {
                    JOptionPane.showMessageDialog(null, "Debe atender a los errores anteriormente mencionados, no se pudo guardar el tratamiento");
                }
                if (boton.equalsIgnoreCase("ACTUALIZAR")) {
                    JOptionPane.showMessageDialog(null, "Debe atender a los errores anteriormente mencionados, no se pudo actualizar el tratamiento");
                }

            } else {

                if (boton.equalsIgnoreCase("GUARDAR")) {
                    Tratamiento t = new Tratamiento(nombre,detalle,tiempo,precio,true,tipo);
                    tratamientos.cargarTratamiento(t);
                    cargarTabla(-1);
                    crearTratamiento();    
                }

                if (boton.equalsIgnoreCase("ACTUALIZAR")) {
                    boolean estado = tratamientos.buscarTratamiento(Integer.parseInt(jtfID.getText())).isEstado();
                    Tratamiento t = new Tratamiento(nombre,detalle,tiempo,precio,true,tipo);
                    t.setCodTrat(Integer.parseInt(jtfID.getText()));
                    tratamientos.actualizarTratamiento(t);
                    cargarTabla(-1);
                    crearTratamiento();
                }

            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un formato válido, númerico");
            System.out.println(e.getMessage() + e.getStackTrace());

        } catch (DateTimeException e) {
            JOptionPane.showMessageDialog(null, "Debe colocar un formato válido en la información de Horas-Minutos");
            System.out.println(e.getMessage() + e.getStackTrace());
        }
        
    }


}
