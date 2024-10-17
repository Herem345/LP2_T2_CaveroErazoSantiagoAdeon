package pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.model.entity.AreaEntity;
import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.repository.AreaRepository;
import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.service.AreaService;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaRepository areaRepository; 

    @Override
    public List<AreaEntity> buscarAreas() {
        return areaRepository.findAll(); 
    }

    @Override
    public void crearArea(AreaEntity area) {
        areaRepository.save(area);
    }

    @Override
    public AreaEntity buscarAreaPorId(Integer id) {
    	return areaRepository.findById(id).get();
         }

  

    @Override
    public void actualizarArea(Integer id, AreaEntity areaActualizado) {
		// TODO Auto-generated method stub
		AreaEntity areaEncontrado = buscarAreaPorId(id);
		if(areaEncontrado == null) {
			throw new RuntimeException("area no encontrado");
		}
		try {
			
			areaEncontrado.setNombreArea(areaActualizado.getNombreArea());
			areaRepository.save(areaActualizado);
		}catch (Exception e) {
			throw new RuntimeException("Error al actualizar");
		}
    } 
    
    @Override
    public void eliminarArea(Integer id) {// TODO Auto-generated method stub
		AreaEntity usuarioEncontrado = buscarAreaPorId(id);
		if(usuarioEncontrado == null) {
			throw new RuntimeException("Usuario no encontrado");
		}
		areaRepository.delete(usuarioEncontrado);
    }
}
