import java.util.ArrayList;
import java.util.List;

public class Tienda {
    private List<Moto> tienda;

    public Tienda(){
        tienda=new ArrayList<>();
        predefinir();
    }

    public void predefinir(){
        tienda.add(new Moto(1,"bmw",800,2024,1000.99f));
        tienda.add(new Moto(19,"suzuki",250,2020,8000.99f));
        tienda.add(new Moto(21,"yamaha",700,2023,6000.99f));
        tienda.add(new Moto(50,"ducati",600,2026,4000.99f));
        tienda.add(new Moto(41,"honda",550,2025,5000.99f));

    }

    public void agregar(Moto moto){
        tienda.add(moto);
    }

    public void ordenarId(){
        Moto aux;
        for(int i=0;i<tienda.size()-1;i++){
            for(int j=i+1; j<tienda.size();j++){
                if(tienda.get(i).getCodigo()>
                tienda.get(j).getCodigo()){
                    aux=tienda.get(i);
                    tienda.set(i,tienda.get(j));
                    tienda.set(j,aux);
                }
            }
        }
    }

    public void ordenarAnio(){
        Moto aux;
        int j;
        for(int i=1; i<tienda.size(); i++){
            aux=tienda.get(i);
            j=i-1;
            while(j>=0  && aux.getAnio()<tienda.get(j).getAnio()){
                tienda.set(j+1,tienda.get(j));
                j--;
            }
            tienda.set(j+1,aux);
        }

    }

    public List<Moto> getTienda() {
        return tienda;
    }
}
