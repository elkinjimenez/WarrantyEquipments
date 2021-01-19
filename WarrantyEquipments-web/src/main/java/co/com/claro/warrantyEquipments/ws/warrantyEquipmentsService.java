/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.warrantyEquipments.ws;

import co.com.claro.warrantyEquipments.entity.WarEquipmentTecAcc;
import co.com.claro.warrantyEquipments.facade.WarEquipmentTecAccFacade;
import co.com.claro.warrantyEquipments.model.DataResponse;
import co.com.claro.warrantyEquipments.model.GenericResponse;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;

/**
 *
 * @author ElkinJ
 */
@Path("warrantyEquipments")
@Stateless
@TransactionManagement
public class warrantyEquipmentsService {

    @EJB
    private WarEquipmentTecAccFacade equipmentFacade;

    public warrantyEquipmentsService() {
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    @Path("queryByCode")
    public DataResponse queryByCode(@QueryParam("code") String code) {
        DataResponse responseEnd = new DataResponse();
        try {
            if ("".equals(code) || code == null) {
                GenericResponse response = new GenericResponse(false, "Por favor enviar el código del equipo a consultar (code).");
                responseEnd.setCavs(null);
                responseEnd.setResponse(response);
            } else {
                List<WarEquipmentTecAcc> list = equipmentFacade.queryCode(code);
                if (list != null) {
                    GenericResponse response = new GenericResponse(true, "Consulta exitosa.");
                    responseEnd.setCavs(list);
                    responseEnd.setResponse(response);
                } else {
                    GenericResponse response = new GenericResponse(false, "No se encontraron registros con el código: " + code);
                    responseEnd.setCavs(null);
                    responseEnd.setResponse(response);
                }
            }
        } catch (Exception e) {
            GenericResponse response = new GenericResponse(false, "Ocurrió un error al consultar los equipos. Detalle: " + e.getMessage());
            responseEnd.setCavs(null);
            responseEnd.setResponse(response);
        }
        return responseEnd;
    }

}
