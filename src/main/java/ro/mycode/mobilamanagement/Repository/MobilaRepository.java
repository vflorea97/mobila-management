package ro.mycode.mobilamanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ro.mycode.mobilamanagement.Model.Mobila;

import java.util.List;
import java.util.Optional;

@Repository
public interface MobilaRepository extends JpaRepository<Mobila, Long> {

    @Query("select m from Mobila m where m.culoare = ?1")
    Optional<List<Mobila>> getMobilaByCuloare (String culoare);

    @Query("select m from Mobila m where m.latime = ?1 and m.lungime = ?2")
    Optional<List<Mobila>> getMobilaByDimensiuni (double latime, double lungime);

    @Query("select m from Mobila m where substr(m.numeProdus,1,1) in ?1")
    Optional<List<Mobila>> getMobilaByFirsNameChar(char litera);

    @Query("select m.numeProdus from Mobila m order by m.numeProdus")
    Optional<List<Mobila>> getMobilaInOrder();

    Optional<Mobila> findByCod(String cod);
}
