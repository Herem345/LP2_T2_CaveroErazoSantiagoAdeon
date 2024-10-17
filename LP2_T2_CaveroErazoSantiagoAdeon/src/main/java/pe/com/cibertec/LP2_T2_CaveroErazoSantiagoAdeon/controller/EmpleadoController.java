package pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.model.entity.AreaEntity;
import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.model.entity.EmpleadoEntity;
import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.service.AreaService;
import pe.com.cibertec.LP2_T2_CaveroErazoSantiagoAdeon.service.EmpleadosService;

import java.util.List;

@Controller
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadosService empleadosService;
    
    @Autowired
    private AreaService areaService;

    @GetMapping("/")
    public String listarEmpleados(Model model) {
        List<EmpleadoEntity> listaEmpleados = empleadosService.buscarEmpleados();
        model.addAttribute("lista_empleados", listaEmpleados);
        return "listar_empleados"; 
    }

    @GetMapping("/registrar_empleado")
    public String mostrarRegistrarEmpleado(Model model) {
        model.addAttribute("empleado", new EmpleadoEntity());
        List<AreaEntity> listaAreas = areaService.buscarAreas();
        model.addAttribute("listaAreas", listaAreas);
        return "registrar_empleado"; 
    }

    @PostMapping("/registrar_empleado")
    public String registrarEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
        empleadosService.crearEmpleado(empleado);
        return "redirect:/empleado/"; 
    }

    @GetMapping("/detalle_empleado/{dni}")
    public String verDetalleEmpleado(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleado = empleadosService.buscarEmpleadoPorDni(dni);
        model.addAttribute("empleado", empleado);
        return "detalle_empleado"; 
    }

    @GetMapping("/delete/{dni}")
    public String eliminarEmpleado(@PathVariable("dni") String dni) {
        empleadosService.eliminarEmpleado(dni);
        return "redirect:/empleado/"; 
    }

    @GetMapping("/editar_empleado/{dni}")
    public String mostrarFormularioEdicion(@PathVariable("dni") String dni, Model model) {
        EmpleadoEntity empleado = empleadosService.buscarEmpleadoPorDni(dni);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            model.addAttribute("listaAreas", areaService.buscarAreas()); // Cargar las áreas si es necesario
            return "editar_empleado"; // Nombre de la plantilla Thymeleaf
        }
        // Manejar el caso donde el empleado no se encuentra
        return "redirect:/empleado"; // Redirigir o mostrar un mensaje de error
    }


    @PostMapping("/editar_empleado/{dni}")
    public String actualizarEmpleado(@PathVariable("dni") String dni, @ModelAttribute("empleado") EmpleadoEntity empleado, Model model) {
        empleadosService.actualizarEmpleado(dni, empleado);
        return "redirect:/empleado/"; 
    }

    @GetMapping("/buscar_por_area")
    public String buscarEmpleadosPorArea(@RequestParam("areaId") Integer areaId, Model model) {
        List<EmpleadoEntity> empleadosPorArea = empleadosService.buscarEmpleadosPorArea(areaId);
        model.addAttribute("lista_empleados", empleadosPorArea);
        return "listar_empleados"; 
    }

    @GetMapping("/buscar_por_nombre")
    public String buscarEmpleadosPorNombre(@RequestParam("nombre") String nombre, Model model) {
        List<EmpleadoEntity> empleadosPorNombre = empleadosService.buscarEmpleadosPorNombre(nombre);
        model.addAttribute("lista_empleados", empleadosPorNombre);
        return "listar_empleados"; 
    }

    @GetMapping("/buscar_por_apellido")
    public String buscarEmpleadosPorApellido(@RequestParam("apellido") String apellido, Model model) {
        List<EmpleadoEntity> empleadosPorApellido = empleadosService.buscarEmpleadosPorApellido(apellido);
        model.addAttribute("lista_empleados", empleadosPorApellido);
        return "listar_empleados"; 
    }
}
