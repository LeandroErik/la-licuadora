package domain.repositorios;

import domain.modelos.ProductoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "productos")
public interface RepoProductoBaseJPA extends JpaRepository<ProductoBase,Integer> {

}
