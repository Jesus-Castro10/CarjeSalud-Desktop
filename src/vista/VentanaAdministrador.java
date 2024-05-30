package vista;

import static util.FuncionesForm.*;
import dominio.Doctor;
import dominio.Persona;
import dominio.Recepcionista;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicio.DoctorService;
import servicio.RecepcionistaService;
import util.Reportes;

public class VentanaAdministrador extends javax.swing.JFrame {

    private DoctorService doctorService = new DoctorService();
    private RecepcionistaService recepcionistaService = new RecepcionistaService();
    private String uriImg;

    public VentanaAdministrador() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        lblTotalDoctores.setText(totalDoctores());
        lblTotalRecepcionistas.setText(totalRecepcionistas());
        lblTotal.setText(totalUsers());
        llenarTablaTotal();
        llenarTablaDoctores();
    }

    private void llenarTablaDoctores() {
        DefaultTableModel model = (DefaultTableModel) tablaDoctores.getModel();
        java.util.List<Doctor> doctores = doctorService.listarDoctores();
        Object[] obj = new Object[6];
        model.getDataVector().removeAllElements();
        if (!doctores.isEmpty()) {
            for (Doctor doctor : doctores) {
                obj[0] = doctor.getCodigo();
                obj[1] = doctor.getNumeroDocumento();
                obj[2] = doctor.getPrimerNombre();
                obj[3] = doctor.getPrimerApellido();
                obj[4] = doctor.getEspecialidad();
                obj[5] = doctor.getEmail();
                model.addRow(obj);
            }
        } else {
            model.addRow(obj);
        }
    }

    private void llenarTablaRecepcionistas() {
        DefaultTableModel model = (DefaultTableModel) listaRecepcionistas.getModel();
        java.util.List<Recepcionista> recepcionistas = recepcionistaService.listarRecepcionistaes();
        Object[] obj = new Object[6];
        model.getDataVector().removeAllElements();
        if (!recepcionistas.isEmpty()) {
            for (Recepcionista recepcionista : recepcionistas) {
                obj[0] = recepcionista.getCodigo();
                obj[1] = recepcionista.getNumeroDocumento();
                obj[2] = recepcionista.getPrimerNombre();
                obj[3] = recepcionista.getPrimerApellido();
                obj[4] = recepcionista.getEmail();
                obj[5] = recepcionista.getCelular();
                model.addRow(obj);
            }
        } else {
            model.addRow(obj);
        }
    }

    private void llenarTablaTotal() {
        DefaultTableModel model = (DefaultTableModel) listaTotal.getModel();
        java.util.List<Recepcionista> recepcionistas = recepcionistaService.listarRecepcionistaes();
        Object[] objR = new Object[4];
        java.util.List<Doctor> doctores = doctorService.listarDoctores();
        Object[] objD = new Object[4];
        model.getDataVector().removeAllElements();
        if (!recepcionistas.isEmpty() || !doctores.isEmpty()) {
            for (Recepcionista recepcionista : recepcionistas) {
                objR[0] = recepcionista.getCodigo();
                objR[1] = recepcionista.getPrimerNombre() + " " + recepcionista.getSegundoNombre();
                objR[2] = recepcionista.getPrimerApellido() + " " + recepcionista.getSegundoApellido();
                objR[3] = "Recepcionista";
                model.addRow(objR);
            }
            for (Doctor doctor : doctores) {
                objD[0] = doctor.getCodigo();
                objD[1] = doctor.getPrimerNombre() + " " + doctor.getSegundoNombre();
                objD[2] = doctor.getPrimerApellido() + " " + doctor.getSegundoApellido();
                objD[3] = "Doctor";
                model.addRow(objD);
            }
        } else {
            model.addRow(objR);
            model.addRow(objD);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnModDoctor = new javax.swing.JPanel();
        txtModDoctor = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        btnDoctores = new javax.swing.JPanel();
        txtDoctores = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        btnRecepcionista = new javax.swing.JPanel();
        txtRecepcionista = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnModRecepcionista = new javax.swing.JPanel();
        txtModRecepcionista = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        marcoImg = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        lblCerrar = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        lblInicio = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        crudVentanaPrincipal = new javax.swing.JTabbedPane();
        panelInicio = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        lblTotalDoctores = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        lblTotalRecepcionistas = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaTotal = new rojerusan.RSTableMetro();
        panelAgregarDoctor = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblImgUserD = new javax.swing.JLabel();
        dcFechaNacimientoD = new com.toedter.calendar.JDateChooser();
        cbSexoD = new javax.swing.JComboBox<>();
        cbEpsD = new javax.swing.JComboBox<>();
        cbEspecialidad = new javax.swing.JComboBox<>();
        txtCelularD = new jtextfieldround.JTextFieldRound();
        txtNumDocD = new jtextfieldround.JTextFieldRound();
        txtPriNombreD = new jtextfieldround.JTextFieldRound();
        txtSegNombreD = new jtextfieldround.JTextFieldRound();
        txtPriApellidoD = new jtextfieldround.JTextFieldRound();
        txtSegApellidoD = new jtextfieldround.JTextFieldRound();
        txtEmailD = new jtextfieldround.JTextFieldRound();
        jButton2 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        PanelModificarDoctor = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtDocumentoBuscarListadoD = new jtextfieldround.JTextFieldRound();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaDoctores = new rojerusan.RSTableMetro();
        panelAgregarRecepcionista = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        lblImgUserR = new javax.swing.JLabel();
        cbSexoR = new javax.swing.JComboBox<>();
        dcFechaNacimientoR = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        cbEpsR = new javax.swing.JComboBox<>();
        txtEmailR = new jtextfieldround.JTextFieldRound();
        txtNumDocR = new jtextfieldround.JTextFieldRound();
        txtPriNombreR = new jtextfieldround.JTextFieldRound();
        txtSegNombreR = new jtextfieldround.JTextFieldRound();
        txtPriApellidoR = new jtextfieldround.JTextFieldRound();
        txtSegApellidoR = new jtextfieldround.JTextFieldRound();
        txtCelularR = new jtextfieldround.JTextFieldRound();
        jButton8 = new javax.swing.JButton();
        PanelModificarRecepcionista = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtDocumentoBuscarListadoR = new jtextfieldround.JTextFieldRound();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaRecepcionistas = new rojerusan.RSTableMetro();
        panelAcciones = new javax.swing.JPanel();
        panelMini = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelExit = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setPreferredSize(new java.awt.Dimension(1150, 710));
        bg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Administrador");
        jLabel2.setMaximumSize(new java.awt.Dimension(155, 32));
        jLabel2.setMinimumSize(new java.awt.Dimension(155, 32));
        jLabel2.setPreferredSize(new java.awt.Dimension(155, 32));
        bg.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 230, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        bg.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 230, 20));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Graphicloads-Medical-Health-Heart-beat.48.png"))); // NOI18N
        bg.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 60, 60));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 44)); // NOI18N
        jLabel3.setText("CarjeSalud");
        bg.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 2, 350, 60));

        jPanel8.setBackground(new java.awt.Color(10, 92, 184));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Registro, Modificaciones, Eliminacion de Recepcionista y Doctores");
        jPanel8.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 442, 84));

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/estetoscopio.png"))); // NOI18N
        jPanel8.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 70, 70));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/equipo-medico.png"))); // NOI18N
        jPanel8.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 80, 60));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("Tu salud es la nuestra");
        jPanel8.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 270, -1));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel56.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dentista.png"))); // NOI18N
        jPanel8.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 80, 70));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/visita-al-doctor.png"))); // NOI18N
        jPanel8.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 20, 80, 70));

        bg.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 850, 130));

        jPanel1.setBackground(new java.awt.Color(19, 28, 70));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 620));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModDoctor.setBackground(new java.awt.Color(19, 28, 70));
        btnModDoctor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModDoctor.setMinimumSize(new java.awt.Dimension(113, 50));
        btnModDoctor.setPreferredSize(new java.awt.Dimension(219, 64));
        btnModDoctor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModDoctorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModDoctorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModDoctorMouseExited(evt);
            }
        });

        txtModDoctor.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtModDoctor.setForeground(new java.awt.Color(255, 255, 255));
        txtModDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtModDoctor.setText("Modificar Doctor");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N

        javax.swing.GroupLayout btnModDoctorLayout = new javax.swing.GroupLayout(btnModDoctor);
        btnModDoctor.setLayout(btnModDoctorLayout);
        btnModDoctorLayout.setHorizontalGroup(
            btnModDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModDoctorLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtModDoctor)
                .addGap(73, 73, 73))
        );
        btnModDoctorLayout.setVerticalGroup(
            btnModDoctorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModDoctorLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtModDoctor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(btnModDoctorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnModDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 299, 60));

        btnDoctores.setBackground(new java.awt.Color(19, 28, 70));
        btnDoctores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDoctores.setMinimumSize(new java.awt.Dimension(113, 50));
        btnDoctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoctoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDoctoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDoctoresMouseExited(evt);
            }
        });

        txtDoctores.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtDoctores.setForeground(new java.awt.Color(255, 255, 255));
        txtDoctores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDoctores.setText("Agregar Doctor");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paciente.png"))); // NOI18N

        javax.swing.GroupLayout btnDoctoresLayout = new javax.swing.GroupLayout(btnDoctores);
        btnDoctores.setLayout(btnDoctoresLayout);
        btnDoctoresLayout.setHorizontalGroup(
            btnDoctoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDoctoresLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDoctores)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btnDoctoresLayout.setVerticalGroup(
            btnDoctoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDoctoresLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(btnDoctoresLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnDoctores, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 370, 299, -1));

        btnRecepcionista.setBackground(new java.awt.Color(19, 28, 70));
        btnRecepcionista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRecepcionista.setMinimumSize(new java.awt.Dimension(113, 50));
        btnRecepcionista.setPreferredSize(new java.awt.Dimension(219, 64));
        btnRecepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRecepcionistaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRecepcionistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRecepcionistaMouseExited(evt);
            }
        });

        txtRecepcionista.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtRecepcionista.setForeground(new java.awt.Color(255, 255, 255));
        txtRecepcionista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtRecepcionista.setText("Agregar Recepcionista");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/paciente.png"))); // NOI18N

        javax.swing.GroupLayout btnRecepcionistaLayout = new javax.swing.GroupLayout(btnRecepcionista);
        btnRecepcionista.setLayout(btnRecepcionistaLayout);
        btnRecepcionistaLayout.setHorizontalGroup(
            btnRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRecepcionistaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRecepcionista)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        btnRecepcionistaLayout.setVerticalGroup(
            btnRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRecepcionistaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(btnRecepcionistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 300, 60));

        btnModRecepcionista.setBackground(new java.awt.Color(19, 28, 70));
        btnModRecepcionista.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModRecepcionista.setMinimumSize(new java.awt.Dimension(113, 50));
        btnModRecepcionista.setPreferredSize(new java.awt.Dimension(219, 64));
        btnModRecepcionista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModRecepcionistaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnModRecepcionistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnModRecepcionistaMouseExited(evt);
            }
        });

        txtModRecepcionista.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        txtModRecepcionista.setForeground(new java.awt.Color(255, 255, 255));
        txtModRecepcionista.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtModRecepcionista.setText("Modificar Recepcionista");

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizar.png"))); // NOI18N

        javax.swing.GroupLayout btnModRecepcionistaLayout = new javax.swing.GroupLayout(btnModRecepcionista);
        btnModRecepcionista.setLayout(btnModRecepcionistaLayout);
        btnModRecepcionistaLayout.setHorizontalGroup(
            btnModRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModRecepcionistaLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel42)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtModRecepcionista)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        btnModRecepcionistaLayout.setVerticalGroup(
            btnModRecepcionistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnModRecepcionistaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtModRecepcionista, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(btnModRecepcionistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnModRecepcionista, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 300, -1));

        marcoImg.setBackground(new java.awt.Color(255, 255, 255));
        marcoImg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 3));
        jPanel1.add(marcoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 150, 150));

        jPanel10.setBackground(new java.awt.Color(19, 28, 70));
        jPanel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel10MouseExited(evt);
            }
        });
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/flecha-izquierda.png"))); // NOI18N
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 0, 36, 54));

        lblCerrar.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblCerrar.setForeground(new java.awt.Color(255, 255, 255));
        lblCerrar.setText("Cerrar Sesion");
        jPanel10.add(lblCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 300, 60));

        jPanel12.setBackground(new java.awt.Color(19, 28, 70));
        jPanel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel12MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel12MouseExited(evt);
            }
        });

        lblInicio.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lblInicio.setForeground(new java.awt.Color(255, 255, 255));
        lblInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblInicio.setText("Inicio");

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/pagina-de-inicio (1).png"))); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInicio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(lblInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 300, 60));

        bg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 710));

        crudVentanaPrincipal.setBackground(new java.awt.Color(255, 255, 255));

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctorIcon.png"))); // NOI18N

        jLabel41.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel41.setText("Registros Totales");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInicio.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 180, -1));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctorIcon.png"))); // NOI18N

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel44.setText("Total Doctores");

        lblTotalDoctores.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalDoctores.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel43)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTotalDoctores, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTotalDoctores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInicio.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/doctorIcon.png"))); // NOI18N

        jLabel46.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel46.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel46.setText("Total Recepcionistas");

        lblTotalRecepcionistas.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTotalRecepcionistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTotalRecepcionistas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalRecepcionistas, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelInicio.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 180, -1));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("ULTIMOS REGISTROS");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel11.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 40));

        panelInicio.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 730, 40));

        listaTotal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Nombres", "Apellidos", "Cargo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaTotal.setAltoHead(22);
        listaTotal.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        listaTotal.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        listaTotal.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        listaTotal.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        listaTotal.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        listaTotal.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listaTotal.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        listaTotal.setGrosorBordeFilas(0);
        jScrollPane2.setViewportView(listaTotal);
        if (listaTotal.getColumnModel().getColumnCount() > 0) {
            listaTotal.getColumnModel().getColumn(0).setResizable(false);
            listaTotal.getColumnModel().getColumn(1).setResizable(false);
            listaTotal.getColumnModel().getColumn(2).setResizable(false);
            listaTotal.getColumnModel().getColumn(3).setResizable(false);
        }

        panelInicio.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 730, 200));

        crudVentanaPrincipal.addTab("Menu", panelInicio);

        panelAgregarDoctor.setBackground(new java.awt.Color(255, 255, 255));
        panelAgregarDoctor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel66.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel66.setText("Sexo:");
        panelAgregarDoctor.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 105, -1));

        jLabel67.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel67.setText("Email:");
        panelAgregarDoctor.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 220, -1));

        jLabel68.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel68.setText("Celular:");
        panelAgregarDoctor.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 220, -1));

        jLabel64.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel64.setText("Segundo Apellido:");
        panelAgregarDoctor.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 220, -1));

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel28.setText("Primer Apellido:");
        panelAgregarDoctor.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 220, -1));

        jLabel65.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel65.setText("Fecha de Nacimiento:");
        panelAgregarDoctor.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 220, -1));

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel11.setText("Primer Nombre:");
        panelAgregarDoctor.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 140, 220, -1));

        jLabel29.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel29.setText("Segundo Nombre:");
        panelAgregarDoctor.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 220, -1));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setText("Número de Documento:");
        panelAgregarDoctor.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 220, -1));

        jLabel69.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel69.setText("Especialidad:");
        panelAgregarDoctor.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 220, -1));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setText("Eps:");
        panelAgregarDoctor.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 140, 50, -1));

        lblImgUserD.setBackground(new java.awt.Color(232, 230, 229));
        lblImgUserD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgUserD.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, java.awt.Color.blue, null, null));
        panelAgregarDoctor.add(lblImgUserD, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 160, 160));

        dcFechaNacimientoD.setBackground(new java.awt.Color(0, 0, 0, 0));
        panelAgregarDoctor.add(dcFechaNacimientoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 220, 30));

        cbSexoD.setBackground(new java.awt.Color(0, 0, 0, 0));
        cbSexoD.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cbSexoD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        panelAgregarDoctor.add(cbSexoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 70, 25));

        cbEpsD.setBackground(new java.awt.Color(0, 0, 0, 0));
        cbEpsD.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cbEpsD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coosalud", "Sanitas", "Nueva Eps" }));
        panelAgregarDoctor.add(cbEpsD, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 170, 130, 25));

        cbEspecialidad.setBackground(new java.awt.Color(0, 0, 0, 0)
        );
        cbEspecialidad.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cbEspecialidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Medicina General", "Psicologia", "Pediatria", "Ortopedia" }));
        panelAgregarDoctor.add(cbEspecialidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 220, 30));

        txtCelularD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtCelularD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtCelularD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 220, 30));

        txtNumDocD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtNumDocD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtNumDocD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 220, 30));

        txtPriNombreD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtPriNombreD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtPriNombreD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 220, 30));

        txtSegNombreD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtSegNombreD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtSegNombreD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 220, 30));

        txtPriApellidoD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtPriApellidoD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtPriApellidoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 220, 30));

        txtSegApellidoD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtSegApellidoD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtSegApellidoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 220, 30));

        txtEmailD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtEmailD.setFont(new java.awt.Font("Century Gothic", 0, 22)); // NOI18N
        panelAgregarDoctor.add(txtEmailD, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 310, 220, 30));

        jButton2.setBackground(new java.awt.Color(10, 92, 184));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Subir Foto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        panelAgregarDoctor.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 240, 160, 30));

        jButton7.setBackground(new java.awt.Color(10, 92, 184));
        jButton7.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("GUARDAR");
        jButton7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        panelAgregarDoctor.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 120, 35));

        crudVentanaPrincipal.addTab("AgregarDoctor", panelAgregarDoctor);

        PanelModificarDoctor.setBackground(new java.awt.Color(255, 255, 255));
        PanelModificarDoctor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setText("LISTADO DE DOCTORES");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 30));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("CODIGO:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 100, 30));

        txtDocumentoBuscarListadoD.setForeground(new java.awt.Color(0, 51, 153));
        txtDocumentoBuscarListadoD.setCaretColor(new java.awt.Color(0, 102, 153));
        txtDocumentoBuscarListadoD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoBuscarListadoDKeyPressed(evt);
            }
        });
        jPanel4.add(txtDocumentoBuscarListadoD, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 230, 30));

        jButton3.setBackground(new java.awt.Color(0,0,0,0)
        );
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Reload32.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, 32, 32));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/print_1.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 10, 32, 32));

        PanelModificarDoctor.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 700, 50));

        tablaDoctores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Documento", "Nombre", "Apellido", "Especialidad", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaDoctores.setAltoHead(22);
        tablaDoctores.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        tablaDoctores.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        tablaDoctores.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        tablaDoctores.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        tablaDoctores.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        tablaDoctores.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablaDoctores.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        tablaDoctores.setGrosorBordeFilas(0);
        tablaDoctores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaDoctoresMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaDoctores);
        if (tablaDoctores.getColumnModel().getColumnCount() > 0) {
            tablaDoctores.getColumnModel().getColumn(0).setResizable(false);
            tablaDoctores.getColumnModel().getColumn(1).setResizable(false);
            tablaDoctores.getColumnModel().getColumn(2).setResizable(false);
            tablaDoctores.getColumnModel().getColumn(3).setResizable(false);
            tablaDoctores.getColumnModel().getColumn(4).setResizable(false);
            tablaDoctores.getColumnModel().getColumn(5).setResizable(false);
        }

        PanelModificarDoctor.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 700, 390));

        crudVentanaPrincipal.addTab("ModificarDoctor", PanelModificarDoctor);

        panelAgregarRecepcionista.setBackground(new java.awt.Color(255, 255, 255));
        panelAgregarRecepcionista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel71.setText("Sexo:");
        panelAgregarRecepcionista.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 130, 105, -1));

        jLabel73.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel73.setText("Celular:");
        panelAgregarRecepcionista.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, 220, -1));

        jLabel72.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel72.setText("Email:");
        panelAgregarRecepcionista.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 220, -1));

        jLabel74.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel74.setText("Segundo Apellido:");
        panelAgregarRecepcionista.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 220, -1));

        jLabel30.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel30.setText("Primer Apellido:");
        panelAgregarRecepcionista.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 220, -1));

        jLabel75.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel75.setText("Fecha de Nacimiento:");
        panelAgregarRecepcionista.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 220, -1));

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setText("Primer Nombre:");
        panelAgregarRecepcionista.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 220, -1));

        jLabel31.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel31.setText("Segundo Nombre:");
        panelAgregarRecepcionista.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 220, -1));

        jLabel33.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel33.setText("Número de Documento:");
        panelAgregarRecepcionista.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 220, -1));

        jLabel76.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel76.setText("Eps:");
        panelAgregarRecepcionista.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 130, 150, -1));

        lblImgUserR.setBackground(new java.awt.Color(232, 230, 229));
        lblImgUserR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImgUserR.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 51, 255), null, null));
        panelAgregarRecepcionista.add(lblImgUserR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 60, 160, 160));

        cbSexoR.setBackground(new java.awt.Color(0, 0, 0, 0));
        cbSexoR.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cbSexoR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F" }));
        panelAgregarRecepcionista.add(cbSexoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 160, 60, 30));

        dcFechaNacimientoR.setBackground(new java.awt.Color(0, 0, 0, 0));
        panelAgregarRecepcionista.add(dcFechaNacimientoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 90, 230, 30));

        jButton1.setBackground(new java.awt.Color(10, 92, 184));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Subir Foto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        panelAgregarRecepcionista.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 160, 30));

        cbEpsR.setBackground(new java.awt.Color(0, 0, 0, 0));
        cbEpsR.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        cbEpsR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Coosalud", "Sanistas", "Comfamiliar", "Nueva Eps" }));
        panelAgregarRecepcionista.add(cbEpsR, new org.netbeans.lib.awtextra.AbsoluteConstraints(425, 160, 150, 30));

        txtEmailR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtEmailR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtEmailR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 230, 30));

        txtNumDocR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtNumDocR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtNumDocR, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 230, 30));

        txtPriNombreR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtPriNombreR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtPriNombreR, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 230, 30));

        txtSegNombreR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtSegNombreR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtSegNombreR, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 230, 30));

        txtPriApellidoR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtPriApellidoR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtPriApellidoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 230, 30));

        txtSegApellidoR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtSegApellidoR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtSegApellidoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 230, 30));

        txtCelularR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtCelularR.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        panelAgregarRecepcionista.add(txtCelularR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 230, 30));

        jButton8.setBackground(new java.awt.Color(10, 92, 184));
        jButton8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("GUARDAR");
        jButton8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        panelAgregarRecepcionista.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 150, 35));

        crudVentanaPrincipal.addTab("AgregarRecepcionista", panelAgregarRecepcionista);

        PanelModificarRecepcionista.setBackground(new java.awt.Color(255, 255, 255));
        PanelModificarRecepcionista.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel34.setText("LISTADO DE RECEPCIONISTAS");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 250, 30));

        jLabel35.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel35.setText("CODIGO:");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 100, 30));

        txtDocumentoBuscarListadoR.setForeground(new java.awt.Color(0, 51, 153));
        txtDocumentoBuscarListadoR.setCaretColor(new java.awt.Color(0, 102, 153));
        txtDocumentoBuscarListadoR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoBuscarListadoRKeyPressed(evt);
            }
        });
        jPanel5.add(txtDocumentoBuscarListadoR, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 190, 30));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Reload32.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 10, 32, 32));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/print_1.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 32, 32));

        PanelModificarRecepcionista.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 700, 50));

        listaRecepcionistas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Documento", "Nombre", "Apellido", "Email", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        listaRecepcionistas.setAltoHead(22);
        listaRecepcionistas.setColorBackgoundHead(new java.awt.Color(0, 51, 51));
        listaRecepcionistas.setColorFilasBackgound2(new java.awt.Color(240, 240, 240));
        listaRecepcionistas.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        listaRecepcionistas.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        listaRecepcionistas.setFuenteFilas(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        listaRecepcionistas.setFuenteFilasSelect(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        listaRecepcionistas.setFuenteHead(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        listaRecepcionistas.setGrosorBordeFilas(0);
        listaRecepcionistas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaRecepcionistasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaRecepcionistas);
        if (listaRecepcionistas.getColumnModel().getColumnCount() > 0) {
            listaRecepcionistas.getColumnModel().getColumn(0).setResizable(false);
            listaRecepcionistas.getColumnModel().getColumn(1).setResizable(false);
            listaRecepcionistas.getColumnModel().getColumn(2).setResizable(false);
            listaRecepcionistas.getColumnModel().getColumn(3).setResizable(false);
            listaRecepcionistas.getColumnModel().getColumn(4).setResizable(false);
            listaRecepcionistas.getColumnModel().getColumn(5).setResizable(false);
        }

        PanelModificarRecepcionista.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 700, 390));

        crudVentanaPrincipal.addTab("ModificarDoctor", PanelModificarRecepcionista);

        bg.add(crudVentanaPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 850, 550));

        panelAcciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelMini.setBackground(new java.awt.Color(255, 255, 255));
        panelMini.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelMiniMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelMiniMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelMiniMouseExited(evt);
            }
        });
        panelMini.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 50)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/min.png"))); // NOI18N
        panelMini.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        panelAcciones.add(panelMini, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        panelExit.setBackground(new java.awt.Color(255, 255, 255));
        panelExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelExitMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelExitMouseExited(evt);
            }
        });
        panelExit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("X");
        jLabel10.setToolTipText("");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel10MouseExited(evt);
            }
        });
        panelExit.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 50));

        panelAcciones.add(panelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 50, 50));

        bg.add(panelAcciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 0, 100, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoctoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctoresMouseExited
        btnDoctores.setBackground(new Color(19, 28, 70));
        txtDoctores.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnDoctoresMouseExited

    private void btnDoctoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctoresMouseEntered
        btnDoctores.setBackground(new Color(10, 92, 184));
        txtDoctores.setForeground(new Color(19, 28, 70));
    }//GEN-LAST:event_btnDoctoresMouseEntered

    private void btnDoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoctoresMouseClicked
        limpiarCamposDoctor();
        LocalDate date = dcFechaNacimientoD.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        calcularFecha(dcFechaNacimientoD,date);
        crudVentanaPrincipal.setSelectedIndex(1);
    }//GEN-LAST:event_btnDoctoresMouseClicked

    private void btnModDoctorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModDoctorMouseExited
        btnModDoctor.setBackground(new Color(19, 28, 70));
        txtModDoctor.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnModDoctorMouseExited

    private void btnModDoctorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModDoctorMouseEntered
        btnModDoctor.setBackground(new Color(10, 92, 184));
        txtModDoctor.setForeground(new Color(19, 28, 70));
    }//GEN-LAST:event_btnModDoctorMouseEntered

    private void btnModDoctorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModDoctorMouseClicked
        llenarTablaDoctores();
        crudVentanaPrincipal.setSelectedIndex(2);
    }//GEN-LAST:event_btnModDoctorMouseClicked

    private void btnRecepcionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecepcionistaMouseClicked
        limpiarCamposRecepcionista();
        LocalDate date = dcFechaNacimientoR.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        calcularFecha(dcFechaNacimientoR,date);
        crudVentanaPrincipal.setSelectedIndex(3);
    }//GEN-LAST:event_btnRecepcionistaMouseClicked

    private void btnRecepcionistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecepcionistaMouseEntered
        btnRecepcionista.setBackground(new Color(10, 92, 184));
        txtRecepcionista.setForeground(new Color(19, 28, 70));
    }//GEN-LAST:event_btnRecepcionistaMouseEntered

    private void btnRecepcionistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRecepcionistaMouseExited
        btnRecepcionista.setBackground(new Color(19, 28, 70));
        txtRecepcionista.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnRecepcionistaMouseExited

    private void btnModRecepcionistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModRecepcionistaMouseClicked
        llenarTablaRecepcionistas();
        crudVentanaPrincipal.setSelectedIndex(4);
    }//GEN-LAST:event_btnModRecepcionistaMouseClicked

    private void btnModRecepcionistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModRecepcionistaMouseEntered
        btnModRecepcionista.setBackground(new Color(10, 92, 184));
        txtModRecepcionista.setForeground(new Color(19, 28, 70));
    }//GEN-LAST:event_btnModRecepcionistaMouseEntered

    private void btnModRecepcionistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModRecepcionistaMouseExited
        btnModRecepcionista.setBackground(new Color(19, 28, 70));
        txtModRecepcionista.setForeground(new Color(242, 242, 242));
    }//GEN-LAST:event_btnModRecepcionistaMouseExited

    private void jPanel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseEntered
        jPanel10.setBackground(new Color(10, 92, 184));
        lblCerrar.setForeground(new Color(19, 28, 70));
    }//GEN-LAST:event_jPanel10MouseEntered

    private void jPanel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseExited
        jPanel10.setBackground(new Color(19, 28, 70));
        lblCerrar.setForeground(Color.white);
    }//GEN-LAST:event_jPanel10MouseExited

    private void jPanel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel10MouseClicked
        if (validarCerraSesion(this)) {
            new VentanaPrincipal().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jPanel10MouseClicked

    private void jPanel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseClicked
        llenarTablaTotal();
        crudVentanaPrincipal.setSelectedIndex(0);
        lblTotalDoctores.setText(totalDoctores());
        lblTotalRecepcionistas.setText(totalRecepcionistas());
        lblTotal.setText(totalUsers());
    }//GEN-LAST:event_jPanel12MouseClicked

    private void jPanel12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseEntered
        jPanel12.setBackground(new Color(10, 92, 184));
        lblInicio.setForeground(new Color(19, 28, 70));
    }//GEN-LAST:event_jPanel12MouseEntered

    private void jPanel12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel12MouseExited
        jPanel12.setBackground(new Color(19, 28, 70));
        lblInicio.setForeground(Color.white);
    }//GEN-LAST:event_jPanel12MouseExited

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        uriImg = escogerImagen(lblImgUserD, this);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        uriImg = escogerImagen(lblImgUserR, this);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtDocumentoBuscarListadoDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoBuscarListadoDKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (checkField(txtDocumentoBuscarListadoD)) {
                JOptionPane.showMessageDialog(this, "El campo esta vacio");
                return;
            }
            String codigo = txtDocumentoBuscarListadoD.getText();
            Doctor doctor = doctorService.encontrarDoctor(codigo);
            if (doctor == null) {
                JOptionPane.showMessageDialog(this, "Doctor no encontrado");
                return;
            }
            txtDocumentoBuscarListadoD.setText("");
            DialogModificarDoctor ventana = new DialogModificarDoctor(this, rootPaneCheckingEnabled, doctor);
            ventana.setResizable(false);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txtDocumentoBuscarListadoDKeyPressed

    private void tablaDoctoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaDoctoresMouseClicked
        int fila = tablaDoctores.getSelectedRow();
        String numeroDocumento = tablaDoctores.getValueAt(fila, 1).toString();
        Doctor doctor = doctorService.encontrarDoctor(numeroDocumento);
        DialogModificarDoctor ventana = new DialogModificarDoctor(this, true, doctor);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_tablaDoctoresMouseClicked

    private void listaRecepcionistasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaRecepcionistasMouseClicked
        int fila = listaRecepcionistas.getSelectedRow();
        String numeroDocumento = listaRecepcionistas.getValueAt(fila, 1).toString();
        Recepcionista recepcionista = recepcionistaService.encontrarRecepcionista(numeroDocumento);
        DialogModificarRecepcionista ventana = new DialogModificarRecepcionista(this, true, recepcionista);
        ventana.setResizable(false);
        ventana.setLocationRelativeTo(null);
        ventana.setVisible(true);
    }//GEN-LAST:event_listaRecepcionistasMouseClicked

    private void txtDocumentoBuscarListadoRKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoBuscarListadoRKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (checkField(txtDocumentoBuscarListadoR)) {
                JOptionPane.showMessageDialog(this, "El campo esta vacio");
                return;
            }
            String numeroDocumento = txtDocumentoBuscarListadoR.getText().toLowerCase();
            Recepcionista recepcionista = recepcionistaService.encontrarRecepcionista(numeroDocumento);
            if (recepcionista == null) {
                JOptionPane.showMessageDialog(this, "Recepcionista no encontrado");
                return;
            }
            txtDocumentoBuscarListadoR.setText("");
            DialogModificarRecepcionista ventana = new DialogModificarRecepcionista(this, true, recepcionista);
            ventana.setResizable(false);
            ventana.setLocationRelativeTo(null);
            ventana.setVisible(true);
        }
    }//GEN-LAST:event_txtDocumentoBuscarListadoRKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (listaRecepcionistas.getSelectedRow() != -1 || listaRecepcionistas.getSelectedRows().length >= 1) {
            llenarTablaRecepcionistas();
            listaRecepcionistas.clearSelection();
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (tablaDoctores.getSelectedRow() != -1 || tablaDoctores.getSelectedRows().length >= 1) {
            llenarTablaDoctores();
            tablaDoctores.clearSelection();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void panelMiniMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMiniMouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_panelMiniMouseClicked

    private void panelMiniMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMiniMouseEntered
        panelMini.setBackground(Color.GRAY);
    }//GEN-LAST:event_panelMiniMouseEntered

    private void panelMiniMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMiniMouseExited
        panelMini.setBackground(Color.white);
    }//GEN-LAST:event_panelMiniMouseExited

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        panelExitMouseClicked(null);
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        panelExitMouseEntered(null);
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jLabel10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseExited
        panelExitMouseExited(null);
    }//GEN-LAST:event_jLabel10MouseExited

    private void panelExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_panelExitMouseClicked

    private void panelExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseEntered
        panelExit.setBackground(new Color(255, 0, 0));
    }//GEN-LAST:event_panelExitMouseEntered

    private void panelExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelExitMouseExited
        panelExit.setBackground(Color.white);
    }//GEN-LAST:event_panelExitMouseExited

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Persona persona = new Doctor();
        Doctor doctor;
        if (!getDataForm(txtNumDocD, txtPriNombreD, txtSegNombreD, txtPriApellidoD, txtSegApellidoD,
                txtEmailD, txtCelularD, dcFechaNacimientoD, cbSexoD,
                cbEpsD, uriImg, persona)) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }
        doctor = (Doctor) persona;
        String codigo = createCode(doctor.getNumeroDocumento());
        String especialidad = cbEspecialidad.getSelectedItem().toString();
        doctor.setCodigo(codigo);
        doctor.setEspecialidad(especialidad);
        if (doctorService.encontrarDoctor(doctor.getNumeroDocumento()) != null) {
            JOptionPane.showMessageDialog(this, "Doctor ya se encuentra registrado");
            return;
        }
        doctorService.guardarDoctor(doctor);
        limpiarCamposDoctor();
        JOptionPane.showMessageDialog(this, "Doctor registrado correctamente");
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        Persona persona = new Recepcionista();
        Recepcionista recepcionista;
        if (!getDataForm(txtNumDocR, txtPriNombreR, txtSegNombreR, txtPriApellidoR,
                txtSegApellidoR, txtEmailR, txtCelularR, dcFechaNacimientoR,
                cbSexoR, cbEpsR, uriImg, persona)) {
            JOptionPane.showMessageDialog(this, "Rellene todos los campos");
            return;
        }
        recepcionista = (Recepcionista) persona;
        String codigo = createCode(recepcionista.getNumeroDocumento());
        recepcionista.setCodigo(codigo);
        if (recepcionistaService.encontrarRecepcionista(recepcionista.getNumeroDocumento()) != null) {
            JOptionPane.showMessageDialog(this, "Recepcionista ya se encuentra registrado");
            return;
        }
        recepcionistaService.guardarRecepcionista(recepcionista);
        limpiarCamposRecepcionista();
        JOptionPane.showMessageDialog(this, "Usuario guardado correctamente\nCodigo : " + codigo);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Reportes.exportarExcel(tablaDoctores);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Reportes.exportarExcel(listaRecepcionistas);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void limpiarCamposDoctor() {
        limpiar(txtNumDocD, txtPriNombreD, txtSegNombreD, txtPriApellidoD,
                txtSegApellidoD, txtEmailD, txtCelularD);
        limpiar(dcFechaNacimientoD);
        limpiar(cbSexoD);
        lblImgUserD.setIcon(null);
    }

    private void limpiarCamposRecepcionista() {
        limpiar(txtNumDocR, txtPriNombreR, txtSegNombreR, txtPriApellidoR,
                txtSegApellidoR, txtEmailR, txtCelularR);
        limpiar(dcFechaNacimientoR);
        limpiar(cbSexoR);
        lblImgUserR.setIcon(null);
    }

    private String createCode(String str) {
        int i = (int) (Math.random() * 9 + 0);
        int a = (int) (Math.random() * 9 + 0);
//        int b = (int) (Math.random() * 9999 + 0);
        String code = i + str.substring(0, 3) + a;
        return code;
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
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAdministrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAdministrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelModificarDoctor;
    private javax.swing.JPanel PanelModificarRecepcionista;
    private javax.swing.JPanel bg;
    private javax.swing.JPanel btnDoctores;
    private javax.swing.JPanel btnModDoctor;
    private javax.swing.JPanel btnModRecepcionista;
    private javax.swing.JPanel btnRecepcionista;
    private javax.swing.JComboBox<String> cbEpsD;
    private javax.swing.JComboBox<String> cbEpsR;
    private javax.swing.JComboBox<String> cbEspecialidad;
    private javax.swing.JComboBox<String> cbSexoD;
    private javax.swing.JComboBox<String> cbSexoR;
    private javax.swing.JTabbedPane crudVentanaPrincipal;
    private com.toedter.calendar.JDateChooser dcFechaNacimientoD;
    private com.toedter.calendar.JDateChooser dcFechaNacimientoR;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblCerrar;
    private javax.swing.JLabel lblImgUserD;
    private javax.swing.JLabel lblImgUserR;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblTotalDoctores;
    private javax.swing.JLabel lblTotalRecepcionistas;
    private rojerusan.RSTableMetro listaRecepcionistas;
    private rojerusan.RSTableMetro listaTotal;
    private javax.swing.JLabel marcoImg;
    private javax.swing.JPanel panelAcciones;
    private javax.swing.JPanel panelAgregarDoctor;
    private javax.swing.JPanel panelAgregarRecepcionista;
    private javax.swing.JPanel panelExit;
    private javax.swing.JPanel panelInicio;
    private javax.swing.JPanel panelMini;
    private rojerusan.RSTableMetro tablaDoctores;
    private jtextfieldround.JTextFieldRound txtCelularD;
    private jtextfieldround.JTextFieldRound txtCelularR;
    private javax.swing.JLabel txtDoctores;
    private jtextfieldround.JTextFieldRound txtDocumentoBuscarListadoD;
    private jtextfieldround.JTextFieldRound txtDocumentoBuscarListadoR;
    private jtextfieldround.JTextFieldRound txtEmailD;
    private jtextfieldround.JTextFieldRound txtEmailR;
    private javax.swing.JLabel txtModDoctor;
    private javax.swing.JLabel txtModRecepcionista;
    private jtextfieldround.JTextFieldRound txtNumDocD;
    private jtextfieldround.JTextFieldRound txtNumDocR;
    private jtextfieldround.JTextFieldRound txtPriApellidoD;
    private jtextfieldround.JTextFieldRound txtPriApellidoR;
    private jtextfieldround.JTextFieldRound txtPriNombreD;
    private jtextfieldround.JTextFieldRound txtPriNombreR;
    private javax.swing.JLabel txtRecepcionista;
    private jtextfieldround.JTextFieldRound txtSegApellidoD;
    private jtextfieldround.JTextFieldRound txtSegApellidoR;
    private jtextfieldround.JTextFieldRound txtSegNombreD;
    private jtextfieldround.JTextFieldRound txtSegNombreR;
    // End of variables declaration//GEN-END:variables

    private String totalDoctores() {
        return doctorService.totalRegistros() + "";
    }

    private String totalRecepcionistas() {
        return recepcionistaService.totalRecepcionistas() + "";
    }

    private String totalUsers() {
        long t = doctorService.totalRegistros() + recepcionistaService.totalRecepcionistas();
        return t + "";
    }
}
