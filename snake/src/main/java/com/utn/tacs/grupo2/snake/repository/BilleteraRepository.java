package com.utn.tacs.grupo2.snake.repository;

import com.utn.tacs.grupo2.snake.domain.Billetera;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleteraRepository extends JpaRepository<Billetera, Long> {

    Billetera findByUsuarioIdAndMonedaNombre(Long usuarioId, String monedaNombre);

    List<Billetera> findByUsuarioId(Long usuarioId);

}
