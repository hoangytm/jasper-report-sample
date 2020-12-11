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
@Table(name="BOOK_MONITORING_DETAIL")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookMonitoringDetail implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false, length = 100)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "BOOK_MONITORING_ID", length = 100)
    private String bookMonitoringId;

    @Column(name = "EFILE_ID", length = 100)
    private String efileId;

    @Column(name = "EFILE_CODE", length = 100)
    private String efileCode;

    @Column(name = "PROCEDURE_ID", length = 100)
    private String procedureId;

    @Column(name = "PROCEDURE_NAME", length = 100)
    private String procedureName;

    @Column(name = "OWNER_ID")
    private String ownerId;

    @Column(name = "OWNER_NAME")
    private String ownerName;

    @Column(name = "OWNER_ADDRESS")
    private String ownerAddress;

    @Column(name = "OWNER_TEL")
    private String ownerTel;

    @Column(name = "DEPT_PROCESSOR")
    private String deptProcessor;

    @Column(name = "DEPT_PROCESSOR_ID")
    private String deptProcessorId;

    @Column(name = "RECEIPT_DATE", length = 250)
    @Temporal(TemporalType.TIMESTAMP)
    private Date receiptDate;

    @Column(name = "PROMISE_DATE", length = 250)
    @Temporal(TemporalType.TIMESTAMP)
    private Date promiseDate;

    @Column(name = "RESULT_DATE", length = 250)
    @Temporal(TemporalType.TIMESTAMP)
    private Date resultDate;

    @Column(name = "RESULT_METHOD_TYPE")
    private Long resultMethodType;

    @Column(name = "RESULT_METHOD")
    private String resultMethod;

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