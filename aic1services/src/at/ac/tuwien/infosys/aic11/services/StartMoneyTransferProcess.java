package at.ac.tuwien.infosys.aic11.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for start_money_transfer_process complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="start_money_transfer_process">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://services.aic11.infosys.tuwien.ac.at/}disbursementPreference" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://services.aic11.infosys.tuwien.ac.at/}money" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://services.aic11.infosys.tuwien.ac.at/}customer" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "start_money_transfer_process", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class StartMoneyTransferProcess {

    protected at.ac.tuwien.infosys.aic11.disbursement.DisbursementPreference arg0;
    protected Money arg1;
    protected Customer arg2;

    /**
     * Gets the value of the arg0 property.
     *
     * @return
     *     possible object is
     *     {@link at.ac.tuwien.infosys.aic11.disbursement.DisbursementPreference }
     *
     */
    public at.ac.tuwien.infosys.aic11.disbursement.DisbursementPreference getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value
     *     allowed object is
     *     {@link at.ac.tuwien.infosys.aic11.disbursement.DisbursementPreference }
     *
     */
    public void setArg0(at.ac.tuwien.infosys.aic11.disbursement.DisbursementPreference value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     *
     * @return
     *     possible object is
     *     {@link Money }
     *
     */
    public Money getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     *
     * @param value
     *     allowed object is
     *     {@link Money }
     *
     */
    public void setArg1(Money value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     *
     * @return
     *     possible object is
     *     {@link Customer }
     *
     */
    public Customer getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     *
     * @param value
     *     allowed object is
     *     {@link Customer }
     *
     */
    public void setArg2(Customer value) {
        this.arg2 = value;
    }

}
