package com.hoangytm.report.myReport.bookMonitoring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author PhanHoang
 * 12/10/2020
 */
@Entity
@Table(name="BOOK_MONITORING")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMonitoring implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false, length = 100)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "DOC_TITLE", length = 100)
    private String docTitle;

    @Column(name = "PROCESS_TRANSACTION_ID", length = 100)
    private Long processTransactionId;

    @Column(name = "DOC_CODE", length = 100)
    private String docCode;

    @Column(name = "DOC_PLACE", length = 100)
    private String docPlace;

    @Column(name = "DOC_DATE", length = 250)
    @Temporal(TemporalType.TIMESTAMP)
    private Date docDate;

    @Column(name = "NOTE")
    private String note;

    @Column(name = "IS_DELETE")
    private Long isDelete;

    @Column(name = "CREATOR_ID")
    private Long userCreateId;

    @Column(name = "CREATOR_NAME", length = 100)
    private String creatorName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "UPDATOR_ID")
    private Long userUpdateId;

    @Column(name = "UPDATOR_NAME", length = 100)
    private String updatorName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "UPDATE_TIME")
    private Date updateTime;

    @Column(name = "IS_ACTIVE")
    private Long isActive;

}
