import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Table" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Currency" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Rates">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Rate" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                             &lt;element name="Bid" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                             &lt;element name="Ask" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "table",
        "currency",
        "code",
        "rates"
})
@XmlRootElement(name = "ExchangeRatesSeries")
public class ExchangeRatesSeries {

    @XmlElement(name = "Table", required = true)
    protected String table;
    @XmlElement(name = "Currency", required = true)
    protected String currency;
    @XmlElement(name = "Code", required = true)
    protected String code;
    @XmlElement(name = "Rates", required = true)
    protected ExchangeRatesSeries.Rates rates;

    /**
     * Gets the value of the table property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTable() {
        return table;
    }

    /**
     * Sets the value of the table property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTable(String value) {
        this.table = value;
    }

    /**
     * Gets the value of the currency property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the code property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the rates property.
     *
     * @return possible object is
     * {@link ExchangeRatesSeries.Rates }
     */
    public ExchangeRatesSeries.Rates getRates() {
        return rates;
    }

    /**
     * Sets the value of the rates property.
     *
     * @param value allowed object is
     *              {@link ExchangeRatesSeries.Rates }
     */
    public void setRates(ExchangeRatesSeries.Rates value) {
        this.rates = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Rate" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *                   &lt;element name="Bid" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                   &lt;element name="Ask" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "rate"
    })
    public static class Rates {

        @XmlElement(name = "Rate")
        protected List<ExchangeRatesSeries.Rates.Rate> rate;

        /**
         * Gets the value of the rate property.
         *
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the rate property.
         *
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRate().add(newItem);
         * </pre>
         *
         *
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link ExchangeRatesSeries.Rates.Rate }
         */
        public List<ExchangeRatesSeries.Rates.Rate> getRate() {
            if (rate == null) {
                rate = new ArrayList<ExchangeRatesSeries.Rates.Rate>();
            }
            return this.rate;
        }


        /**
         * <p>Java class for anonymous complex type.
         *
         * <p>The following schema fragment specifies the expected content contained within this class.
         *
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="No" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="EffectiveDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
         *         &lt;element name="Bid" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *         &lt;element name="Ask" type="{http://www.w3.org/2001/XMLSchema}float"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
                "no",
                "effectiveDate",
                "bid",
                "ask"
        })
        public static class Rate {

            @XmlElement(name = "No", required = true)
            protected String no;
            @XmlElement(name = "EffectiveDate", required = true)
            @XmlSchemaType(name = "date")
            protected XMLGregorianCalendar effectiveDate;
            @XmlElement(name = "Bid")
            protected float bid;
            @XmlElement(name = "Ask")
            protected float ask;

            /**
             * Gets the value of the no property.
             *
             * @return possible object is
             * {@link String }
             */
            public String getNo() {
                return no;
            }

            /**
             * Sets the value of the no property.
             *
             * @param value allowed object is
             *              {@link String }
             */
            public void setNo(String value) {
                this.no = value;
            }

            /**
             * Gets the value of the effectiveDate property.
             *
             * @return possible object is
             * {@link XMLGregorianCalendar }
             */
            public XMLGregorianCalendar getEffectiveDate() {
                return effectiveDate;
            }

            /**
             * Sets the value of the effectiveDate property.
             *
             * @param value allowed object is
             *              {@link XMLGregorianCalendar }
             */
            public void setEffectiveDate(XMLGregorianCalendar value) {
                this.effectiveDate = value;
            }

            /**
             * Gets the value of the bid property.
             */
            public float getBid() {
                return bid;
            }

            /**
             * Sets the value of the bid property.
             */
            public void setBid(float value) {
                this.bid = value;
            }

            /**
             * Gets the value of the ask property.
             */
            public float getAsk() {
                return ask;
            }

            /**
             * Sets the value of the ask property.
             */
            public void setAsk(float value) {
                this.ask = value;
            }

        }

    }


    @Override
    public String toString() {
        return "ExchangeRatesSeries{" +
                "table='" + table + '\'' +
                ", currency='" + currency + '\'' +
                ", code='" + code + '\'' +
                ", rates=" + rates +
                '}';
    }
}
