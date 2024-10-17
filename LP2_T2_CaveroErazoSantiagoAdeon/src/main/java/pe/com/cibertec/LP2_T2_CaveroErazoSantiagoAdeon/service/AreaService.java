package pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.service;

import java.util.List;

import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.model.entity.AreaEntity;

public interface AreaService {
    List<AreaEntity> buscarAreas();
    void crearArea(AreaEntity area);
    AreaEntity buscarAreaPorId(Integer id);
    void actualizarArea(Integer id, AreaEntity area); 
    void eliminarArea(Integer id); 
}
