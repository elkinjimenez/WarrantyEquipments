/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.warrantyEquipments.facade;

import co.com.claro.warrantyEquipments.entity.WarCav;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author jimenezelkg
 */
@Stateless
public class WarCavFacade extends AbstractFacade<WarCav> {

    @PersistenceContext(unitName = "co.com.claro.warrantyEquipments_WarrantyEquipments-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WarCavFacade() {
        super(WarCav.class);
    }

    public List<WarCav> queryCodeCav(String codeCav) {
        List<WarCav> list = (List<WarCav>) em.createQuery("SELECT w FROM WarCav w WHERE w.codeCav='" + codeCav + "'").getResultList();
        if (!list.isEmpty()) {
            return list;
        } else {
            return null;
        }
    }

}
