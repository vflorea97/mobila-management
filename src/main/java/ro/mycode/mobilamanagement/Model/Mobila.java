package ro.mycode.mobilamanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Entity(name="Mobila")
@Table(name="mobila")
public class Mobila implements Comparable<Mobila>{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id

    private String firma;
    private String numeProdus;
    private String culoare;
    private String cod;
    private double lungime;
    private double latime;
    private double inaltime;

    @Override
    public int compareTo(Mobila o) {
        if (this.cod.compareTo(o.cod) > 0){
            return 1;
        }
        if (this.cod.compareTo(o.cod) < 0){
            return -1;
        }else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object o){
        Mobila m = (Mobila) o;
        return this.cod.equals(m.cod);
    }
}
