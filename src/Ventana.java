import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel panel;
    private JTabbedPane tabbedPane1;
    private JList lstTienda;
    private JButton btnOrdenId;
    private JButton btnOrdenAnio;
    private JButton btnEliminar;
    Tienda miTienta=new Tienda();
    public void llenarJList(){
        DefaultListModel dlm=new DefaultListModel();
        for(Moto m:miTienta.getTienda()){
            dlm.addElement(m);
        }
        lstTienda.setModel(dlm);
    }

    public Ventana() {
        llenarJList();
        btnOrdenId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miTienta.ordenarId();
                llenarJList();
            }
        });
        btnOrdenAnio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                miTienta.ordenarAnio();
                llenarJList();
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(lstTienda.getSelectedIndex()!=-1){
               //     Moto aux=(Moto)lstTienda.getSelectedValue();
                    int indice=lstTienda.getSelectedIndex();
                 /*   for(Moto m:miTienta.getTienda()){
                        if(m.getCodigo()==aux.getCodigo()){
                            aux=m;
                        }
                    }*/
                    miTienta.getTienda().remove(indice);
                    llenarJList();
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Seleccione un elemento en la lista");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
