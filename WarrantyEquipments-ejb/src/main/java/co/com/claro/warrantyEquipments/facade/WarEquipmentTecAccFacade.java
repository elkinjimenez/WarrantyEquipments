/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.warrantyEquipments.facade;

import co.com.claro.warrantyEquipments.entity.WarEquipmentTecAcc;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class WarEquipmentTecAccFacade extends AbstractFacade<WarEquipmentTecAcc> {

    @PersistenceContext(unitName = "co.com.claro.warrantyEquipments_WarrantyEquipments-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WarEquipmentTecAccFacade() {
        super(WarEquipmentTecAcc.class);
    }

    public List<WarEquipmentTecAcc> queryCode(String code) {
        List<WarEquipmentTecAcc> list = (List<WarEquipmentTecAcc>) em.createQuery("SELECT w FROM WarEquipmentTecAcc w WHERE w.code='" + code + "'").getResultList();
        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

}
