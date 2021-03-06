/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidad.vistas;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import modelo.Alumno;
import modelo.AlumnoData;
import modelo.Conexion;
import modelo.Cursada;
import modelo.CursadaData;
import modelo.Materia;
import modelo.MateriaData;

/**
 *
 * @author Martin
 */
public class VistaListadoAlumnos extends javax.swing.JInternalFrame {
    private DefaultTableModel modelo;
 //private ArrayList<Cursada> listaCursada;
 //private ArrayList<Materia> listaMateria;
//// private CursadaData cd;
// private MateriaData md;
 private Conexion con;
 private AlumnoData ad;
 private ArrayList <Alumno> listaAlumno;

    /**
     * Creates new form VistaListadoAlumnos
     */
    public VistaListadoAlumnos() {
        initComponents();
        con =new Conexion();
        modelo= new DefaultTableModel();
                      
        ad= new AlumnoData(con);
        listaAlumno=(ArrayList<Alumno>)ad.obtenerAlumnos();
      
        borrarFilasTabla();
        armarCabaceraTabla();
        cargarDatos();
    }
    
    public void armarCabaceraTabla(){
    ArrayList<Object> columns= new ArrayList<>();
    columns.add("ID");
    columns.add("Nombre");
    columns.add("DNI");
    columns.add("Domicilio");
    columns.add("Fecha nacimiento");
    for (Object it:columns)
    {
        modelo.addColumn(it);
    }
    jtListadoAlumnos.setModel(modelo);
    }
    
    public void borrarFilasTabla(){
     int a=modelo.getRowCount()-1 ;
          
     
     for (int i=a;i>=0;i--){
     modelo.removeRow(i);
     }
    }
    
    private void cargarDatos(){
     borrarFilasTabla();
    // Materia mat=(Materia)cbMaterias.getSelectedItem();
     
    for (Alumno a:listaAlumno){
     // if(m.getMateria().getId()==mat.getId()){
       modelo.addRow(new Object[]{a.getId(),a.getNombre(),a.getDni(),a.getDomicilio(),(a.getFechaNac().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")))});
     // }
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

        jlListadoAlumnos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtListadoAlumnos = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jlListadoAlumnos.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        jlListadoAlumnos.setText("Listado de alumnos");

        jtListadoAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtListadoAlumnos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jlListadoAlumnos)
                .addContainerGap(239, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlListadoAlumnos)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlListadoAlumnos;
    private javax.swing.JTable jtListadoAlumnos;
    // End of variables declaration//GEN-END:variables
}
