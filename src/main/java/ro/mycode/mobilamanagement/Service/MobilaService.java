package ro.mycode.mobilamanagement.Service;

import org.springframework.stereotype.Service;
import ro.mycode.mobilamanagement.Exceptii.ExceptieObiectExistent;
import ro.mycode.mobilamanagement.Exceptii.ExceptieObiectNecorespunzator;
import ro.mycode.mobilamanagement.Exceptii.ExceptieObiectNeexistent;
import ro.mycode.mobilamanagement.Model.Mobila;
import ro.mycode.mobilamanagement.Repository.MobilaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MobilaService {

    private MobilaRepository mobilaRepository;

    public MobilaService(MobilaRepository mobilaRepository){
        this.mobilaRepository = mobilaRepository;
    }

    public void afisare(){
        List<Mobila> mobila = mobilaRepository.findAll();
        mobila.forEach(m-> System.out.println(m));
    }

    public void add(Mobila mobila) throws ExceptieObiectExistent {
        Optional<Mobila> obiectMobila = mobilaRepository.findByCod(mobila.getCod());
        if (obiectMobila.equals(Optional.empty())){
            mobilaRepository.save(mobila);
            System.out.println("Ai adaugat un obiect de mobilier cu succes!!");
        }else{
            throw new ExceptieObiectExistent();
        }
    }

    public void removeMobilaByCod(String cod) throws ExceptieObiectNeexistent {
        Optional<Mobila> obiectMobila = mobilaRepository.findByCod(cod);
        if (!obiectMobila.isEmpty()){
            mobilaRepository.removeMobilaByCod(cod);
            System.out.println("Ai sters un obiect de mobilier cu succes!!");
        }
    }

    public List<Mobila> getMobilaByCuloare(String culoare) throws ExceptieObiectNecorespunzator {
        List<Mobila> mobila = mobilaRepository.getMobilaByCuloare(culoare).get();
        if (mobila.size() > 0){
            return mobila;
        }else{
            throw new ExceptieObiectNecorespunzator();
        }
    }

    public List<Mobila> getMobilaByDimensiuni (double latime, double lungime) throws ExceptieObiectNecorespunzator {
        List<Mobila> mobila = mobilaRepository.getMobilaByDimensiuni(latime, lungime).get();
        if (mobila.size() > 0){
            return mobila;
        }else{
            throw new ExceptieObiectNecorespunzator();
        }
    }

    public List<Mobila> getMobilaByFirsNameChar(char litera) throws ExceptieObiectNecorespunzator{
        List<Mobila> mobila = mobilaRepository.getMobilaByFirsNameChar(litera).get();
        if (mobila.size() > 0){
            return mobila;
        }else{
            throw new ExceptieObiectNecorespunzator();
        }
    }

    public void getMobilaInOrder(){
        List<Mobila> mobila = mobilaRepository.getMobilaInOrder().get();
        mobila.forEach(m-> System.out.println(m));
    }

}
