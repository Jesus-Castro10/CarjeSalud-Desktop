package util;

import com.toedter.calendar.JDateChooser;
import dominio.Doctor;
import dominio.Paciente;
import dominio.Persona;
import dominio.Recepcionista;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FuncionesForm {

    static FuncionesVista fv = new FuncionesVista();

    public static boolean getDataForm(JTextField documento, JTextField nombre1, JTextField nombre2, JTextField apellido1,
            JTextField apellido2, JTextField txtEmail, JTextField txtCelular, JDateChooser nacimiento,
            JComboBox cbbSexo, JComboBox cbbEps, String uriImg, Object object) {
        String numeroDocumento, primerNombre, segundoNombre,
                primerApellido, segundoApellido, email, celular, sexo, eps;
        Date fechaNacimiento;
        byte[] fotoPerfil;
        if (validation(documento, nombre1, apellido1, apellido2, txtEmail, txtCelular)) {
            numeroDocumento = documento.getText();
            primerNombre = nombre1.getText();
            segundoNombre = nombre2.getText();
            primerApellido = apellido1.getText();
            segundoApellido = apellido2.getText();
            email = txtEmail.getText();
            celular = txtCelular.getText();
            sexo = cbbSexo.getSelectedItem().toString();
            eps = cbbEps.getSelectedItem().toString();
            fechaNacimiento = nacimiento.getDate();
            fotoPerfil = crearImagen(uriImg);
            System.out.println("fotoPerfil = " + fotoPerfil.length + "\nFoto " + fotoPerfil.toString());
        } else {
            return false;
        }
        if (object instanceof Persona person) {
            person.setNumeroDocumento(numeroDocumento);
            person.setPrimerNombre(primerNombre);
            person.setSegundoNombre(segundoNombre);
            person.setPrimerApellido(primerApellido);
            person.setSegundoApellido(segundoApellido);
            person.setSexo(sexo);
            person.setEmail(email);
            person.setCelular(celular);
            person.setEps(eps);
            person.setFechaNacimiento(fechaNacimiento);
            person.setFotoPerfil(fotoPerfil);
        }
        return true;
    }

    public static boolean validation(JTextField... fields) {
        for (JTextField field : fields) {
            if (field.getText().isEmpty()) {
                field.setBackground(Color.red);
                return false;
            }
        }
        return true;
    }

    public static byte[] crearImagen(String uriImg) {
        if (uriImg == null) {
            uriImg = "C:\\Users\\Lenovo\\Downloads\\ProAula1.2\\ProAula1.2\\Hosptial\\src\\imagenes\\noImage.jpg";
        }
        File imagen = new File(uriImg);
        try {
            byte[] icono = new byte[(int) imagen.length()];
            InputStream inputStream = new FileInputStream(imagen);
            inputStream.read(icono);

            return icono;
        } catch (IOException e) {
            return null;
        }
    }

    public static ImageIcon cargarImagen(Object object, JLabel label) {
        byte[] imagen = null;
        if (object instanceof Doctor doctor) {
            imagen = doctor.getFotoPerfil();
        }
        if (object instanceof Paciente paciente) {
            imagen = paciente.getFotoPerfil();
        }
        if (object instanceof Recepcionista recepcionista) {
            imagen = recepcionista.getFotoPerfil();
        }
        try {
            if (imagen != null) {

                BufferedImage bufferedImage = null;
                InputStream inputStream = new ByteArrayInputStream(imagen);
                bufferedImage = ImageIO.read(inputStream);
                ImageIcon mIcono = new ImageIcon(bufferedImage.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH));
                return mIcono;
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
        return null;
    }

    public static String escogerImagen(JLabel label, Component parent) {
        String uriImg;
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter fileNameExtensionFilter = new FileNameExtensionFilter("JPG, PNG & GIF", "jpg", "png", "gif");
        fileChooser.setFileFilter(fileNameExtensionFilter);
        java.awt.Image imagen;
        ImageIcon mIcono;
        if (fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION) {
            uriImg = fileChooser.getSelectedFile().getAbsolutePath();
        } else {
            uriImg = "/imagenes/noImage.jpg";
        }
        imagen = new ImageIcon(uriImg).getImage();
        mIcono = new ImageIcon(imagen.getScaledInstance(label.getWidth(), label.getHeight(), java.awt.Image.SCALE_SMOOTH));
        label.setIcon(mIcono);
        return uriImg;
    }

    public static boolean checkField(JTextField jTextField) {
        return jTextField.getText().isBlank();
    }

    public static boolean validarCerraSesion(Component parent) {
        String path = "/imagenes/cerrar_icon48.png";
        String message = "¿Seguro que quiere cerrar sesion?";
        int op = JOptionPane.showConfirmDialog(parent, message, "Cerrar sesion",
                0, 0, fv.crearIcono(path));
        return op == JOptionPane.YES_OPTION;
    }

    public static void cerrar(Component parent) {
        String botones[] = {"Cerrar", "Cancelar"};
        int eleccion = JOptionPane.showOptionDialog(parent, "¿Desea cerrar la aplicación?", "Salir de la aplicación!", 0, 0, null, botones, parent);

        if (eleccion == JOptionPane.YES_OPTION) {
            System.exit(0);

        } else if (eleccion == JOptionPane.NO_OPTION) {

            JOptionPane.showMessageDialog(parent, "Se cancelo el cierre");
        }
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void limpiar(JTextField... fields) {
        for (JTextField field : fields) {
            field.setText("");
        }
    }

    public static void limpiar(JDateChooser... dates) {
        for (JDateChooser date : dates) {
            date.setDate(new Date());
        }
    }

    public static void limpiar(JTextArea... areas) {
        for (JTextArea area : areas) {
            area.setText("");
        }
    }

    public static void limpiar(JComboBox... cbbs) {
        for (JComboBox cbb : cbbs) {
            cbb.setSelectedIndex(0);
        }
    }

    public static String formatearFecha(Date fecha) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        return format.format(fecha);
    }

    public static void calcularFecha(JDateChooser jdChooser, LocalDate date) {
        LocalDate fechaSeleccionada = date;

        // Restar 18 años a la fecha seleccionada
        LocalDate fechaHace18Anios = fechaSeleccionada.minusYears(18);

        // Convertir LocalDate a java.util.Date
        Date fechaCalculada = Date.from(fechaHace18Anios.atStartOfDay(ZoneId.systemDefault()).toInstant());

        // Establecer la fecha calculada en el JDateChooser
        jdChooser.setDate(fechaCalculada);
        jdChooser.setMaxSelectableDate(fechaCalculada);
    }
}
