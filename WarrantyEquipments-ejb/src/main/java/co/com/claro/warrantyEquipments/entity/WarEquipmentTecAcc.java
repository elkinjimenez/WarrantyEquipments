/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.claro.warrantyEquipments.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jimenezelkg
 */
@Entity
@Table(name = "WAR_EQUIPMENT_TEC_ACC")
@XmlRootElement(name = "WarEquipmentTecAcc")
@NamedQueries({
    @NamedQuery(name = "WarEquipmentTecAcc.findAll", query = "SELECT w FROM WarEquipmentTecAcc w")
    , @NamedQuery(name = "WarEquipmentTecAcc.findById", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.id = :id")
    , @NamedQuery(name = "WarEquipmentTecAcc.findByCode", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.code = :code")
    , @NamedQuery(name = "WarEquipmentTecAcc.findByMaker", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.maker = :maker")
    , @NamedQuery(name = "WarEquipmentTecAcc.findByProduct", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.product = :product")
    , @NamedQuery(name = "WarEquipmentTecAcc.findByWarrantyPeriod", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.warrantyPeriod = :warrantyPeriod")
    , @NamedQuery(name = "WarEquipmentTecAcc.findByProvider", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.provider = :provider")
    , @NamedQuery(name = "WarEquipmentTecAcc.findByStatus", query = "SELECT w FROM WarEquipmentTecAcc w WHERE w.status = :status")})
public class WarEquipmentTecAcc implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    @XmlElement(required = true)
    private BigDecimal id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODE")
    @XmlElement(required = true)
    private short code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "MAKER")
    @XmlElement(required = true)
    private String maker;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "PRODUCT")
    @XmlElement(required = true)
    private String product;
    @Basic(optional = false)
    @NotNull
    @Column(name = "WARRANTY_PERIOD")
    @XmlElement(required = true)
    private short warrantyPeriod;
    @Size(max = 250)
    @Column(name = "PROVIDER")
    @XmlElement(required = false)
    private String provider;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STATUS")
    @XmlElement(required = true)
    private short status;

    public WarEquipmentTecAcc() {
    }

    public WarEquipmentTecAcc(BigDecimal id) {
        this.id = id;
    }

    public WarEquipmentTecAcc(BigDecimal id, short code, String maker, String product, short warrantyPeriod, short status) {
        this.id = id;
        this.code = code;
        this.maker = maker;
        this.product = product;
        this.warrantyPeriod = warrantyPeriod;
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public short getCode() {
        return code;
    }

    public void setCode(short code) {
        this.code = code;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public short getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(short warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WarEquipmentTecAcc)) {
            return false;
        }
        WarEquipmentTecAcc other = (WarEquipmentTecAcc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.com.claro.warrantyEquipments.entity.WarEquipmentTecAcc[ id=" + id + " ]";
    }

}
